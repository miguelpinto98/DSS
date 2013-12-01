package Business_Layer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

public class Plantel {
    
	//Variaveis de Instancia
    private Treinador treinador;
    private HashSet<Jogador> jogadores;

    //Construtores
    public Plantel() {
    	this.treinador = null;
    	this.jogadores = new HashSet<>();
    }

    public Plantel(Plantel p) {
    	this.treinador = p.getTreinador();
    	this.jogadores = p.getJogadores();
    }

    //Getters
    public Treinador getTreinador() {
        return this.treinador;
    }
    
    public HashSet<Jogador> getJogadores() {
        return this.jogadores;
    }
   
    //Setters
    public void setTreinador(Treinador t) {
        this.treinador = t;
    }

    public void setJogadores(HashSet<Jogador> j) {
        this.jogadores = j;
    }

    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.jogadores);
        return hash;
    }

    public boolean equals(Object o) {
        if (this == null)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
        	Plantel p = (Plantel) o;
        	return this.treinador.equals(p.getTreinador()) && this.jogadores.equals(p.getJogadores());
        }
    }

    public Plantel clone() {
    	return new Plantel(this);
    }

    public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("--Plantel--\n");
		
		return str.toString(); 
	}

	//Metodos
	public void inserirJogador(Jogador j) {
        } 
        
        public void removerJogador(Jogador j) {
        }
        
        public void editarJogador(Jogador j) {
        }
        
        public Set<Jogador> procurarJogador(String nome) {
            Set<Jogador> res = new HashSet<Jogador>();
            return res;
        }
}

