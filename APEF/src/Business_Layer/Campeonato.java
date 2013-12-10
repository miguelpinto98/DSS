package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Campeonato implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nome;
    private int nrPlanteis;
    private Calendario calendario;
    private HashSet<Plantel> listaPlanteis;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
    private Classificacao classificacao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;

    //Construtores
    public Campeonato() {
    	this.id = 0;
        this.tipoEscalao = -1;
    	this.nome = "";
    	this.nrPlanteis = 0;
    	this.calendario = new Calendario();
        this.listaPlanteis = new HashSet<>();
    	this.goleadores = new HashMap<>();
        this.classificacao = null;
        this.dataInicio = new GregorianCalendar();
        this.dataFim = new GregorianCalendar();
    }
    
    public Campeonato(Campeonato ca) {
    	this.id = ca.getID();
        this.tipoEscalao = ca.getTipoEscalao();
    	this.nome = ca.getNome();
    	this.nrPlanteis = ca.getNrPlanteis();
    	this.calendario = ca.getCalendario();
        this.listaPlanteis = ca.getListaPlanteis();
    	this.goleadores = ca.getGoleadores();
        this.classificacao = ca.getClassificacao();
        this.dataInicio = ca.getDataInicio();
        this.dataFim = ca.getDataFim();
    }

    public Campeonato(int id, String nome, GregorianCalendar i, int tipo) {
        this.id = id;
        this.tipoEscalao = tipo;
        this.nome = nome;
        this.nrPlanteis = 0;
        this.calendario = new Calendario();
        this.listaPlanteis = new HashSet<>();
        this.goleadores = new HashMap<>();
        this.classificacao = new Classificacao();
        this.dataInicio = i;
        this.dataFim = i;
    }

    //Getters e Setters
    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public int getTipoEscalao() {
        return this.tipoEscalao;
    }

    public void setTipoEscalao(int tipo) {
        this.tipoEscalao = tipo;
    }
    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNrPlanteis() {
        return this.nrPlanteis;
    }

    public void setNrPlanteis(int nrPlanteis) {
        this.nrPlanteis = nrPlanteis;
    }

    public Calendario getCalendario() {
        return this.calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public HashSet<Plantel> getListaPlanteis() {
        HashSet<Plantel> aux = new HashSet<Plantel>();
        for(Plantel e: this.listaPlanteis) 
            aux.add(e.clone());
        return aux;
    }

    public void setListaPlanteis (HashSet<Plantel> le){
        this.listaPlanteis = le;
    }
    
    public Classificacao getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public HashMap<Integer, Integer> getGoleadores() {
		HashMap<Integer,Integer> hsg = new HashMap<>();
		for(Integer n : this.goleadores.keySet())
			hsg.put(n, this.goleadores.get(n));
		
		return hsg;
	}

    public void setGoleadores(HashMap<Integer, Integer> goleadores) {
        this.goleadores = goleadores;
    }

    public GregorianCalendar getDataInicio(){
        return this.dataInicio;
    }

    public void setDataInicio (GregorianCalendar data) {
        this.dataInicio = data;
    }

    public GregorianCalendar getDataFim(){
        return this.dataFim;
    }

    public void setDataFim (GregorianCalendar data){
        this.dataFim = data;
    }
    
    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.goleadores);
        return hash;
    }
    
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
        	Campeonato c = (Campeonato) o;
        	return (this.getID() == c.getID());
        }
    }

    public Campeonato clone() {
    	return new Campeonato(this);
    }

    public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("--Campeonato--\n");
		
		return str.toString(); 
	}
}


