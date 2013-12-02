package Business_Layer;

import java.util.HashSet;
import java.util.Objects;

public class Epoca {

    //Variaveis de Instancia
    private String nome;
    private Campeonato campeonato;
    private HashSet<Torneio> torneios;

    //Construtores
    public Epoca() {
    	this.nome = "";
    	this.campeonato = new Campeonato();
    	this.torneios = new HashSet<>();
    }

    public Epoca(String n, Campeonato c, HashSet<Torneio> t){
        this.nome = n;
        this.campeonato = c;
        this.torneios = t;
    }

    public Epoca(Epoca e) {
    	this.nome = e.getNome();
    	this.campeonato = e.getCampeonato();
    	this.torneios = e.getTorneios();
    }

    //Getters
    public String getNome() {
        return this.nome;
    }
    
    public Campeonato getCampeonato() {
        return this.campeonato;
    }
    
    public HashSet<Torneio> getTorneios() {
        HashSet<Torneio> aux = new HashSet<Torneio>();
        for(Torneio t: this.torneios) 
            aux.add(t.clone());
        return aux;
    }

    //Setters
    public void setNome(String n) {
        this.nome = n;
    }

    public void setCampeonato(Campeonato c) {
        this.campeonato = c;
    }
    public void setTorneios(HashSet<Torneio> t) {
        this.torneios = t;
    }	

    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.torneios);
        return hash;
    }
    
    public boolean equals(Object o) {
        if (this == null)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
            Epoca t = (Epoca) o;
            return ( this.nome.equals(t.getNome()) && this.campeonato.equals(t.getCampeonato()) &&
        			this.torneios.equals(t.getTorneios()) );
        }
    }

    public Epoca clone() {
        return new Epoca(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder(); 
        
        str.append("--Epoca--\n");
        str.append(this.getNome() + "\n");
		str.append(this.getCampeonato() + "\n");
		str.append(this.getTorneios() + "\n");
        return str.toString(); 
    }
}
