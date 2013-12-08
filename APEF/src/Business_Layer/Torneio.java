package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;

public class Torneio implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private String nome;
    private int nrEquipas;
    private HashMap<Integer,Integer> goleadores;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;
    private ArrayList<Fase> fases;    

    public Torneio() {
        this.id = 0;
        this.nome = "";
        this.nrEquipas = 0;
        this.goleadores = new HashMap<>();
        this.fases = new ArrayList<>();
        this.dataInicio = new GregorianCalendar();
        this.dataFim = new GregorianCalendar();
    }
        
	public Torneio(Torneio t) {
        this.id = t.getID();
        this.nome = t.getNome();
        this.nrEquipas = t.getNrEquipas();
        this.goleadores = t.getGoleadores();
        this.fases = t.getFases();
        this.dataInicio = t.getDataInicio();
        this.dataFim = t.getDataFim();
	}

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNrEquipas() {
        return this.nrEquipas;
    }

    public void setNrEquipas(int nrEquipas) {
        this.nrEquipas = nrEquipas;
    }

    public HashMap<Integer, Integer> getGoleadores() {
        HashMap<Integer,Integer> hsg = new HashMap<>();
        for(Integer n : this.goleadores.keySet())
            hsg.put(n, this.goleadores.get(n));
        
        return hsg;
    }

    public void setGoleadores(HashMap<Integer, Integer> goleadores) {
        this.goleadores = goleadores;
    }

    public ArrayList<Fase> getFases(){
        ArrayList<Fase> aux = new ArrayList<>();

        for(Fase f : this.fases){
            aux.add(f);
        }
        return aux;
    }

    public void setFases (ArrayList<Fase> al){
        this.fases = al;
    }
    
    public GregorianCalendar getDataInicio(){
        return this.dataInicio;
    }

    public void setDataInicio (GregorianCalendar data) {
        this.dataInicio = data;
    }

    public GregorianCalendar getDataFim(){
        return this.dataFim;
    }

    public void setDataFim (GregorianCalendar data){
        this.dataFim = data;
    }

    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.goleadores);
        return hash;
    }
    
    public boolean equals(Object o) {
        if (this == null)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
            Torneio c = (Torneio) o;
            return (this.getID() == c.getID());
        }
    }

    public Torneio clone() {
        return new Torneio(this);
    }   

    public String toString() {
        StringBuilder str = new StringBuilder(); 
        
        str.append("--Torneio--\n");
        
        return str.toString(); 
    } 
}
