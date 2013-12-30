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

    public static ArrayList<Integer> moveArray(ArrayList<Integer> le) {
        int i=0,tam = le.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(i,le.get(i));
        for(i=1;i<tam;i++){
            if (i==1) {
                res.add(i,le.get(tam-1));
            }
            else res.add(i,le.get(i-1));
        }
        return res;
    }
    
    public static ArrayList<Integer> inverteArray(ArrayList<Integer> le) {
        int i=0, indice = le.size()-1, aux;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(i=0;i<indice+1;i++){
            aux = indice-i;
            res.add(i,le.get(aux));
        }
        return res;
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
    
    public GregorianCalendar dataJornadaSeguinte(GregorianCalendar g, int jr){
       GregorianCalendar res = new GregorianCalendar();
       int hora;
       res = g;
       hora = res.get(res.HOUR) + 1*jr;
       res.set(res.HOUR,hora);
       
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
    
    public HashSet<Utilizador> geraCalendario(int idComp, GregorianCalendar dataInicio, ArrayList<Integer> listaEscaloes, Campo ca, ArrayList<Utilizador> listaArbitros){
        int nrEscaloes = listaEscaloes.size();
        int count = 0;
        int nrJornadas = nrEscaloes-1;
        int i, varAux;
        Escalao casa,fora;
        ArrayList<Integer> copia = new ArrayList<>();
        HashSet<Utilizador> resArbitros = new HashSet<>();
        
        
        for(i=0;i<nrEscaloes;i++){
            copia.add(i,listaEscaloes.get(i));
        }
        
        int nrJ=0;
        while(count < nrJornadas){
            
            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();
            ArrayList<Integer> aux = new ArrayList<>();
            ArrayList<Utilizador> arbitrosEscolhidos = new ArrayList<>();
            
            for(i=0;i<nrEscaloes;i++) {
                if(i<(nrEscaloes/2)) {
                    array1.add(i,copia.get(i));
                }
                else {
                    aux.add(i-(nrEscaloes/2),copia.get(i));
                    array2 = inverteArray(aux);
                }
            }
            
            copia = moveArray(copia);
            
            Jornada jornada = new Jornada(count+1);
            GregorianCalendar data = new GregorianCalendar(); 
            
            if (count==0) {
                data = dataInicio;
            }
            else {
                data = dataJornadaSeguinte(data,count);
            }
            
            
            if(count % 2 != 0) {
                for (i=0; i<(nrEscaloes/2); i++){
                    casa = buscaEscalao(array1.get(i));
                    fora = buscaEscalao(array2.get(i));
                    Campo campo = ca;
                    Utilizador arbitro = daArbitroAleatorio(listaArbitros,arbitrosEscolhidos);
                    Arbitro arb = (Arbitro) arbitro;
                    arbitrosEscolhidos.add(arbitro);
                    resArbitros.add(arbitro);
                    Jogo jogo = new Jogo(idComp,data,campo,arb,casa,fora);
                    jornada.inserirJogo(jogo);
                    jogo.getArbitroJogo().preencheAgendaArbitro(jogo);
                    jogo.getEscalaoCasa().preencheAgendaEscalao(jogo);
                    jogo.getEscalaoFora().preencheAgendaEscalao(jogo);
                }
            }
            else {
                for (i=0; i<(nrEscaloes/2); i++){
                    casa = buscaEscalao(array2.get(i));
                    fora = buscaEscalao(array1.get(i));
                    Campo campo = ca;
                    Utilizador arbitro = daArbitroAleatorio(listaArbitros,arbitrosEscolhidos);
                    Arbitro arb = (Arbitro) arbitro;
                    arbitrosEscolhidos.add(arbitro);
                    resArbitros.add(arbitro);
                    Jogo jogo = new Jogo(idComp,data,campo,arb,casa,fora);
                    jornada.inserirJogo(jogo);
                    jogo.getArbitroJogo().preencheAgendaArbitro(jogo);
                    jogo.getEscalaoCasa().preencheAgendaEscalao(jogo);
                    jogo.getEscalaoFora().preencheAgendaEscalao(jogo);                
                }
            }
            nrJ++;
            jornada.setNrJornada(nrJ);
            this.calendario.inserirJornada(jornada);
            count++;
        }
        return resArbitros;
    }
    
    public boolean atualizaFase(Jogo j) {
        return this.calendario.atualizaCalendario(j);
    }
}
