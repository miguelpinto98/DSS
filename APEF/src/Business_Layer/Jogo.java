package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Jogo {
    private boolean realizado; /* Comeca a falso */
    private GregorianCalendar dia; /* Dia e hora de jogo */
    private Campo campo;
    private Arbitro arbitro;
    private Escalao ecasa;
    private Escalao efora;
    private int numGolosCasa;
    private int numGolosFora;
    private HashMap<Integer,Integer> goleadores;
	
    public Jogo() {
    	this.realizado = false;
    	this.dia = new GregorianCalendar();
    	this.campo = new Campo();
    	this.arbitro = new Arbitro();
    	this.ecasa = null;		//!!!
    	this.efora = null;		//!!!
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new HashMap<> ();
    }
    
    public Jogo(GregorianCalendar g, Campo c, Arbitro a, Escalao ec, Escalao ef) {
    	this.realizado = false;
    	this.dia = (GregorianCalendar) g.clone();
    	this.campo = c;
    	this.arbitro = a;
    	this.ecasa = ec;
    	this.efora = ef;
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new HashMap<>();
    }
    
    public Jogo(Jogo j) {
    	this.realizado = j.isJogoRealizado();
    	this.dia = j.getDiaJogo();
    	this.campo = j.getCampoJogo();
    	this.arbitro = j.getArbitroJogo();
    	this.ecasa = j.getEscalaoJogoCasa();
    	this.efora = j.getEscalaoJogoFora();
    	this.numGolosCasa = j.getNumGolosJogoCasa();
    	this.numGolosFora = j.getNumGolosJogoFora();
    	this.goleadores = j.getGoleadoresJogo();
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

	public Escalao getEscalaoJogoCasa() {
		return this.ecasa;
	}

	public void setEscalaoJogoCasa(Escalao ecasa) {
		this.ecasa = ecasa;
	}
	
	public Escalao getEscalaoJogoFora() {
		return this.efora;
	}

	public void setEscalaoJogoFora(Escalao efora) {
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

	public HashMap<Integer, Integer> getGoleadoresJogo() {
		HashMap<Integer,Integer> hsg = new HashMap<>();
		
		for(Integer n : this.goleadores.keySet())
			hsg.put(n, this.goleadores.get(n));
		
		return hsg;
	}

	public void setGoleadoresJogo(HashMap<Integer, Integer> goleadores) {
		this.goleadores = goleadores;
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
					this.ecasa.equals(j.getEscalaoJogoCasa()) &&
					this.efora.equals(j.getEscalaoJogoFora()) &&
					this.numGolosCasa == j.getNumGolosJogoCasa() &&
					this.numGolosFora == j.getNumGolosJogoFora() &&
					this.goleadores.equals(j.getGoleadoresJogo()));
		}
	}
	
	protected Jogo clone() {
		return new Jogo(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder("Jogo");
		
		str.append("Campo: "+this.campo.toString());
		
		return str.toString();
	}
	
	public void resultadoJogo(int ngc, int ngf) {
		setNumGolosJogoCasa(ngc);
		setNumGolosJogoFora(ngf);
	}
	
	public void addJogadorGoleador(int id) {
		this.goleadores.put(id, this.goleadores.get(id) + 1);
	}

	public void goleadoresJogo(ArrayList<Integer> golos) {
		for(Integer id : golos)
			this.addJogadorGoleador(id);
	}
}
