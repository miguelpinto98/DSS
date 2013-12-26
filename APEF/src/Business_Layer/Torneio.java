package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Torneio implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nome;
    private int nrEscaloes;
    private HashMap<Integer,Integer> goleadores;
    private HashSet<Escalao> listaEscaloes;
    private EstatisticaCompeticao estatisticaCompeticao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataLimiteInscricoes;
    private ArrayList<Fase> fases;
    private Campo campo; 

    public Torneio() {
        this.id = 0;
        this.tipoEscalao = -1;
        this.nome = "";
        this.nrEscaloes = 0;
        this.goleadores = new HashMap<>();
        this.listaEscaloes = new HashSet<>();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new ArrayList<>();
        this.dataInicio = new GregorianCalendar();
        this.dataLimiteInscricoes = new GregorianCalendar();
        this.campo = new Campo();
    }
    
    public Torneio(String nome, GregorianCalendar limite, int tipo, int nrEquipas, Campo campo){
        this.id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipo;
        this.nome = nome;
        this.nrEscaloes = nrEquipas;
        this.goleadores = new HashMap<>();
        this.listaEscaloes = new HashSet<>();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new ArrayList<>();
        this.dataInicio = new GregorianCalendar();
        this.dataLimiteInscricoes = limite;
        this.campo = campo;
    }   

	public Torneio(Torneio t) {
        this.id = t.getID();
        this.tipoEscalao = t.getTipoEscalao();
        this.nome = t.getNome();
        this.nrEscaloes = t.getNrEscaloes();
        this.goleadores = t.getGoleadores();
        this.listaEscaloes = t.getListaEscaloes();
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

    public int getTipoEscalao() {
        return this.tipoEscalao;
    }

    public void setTipoEscalao(int t) {
        this.tipoEscalao = t;
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
    
    public HashSet<Escalao> getListaEscaloes() {
        HashSet<Escalao> aux = new HashSet<Escalao>();
        for(Escalao e: this.listaEscaloes) 
            aux.add(e);
        return aux;
    }

    public void setListaEscaloes (HashSet<Escalao> le){
        this.listaEscaloes = le;
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
    
    /** Metodos */
    public void inserirEscalao(Escalao e) {
        if(!this.listaEscaloes.contains(e))
            this.listaEscaloes.add(e);
    }

    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e);
    }

    public void inscreverEscalao(Escalao e) {
        inserirEscalao(e);
        this.nrEscaloes++;//no caso dos torneios temos de ver melhor isto ,,, 
                          // nao se sabe quantas equipas vai ter logo nao podes inicia-lo com um valor ,,,
                          // mais vale fazer o inverso, começar a 0 e incrementar
    }
}
