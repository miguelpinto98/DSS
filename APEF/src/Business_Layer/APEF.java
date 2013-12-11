package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class APEF {
	private HashMap<String, Escola> escolas;
	private HashMap<Integer, Epoca> epocas;
	private HashMap<String, Utilizador> users;
	private Utilizador emSessao;

    public static int IDENTIFICADOR=1;
    
    public APEF() {
    	this.escolas = new HashMap<>();
    	this.epocas = new HashMap<>();
    	this.users = new HashMap<>();
        this.emSessao = null;
    }

	public APEF(APEF a) {
		this.escolas = a.getEscolas();
		this.epocas = a.getEpoca();
		this.users = a.getUsers();
                this.emSessao = a.getEmSessao();
	}

	public HashMap<String, Escola> getEscolas() {
		HashMap<String,Escola> aux = new HashMap<>();
		
		for(String s : this.escolas.keySet())
			aux.put(s, this.escolas.get(s).clone());
		
		return aux;
	}
	
	public HashMap<Integer, Epoca> getEpoca() {
		HashMap<Integer,Epoca> aux = new HashMap<>();
		
		for(Integer s : this.epocas.keySet())
			aux.put(s, this.epocas.get(s).clone());
		
		return aux;
	}

	public HashMap<String, Utilizador> getUsers() {
		HashMap<String,Utilizador> aux = new HashMap<>();
		
		for(String s : this.users.keySet())
			aux.put(s, this.users.get(s));
		
		return aux;
	}

	public Utilizador getEmSessao() {
		return this.emSessao;
	}

	public void setEscolas(HashMap<String, Escola> escolas) {
		this.escolas = escolas;
	}
	
	public void setEpoca(HashMap<Integer, Epoca> epocas) {
		this.epocas = epocas;
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
		result = prime * result + ((this.epocas == null) ? 0 : this.epocas.hashCode());
		result = prime * result + ((this.escolas == null) ? 0 : this.escolas.hashCode());
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
			return this.escolas.equals(apef.getEscolas()) && this.epocas.equals(apef.getEpoca()) && this.users.equals(apef.getUsers());
		}
	}
	
	public APEF clone() {
		return new APEF(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("APEF\n");
		str.append("Utilizador:" + this.getUsers());
        str.append("Escola:" + this.getEscolas());
		
		return str.toString(); 
	}

	/**
	*Metodos Utilizadores
	*/
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
		if ( !(existeUtilizador(user.getNomeUser(),user.getEmail())) ) {
                    this.users.put(user.getNomeUser(),user);
                    IDENTIFICADOR++;
        }
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
		GregorianCalendar g = new GregorianCalendar();
		if(validaPassword(password)) {
			if (tipoUser==0) { 
				Admin user = new Admin(IDENTIFICADOR, nickname, password, email, g);
				String pw = user.encriptarPassword(password);
                user.setPass(pw);
       	    	inserirUtilizador(user);
			}
			if (tipoUser==1) { 
				ResponsavelEscola user = new ResponsavelEscola(IDENTIFICADOR, nickname, password, email,g);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
                inserirUtilizador(user);
            }
			if (tipoUser==2) { 
				Arbitro user = new Arbitro(IDENTIFICADOR, nickname, password, email, g);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
	            inserirUtilizador(user);
	        }	
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
			  if ((this.users.get(nickname).isAtivo())) { 
			  	this.emSessao = this.users.get(nickname);
			  	if(this.users.get(nickname).isAtivo() && !this.users.get(nickname).isCamposPreenchidos())
			  			{ /** metodo prencher campos*/ }
			  }
			  else { System.out.println("espera validacao"); }
			}
		else System.out.println("LOGIN INVALIDO");
	}
	
	public void logout(){
		this.emSessao = null;
	}

	/**
	*Metodos Escola
	*/
        
    public void criarEscola(String nome, String local, String nomeCampo) {
    	if(!(this.escolas.containsKey(nome))){
    		Campo c = new Campo(IDENTIFICADOR,nomeCampo);
        	Escola a = new Escola(nome,local,c);
    		this.escolas.put(nome,a);
        	IDENTIFICADOR++;
    	}
    	else
    		System.out.println("Escola ja existe");
    }

    public void removerEscola(Escola escola) {
		this.escolas.remove(escola.getNome());
	}

	public void criaEpoca(int anoEpoca) {
		GregorianCalendar g = new GregorianCalendar();
		
		if(this.epocas.containsKey(anoEpoca) || (anoEpoca-g.get(GregorianCalendar.YEAR))==0)
			; /*Epoca ja existe || Nao esta no ano corrente*/
		else {
			Epoca e = new Epoca();
			this.epocas.put(anoEpoca, e);
		}	
	}
	
	public void mudarPermissoes(String name) {
		this.users.get(name).setAtivo(true);		
	}
}