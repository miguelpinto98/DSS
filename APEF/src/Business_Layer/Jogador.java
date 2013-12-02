package Business_Layer;

import java.util.GregorianCalendar;

public class Jogador extends Pessoa {    
    
    //Variaveis de Instancia
    private int nrGolos;

    //Construtores
    public Jogador() {
    	super();
    	this.nrGolos = 0;
    }
   
    public Jogador(String nome, GregorianCalendar g,int sexo) {
        super(1,nome,null,g,sexo);
        this.nrGolos = 99;
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
        str.append(this.getID());
        str.append(this.getNrGolos()+"  ");
        str.append(this.getDataNasc());
        str.append(this.getSexo()+"\n");
        str.append(this.getNome());
        

    	return str.toString();
    }  	
    //Metodos
}
