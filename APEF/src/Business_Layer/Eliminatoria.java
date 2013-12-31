package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class Eliminatoria extends Fase {    
    
    //Construtores
    public Eliminatoria() {
        super();
    }

    public Eliminatoria(Eliminatoria g) {
        super(g);
    }
    
    public Eliminatoria(String n, HashSet<Escalao> le){
        super(n,le);
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if ( (o == null) || (this.getClass() != o.getClass()) )
            return false;
        else {
        Eliminatoria e = (Eliminatoria) o;
        return (this.getCalendario().equals(e.getCalendario()));
        }
    }
    
    public Eliminatoria clone() {
        return new Eliminatoria(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("--Eliminatoria--") ;
        str.append(this.getListaEscaloes());
        str.append(this.getCalendario()+"  ");
        return str.toString();
    }   
    //Metodos
    
    public boolean atualizaEliminatoriaTipo1(Jogo j) {
        return this.getCalendario().atualizaCalendario(j);
    }
    
    public void geraCalendarioTipo1(int idComp, GregorianCalendar dataInicio, ArrayList<Utilizador> arbitros, ArrayList<Integer> equipas1, ArrayList<Integer> equipas2, Campo x) {
        ArrayList<Utilizador> escolhidos = new ArrayList<>();
        Escalao casa1 = buscaEscalao(equipas1.get(0));
        Escalao fora1 = buscaEscalao(equipas2.get(1));
        
        Escalao casa2 = buscaEscalao(equipas1.get(1));
        Escalao fora2 = buscaEscalao(equipas2.get(0));
        
        Utilizador arbitro = daArbitroAleatorio(arbitros,escolhidos);
        Arbitro arb = (Arbitro) arbitro;
        escolhidos.add(arbitro);
        
        Jogo jogo = new Jogo(idComp,dataInicio,x,arb,casa1,fora1);
        
        arbitro = daArbitroAleatorio(arbitros,escolhidos);
        arb = (Arbitro) arbitro;
        Jogo jogo2 = new Jogo(idComp,dataInicio,x,arb,casa2,fora2);
        
        
        Jornada j = new Jornada();
        j.inserirJogo(jogo);
        jogo.getArbitroJogo().preencheAgendaArbitro(jogo);
        jogo.getEscalaoCasa().preencheAgendaEscalao(jogo);
        jogo.getEscalaoFora().preencheAgendaEscalao(jogo);
        
        j.inserirJogo(jogo2); 
        jogo.getArbitroJogo().preencheAgendaArbitro(jogo);
        jogo.getEscalaoCasa().preencheAgendaEscalao(jogo);
        jogo.getEscalaoFora().preencheAgendaEscalao(jogo);
        
        getCalendario().inserirJornada(j);       
    }
    
    public void geraFinal(int idComp, GregorianCalendar dataInicio, ArrayList<Utilizador> arbitros, HashSet<Escalao> finalistas, Campo x) {
        ArrayList<Utilizador> escolhidos = new ArrayList<>();
        ArrayList<Escalao> aux = new ArrayList<>();
        for(Escalao e : finalistas) {
            aux.add(e);
        }
        
        Utilizador arbitro = daArbitroAleatorio(arbitros,escolhidos);
        Arbitro arb = (Arbitro) arbitro;
        escolhidos.add(arbitro);
        Jornada j = new Jornada();
        Jogo jogo = new Jogo(idComp,dataInicio,x,arb,aux.get(0),aux.get(1));
        j.inserirJogo(jogo);
        
    }
    
    public HashSet<Escalao> vencedores() {
        HashSet<Escalao> aux = new HashSet<>();
        for(Jogo j : this.getCalendario().getJornadas().first().getListaJogos()) {
            if(j.getNumGolosJogoCasa()>j.getNumGolosJogoFora())
                aux.add(j.getEscalaoCasa());
            else
                aux.add(j.getEscalaoFora());
        } 
        return aux;
    }
    
    public void geraCalendarioTipo2(int idComp, GregorianCalendar dataInicio, ArrayList<Utilizador> arbitros, ArrayList<Integer> equipas, Campo x) {
        ArrayList<Integer> equipasCasa = new ArrayList<>();
        ArrayList<Integer> equipasFora = new ArrayList<>();
        ArrayList<Utilizador> escolhidos = new ArrayList<>();
        int i=0,nrEscaloes;
        nrEscaloes = equipas.size();
        for(i=0;i<nrEscaloes;i++){
            if(i<(nrEscaloes/2)){
                equipasCasa.add(i,equipas.get(i));
            }
            else equipasFora.add(i-(nrEscaloes/2),equipas.get(i));
        }
        
        Utilizador arbitro;
        Jornada j = new Jornada();
        for(i=0;i<(nrEscaloes/2);i++){
            Escalao casa = buscaEscalao(equipasCasa.get(i));
            Escalao fora = buscaEscalao(equipasFora.get(i));
            arbitro = daArbitroAleatorio(arbitros,escolhidos);
            Arbitro arb = (Arbitro) arbitro;
            escolhidos.add(arbitro);
            Jogo jogo = new Jogo(idComp,dataInicio,x,arb,casa,fora);
            j.inserirJogo(jogo);
            jogo.getArbitroJogo().preencheAgendaArbitro(jogo);
            jogo.getEscalaoCasa().preencheAgendaEscalao(jogo);
            jogo.getEscalaoFora().preencheAgendaEscalao(jogo);
        }
        
        this.getCalendario().inserirJornada(j);       
    }
}

