package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;

public class Torneio implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private String nome;
    private int nrEscaloes;
    private HashMap<Integer,Integer> goleadores;
    private EstatisticaCompeticao estatisticaCompeticao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataLimiteInscricoes;
    private ArrayList<Fase> fases;
    private Campo campo; 

    public Torneio() {
        this.id = 0;
        this.nome = "";
        this.nrEscaloes = 0;
        this.goleadores = new HashMap<>();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new ArrayList<>();
        this.dataInicio = new GregorianCalendar();
        this.dataLimiteInscricoes = new GregorianCalendar();
        this.campo = new Campo();
    }
        
	public Torneio(Torneio t) {
        this.id = t.getID();
        this.nome = t.getNome();
        this.nrEscaloes = t.getNrEscaloes();
        this.goleadores = t.getGoleadores();
        this.estatisticaCompeticao = t.getEstatisticaCompeticao();
        this.fases = t.getFases();
        this.dataInicio = t.getDataInicio();
        this.dataLimiteInscricoes = t.getDataLimiteInscricoes();
        this.campo = t.getCampo();
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

    public int getNrEscaloes() {
        return this.nrEscaloes;
    }

    public void setNrEscaloes(int nrEscaloes) {
        this.nrEscaloes = nrEscaloes;
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

    public EstatisticaCompeticao getEstatisticaCompeticao(){
        return this.estatisticaCompeticao;
    }

    public void setEstatisticaCompeticao(EstatisticaCompeticao ec){
        this.estatisticaCompeticao = ec;
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

    public GregorianCalendar getDataLimiteInscricoes(){
        return this.dataLimiteInscricoes;
    }

    public void setDataLimiteInscricoes (GregorianCalendar data){
        this.dataLimiteInscricoes = data;
    }

    public Campo getCampo(){
        return this.campo;
    }

    public void setCampo(Campo c){
        this.campo = c;
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
