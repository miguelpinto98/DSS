package Business_Layer;

import java.util.ArrayList;
import java.util.HashMap;

public class Equipa {
    private int id;
    private String nome;
    private Imagem emblema;
    private HashMap<String,Integer> palmares; //<nome da competicao, nr vezes que ganhou>
    private ArrayList<Plantel> planteis;  
    
    public Equipa() {
    	this.id = 0;
    	this.nome = new String();
    	this.emblema = new Imagem();
    	this.palmares = new HashMap<>();
    	this.planteis = new ArrayList<>();
    }
    
    public Equipa(int id, String n, Imagem e) {
    	this.id = id;
    	this.nome = n;
    	this.emblema = e;
    	this.palmares = new HashMap<>();
    	this.planteis = new ArrayList<>();	
    }
    

    public Equipa(Equipa e) {
    	this.id = e.getID();
    	this.nome = e.getNome();
    	this.emblema = e.getEmblema();
    	this.palmares = e.getPalmares();
    	this.planteis = e.getPlanteis();
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

	public ArrayList<Plantel> getPlanteis() {
		ArrayList<Plantel> ale = new ArrayList<>();
		
		for(Plantel p : this.planteis)
			ale.add(p.clone());
		
		return ale;
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

	public void setPlanteis(ArrayList<Plantel> planteis) {
		this.planteis = planteis;
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
