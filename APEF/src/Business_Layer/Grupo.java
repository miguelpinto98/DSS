package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

public class Grupo extends Fase {    
    
    //Variaveis de Instancia
    private EstatisticaCompeticao classificacao;

    //Construtores
    public Grupo() {
    	super();
    	this.classificacao = new EstatisticaCompeticao();
    }

    public Grupo(String n, HashSet<Escalao> le){
        super(n,le);
        this.classificacao = new EstatisticaCompeticao();
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
    public boolean atualizaGrupoTipo1(Jogo j) {
        boolean res=false;
        if(this.getCalendario().atualizaCalendario(j))
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
            data = dataInicio;
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
}
