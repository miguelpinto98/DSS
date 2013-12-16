package Business_Layer;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class Jornada implements Comparable<Jornada>{
    
    //Variaveis de Instancia
    private int nrJornada;
    private HashSet<Jogo> listaJogos; 

    //Construtores
    public Jornada() {
        this.nrJornada = 0;
        this.listaJogos = new HashSet<Jogo>();
    }
    
    public Jornada(Jornada j) {
        this.nrJornada = j.getNrJornada();
        this.listaJogos = j.getListaJogos();
    }
    
    //Getters
    //Getters
    public int getNrJornada() {
        return this.nrJornada;
    }
    
    public HashSet<Jogo> getListaJogos() {
        HashSet<Jogo> aux = new HashSet<Jogo>();
        for(Jogo e: this.listaJogos) 
            aux.add(e);
        return aux;
    }
    
    //Setter
    public void setNrJornada(int n){
        this.nrJornada = n;
    }
    
    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.listaJogos);
        return hash;
    }

    public boolean equals(Object o) {
        if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Jornada j = (Jornada) o;
    	return this.listaJogos.equals(j.getListaJogos());
        }
    }
    
    public int compareTo(Jornada j) {
        if(j.getNrJornada() < this.nrJornada) return 1;
        if(j.getNrJornada() > this.nrJornada) return -1;
        else return 0;
    }
    
    public Jornada clone() {
        return new Jornada(this);
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("--Jornada número: "+this.getNrJornada()+" --\n") ;
        str.append(this.getListaJogos());

        return str.toString();
    }

    public void removerJogo(Jogo j) {
        this.listaJogos.remove(j);
    }


    public void inserirJogo(Jogo j) {
        if (!this.listaJogos.contains(j))
            this.listaJogos.add(j);
    }

}
