package Business_Layer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
    private int nFase;
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
        this.nFase = 0;
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
        this.nFase = 0;
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
        this.nFase = t.getNFase();
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
    
    public int getNFase() {
        return this.nFase;
    }

    public void setNFase(int n) {
        this.nFase = n;
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
    
    public Escalao buscaEscalao(int id) {
        Escalao res = new Escalao();
        boolean flag = false;
        Iterator<Escalao> it = this.listaEscaloes.iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            if (e.getID()==id) {
                res = e;
                flag = true;
            }
        }
        return res;
    }
    
    public void atualizaGoleadores(Jogo j) {
        int contador;
        for(Integer id: j.getGoleadoresJogo()) {
            if(this.goleadores.containsKey(id)) {
                contador = this.goleadores.get(id);
                this.goleadores.put(id, contador+1);
            }
            else
                this.goleadores.put(id, 1); 
        }
    }
    
    public ArrayList<Integer> melhoresMarcadoresAux() {
        HashMap<Integer,Integer> aux = this.goleadores;
        ArrayList<Integer> res = new ArrayList<>();
        int maxGolos = Collections.max(aux.values());

		Iterator<Integer> it = this.goleadores.keySet().iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (maxGolos == this.goleadores.get(id)) {
                res.add(id);
                aux.remove(id);
            }
        }
        return res; 
    }
    
    public Jogador buscaJogador(int id) {
        Jogador res = new Jogador();
        boolean flag = false;
        
        Iterator<Escalao> it = this.listaEscaloes.iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            Iterator<Integer> it2 = e.getJogadores().keySet().iterator(); 
            while (it2.hasNext() && !flag) {
                Integer i = it2.next();
                if (i==id) {
                    res = e.getJogadores().get(id);
                    flag = true;
                }
            }
        }
        return res;
    }
        
    public ArrayList<Jogador> melhoresMarcardores() {
        ArrayList<Jogador> res = new ArrayList<>();
        ArrayList<Integer> aux = melhoresMarcadoresAux();
        Jogador j = new Jogador();
        for (int i = 0; i < aux.size(); i++) {
            j = buscaJogador(aux.get(i));
            res.add(i,j);
        }
        return res;
    }
    public boolean atualizaTorneio(Jogo j) {
        this.atualizaGoleadores(j);
        this.estatisticaCompeticao.actualizaClassificacao(j);
        return this.fases.get(this.getNFase()).atualizaFase(j);
    }
}
