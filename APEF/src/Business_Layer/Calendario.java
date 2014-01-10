package Business_Layer;

import Data_Layer.JornadaDAO;
import java.util.Map;
import java.util.TreeSet;
import java.util.Objects;

public class Calendario {
	
	//Variaveis de Instancia  
    private int idCalendario;
    private Map<Integer,Jornada> jornadas;

    //Construtores
	public Calendario() {
        this.idCalendario = APEF.getID();
		this.jornadas = new JornadaDAO(idCalendario);
        APEF.putID();
    }
    
    public Calendario(int id, Map<Integer,Jornada> jo) {
        this.idCalendario = id;
        this.jornadas = jo;
    }

    public Calendario(Calendario c) {
    	this.jornadas = c.getJornadas();
    }

    //Getters
    public Map<Integer,Jornada> getJornadas() {
    	Map<Integer,Jornada> aux = new JornadaDAO(this.idCalendario);
        for(Jornada j: this.jornadas.values()) 
            aux.put(j.getID(), j);
        return aux;
    }
    
    public int getID() {
        return this.idCalendario;
    }

    //Setters
    public void setJornadas(Map<Integer,Jornada> j) {
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
        for (Jornada j : this.jornadas.values()){
            str.append(j);
        }

    	return str.toString();
    } 

    public void inserirJornada(Jornada j) {
        if (!this.jornadas.containsKey(j.getNrJornada()))
            this.jornadas.put(j.getID(), j);
    }

    public void removerJornada(Jornada j) {
        this.jornadas.remove(j);
    }

	public boolean atualizaCalendario(Jogo j, APEF a) {
		boolean flag = false;
		for(Jornada jr : this.jornadas.values())
			if(jr.getJogosRealizados() < jr.getListaJogos().size() )
				flag = jr.atualizaJornada(j);		
		return flag;
	}
}
