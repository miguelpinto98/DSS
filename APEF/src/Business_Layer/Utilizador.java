package Business_Layer;

import java.util.GregorianCalendar;

public abstract class Utilizador {
	private int id;
    private String nomeUtilizador;
    private String nome;
    private String email;
    private String password;
    private String morada;
    private String telemovel;
    private String codigoPostal;
    private GregorianCalendar dataNascimento;
    private boolean ativo;
    
    public Utilizador() {
    	
    }
    
    public Utilizador(Utilizador u) {
    	
    }
    
    public abstract Utilizador clone() ;
}
