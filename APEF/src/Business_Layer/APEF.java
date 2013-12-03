package Business_Layer;

import java.util.HashMap;
import java.util.Iterator;

public class APEF {
	private HashMap<String, Escola> escola;
	private HashMap<String, Epoca> epoca;
	private HashMap<String, Utilizador> users;
	private Utilizador emSessao;

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

	public Utilizador getEmSessao() {
		return this.emSessao;
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

    public void setEmSessao(Utilizador u) {
    	this.emSessao = u;
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

	/**
	*Metodos Utilizadores
	*/

	/**public boolean existeEmail(String e) {
		boolean res=false;
		for(Utilizador u : this.users) {
			if (u.getEmail().equals(e)) {
				res = true;
				break;
			}
		}
		return res;
	}*/

	public boolean existeEmail(String e) {
		boolean res=false;
		Iterator<String> it = this.users.keySet().iterator(); 
		while (it.hasNext() && !res) {
			String u = it.next();
			if (this.users.get(u).getEmail().equals(e)) {
				res = true;
			}
		}
                return res;
	}

	public boolean existeNickname(String nickname){
		return (this.users.containsKey(nickname));
	}

	public boolean existeUtilizador(String nickname, String email){
		return (existeNickname(nickname) || existeEmail(email));
	}

	public void inserirUtilizador(Utilizador user) {
		if ( !(existeUtilizador(user.getNomeUser(),user.getEmail())) )
                    this.users.put(user.getNomeUser(),user);
	}

	public static boolean validaPassword(String pw) {
        boolean res = true;
        int i = 0;
        
        if(pw.length() < 6)
                    return false ;
        for (; i < pw.length() && res; i++) {
        	char c = pw.charAt(i);
            if (!(Character.isDigit(c) || Character.isLetter(c) || (c == '_') || (c == '.')))
            	res = false;
        }
        return res;
    }

	public void registarUser(String nickname, String password, String email, int tipoUser) {
		if(validaPassword(password)) {
			if (tipoUser==0) 
			{ Admin user = new Admin(IDENTIFICADOR, nickname, password, email);
       	    		  inserirUtilizador(user);
			}
			if (tipoUser==1) 
			{ ResponsavelEscola user = new ResponsavelEscola(IDENTIFICADOR, nickname, password, email);
                	  inserirUtilizador(user);
            }
			if (tipoUser==2) 
			{ Arbitro user = new Arbitro(IDENTIFICADOR, nickname, password, email);
	                  inserirUtilizador(user);
            }
		IDENTIFICADOR++;
		}
	}

	public void removerUtilizador(Utilizador user) {
		this.users.remove(user.getNomeUser());
	}

	public boolean validaLogin(String nickname, String password){
		return (existeNickname(nickname) && this.users.get(nickname).passwordCorresponde(password));
	}

	public void login(String nickname, String password){
		if (validaLogin(nickname,password)) {
			  Utilizador user = this.users.get(nickname);
			  if (user.getAtivo()) { 
			  	this.emSessao = user;
			  	if(user.getAtivo() && !user.getCamposPreenchidos())
			  			{ /** metodo prencher campos*/ }
			  }
			  else { System.out.println("espera validacao"); }
			}
		else System.out.println("LOGIN INVALIDO");
	}
	
	public void logout(){
		this.emSessao = null;
	}

}