package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jogador extends Pessoa {    
    
    //Variaveis de Instancia
    private int nrGolos;
    private ArrayList<Integer> competicoes;

    //Construtores
    public Jogador() {
    	super();
    	this.nrGolos = 0;
    }
   
    public Jogador(int id,String nome, GregorianCalendar g,int sexo) {
        super(id,nome,null,g,sexo);
        this.nrGolos = 0;
    }

    public Jogador(Jogador t) {
    	super(t);
    	this.nrGolos = t.getNrGolos();
    }

    //Getters
    public int getNrGolos() {
    	return this.nrGolos;
    }

    //Setters
    public void setNrGolos(int n) {
    	this.nrGolos = n;
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {

    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Jogador jogador = (Jogador) o;
    	return (this.getID() == jogador.getID());
        }
    }
    
    public Jogador clone() {
        return new Jogador(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Jogador--") ;
        str.append("\nJogador ID: "+this.getID());
        str.append("\nJogador Nome: "+this.getNome());
        str.append("\nJogador Golos: "+this.getNrGolos());
        str.append("\nJogador Data Nascimento: "+this.getDataNasc().get(GregorianCalendar.YEAR) +"/"+
				this.getDataNasc().get(GregorianCalendar.MONTH) +"/"+
				this.getDataNasc().get(GregorianCalendar.DAY_OF_MONTH));
        str.append("\nJogador Sexo: "+this.getSexo()+"\n");
 
    	return str.toString();
    }  	
    //Metodos

	public void addGolosJogador() {
		this.nrGolos = this.nrGolos + 1;
	}
}
