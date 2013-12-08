package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Campeonato implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private String nome;
    private int nrEquipas;
    private Calendario calendario;
    private HashSet<Equipa> listaEquipas;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
    private Classificacao classificacao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;

    //Construtores
    public Campeonato() {
    	this.id = 0;
    	this.nome = "";
    	this.nrEquipas = 0;
    	this.calendario = new Calendario();
        this.listaEquipas = new HashSet<>();
    	this.goleadores = new HashMap<>();
        this.classificacao = null;
        this.dataInicio = new GregorianCalendar();
        this.dataFim = new GregorianCalendar();
    }
    
    public Campeonato(Campeonato ca) {
    	this.id = ca.getID();
    	this.nome = ca.getNome();
    	this.nrEquipas = ca.getNrEquipas();
    	this.calendario = ca.getCalendario();
        this.listaEquipas = ca.getListaEquipas();
    	this.goleadores = ca.getGoleadores();
        this.classificacao = ca.getClassificacao();
        this.dataInicio = ca.getDataInicio();
        this.dataFim = ca.getDataFim();
    }
    
    //Getters e Setters
    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNrEquipas() {
        return this.nrEquipas;
    }

    public void setNrEquipas(int nrEquipas) {
        this.nrEquipas = nrEquipas;
    }

    public Calendario getCalendario() {
        return this.calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public HashSet<Equipa> getListaEquipas() {
        HashSet<Equipa> aux = new HashSet<Equipa>();
        for(Equipa e: this.listaEquipas) 
            aux.add(e.clone());
        return aux;
    }

    public void setListaEquipas (HashSet<Equipa> le){
        this.listaEquipas = le;
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
        if (this == null)
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


