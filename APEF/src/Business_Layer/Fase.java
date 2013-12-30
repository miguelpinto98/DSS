package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Fase {
    
    //Variaveis de Instancia
    private String nome;
    private HashSet<Escalao> listaEscaloes;
    private Calendario calendario;

    public Fase() {
        this.nome = "";
        this.listaEscaloes = new HashSet<>();
        this.calendario = new Calendario();
    }

    public Fase(String nome, HashSet<Escalao> le) {
        this.nome = nome;
        this.listaEscaloes = le;
        this.calendario = new Calendario();
    }

    public Fase(Fase f) {
        this.nome = f.getNome();
        this.listaEscaloes = f.getListaEscaloes();
        this.calendario = f.getCalendario();
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public HashSet<Escalao> getListaEscaloes() {
        HashSet<Escalao> aux = new HashSet<Escalao>();
        for(Escalao e: this.listaEscaloes) 
            aux.add(e);
        return aux;
    }

    public void setListaEquipas (HashSet<Escalao> le){
        this.listaEscaloes = le;
    }

    public Calendario getCalendario() {
        return this.calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    //Equals,hashCode,Clone,toString
    
    public abstract boolean equals(Object o);

    public abstract Fase clone();

    public abstract String toString();

    public void inserirEscalao(Escalao e) {
        if (!this.listaEscaloes.contains(e))
            this.listaEscaloes.add(e);
    }
    
    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e.getID());
    }

    /**Metodos*/
   
}
