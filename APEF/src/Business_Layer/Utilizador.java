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
    	this.id = 0;
        this.nomeUtilizador = "";
        this.nome = "";
        this.email = "";
        this.password = "";
        this.morada = "";
        this.telemovel = "";
        this.codigoPostal = "";
        this.dataNascimento = new GregorianCalendar();
        this.ativo = false;
    }
    
    public Utilizador(Utilizador u) {
    	this.id = u.getID();
        this.nomeUtilizador = u.getNomeUser();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.password = u.getPass();
        this.morada = u.getMorada();
        this.telemovel = u.getTelemovel();
        this.codigoPostal = u.getCodPostal();
        this.dataNascimento = u.getDataNasc();
        this.ativo = u.getAtivo();
    }

    //Get's
    public int getID() {
        return this.id;
    }

    public String getNomeUser() {
        return this.nomeUtilizador;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPass() {
        return this.password;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getTelemovel() {
        return this.telemovel;
    }

    public String getCodPostal() {
        return this.codigoPostal;
    }

    public GregorianCalendar getDataNasc() {
        return (GregorianCalendar) dataNascimento.clone();
    }

    public boolean getAtivo() {
        return this.ativo;
    }
    
    //Set's
    public void setID(int iden){
        this.id = iden;
    }
    
    public void setNomeUser(String nUser){
        this.nomeUtilizador = nUser;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    
    public void setPass(String pass){
        this.password = pass;
    }
    
    public void setMorada(String m){
        this.morada = m;
    }
    
    public void setTelemovel(String tele){
        this.telemovel = tele;
    }
    
    public void setCodPostal(String cp){
        this.codigoPostal = cp;
    }
    
    public void setDataNasc(GregorianCalendar dn){
        this.dataNascimento = dn;
    }
    
    public abstract Utilizador clone(); 
   
    public abstract String toString();
    
    public abstract void equals();
}

