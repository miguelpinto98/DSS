package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Objects;

public class Epoca {

    //Variaveis de Instancia
    private int ano;
    private ArrayList<Campeonato> campeonatos; //[1ºpetizes,2ºtraquinas,3ºbenjamins,4ºinfantis]
    private ArrayList<HashSet<Torneio>> torneios;

    //Construtores
    public Epoca() {
    	this.ano = 0;
    	this.campeonatos = new ArrayList<>();
    	this.torneios = new ArrayList<>();
    }

    public Epoca(int ano, ArrayList<Campeonato> c, ArrayList<HashSet<Torneio>> t){
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
    	this.campeonatos = new ArrayList<>();
    	this.torneios = new ArrayList<>();
    }

    //Getters
    public int getAno() {
        return this.ano;
    }
    
    public ArrayList<Campeonato> getCampeonatos() {
        ArrayList<Campeonato> aux = new ArrayList<>();
        int i;
        for(i=0;i<this.campeonatos.size();i++){
            aux.add(this.campeonatos.get(i).clone());
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

    public void setCampeonatos(ArrayList<Campeonato> c) {
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
    
    public void criarCampeonato(String nome, int nrEquipas, GregorianCalendar i, GregorianCalendar f) {   
        if(!existeNomeCampeonato(nome)) {
            Campeonato c = new Campeonato(APEF.IDENTIFICADOR,nome,nrEquipas,i,f);
            this.campeonatos.add(c);
            APEF.IDENTIFICADOR++;
        }
        else
            System.out.println("Nome já existe");
    }

}
