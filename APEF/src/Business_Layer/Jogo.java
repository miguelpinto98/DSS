package Business_Layer;

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
    	//this.ecasa = new Escalao();
    	//this.efora = new Escalao();
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new HashMap<> ();
    }
    
    public Jogo(Jogo jogo) {
	}
    
	public boolean equals(Object obj) {

		return true;
	}
	
	protected Jogo clone() {
		return new Jogo(this);
	}

	public String toString() {
		return "";
	}
}
