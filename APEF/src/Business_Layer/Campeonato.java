package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Campeonato implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private String nome;
    private int nrEscaloes;
    private Calendario calendario;
    private HashSet<Escalao> listaEscaloes;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
    private Classificacao classificacao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;

    //Construtores
    public Campeonato() {
    	this.id = 0;
        this.tipoEscalao = -1;
    	this.nome = "";
    	this.nrEscaloes = 0;
    	this.calendario = new Calendario();
        this.listaEscaloes = new HashSet<>();
    	this.goleadores = new HashMap<>();
        this.classificacao = null;
        this.dataInicio = new GregorianCalendar();
        this.dataFim = new GregorianCalendar();
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
        this.dataFim = ca.getDataFim();
    }

    public Campeonato(String nome, GregorianCalendar limiteInscricao, int tipo, int nrEquipasMax) {
        this.id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipo;
        this.nome = nome;
        this.nrEscaloes = nrEquipasMax;
        this.calendario = new Calendario();
        this.listaEscaloes = new HashSet<>();
        this.goleadores = new HashMap<>();
        this.classificacao = new Classificacao();
        this.dataInicio = limiteInscricao;
        this.dataFim = limiteInscricao;
        APEF.IDENTIFICADOR++;
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

    public HashSet<Escalao> getListaEscaloes() {
        HashSet<Escalao> aux = new HashSet<Escalao>();
        for(Escalao e: this.listaEscaloes) 
            aux.add(e.clone());
        return aux;
    }

    public void setListaEscaloes (HashSet<Escalao> le){
        this.listaEscaloes = le;
    }
    
    public Classificacao getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
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

    public GregorianCalendar getDataInicio(){
        return this.dataInicio;
    }

    public void setDataInicio (GregorianCalendar data) {
        this.dataInicio = data;
    }

    public GregorianCalendar getDataFim(){
        return this.dataFim;
    }

    public void setDataFim (GregorianCalendar data){
        this.dataFim = data;
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
        str.append("\nNrEquipas: "+this.getNrEscaloes());
        str.append("\nParticipantes: "+this.getListaEscaloes());
		
		return str.toString(); 
	}

    /**Metodos*/
    public void inserirEscalao(Escalao e) {
        if(!this.listaEscaloes.contains(e))
            this.listaEscaloes.add(e);
    }

    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e);
    }

    public void inscreverEscalao(Escalao e) {
        inserirEscalao(e);
        this.nrEscaloes--;//nao e' preciso ter isto. depois basta ver se size()==nrEquipas
                          //e entao pode-se "IniciarCampeonato"
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
    
    public void geraCalendario(ArrayList<Integer> listaEscaloes){
        int nrEscaloes = listaEscaloes.size();
        int count = 0;
        int nrJornadas = nrEscaloes*2-2;
        int i,casa,fora;
        ArrayList<Integer> copia = new ArrayList<>();
        
        for(i=0;i<nrEscaloes;i++){
            copia.add(i,listaEscaloes.get(i));
        }
        
        int nrJ=0;
        while(count < nrJornadas){
            
            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();
            ArrayList<Integer> aux = new ArrayList<>();
        
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
            Jornada jornada = new Jornada();
            
            if(count % 2 != 0) {
                for (i=0; i<(nrEscaloes/2); i++){
                    casa = array1.get(i);
                    fora = array2.get(i);
                    Jogo jogo = new Jogo(casa,fora);
                    jornada.inserirJogo(jogo);
                }
            }
            else {
                for (i=0; i<(nrEscaloes/2); i++){
                    casa = array2.get(i);
                    fora = array1.get(i);
                    Jogo jogo = new Jogo(casa,fora);
                    jornada.inserirJogo(jogo);
                }
            }
            nrJ++;
            jornada.setNrJornada(nrJ);
            this.calendario.inserirJornada(jornada);
            count++;
        }
      }

	public boolean atualizaCampeonato(Jogo j) {
		return this.calendario.atualizaCalendario(j);
	}
      
}


