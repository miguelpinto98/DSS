package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Escalao {
    
	//Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nomeEquipa; 
    private Treinador treinador;
    private HashMap<Integer,Jogador> jogadores;
    private Agenda agenda;          //Jogos 
    private DadosEstatisticos dados;

    //Construtores
    public Escalao() {
        this.id = 0;
        this.tipoEscalao = -1;
        this.nomeEquipa = "";
    	this.treinador = new Treinador();
    	this.jogadores = new HashMap<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos();
    }
    
    //falta contrutor com a passagem do nome da equipa como parametro

    public Escalao(int tipo, Treinador t, HashMap<Integer,Jogador> j, Agenda a, DadosEstatisticos d) {
    	this.id = APEF.IDENTIFICADOR;
    	this.tipoEscalao = tipo;
    	this.treinador = t;
    	this.jogadores = j;
    	this.agenda = a;
    	this.dados = d;
        APEF.IDENTIFICADOR++;
    }
    
    public Escalao(int tipo) {
        this. id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipo;
        this.nomeEquipa = "";
        this.treinador = new Treinador();
    	this.jogadores = new HashMap<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos(); 
        APEF.IDENTIFICADOR++;
    }

    public Escalao(Escalao p) {
        this.id = p.getID();
        this.tipoEscalao = p.getTipoEscalao();
        this.nomeEquipa = p.getNomeEquipa();
    	this.treinador = p.getTreinador();
    	this.jogadores = p.getJogadores();
        this.agenda = p.getAgenda();
        this.dados = p.getDados();
    }

    //Getters
    public int getID(){
        return this.id;
    }
    
    public int getTipoEscalao(){
        return this.tipoEscalao;
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
        
		
		return str.toString(); 
	}

    
    /**
    * Metodos Jogadores
    */
    
    public void inserirJogador(Jogador j) {
    	if( !(this.jogadores.containsKey(j.getID())) )
    			this.jogadores.put(j.getID(), j);
    }
        
    public void removerJogador(Jogador j) { /* DEVE Faltar verificacoes */
        this.jogadores.remove(j);
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
	
	/*FALTA METODO PARA MEXER NO CALENDARIO DO Escalao*/
}

