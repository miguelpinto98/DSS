package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Objects;

public class Epoca {

    private static final int indexInfantis = 0;
    private static final int indexBenjamins = 1;
    private static final int indexTraquinas = 2;
    private static final int indexPetizes = 3;
    private static final int maxEscaloes = 4;

    //Variaveis de Instancia
    private int ano;
    private Campeonato[] campeonatos;
    private ArrayList<HashSet<Torneio>> torneios;

    //Construtores
    public Epoca() {
    	this.ano = 0;
    	this.campeonatos = new Campeonato[maxEscaloes];
    	this.torneios = new ArrayList<HashSet<Torneio>>();
    }

    public Epoca(int ano, Campeonato[] c, ArrayList<HashSet<Torneio>> t){
        this.ano = ano;
        this.campeonatos = c;
        this.torneios = t;
    }

    public Epoca(Epoca e) {
    	this.ano = e.getAno();
    	this.campeonatos = e.getCampeonatos();
    	this.torneios = e.getTorneios();
    }
    
    public Epoca(int ano) {
    	this.ano = ano;
    	this.campeonatos = new Campeonato[maxEscaloes];
    	this.torneios = new ArrayList<>();
    }

    //Getters
    public int getAno() {
        return this.ano;
    }
    
    public Campeonato[] getCampeonatos() {
        Campeonato[] aux = new Campeonato[maxEscaloes];
        int i;
        for(i=0;i<maxEscaloes;i++){
            if(this.campeonatos[i]!=null)
                aux[i] = this.campeonatos[i].clone();
        }
        return aux;
    }
    
    public ArrayList<HashSet<Torneio>> getTorneios() {
        ArrayList<HashSet<Torneio>> array = new ArrayList<>();
        HashSet<Torneio> hash = null;
        int i;
        
        for(i=0;i<this.torneios.size();i++){
            hash = new HashSet<>();
            for(Torneio t: this.torneios.get(i)){ 
                hash.add(t.clone());
            }
            array.add(hash);
        }
        return array;
    }

    //Setters
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCampeonatos(Campeonato[] c) {
        this.campeonatos = c;
    }
    public void setTorneios(ArrayList<HashSet<Torneio>> t) {
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
            return ( this.ano == t.getAno() && this.campeonatos.equals(t.getCampeonatos()) &&
        			this.torneios.equals(t.getTorneios()));
        }
    } 

    public Epoca clone() {
        return new Epoca(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder(); 
        
        str.append("--Epoca--\n");
        str.append(this.getAno() + "\n");
		str.append(this.getCampeonatos() + "\n");
		str.append(this.getTorneios() + "\n");
        return str.toString(); 
    }

    public boolean existeNomeCampeonato(String n) {
        boolean res=false;
        for(Campeonato c : this.campeonatos) {
            if(c.getNome().equals(n)) 
                res=true;
            else
                res=false;    
        }
        
        return res;
    }
    
    public void inserirCampeonato(Campeonato c) {
        this.campeonatos[c.getTipoEscalao()] = c;
    }
    
    public void inscreveEmCampeonato(Escalao e) {
        this.campeonatos[e.getTipoEscalao()].inscreverEscalao(e);
    }
    
    public void inscreveEmTorneio(Escalao e, int id) {
        for(Torneio t: this.torneios.get(e.getTipoEscalao())) {
            if(t.getID() == id)
                t.inscreverEscalao(e);
        }
    }

	public void atualizaEpoca(Jogo j) {
		int idEscalao = j.getEscalaoCasa().getTipoEscalao();
		boolean encontrou = false, encontrouT = false;
		
		while(!encontrou && !encontrouT) {
			encontrou = this.campeonatos[idEscalao].atualizaCampeonato(j);
			for(Torneio t: this.torneios.get(idEscalao)) {
                if(t.getID() == j.getIdCompeticao()) {
                    encontrouT = t.atualizaTorneio(j);
                }
            }
        }
    }
}

