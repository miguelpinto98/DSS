package Business_Layer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Grupo extends Fase {    
    
    //Variaveis de Instancia
    private EstatisticaCompeticao classificacao;

    //Construtores
    public Grupo() {
    	super();
    	this.classificacao = new EstatisticaCompeticao();
    }

    public Grupo(String n, int t,int nf){
        super(n,t,nf);
        this.classificacao = new EstatisticaCompeticao();
    }
    
    public Grupo(int id, String n, Map<Integer,Escalao> l, Calendario c, int t, EstatisticaCompeticao e,int nf) {
        super(id,n,l,c,t,nf);
        this.classificacao = e;
    }

    public Grupo(Grupo g) {
    	super(g);
    	this.classificacao = g.getClassificacao();
    }

    //Getters Setters

    public EstatisticaCompeticao getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(EstatisticaCompeticao classificacao) {
        this.classificacao = classificacao;
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {

    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Grupo grupo = (Grupo) o;
    	return (this.getClassificacao().equals(grupo.getClassificacao()));
        }
    }
    
    public Grupo clone() {
        return new Grupo(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Grupo--") ;
        str.append(this.getListaEscaloes());
        str.append(this.getCalendario()+"  ");
        str.append(this.getClassificacao());
    	return str.toString();
    }  	
    //Metodos     
    public boolean atualizaGrupoTipo1(Jogo j, APEF a) {
        boolean res=false;
        if(this.getCalendario().atualizaCalendario(j,a))
            this.classificacao.actualizaClassificacao(j);
        return res;
    }
        
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
    
    public HashSet<Utilizador> geraCalendario(int idComp, GregorianCalendar dataInicio, ArrayList<Integer> listaEscaloes, Campo ca, ArrayList<Utilizador> listaArbitros){
        int nrEscaloes = listaEscaloes.size();
        int count = 0;
        int nrJornadas = nrEscaloes-1;
        int i;
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
            data = dataJornadaSeguinte(dataInicio, nrJ);
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
            getCalendario().inserirJornada(jornada);
            count++;
        }
        return resArbitros;
    }
    
    public ArrayList<Integer> doisMelhores() {
        ArrayList<Integer> aux = new ArrayList<>();
        Collection<DadosEstatisticos> ds = this.classificacao.getEstatistica().values();
        TreeSet<DadosEstatisticos> dss = (TreeSet<DadosEstatisticos>) ds;
        DadosEstatisticos d1 = dss.first();
        DadosEstatisticos d2 = dss.higher(dss.first());
        
        aux.add(0, d1.getIdEscalao());
        aux.add(1, d2.getIdEscalao());
        
        return aux;
    }
}
