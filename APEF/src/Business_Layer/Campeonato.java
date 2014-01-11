package Business_Layer;

import Data_Layer.EscalaoDAO;
import Data_Layer.EstatisticaCompeticaoDAO;
import Data_Layer.GoleadoresDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Campeonato implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nome;
    private int nrEscaloes;
    private Calendario calendario;
    private Map<Integer,Escalao> listaEscaloes;
    private Map<Integer,Integer> goleadores; //<id do jogador,nr golos>     
    private Map<Integer,EstatisticaCompeticao> classificacao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataLimiteInscricoes;

    //Construtores
    public Campeonato() {
    	this.id = APEF.getID();
        this.tipoEscalao = -1;
    	this.nome = "";
    	this.nrEscaloes = 0;
    	this.calendario = new Calendario();
        this.listaEscaloes = new EscalaoDAO();
    	this.goleadores = new GoleadoresDAO();
        this.classificacao = new EstatisticaCompeticaoDAO(this.id);
        this.dataInicio = new GregorianCalendar();
        this.dataLimiteInscricoes = new GregorianCalendar();
        APEF.putID();
    }
    
    public Campeonato(Campeonato ca) {
    	this.id = ca.getID();
        this.tipoEscalao = ca.getTipoEscalao();
    	this.nome = ca.getNome();
    	this.nrEscaloes = ca.getNrEscaloes();
    	this.calendario = ca.getCalendario();
        this.listaEscaloes = ca.getListaEscaloes();
    	this.goleadores = ca.getGoleadores();
        this.classificacao = ca.getClassificacao();
        this.dataInicio = ca.getDataInicio();
        this.dataLimiteInscricoes = ca.getDataLimiteInscricoes();
    }

    public Campeonato(String nome, GregorianCalendar inicio, GregorianCalendar limiteInscricao, int tipo, int nrEquipasMax) {
        this.id = APEF.getID();
        this.tipoEscalao = tipo;
        this.nome = nome;
        this.nrEscaloes = nrEquipasMax;
        this.calendario =  null;
        this.listaEscaloes = null;
        this.goleadores = null;
        this.classificacao = new EstatisticaCompeticaoDAO(this.id);
        this.dataInicio = inicio;
        this.dataLimiteInscricoes = limiteInscricao;
        APEF.putID();
    }

    //Getters e Setters
    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public int getTipoEscalao() {
        return this.tipoEscalao;
    }

    public void setTipoEscalao(int tipo) {
        this.tipoEscalao = tipo;
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

    public Calendario getCalendario() {
        return this.calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Map<Integer,Escalao> getListaEscaloes() {
        Map<Integer,Escalao> aux = new EscalaoDAO();
        for(Escalao e: this.listaEscaloes.values()) 
            aux.put(e.getID(),e);
        return aux;
    }

    public void setListaEscaloes (Map<Integer,Escalao> le){
        this.listaEscaloes = le;
    }
    
    public Map<Integer,EstatisticaCompeticao> getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(Map<Integer,EstatisticaCompeticao> classificacao) {
        this.classificacao = classificacao;
    }

    public Map<Integer, Integer> getGoleadores() {
		Map<Integer,Integer> hsg = new GoleadoresDAO();
		for(Integer n : this.goleadores.keySet())
			hsg.put(n, this.goleadores.get(n));
		
		return hsg;
	}

    public void setGoleadores(HashMap<Integer, Integer> goleadores) {
        this.goleadores = goleadores;
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
    
    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.goleadores);
        return hash;
    }
    
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
        	Campeonato c = (Campeonato) o;
        	return (this.getID() == c.getID());
        }
    }

    public Campeonato clone() {
    	return new Campeonato(this);
    }

    
    public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("--Campeonato--\n");
        str.append("\nID: "+this.getID());
        str.append("\nNome: "+this.getNome());
        str.append("\n"+this.getCalendario());
        str.append("\nNrEquipas: "+this.getNrEscaloes());
        str.append("\nParticipantes: "+this.getListaEscaloes());
        str.append("\nClassificacao:"+this.classificacao);
		
		return str.toString(); 
	}

    /**Metodos*/
    public void inserirEscalao(Escalao e) {
        if(!this.listaEscaloes.containsKey(e.getID()))
            this.listaEscaloes.put(e.getID(),e);
    }

    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e);
    }

    public void inscreverEscalao(Escalao e) {
        inserirEscalao(e);
        this.nrEscaloes--;
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
        Iterator<Escalao> it = this.listaEscaloes.values().iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            if (e.getID()==id) {
                res = e;
                flag = true;
            }
        }
        return res;
    }
    
    public GregorianCalendar dataJornadaSeguinte(GregorianCalendar g){
       GregorianCalendar res = new GregorianCalendar();
       
       if (g.isLeapYear(g.get(g.YEAR))) {
                if (g.get(g.DAY_OF_YEAR) > 359){   
                    int ano = g.get(g.YEAR)+1;
                    int aux = 1;
                    g.set(ano,0,aux);
                    while(g.get(g.DAY_OF_WEEK)!=1) {
                        g.set(ano,0,aux++);
                    }
                    res = g;
                }
                else {
                    res = g;
                    res.set(res.DAY_OF_YEAR,res.get(res.DAY_OF_YEAR)+7);
                }
      }
       else {
           if (g.get(g.DAY_OF_YEAR) > 358){   
                    int ano = g.get(g.YEAR)+1;
                    int aux = 1;
                    g.set(ano,0,aux);
                    while(g.get(g.DAY_OF_WEEK)!=1) {
                        g.set(ano,0,aux++);
                    }
                    res = g;
                }
                else {
                    res = g;
                    res.set(res.DAY_OF_YEAR,res.get(res.DAY_OF_YEAR)+7);
                }
       }
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
    
    public void geraCalendario(ArrayList<Integer> listaEscaloes, ArrayList<Campo> listaCampos, ArrayList<Utilizador> listaArbitros){
        int nrEscaloes = listaEscaloes.size();
        int count = 0;
        int nrJornadas = nrEscaloes*2-2;
        int i, varAux;
        Escalao casa,fora;
        ArrayList<Integer> copia = new ArrayList<>();
        
        
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
            data = this.dataInicio;
            
            if (count==0) {
                data = this.dataInicio;
            }
            else {
                data = dataJornadaSeguinte(data);
            }
            
            
            if(count<nrEscaloes) { varAux=count; }
            else varAux=count-nrEscaloes;
            
            if(count % 2 != 0) {
                for (i=0; i<(nrEscaloes/2); i++){
                    casa = buscaEscalao(array1.get(i));
                    fora = buscaEscalao(array2.get(i));
                    Campo campo = listaCampos.get(varAux);
                    Utilizador arbitro = daArbitroAleatorio(listaArbitros,arbitrosEscolhidos);
                    Arbitro arb = (Arbitro) arbitro;
                    arbitrosEscolhidos.add(arbitro);
                    Jogo jogo = new Jogo(this.id,data,campo,arb,casa,fora);
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
                    Campo campo = listaCampos.get(varAux);
                    Utilizador arbitro = daArbitroAleatorio(listaArbitros,arbitrosEscolhidos);
                    Arbitro arb = (Arbitro) arbitro;
                    arbitrosEscolhidos.add(arbitro);
                    Jogo jogo = new Jogo(this.id,data,campo,arb,casa,fora);
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
    }
    
    public void atualizaGoleadores(Jogo j) {
        int contador;
        for(Integer id: j.getGoleadoresJogo().keySet()) {
            if(this.goleadores.containsKey(id)) {
                contador = this.goleadores.get(id);
                this.goleadores.put(id, contador+1);
            }
            else
                this.goleadores.put(id, 1); 
        }
    }
    
    public boolean acabou() {
        boolean flag = true;
        for(Jornada jr : this.calendario.getJornadas().values())
			if(jr.getJogosRealizados() < jr.getListaJogos().size() )
				flag = false;		
		
        return flag;
    }
    
	public boolean atualizaCampeonato(Jogo j, APEF a) {
        boolean res = false;
        Collection<DadosEstatisticos> ds = this.classificacao.get(this.id).getEstatistica().values();
        TreeSet<DadosEstatisticos> dss = (TreeSet<DadosEstatisticos>) ds;
        if(this.acabou()) {
            int idEscalao = dss.first().getIdEscalao();
            Escalao es = this.buscaEscalao(idEscalao);
            a.atualizaPalmaresEquipa(this.nome, es.getNomeEscola(), es.getNomeEquipa());
        }
            
            
        if(j.getIdCompeticao() == this.id) {
            if(this.calendario.atualizaCalendario(j,a)) { 
                this.atualizaGoleadores(j);
                this.classificacao.get(this.id).actualizaClassificacao(j);
                res = true;
            }
            return res;
        }
        else return res;
    }
    
    public ArrayList<Integer> melhoresMarcadoresAux() {
        Map<Integer,Integer> aux = this.goleadores;
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
        
        Iterator<Escalao> it = this.listaEscaloes.values().iterator(); 
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
    
    
}
