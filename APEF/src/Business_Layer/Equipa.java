package Business_Layer;

import java.util.ArrayList;
import java.util.HashMap;

public class Equipa {

	private static final int indexInfantis = 0;
    private static final int indexBenjamins = 1;
    private static final int indexTraquinas = 2;
    private static final int indexPetizes = 3;
    private static final int maxEscaloes = 4;
    
    private int id;
    private String nome;
    private Imagem emblema;
    private HashMap<String,Integer> palmares; //<nome da competicao, nr vezes que ganhou>
    private Escalao[] escaloes;  
    
    public Equipa() {
    	this.id = 0; 	//nao definido
    	this.nome = new String();
    	this.emblema = new Imagem();
    	this.palmares = new HashMap<>();
    	this.escaloes = new Escalao[maxEscaloes];
    }
    
    public Equipa(int id, String n, Imagem e) {
    	this.id = id;
    	this.nome = n;
    	this.emblema = e;
    	this.palmares = new HashMap<>();
    	this.escaloes = new Escalao[maxEscaloes];	
    }
    

    public Equipa(Equipa e) {
    	this.id = e.getID();
    	this.nome = e.getNome();
    	this.emblema = e.getEmblema();
    	this.palmares = e.getPalmares();
    	this.escaloes = e.getEscaloes();
	}

	public int getID() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Imagem getEmblema() {
		return this.emblema;
	}

	public HashMap<String, Integer> getPalmares() {
		HashMap<String, Integer> hmp = new HashMap<>();
		
		for(String s : this.palmares.keySet())
			hmp.put(s, this.palmares.get(s));
		
		return hmp;
	}

	public Escalao[] getEscaloes() {
		Escalao[] aux = new Escalao[maxEscaloes];
        int i;
        for(i=0;i<maxEscaloes;i++){
            aux[i] = this.escaloes[i].clone();
        }
        return aux;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmblema(Imagem emblema) {
		this.emblema = emblema;
	}

	public void setPalmares(HashMap<String, Integer> palmares) {
		this.palmares = palmares;
	}

	public void setEscaloes(Escalao[] escaloes) {
		this.escaloes = escaloes;
	}

	public Equipa clone() {
    	return new Equipa(this);
    }

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palmares == null) ? 0 : palmares.hashCode());
		return result;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Equipa");
		
		str.append("Nome: "+this.nome.toString());
		
		return str.toString();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Equipa e = (Equipa) o;
			return (this.id == (e.getID()));
		}
	}


}
