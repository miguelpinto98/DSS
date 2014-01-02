package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Jogador extends Pessoa {    
    
    //Variaveis de Instancia
    private int nrGolos;
    private ArrayList<Integer> competicoes;
    private boolean emprestado;
    private String nomeEquipa;
    private String nomeEquipaEmprestimo;

    //Construtores
    public Jogador() {
    	super();
    	this.nrGolos = 0;
        this.emprestado = false;
        this.nomeEquipa = "";
        this.nomeEquipaEmprestimo = "";
    }
   
    public Jogador(String nome, Imagem img, GregorianCalendar g, int sexo, String nEquipa) {
        super(nome,img,g,sexo);
        this.nrGolos = 0;
        this.competicoes = new ArrayList<>();
        this.nomeEquipa = nEquipa;
        this.nomeEquipaEmprestimo = new String();
        this.emprestado = false;
    }

    public Jogador(String nome, GregorianCalendar g, int sexo, boolean emprestado, String nomeEquipa) {
        super(nome,null,g,sexo);
        this.nrGolos = 0;
        this.competicoes = new ArrayList<>();
        this.emprestado = emprestado;
        this.nomeEquipa=nomeEquipa;
    }

    public Jogador(Jogador t) {
    	super(t);
    	this.nrGolos = t.getNrGolos();
        this.emprestado = t.getEmprestado();
        this.nomeEquipa = t.getNomeEquipa();
        this.nomeEquipaEmprestimo = t.getNomeEquipaEmprestimo();
    }

    //Getters
    public int getNrGolos() {
    	return this.nrGolos;
    }

    public boolean getEmprestado() {
        return this.emprestado;
    }
    
    public String getNomeEquipa() {
        return this.nomeEquipa;
    }
    
    public String getNomeEquipaEmprestimo() {
        return this.getNomeEquipaEmprestimo();
    }
    
    public ArrayList<Integer> getCompeticoes() {
        return this.competicoes;
    }
    
    //Setters
    public void setNrGolos(int n) {
    	this.nrGolos = n;
    }

    public void setEmprestado(boolean e) {
        this.emprestado = e;
    }
    
    public void setNomeEquipa(String s) {
        this.nomeEquipaEmprestimo = s;
    }
    
    public void setNomeEquipaEmprestimo(String s) {
        this.nomeEquipaEmprestimo = s;
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
