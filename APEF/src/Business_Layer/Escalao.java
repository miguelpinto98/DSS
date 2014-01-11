package Business_Layer;

import Data_Layer.DadosEstatisticosDAO;
import Data_Layer.JogadorDAO;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;

public class Escalao {
    
	//Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nomeEscola;
    private String nomeEquipa; 
    private Treinador treinador;
    private Map<Integer,Jogador> jogadores;
    private Agenda agenda;          //Jogos 
    private Map<Integer,DadosEstatisticos> dados;

    //Construtores
    public Escalao() {
        this.id = APEF.getID();
        this.tipoEscalao = -1;
        this.nomeEscola = "";
        this.nomeEquipa = "";
    	this.treinador = new Treinador();
    	this.jogadores = new JogadorDAO(this.id,this.nomeEquipa);
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticosDAO(this.id);
        APEF.putID();
    }
    
    public Escalao(int tipo, String nomeEquipa, String nomeEscola) {
        this.id = APEF.getID();
        this.tipoEscalao = tipo;
        this.nomeEscola = nomeEscola;
        this.nomeEquipa = nomeEquipa;
        this.treinador = new Treinador();
    	this.jogadores = new JogadorDAO(this.id,this.nomeEquipa);
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticosDAO(this.id);
        APEF.putID();
    }

    public Escalao(Escalao p) {
        this.id = p.getID();
        this.tipoEscalao = p.getTipoEscalao();
        this.nomeEscola = p.getNomeEscola();
        this.nomeEquipa = p.getNomeEquipa();
    	this.treinador = p.getTreinador();
    	this.jogadores = p.getJogadores();
        this.agenda = p.getAgenda();
        this.dados = p.getDados();
    }
    
    public Escalao(int tipo, String nEscola, String nEquipa, Treinador t) {
        this.id = APEF.getID(); APEF.putID();
        this.tipoEscalao = tipo;
        this.nomeEscola = nEscola;
        this.nomeEquipa = nEquipa;
        this.treinador = t;
        this.jogadores = new JogadorDAO(this.id, this.nomeEquipa);
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticosDAO(this.id); 
    }
    
    public Escalao(int id, int tipo, String nEscola, String nEquipa, Treinador t, int idAgenda, int idDadosEst) {
        this.id = id;
        this.tipoEscalao = tipo;
        this.nomeEscola = nEscola;
        this.nomeEquipa = nEquipa;
        this.treinador = t;
        this.jogadores = new JogadorDAO(this.id, this.nomeEquipa);
        this.agenda = new Agenda(idAgenda);
        this.dados = new DadosEstatisticosDAO(this.id);
    }

    //Getters
    public int getID(){
        return this.id;
    }
    
    public int getTipoEscalao(){
        return this.tipoEscalao;
    }
    
    public String getNomeEscola(){
        return this.nomeEscola;
    }
    
    public String getNomeEquipa(){
        return this.nomeEquipa;
    }

    public Treinador getTreinador() {
        return this.treinador;
    }
    
    public Map<Integer,Jogador> getJogadores() {
        return this.jogadores;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }
    
    public Map<Integer,DadosEstatisticos> getDados() {
        return this.dados;
    }

    //Setters
    public void setID(int i){
        this.id = i;
    }
    
    public void setTipoEscalao(int n){
        this.tipoEscalao = n;
    }
    
    public void setNomeEscola(String n){
        this.nomeEscola = n;
    }
    
    public void setNomeEquipa(String n){
        this.nomeEquipa = n;
    }

    public void setTreinador(Treinador t) {
        this.treinador = t;
    }

    public void setJogadores(Map<Integer, Jogador> j) {
        this.jogadores = j;
    }

    public void setAgenda(Agenda agenda){
        this.agenda = agenda;
    }
    
    public void setDados(Map<Integer,DadosEstatisticos> dados){
        this.dados = dados;
    }
    


    //Equals,hashCode,Clone,toString
    @Override
    public int hashCode() {     
        final int prime = 7;
        int result = 1;
        result = prime * result + ((this.jogadores == null) ? 0 : this.jogadores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
        	Escalao p = (Escalao) o;
        	return this.treinador.equals(p.getTreinador()) && this.jogadores.equals(p.getJogadores());
        }
    }

    @Override
    public Escalao clone() {
    	return new Escalao(this);
    }
    
    public StringBuilder imprime(HashSet<Jogador> hash) {
        StringBuilder s = new StringBuilder();
        
        for (Jogador j: hash)
            s.append(j.toString());
        
       return s;
    }

    @Override
    public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("--Escalao--\n");
                str.append("\nID: ").append(this.getID());
                str.append("\nTipo: ").append(this.getTipoEscalao());
                str.append("\nNome Equipa: ").append(this.getNomeEquipa());
		for(Jogador j : this.jogadores.values())
		str.append(j.toString());
                str.append("\n").append(this.getAgenda());
                str.append("\n").append(this.getDados());
		
		return str.toString(); 
	}

    
    /**
    * Metodos Jogadores
    */
    public int idadeEscalao() {
        int res=0;
        switch (this.tipoEscalao) {
            case 0 : res = 12;
                break;
            case 1 : res = 10;
                break;
            case 2 : res = 8;
                break;
            case 3 : res = 6;
        }
        return res;
    }
    
    public boolean inserirJogador(Jogador a) {
        boolean flag = false;
        
        int anoNasc = (a.getDataNasc()).get((a.getDataNasc()).YEAR);

        GregorianCalendar atual = new GregorianCalendar();
        int anoAtual = atual.get(atual.YEAR);
        
        Jogador j = new Jogador(a.getNome(), a.getFoto(), a.getDataNasc(), a.getSexo(), this.nomeEquipa);
        
    	if(!(this.jogadores.containsKey(j.getID())) && (anoAtual-anoNasc) <= idadeEscalao()) {
            this.jogadores.put(j.getID(),j);
            flag = true;
        }
        
        return flag;
    }
    
    public void inserirTreinador(Treinador t) {
        this.treinador = t;
    }
    
    public boolean removerJogador(Jogador j) {
        boolean res = false;
        if(this.jogadores.size() > 0) { // ALTEREI O VALOR MINIMO DE REMOÇ
            this.jogadores.remove(j.getID());
            res= true;
        }
        
        return res;
    }

    public void removerTreinador() {
        this.treinador = new Treinador();
    }


    
    public HashSet<Jogador> procurarJogadorNome(String jogador) {
    	HashSet<Jogador> res = new HashSet<>();
    	
    	for(Jogador j : this.jogadores.values())
    		if(j.getNome().contains(jogador))
    			res.add(j.clone());
    			
        return res;
    }

	public void adicionaDadosEscalao(int numGolosMarcados, int numGolosSofridos, Map<Integer,Integer> goleadores, GregorianCalendar dia) {
		this.dados.get(this.id).addDadosEstatisticos(numGolosMarcados, numGolosSofridos);
		this.agenda.atualizaAgenda(dia);
		
		for(Integer n : goleadores.keySet()) 
			if(this.jogadores.containsKey(n))
				this.jogadores.get(n).addGolosJogador();
	}
    
    public void preencheAgendaEscalao(Jogo j) {
        agenda.inserirJogo(j);
    }
}

