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
   public Escalao buscaEscalao(int id) {
        Escalao res = new Escalao();
        boolean flag = false;
        Iterator<Escalao> it = getListaEscaloes().iterator(); 
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
           for(Jogo jg : j.getListaJogos()) {
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
