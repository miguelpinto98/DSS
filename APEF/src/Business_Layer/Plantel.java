package Business_Layer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

public class Plantel {
    
	//Variaveis de Instancia
    private Treinador treinador;
    private HashSet<Jogador> jogadores;

    //Construtores
    public Plantel() {
    	this.treinador = new Treinador();
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
        HashSet<Jogador> aux = new HashSet<Jogador>();
        for(Jogador j: this.jogadores) 
            aux.add(j.clone());
        return aux;
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
        final int prime = 7;
        int result = 1;
        result = prime * result + ((this.jogadores == null) ? 0 : this.jogadores.hashCode());
        return result;
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
        if (jogadores.size() < 12) 
            this.jogadores.add(j);
    }
        
    public void removerJogador(Jogador j) {
        this.jogadores.remove(j);
    }
    
    public Set<Jogador> procurarJogadorNome(String jogador) {
        Set<Jogador> res = new HashSet<Jogador>();
    	for (Iterator<Jogador> it = this.jogadores.iterator(); it.hasNext();) {
            Jogador j = it.next();
            if(j.getNome().contains(jogador))
                res.add(j.clone());
        }
        return res;
    }
}

