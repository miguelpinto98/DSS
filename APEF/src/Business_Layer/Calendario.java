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
        this.idCalendario = APEF.IDENTIFICADOR;
		this.jornadas = new JornadaDAO(idCalendario);
        APEF.IDENTIFICADOR++;
    }

    public Calendario(Calendario c) {
    	this.jornadas = c.getJornadas();
    }

    //Getters
    public Map<Integer,Jornada> getJornadas() {
    	Map<Integer,Jornada> aux = new JornadaDAO();
        for(Jornada j: this.jornadas.values()) 
            aux.put(j.getNrJornada(), j);
        return aux;
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
