package Business_Layer;

import java.util.Objects;
import java.util.TreeSet;

public class Jornada {
    
    //Variaveis de Instancia
    private TreeSet<Jogo> jogos; 

    //Construtores
    public Jornada() {
        this.jogos = new TreeSet<>();
    }
    
    public Jornada(Jornada j) {
        this.jogos = j.getJogos();
    }
    
    //Getters
    public TreeSet<Jogo> getJogos() {
        TreeSet<Jogo> aux = new TreeSet<Jogo>();
        for(Jogo j: this.jogos) 
            aux.add(j.clone());
        return aux;
    }

    //Setters
    public void setJogos(TreeSet<Jogo> jogos) {
        this.jogos = jogos;
    }

    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.jogos);
        return hash;
    }

    public boolean equals(Object o) {
        if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Jornada j = (Jornada) o;
    	return this.jogos.equals(j.getJogos());
        }
    }
    
    public Jornada clone() {
        return new Jornada(this);
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
    	str.append("--Calendario--\n") ;

    	return str.toString();
    }  
}
