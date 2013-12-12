package Business_Layer;

import java.util.HashSet;
import java.util.Objects;

public class Calendario {
	
	//Variaveis de Instancia    
    private HashSet<Jornada> jornadas;

    //Construtores
	public Calendario() {
		this.jornadas = new HashSet<>();
    }

    public Calendario(Calendario c) {
    	this.jornadas = c.getJornadas();
    }

    //Getters
    public HashSet<Jornada> getJornadas() {
    	HashSet<Jornada> aux = new HashSet<Jornada>();
        for(Jornada j: this.jornadas) 
            aux.add(j.clone());
        return aux;
    }

    //Setters
    public void setJornadas(HashSet<Jornada> j) {
    	this.jornadas = j;
    }
    
    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.jornadas);
        return hash;
    }

  	public boolean equals(Object o) {
    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Calendario c = (Calendario) o;
    	return this.jornadas.equals(c.getJornadas());
        }
    }
    
    public Calendario clone() {
        return new Calendario(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Calendario--\n") ;

    	return str.toString();
    } 

    public void inserirJornada(Jornada j) {
        if (!this.jornadas.contains(j))
            this.jornadas.add(j);
    }

    public void removerJornada(Jornada j) {
        this.jornadas.remove(j);
    }
}
