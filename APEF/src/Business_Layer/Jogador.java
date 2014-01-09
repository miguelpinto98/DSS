package Business_Layer;

import Data_Layer.CompeticoesJogadorDAO;
import Data_Layer.JogadorDAO;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;

public class Jogador extends Pessoa {    
    
    //Variaveis de Instancia
    private int nrGolos;
    private Map<Integer,Integer> competicoes; //<Id da competicao,id jogador>
    private String nomeEquipa;
    private int emprestado;
    private int nomeEquipaEmprestimo;

    //Construtores
    public Jogador() {
    	super();
    	this.nrGolos = 0;
        this.emprestado = 0;
        this.nomeEquipa = "";
        this.nomeEquipaEmprestimo = 0;
        this.competicoes = new CompeticoesJogadorDAO();
    }
   
    public Jogador(String nome, Imagem img, GregorianCalendar g, int sexo, String nEquipa) {
        super(nome,img,g,sexo);
        this.nrGolos = 0;
        this.competicoes = new CompeticoesJogadorDAO();
        this.nomeEquipa = nEquipa;
        this.nomeEquipaEmprestimo = 0;
        this.emprestado = 0;
    }
    
    public Jogador(String nome, GregorianCalendar g, int sexo,  Imagem img) {
        super(nome,img,g,sexo);
        this.emprestado = 0;
        this.nomeEquipa = "CeSIUM";
        this.nrGolos = 0;
        this.nomeEquipaEmprestimo = 0;
        this.competicoes = new CompeticoesJogadorDAO();
    }

    public Jogador(String nome, GregorianCalendar g, int sexo, boolean emprestado, String nomeEquipa) {
        super(nome,null,g,sexo);
        this.nrGolos = 0;
        this.competicoes = new CompeticoesJogadorDAO();
        this.emprestado = 0;
        this.nomeEquipa=nomeEquipa;
    }

    public Jogador(Jogador t) {
    	super(t);
    	this.nrGolos = t.getNrGolos();
        this.competicoes = t.getCompeticoes();
        this.emprestado = t.getEmprestado();
        this.nomeEquipa = t.getNomeEquipa();
        this.nomeEquipaEmprestimo = t.getNomeEquipaEmprestimo();
    }
    
    public Jogador(int id, String nome, Imagem img, GregorianCalendar g, int sexo, int ngolos, String nomeEquipa, int emprestado, int idEquipaEmprestado) {
        super(id,nome,img,g,sexo);
        this.nrGolos = ngolos;
        this.nomeEquipa = nomeEquipa;
        this.emprestado = emprestado;
        this.nomeEquipaEmprestimo = idEquipaEmprestado;
        this.competicoes = new CompeticoesJogadorDAO();
    }
    
    //Getters
    public int getNrGolos() {
    	return this.nrGolos;
    }

    public int getEmprestado() {
        return this.emprestado;
    }
    
    public String getNomeEquipa() {
        return this.nomeEquipa;
    }
    
    public int getNomeEquipaEmprestimo() {
        return this.getNomeEquipaEmprestimo();
    }
    
    public Map<Integer,Integer> getCompeticoes() {
       Map<Integer,Integer> aux = new CompeticoesJogadorDAO();
        for(Integer n : this.competicoes.keySet()) 
            aux.put(n, this.getID());
        
        return aux;
    }
    
    //Setters
    public void setNrGolos(int n) {
    	this.nrGolos = n;
    }

    public void setEmprestado(int e) {
        this.emprestado = e;
    }
    
    public void setNomeEquipa(String s) {
        this.nomeEquipa = s;
    }
    
    public void setNomeEquipaEmprestimo(int s) {
        this.nomeEquipaEmprestimo = s;
    }

    //Equals,Clone,toString
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.nrGolos;
        hash = 17 * hash + Objects.hashCode(this.competicoes);
        hash = 17 * hash + Objects.hashCode(this.nomeEquipa);
        hash = 17 * hash + Objects.hashCode(this.nomeEquipaEmprestimo);
        return hash;
    }
    @Override
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
    
    @Override
    public Jogador clone() {
        return new Jogador(this);
    }

    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Jogador--") ;
            str.append("\nJogador ID: ").append(this.getID());
            str.append("\nJogador Nome: ").append (this.getNome());
            str.append("\nNum Comp: ").append (this.competicoes.toString());
            str.append("\nJogador Golos: ").append(this.getNrGolos());
            str.append("\nJogador Data Nascimento: ").append(this.getDataNasc().get(GregorianCalendar.YEAR)).append("/").append(this.getDataNasc().get(GregorianCalendar.MONTH)).append("/").append(this.getDataNasc().get(GregorianCalendar.DAY_OF_MONTH));
            str.append("\nJogador Sexo: ").append(this.getSexo()).append("\n");
 
    	return str.toString();
    }  	
    
    /**Metodos*/
	public void addGolosJogador() {
		this.nrGolos = this.nrGolos + 1;
	}

    public void addCompeticao(int id){
            this.competicoes.put(id,this.getID());
    }   
}
