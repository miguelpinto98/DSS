package Business_Layer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Epoca implements Comparable<Epoca>{

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
        HashSet<Torneio> tor = new HashSet<>();
        this.torneios.add(0,tor);
        this.torneios.add(1,tor);
        this.torneios.add(2,tor);
        this.torneios.add(3,tor);
        this.torneios.add(4,tor);
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
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.torneios);
        return hash;
    }
    
    @Override
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

    @Override
    public Epoca clone() {
        return new Epoca(this);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(); 
        
        str.append("--Epoca--\n");
        str.append(this.getAno()).append("\n");
		str.append(this.getCampeonatos()).append("\n");
		str.append(this.getTorneios()).append("\n");
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
    
    public void inserirTorneio(Torneio t){
        
     this.torneios.get(t.getTipoEscalao()).add(t);
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

	public void atualizaEpoca(Jogo j, APEF a) {
		int idEscalao = j.getEscalaoCasa().getTipoEscalao();
		boolean encontrou = false, encontrouT = false;
		
		while(!encontrou && !encontrouT) {
			encontrou = this.campeonatos[idEscalao].atualizaCampeonato(j,a);
			for(Torneio t: this.torneios.get(idEscalao)) {
                if(t.getID() == j.getIdCompeticao()) {
                    if(t.getTipoTorneio() == 1)
                        encontrouT = t.atualizaTorneioTipo1(j,a);
                    if(t.getTipoTorneio() == 2)
                        t.atualizaTorneioTipo2(j, a);
                    //if(t.getTipoTorneio() == 3)
                        //t.atualizaTorneioTipo3(j, a);
                }
            }
        }
    }
        

    public String procuraCampeonato (Integer idCamp){
       int i=0, flag=1;
        String nome= null;
            while (i<4 && flag==1){
                if(this.campeonatos[i].getID()==idCamp) {nome=this.campeonatos[i].getNome(); flag=0;}
                i++;
            }
    return nome;}

    public String procuraTorneio (Integer id){
        String nome=null;
        boolean encontrado=false;        
            for(int i=0; (i<this.torneios.size() && encontrado==false); i++){
                for(Torneio t: this.torneios.get(i)){ 
                    if (t.getID()==id) {nome=t.getNome(); encontrado=true;}
                }
           }
      return nome;
    }
    
    public void avancaDataCampeonto(GregorianCalendar data, int tipoEscalao) {
        boolean flag=false;
        int jornada = 0;
        Iterator<Jornada> it = this.campeonatos[tipoEscalao].getCalendario().getJornadas().iterator();
        while(it.hasNext() && !flag) {
            Jornada jr = it.next();
            Iterator<Jogo> it2 = jr.getListaJogos().iterator();
            while(it2.hasNext() && !flag) {
                Jogo jg = it2.next();
                if( data.get(GregorianCalendar.YEAR) == jg.getDiaJogo().get(GregorianCalendar.YEAR) && data.get(GregorianCalendar.MONTH) == jg.getDiaJogo().get(GregorianCalendar.MONTH) && data.get(GregorianCalendar.DAY_OF_MONTH) == jg.getDiaJogo().get(GregorianCalendar.DAY_OF_MONTH)) {
                    flag = true;
                    jornada = jr.getNrJornada();
                }
            }
        } 
        for(Jornada jor : this.campeonatos[tipoEscalao].getCalendario().getJornadas()) {
            if(jor.getNrJornada() == jornada) {
                for(Jogo jg : jor.getListaJogos()) {
                    jg.setDia(this.campeonatos[tipoEscalao].dataJornadaSeguinte(jg.getDiaJogo()));

                }
                jornada++;
            } 
        } 
    }

    @Override
    public int compareTo(Epoca o) {
        if(o.getAno() < this.ano)
            return -1;
        if(o.getAno() > this.ano)
            return 1;
        else
            return 0;
    }
}

