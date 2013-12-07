package Business_Layer;

import java.util.HashMap;
import java.util.Objects;

public class Campeonato implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private String nome;
    private int nrEquipas;
    private Calendario calendario;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
    private Classificacao classificacao;

    //Construtores
    public Campeonato() {
    	this.id = 0;
    	this.nome = "";
    	this.nrEquipas = 0;
    	this.calendario = new Calendario();
    	this.goleadores = new HashMap<>();
        this.classificacao = null;
    }
    
    public Campeonato(Campeonato ca) {
    	this.id = ca.getID();
    	this.nome = ca.getNome();
    	this.nrEquipas = ca.getNrEquipas();
    	this.calendario = ca.getCalendario();
    	this.goleadores = ca.getGoleadores();
        this.classificacao = ca.getClassificacao();
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


