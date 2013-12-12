package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jogador extends Pessoa {    
    
    //Variaveis de Instancia
    private int nrGolos;
    private ArrayList<Integer> competicoes;
    private boolean emprestado;

    //Construtores
    public Jogador() {
    	super();
    	this.nrGolos = 0;
        this.emprestado = false;
    }
   
    public Jogador(String nome, GregorianCalendar g,int sexo, boolean emprestado) {
        super(nome,null,g,sexo);
        this.nrGolos = 0;
        this.emprestado = emprestado;
    }

    public Jogador(Jogador t) {
    	super(t);
    	this.nrGolos = t.getNrGolos();
        this.emprestado = t.getEmprestado();
    }

    //Getters
    public int getNrGolos() {
    	return this.nrGolos;
    }

    public boolean getEmprestado() {
        return this.emprestado;
    }
    //Setters
    public void setNrGolos(int n) {
    	this.nrGolos = n;
    }

    public void setEmprestado(boolean e) {
        this.emprestado = e;
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
    
    /**Metodos*/
	public void addGolosJogador() {
		this.nrGolos = this.nrGolos + 1;
	}

    public void addCompeticao(int id) {
        this.competicoes.add(id);
    }   
}
