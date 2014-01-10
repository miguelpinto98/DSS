package Business_Layer;

import Data_Layer.EscalaoDAO;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public abstract class Fase {
    
    //Variaveis de Instancia
    private int idFase;
    private String nome;
    private Map<Integer,Escalao> listaEscaloes;
    private Calendario calendario;
    private int tipo;
    private int nFase;

    public Fase() {
        this.idFase = APEF.IDENTIFICADOR;
        this.nome = "";
        this.listaEscaloes = new EscalaoDAO(this.idFase);
        this.calendario = new Calendario();
        this.tipo = -1;
        this.nFase = 0;
        APEF.IDENTIFICADOR++;
    }

    public Fase(String nome, int tipo,int n) {
        this.idFase = APEF.IDENTIFICADOR;
        this.nome = nome;
        this.listaEscaloes = new EscalaoDAO(this.nFase);
        this.calendario = new Calendario();
        this.tipo = tipo;
        this.nFase = n;
        APEF.IDENTIFICADOR++;
    }
    
    public Fase(int id, String n, Map<Integer,Escalao> l, Calendario c, int t, int nf) {
        this.idFase = id;
        this.nome = n;
        this.listaEscaloes = l;
        this.calendario = c;
        this.tipo = t;
        this.nFase = nf;
    }

    public Fase(Fase f) {
        this.nome = f.getNome();
        this.listaEscaloes = f.getListaEscaloes();
        this.calendario = f.getCalendario();
        this.tipo = f.getTipo();
    }

    public String getNome(){
        return this.nome;
    }
    
    public int getTipo() {
        return this.tipo = tipo;
    }
    
    public int getNFase() {
        return this.nFase;
    }
    
    public int getID() {
        return this.idFase;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public Map<Integer,Escalao> getListaEscaloes() {
         Map<Integer,Escalao> aux = new EscalaoDAO(this.idFase);
         for(Integer s : this.listaEscaloes.keySet()){
             aux.put(s,this.listaEscaloes.get(s));
         }
         return aux;
    }

    public void setListaEquipas (Map<Integer,Escalao> le){
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
        if (!this.listaEscaloes.containsKey(e.getID()))
            this.listaEscaloes.put(e.getID(),e);
    }
    
    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e.getID());
    }

    /**Metodos*/
   public Escalao buscaEscalao(int id) {
        Escalao res = new Escalao();
        boolean flag = false;
        Iterator<Escalao> it = getListaEscaloes().values().iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            if (e.getID()==id) {
                res = e;
                flag = true;
            }
        }
        return res;
    }
   
    public boolean ultimoJogoGrupo() {
        boolean res = false;
        if( (jogosEsperadosGrupo()-jogosRealizados()) == 0)
            res=true;
        
        return res;
    }
    
    public boolean ultimoJogoEliminatoria() {
        boolean res = false;
        if( (jogosEsperadosEliminatoria()-jogosRealizados()) == 0)
            res=true;
        
        return res;
    }

    public int jogosRealizados() {
        int res=0;
        for(Jornada j : this.calendario.getJornadas().values()) {
           for(Jogo jg : j.getListaJogos().values()) {
               if(jg.isJogoRealizado()) {
                   res++;
               }
           }
        }
        return res;
    }
    
    public int jogosEsperadosGrupo() {
        return (this.listaEscaloes.size()/2)-1;
    }
    
    public int jogosEsperadosEliminatoria() {
        return (this.listaEscaloes.size()/2);
    }
    
    public GregorianCalendar dataJornadaSeguinte(GregorianCalendar g, int jr){
       GregorianCalendar res = new GregorianCalendar();
       int hora;
       res = g;
       hora = res.get(res.MINUTE) + 1;
       res.set(res.MINUTE,hora);
       
       return res;
    }
    
    public Utilizador daArbitroAleatorio(ArrayList<Utilizador> listaArbitros, ArrayList<Utilizador> listaArbitrosEscolhidos) {
    
        boolean flag=true;
        Utilizador arbitro = new Arbitro();
            while(flag){
                
            int nrAleatorio = (int) (Math.random()*listaArbitros.size());
            arbitro = listaArbitros.get(nrAleatorio);
            
            if ((listaArbitrosEscolhidos.contains(arbitro))==false){
                flag=false;
                }
            }
        return arbitro;
    }
}
