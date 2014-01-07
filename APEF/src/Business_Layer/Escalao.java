package Business_Layer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Escalao {
    
	//Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nomeEscola;
    private String nomeEquipa; 
    private Treinador treinador;
    private HashMap<Integer,Jogador> jogadores;
    private Agenda agenda;          //Jogos 
    private DadosEstatisticos dados;

    //Construtores
    public Escalao() {
        this.id = 0;
        this.tipoEscalao = -1;
        this.nomeEscola = "";
        this.nomeEquipa = "";
    	this.treinador = new Treinador();
    	this.jogadores = new HashMap<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos();
    }
    
    public Escalao(int tipo, String nomeEquipa, String nomeEscola) {
        this. id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipo;
        this.nomeEscola = nomeEscola;
        this.nomeEquipa = nomeEquipa;
        this.treinador = new Treinador();
    	this.jogadores = new HashMap<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos(APEF.IDENTIFICADOR); 
        APEF.IDENTIFICADOR++;
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
        this.id = APEF.IDENTIFICADOR; APEF.IDENTIFICADOR++;
        this.tipoEscalao = tipo;
        this.nomeEscola = nEscola;
        this.nomeEquipa = nEquipa;
        this.treinador = t;
        this.jogadores = new HashMap<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos(); 
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
    
    public HashMap<Integer,Jogador> getJogadores() {
        HashMap<Integer,Jogador> aux = new HashMap<Integer,Jogador>();
        
        for(Integer n : this.jogadores.keySet()) 
            aux.put(n, this.jogadores.get(n));
        
        return aux;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }
    
    public DadosEstatisticos getDados() {
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

    public void setJogadores(HashMap<Integer, Jogador> j) {
        this.jogadores = j;
    }

    public void setAgenda(Agenda agenda){
        this.agenda = agenda;
    }
    
    public void setDados(DadosEstatisticos dados){
        this.dados = dados;
    }
    


    //Equals,hashCode,Clone,toString
    public int hashCode() {     
        final int prime = 7;
        int result = 1;
        result = prime * result + ((this.jogadores == null) ? 0 : this.jogadores.hashCode());
        return result;
    }

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

    public Escalao clone() {
    	return new Escalao(this);
    }
    
    public StringBuilder imprime(HashSet<Jogador> hash) {
        StringBuilder s = new StringBuilder();
        
        for (Jogador j: hash)
            s.append(j.toString());
        
       return s;
    }

    public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("--Escalao--\n");
        str.append("\nID: "+this.getID());
        str.append("\nTipo: "+this.getTipoEscalao());
        str.append("\nNome Equipa: "+this.getNomeEquipa());
		for(Jogador j : this.jogadores.values())
		str.append(j.toString());
        str.append("\n"+this.getAgenda());
        str.append("\n"+this.getDados());
		
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
        if(this.jogadores.size() > 0) {
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

	public void adicionaDadosEscalao(int numGolosMarcados, int numGolosSofridos, ArrayList<Integer> goleadores, GregorianCalendar dia) {
		this.dados.addDadosEstatisticos(numGolosMarcados, numGolosSofridos);
		this.agenda.atualizaAgenda(dia);
		
		for(Integer n : goleadores) 
			if(this.jogadores.containsKey(n))
				this.jogadores.get(n).addGolosJogador();
	}
    
    public void preencheAgendaEscalao(Jogo j) {
        agenda.inserirJogo(j);
    }
}

