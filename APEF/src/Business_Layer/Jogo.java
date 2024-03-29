package Business_Layer;

import Data_Layer.GoleadoresDAO;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class Jogo implements Comparable<Jogo>{
    private int id;
    private int idCompeticao;
    private boolean realizado; /* Comeca a falso */
    private GregorianCalendar dia; /* Dia e hora de jogo */
    private Campo campo;
    private Arbitro arbitro;
    private Escalao ecasa;
    private Escalao efora;
    private int numGolosCasa;
    private int numGolosFora;
    private Map<Integer,Integer> goleadores; //<idJogador,nrgolos>
	
    public Jogo() {
        this.id = 0;
    	this.idCompeticao = 0;
    	this.realizado = false;
    	this.dia = new GregorianCalendar();
    	this.campo = new Campo();
    	this.arbitro = new Arbitro();
    	this.ecasa = new Escalao();
    	this.efora = new Escalao();
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new GoleadoresDAO(id);
    }
    
    public Jogo(int i, GregorianCalendar g, Campo c, Arbitro a, Escalao ec, Escalao ef) {
    	this.id = APEF.getID();
        this.idCompeticao = i;
    	this.realizado = false;
    	this.dia = (GregorianCalendar) g.clone();
    	this.campo = c;
    	this.arbitro = a;
    	this.ecasa = ec;
    	this.efora = ef;
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new GoleadoresDAO(id);
        APEF.putID();
    }
    
    public Jogo(int idJogo, int idCompeticao, GregorianCalendar g, Campo c, Arbitro a, Escalao ec, Escalao ef) {
    	this.id = idJogo;
        this.idCompeticao = idCompeticao;
    	this.realizado = false;
    	this.dia = g;
    	this.campo = c;
    	this.arbitro = a;
    	this.ecasa = ec;
    	this.efora = ef;
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new GoleadoresDAO(id);
    }
    
    public Jogo(int idCompeticao, GregorianCalendar g, Campo campo, Escalao c, Escalao f){
        this.id = APEF.getID();
        this.idCompeticao = idCompeticao;
        this.campo = campo;
        this.dia = g;
        this.ecasa = c;
        this.efora = f;
        APEF.putID();
    }

    public Jogo(Jogo j) {
        this.id = j.getID();
    	this.idCompeticao = j.getIdCompeticao();
    	this.realizado = j.isJogoRealizado();
    	this.dia = j.getDiaJogo();
    	this.campo = j.getCampoJogo();
    	this.arbitro = j.getArbitroJogo();
    	this.ecasa = j.getEscalaoCasa();
    	this.efora = j.getEscalaoFora();
    	this.numGolosCasa = j.getNumGolosJogoCasa();
    	this.numGolosFora = j.getNumGolosJogoFora();
    	this.goleadores = j.getGoleadoresJogo();
	}

    public Jogo(int idJogo, int idComp, GregorianCalendar data2, Campo campo, Arbitro arb) {
        this.id = idJogo;
        this.idCompeticao = idComp;
    	this.realizado = false;
    	this.dia = data2;
    	this.campo = campo;
    	this.arbitro = arb;
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new GoleadoresDAO(id);
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
	public int getIdCompeticao(){
		return this.idCompeticao;
	}

	public void setIdCompeticao(int n){
		this.idCompeticao = n;
	}

	public boolean isJogoRealizado() {
		return this.realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public GregorianCalendar getDiaJogo() {
		return this.dia;
	}

	public void setDia(GregorianCalendar dia) {
		this.dia = dia;
	}

	public Campo getCampoJogo() {
		return this.campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Arbitro getArbitroJogo() {
		return this.arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Escalao getEscalaoCasa() {
		return this.ecasa;
	}

	public void setEscalaoCasa(Escalao ecasa) {
		this.ecasa = ecasa;
	}
	
	public Escalao getEscalaoFora() {
		return this.efora;
	}

	public void setEscalaoFora(Escalao efora) {
		this.efora = efora;
	}

	public int getNumGolosJogoCasa() {
		return this.numGolosCasa;
	}

	public void setNumGolosJogoCasa(int numGolosCasa) {
		this.numGolosCasa = numGolosCasa;
	}

	public int getNumGolosJogoFora() {
		return this.numGolosFora;
	}

	public void setNumGolosJogoFora(int numGolosFora) {
		this.numGolosFora = numGolosFora;
	}

	public Map<Integer,Integer> getGoleadoresJogo() {
		Map<Integer,Integer> hsg = new GoleadoresDAO(this.id);
		
		for(Integer n : this.goleadores.values())
			hsg.put(this.getID(),n);
		
		return hsg;
	}

	public void setGoleadoresJogo(Map<Integer,Integer> goleadores) {
		this.goleadores = goleadores;
	}
	
	public Jogo clone() {
		return new Jogo(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder("\n##### Jogo ######");
		
		str.append("\nID Competicao: "+this.getIdCompeticao());
		str.append("\nRealizado: "+this.isJogoRealizado());
                int aux = this.getDiaJogo().get(this.getDiaJogo().MONTH) + 1;
		str.append("\nData: " + this.getDiaJogo().get(this.getDiaJogo().YEAR) +"/"+
				aux +"/"+
				this.getDiaJogo().get(this.getDiaJogo().DAY_OF_MONTH)+" "+
				this.getDiaJogo().get(GregorianCalendar.HOUR)+" "+
				this.getDiaJogo().get(GregorianCalendar.MINUTE));
		str.append("\nCampo: " + this.campo.toString());
		str.append("\nArbitro: "+this.arbitro.getNomeUser());
		str.append("\nEscalao Casa\n"+this.ecasa.getNomeEquipa());
		str.append("\nEscalao Fora\n"+this.efora.getNomeEquipa());
		str.append("\nGolos Escalao Casa: "+this.numGolosCasa);
		str.append("\nGolos Escalao Fora: "+this.numGolosFora);
		str.append("\nGoleadores: "+"\n");
		
		return str.toString();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Jogo j = (Jogo) o;
			return (this.dia.equals(j.getDiaJogo()) &&
					this.campo.equals(j.getCampoJogo()) &&
					this.arbitro.equals(j.getArbitroJogo()) &&
					this.ecasa.equals(j.getEscalaoCasa()) &&
					this.efora.equals(j.getEscalaoFora()) &&
					this.numGolosCasa == j.getNumGolosJogoCasa() &&
					this.numGolosFora == j.getNumGolosJogoFora() &&
					this.goleadores.equals(j.getGoleadoresJogo()));
		}
	}
	
	public void resultadoJogo(int ngc, int ngf) {
		setNumGolosJogoCasa(ngc);
		setNumGolosJogoFora(ngf);
	}

	public void goleadoresJogo(Map<Integer,Integer> golos) {
		this.setGoleadoresJogo(golos);
	}
	
	public void atualizaEscalao() {
		this.ecasa.adicionaDadosEscalao(this.numGolosCasa,this.numGolosFora,this.goleadores,this.dia);
		this.efora.adicionaDadosEscalao(this.numGolosFora,this.numGolosCasa,this.goleadores,this.dia);
	}
    
     public int criterio(Jogo j) {
        if( this.dia.get(GregorianCalendar.YEAR) == j.getDiaJogo().get(GregorianCalendar.YEAR) && 
                this.dia.get(GregorianCalendar.MONTH) == j.getDiaJogo().get(GregorianCalendar.MONTH) && 
                this.dia.get(GregorianCalendar.DAY_OF_MONTH) == j.getDiaJogo().get(GregorianCalendar.DAY_OF_MONTH))
            return 1;
        else
            return 0;
    }
    
     public int ordenaNormal(Jogo j) {
        if(j.getDiaJogo().before(this.dia)) return 1;
        if(j.getDiaJogo().after(this.dia)) return -1;
        else return 0;
     }
     
     public int ordenaID(Jogo j) {
        if(j.getIdCompeticao() > (this.idCompeticao)) return 1;
        if(j.getIdCompeticao() < (this.idCompeticao)) return -1;
        else return 0;
     }

	public int compareTo(Jogo j) {
        int res = 0;
        switch(criterio(j)) {
            case 0: res = ordenaNormal(j);
                break;
            case 1: res = ordenaID(j);
                break;
        }
        return res;  
    }
}
