package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jogo {
    private int idCompeticao;
    private boolean realizado; /* Comeca a falso */
    private GregorianCalendar dia; /* Dia e hora de jogo */
    private Campo campo;
    private Arbitro arbitro;
    private Escalao ecasa;
    private Escalao efora;
    private int numGolosCasa;
    private int numGolosFora;
    private ArrayList<Integer> goleadores;
	
    public Jogo() {
    	this.idCompeticao = 0;
    	this.realizado = false;
    	this.dia = new GregorianCalendar();
    	this.campo = new Campo();
    	this.arbitro = new Arbitro();
    	this.ecasa = new Escalao();
    	this.efora = new Escalao();
    	this.numGolosCasa = 0;
    	this.numGolosFora = 0;
    	this.goleadores = new ArrayList<> ();
    }
    
    public Jogo(int i, GregorianCalendar g, Campo c, Arbitro a, Escalao ec, Escalao ef) {
    	this.idCompeticao = i;
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
    
    public Jogo(int idCompeticao, Escalao c, Escalao f){
        this.idCompeticao = idCompeticao;
        this.ecasa = c;
        this.efora = f;
    }

    public Jogo(Jogo j) {
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
		StringBuilder str = new StringBuilder("\n##### Jogo ######");
		
		/**str.append("\nID Competicao: "+this.getIdCompeticao());
		str.append("\nRealizado: "+this.isJogoRealizado());
		str.append("\nData de Nascimento: " + this.getDiaJogo().get(GregorianCalendar.YEAR) +"/"+
				this.getDiaJogo().get(GregorianCalendar.MONTH) +"/"+
				this.getDiaJogo().get(GregorianCalendar.DAY_OF_MONTH)+" "+
				this.getDiaJogo().get(GregorianCalendar.HOUR)+":"+
				this.getDiaJogo().get(GregorianCalendar.MINUTE));
		str.append(this.campo.toString());
		str.append("\nArbitro: "+this.arbitro.getNome());
		str.append("\nEscalao Casa\n"+this.ecasa.toString());
		str.append("\nEscalao Fora\n"+this.efora.toString());*/
		str.append(/**Golos Escalao*/"\nEquipa Casa: "+this.numGolosCasa);
		str.append(/**Golos Escalao*/"\nEquipa Fora: "+this.numGolosFora);
		//str.append("\nGoleadores: "+"\n");
		
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

	public void goleadoresJogo(ArrayList<Integer> golos) {
		this.setGoleadoresJogo(golos);
	}
	
	public void atualizaEscalao() {
		this.ecasa.adicionaDadosEscalao(this.numGolosCasa,this.numGolosFora,this.goleadores,this.dia);
		this.efora.adicionaDadosEscalao(this.numGolosFora,this.numGolosCasa,this.goleadores,this.dia);
	}

}
