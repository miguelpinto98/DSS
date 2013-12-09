package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jogo {
    private boolean realizado; /* Comeca a falso */
    private GregorianCalendar dia; /* Dia e hora de jogo */
    private Campo campo;
    private Arbitro arbitro;
    private Plantel ecasa;
    private Plantel efora;
    private int numGolosCasa;
    private int numGolosFora;
    private ArrayList<Integer> goleadores;
	
    public Jogo() {
    	this.realizado = false;
    	this.dia = new GregorianCalendar();
    	this.campo = new Campo();
    	this.arbitro = new Arbitro();
    	this.ecasa = new Plantel();
    	this.efora = new Plantel();
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new ArrayList<> ();
    }
    
    public Jogo(GregorianCalendar g, Campo c, Arbitro a, Plantel ec, Plantel ef) {
    	this.realizado = false;
    	this.dia = (GregorianCalendar) g.clone();
    	this.campo = c;
    	this.arbitro = a;
    	this.ecasa = ec;
    	this.efora = ef;
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new ArrayList<>();
    }
    
    public Jogo(Jogo j) {
    	this.realizado = j.isJogoRealizado();
    	this.dia = j.getDiaJogo();
    	this.campo = j.getCampoJogo();
    	this.arbitro = j.getArbitroJogo();
    	this.ecasa = j.getPlantelCasa();
    	this.efora = j.getPlantelFora();
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

	public Plantel getPlantelCasa() {
		return this.ecasa;
	}

	public void setPlantelCasa(Plantel ecasa) {
		this.ecasa = ecasa;
	}
	
	public Plantel getPlantelFora() {
		return this.efora;
	}

	public void setPlantelFora(Plantel efora) {
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

	public ArrayList<Integer> getGoleadoresJogo() {
		ArrayList<Integer> hsg = new ArrayList<>();
		
		for(Integer n : this.goleadores)
			hsg.add(n);
		
		return hsg;
	}

	public void setGoleadoresJogo(ArrayList<Integer> goleadores) {
		this.goleadores = goleadores;
	}
	
	public Jogo clone() {
		return new Jogo(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder("Jogo");
		
		str.append("Campo: "+this.campo.toString());
		
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
					this.ecasa.equals(j.getPlantelCasa()) &&
					this.efora.equals(j.getPlantelFora()) &&
					this.numGolosCasa == j.getNumGolosJogoCasa() &&
					this.numGolosFora == j.getNumGolosJogoFora() &&
					this.goleadores.equals(j.getGoleadoresJogo()));
		}
	}
	
	public void resultadoJogo(int ngc, int ngf) {
		setNumGolosJogoCasa(ngc);
		setNumGolosJogoFora(ngf);
	}

	public void goleadoresJogo(ArrayList<Integer> golos) {
		this.setGoleadoresJogo(golos);
	}
	/*
	public void atualizaEscalao() {
		this.ecasa.adicionaDadosEscalao(this.numGolosCasa,this.numGolosFora);
		this.ecasa.adicionaDadosEscalao(this.numGolosCasa,this.numGolosFora);
	}*/

}
