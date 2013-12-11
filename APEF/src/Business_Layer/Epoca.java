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
    /*
    public void abreCampeonato(String nome, GregorianCalendar limiteInscricao, int tipoEscalao, int limiteEquipas) {   
        if(!existeNomeCampeonato(nome)) {
            Campeonato c = new Campeonato(APEF.IDENTIFICADOR,nome,limiteInscricao,tipoEscalao,limiteEquipas);
            if (tipoEscalao < 4 && tipoEscalao >= 0) 
                this.campeonatos[tipoEscalao] = c;
                APEF.IDENTIFICADOR++; 
        }
        else
            System.out.println("Nome já existe");
    }
    
    public void inscreverEmCompeticao(Escalao e, int tipo) {
        int nr = this.campeonatos[tipo].getNrEscaloes();
        GregorianCalendar agora = new GregorianCalendar();
        
        if(this.campeonatos[tipo].getListaEscaloes().size() > 0 && agora.compareTo(this.campeonatos[tipo].getDataInicio()) <= 0 ) {
            this.campeonatos[tipo].getListaEscaloes().add(e);
            this.campeonatos[tipo].setNrEscaloes(nr-1);  
        }
        
        else
            System.err.println("erro");
    }*/
}
