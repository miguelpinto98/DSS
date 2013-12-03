package Business_Layer;

import java.util.HashMap;

public class APEF {
	private HashMap<String, Escola> escola;
	private HashMap<String, Epoca> epoca;
	private HashMap<String, Utilizador> users;

    public static int IDENTIFICADOR=1;
    
    public APEF() {
    	this.escola = new HashMap<>();
    	this.epoca = new HashMap<>();
    	this.users = new HashMap<>();
    }

	public APEF(APEF a) {
		this.escola = a.getEscolas();
		this.epoca = a.getEpoca();
		this.users = a.getUsers();
	}

	public HashMap<String, Escola> getEscolas() {
		HashMap<String,Escola> aux = new HashMap<>();
		
		for(String s : this.escola.keySet())
			aux.put(s, this.escola.get(s).clone());
		
		return aux;
	}
	
	public HashMap<String, Epoca> getEpoca() {
		HashMap<String,Epoca> aux = new HashMap<>();
		
		for(String s : this.epoca.keySet())
			aux.put(s, this.epoca.get(s).clone());
		
		return aux;
	}

	public HashMap<String, Utilizador> getUsers() {
		HashMap<String,Utilizador> aux = new HashMap<>();
		
		for(String s : this.users.keySet())
			aux.put(s, this.users.get(s).clone());
		
		return aux;
	}

	public void setEscolas(HashMap<String, Escola> escolas) {
		this.escola = escolas;
	}
	
	public void setEpoca(HashMap<String, Epoca> epocas) {
		this.epoca = epocas;
	}
	
	public void setUsers(HashMap<String, Utilizador> users) {
		this.users = users;
    }
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.epoca == null) ? 0 : this.epoca.hashCode());
		result = prime * result + ((this.escola == null) ? 0 : this.escola.hashCode());
		result = prime * result + ((this.users == null) ? 0 : this.users.hashCode());
		return result;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			APEF apef = (APEF) o;
			return this.escola.equals(apef.getEscolas()) && this.epoca.equals(apef.getEpoca()) && this.users.equals(apef.getUsers());
		}
	}
	
	public APEF clone() {
		return new APEF(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("APEF");
		
		return str.toString(); 
	}
}
