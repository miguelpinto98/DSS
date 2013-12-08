package Business_Layer;

import java.util.HashSet;

public abstract class Fase {
    
    //Variaveis de Instancia
    private String nome;
    private HashSet<Equipa> listaEquipas;
    private Calendario calendario;

    public Fase() {
        this.nome = "";
        this.listaEquipas = new HashSet<>();
        this.calendario = new Calendario();
    }
        
    public Fase(Fase f) {
        this.nome = f.getNome();
        this.listaEquipas = f.getListaEquipas();
        this.calendario = f.getCalendario();
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public HashSet<Equipa> getListaEquipas() {
        HashSet<Equipa> aux = new HashSet<Equipa>();
        for(Equipa e: this.listaEquipas) 
            aux.add(e.clone());
        return aux;
    }

    public void setListaEquipas (HashSet<Equipa> le){
        this.listaEquipas = le;
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
}
