package Business_Layer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.GregorianCalendar;

public abstract class Utilizador {
    
    //Variaveis de Instancia
    private int id;
    private int tipo;
    private Imagem avatar;
    private String nomeUtilizador;
    private String nome;
    private String email;
    private String password;
    private String morada;
    private String telemovel;
    private String codigoPostal;
    private GregorianCalendar dataNascimento;
    private boolean ativo;
    private boolean camposPreenchidos;
    private boolean removido;
    //Construtores
    public Utilizador() {
    	this.id = APEF.getID();
        this.tipo = -1;
        this.avatar = null;
        this.nomeUtilizador = "";
        this.nome = "";
        this.email = "";
        this.password = "";
        this.morada = "";
        this.telemovel = "";
        this.codigoPostal = "";
        this.dataNascimento = new GregorianCalendar();
        this.ativo = false;
        this.camposPreenchidos = false;
        this.removido = false;
        APEF.putID();
    }

    public Utilizador(Imagem img, int tipo, String nickname, String nome, String email, 
                        String pw, String morada, String tlmvl, 
                        String codPostal, GregorianCalendar data, 
                        boolean ativo, boolean camposPreenchidos, boolean removido) {
        this.id = APEF.getID();
        this.tipo = tipo;
        this.avatar = img;
        this.nomeUtilizador = nickname;
        this.nome = nome;
        this.email = email;
        this.password = pw;
        this.morada = morada;
        this.telemovel = tlmvl;
        this.codigoPostal = codPostal;
        this.dataNascimento = data;
        this.ativo = ativo;
        this.camposPreenchidos = camposPreenchidos;
        this.removido = removido;
        APEF.putID();
    }
    
    public Utilizador(int id, Imagem avatar, int tipo, String nick, String nome, String email, String pw, 
            String morada, String tlmvl, String codPostal, GregorianCalendar dataNasc, 
            boolean ativo, boolean camposP, boolean removido) {
        this.id = id;
        this.avatar = avatar;
        this.tipo = tipo;
        this.nomeUtilizador = nick;
        this.nome = nome;
        this.email = email;
        this.password = pw;
        this.morada = morada;
        this.telemovel = tlmvl;
        this.codigoPostal = codPostal;
        this.dataNascimento = dataNasc;
        this.ativo = ativo;
        this.camposPreenchidos = camposP;
        this.removido = removido;
    }
    
    public Utilizador(Utilizador u) {
    	this.id = u.getID();
        this.avatar = u.getAvatar();
        this.nomeUtilizador = u.getNomeUser();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.password = u.getPass();
        this.morada = u.getMorada();
        this.telemovel = u.getTelemovel();
        this.codigoPostal = u.getCodPostal();
        this.dataNascimento = u.getDataNasc();
        this.ativo = u.isAtivo();
        this.camposPreenchidos = u.isCamposPreenchidos();
        this.removido = u.isRemovido();
        this.tipo = u.getTipo();
    }

    //Getters
    public int getID() {
        return this.id;
    }
    
    public Imagem getAvatar() {
        return this.avatar;
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
    
    public int getTipo() {
        return this.tipo;
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

    public boolean isAtivo() {
        return this.ativo;
    }
    
    public boolean isRemovido() {
        return this.removido;
    }
    
    public boolean isCamposPreenchidos() {
        return this.camposPreenchidos;
    }
    
    //Setters
    public void setID(int iden){
        this.id = iden;
    }
    
    public void setAvatar(Imagem img) {
        this.avatar = img;
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
    
    public void setAtivo(boolean m){
        this.ativo = m;
    }

    public void setCamposPreenchidos(boolean m){
        this.camposPreenchidos = m;
    }
    
    //Equals,Clone,toString
    public abstract Utilizador clone(); 
   
    public abstract String toString();
    
    public abstract boolean equals(Object o);

    /**Metodos*/
    public static String encriptarPassword (String pw) {
        byte[] pwB = pw.getBytes() ;
        byte[] pwEnc = null ;
        String res = null ;        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5") ;
            pwEnc = md.digest(pwB) ;
            BigInteger big = new BigInteger(1, pwEnc) ;
            res = big.toString(16) ;            
        } catch (Exception e) {throw new NullPointerException(e.getMessage()) ;}
        return res ;
    }

    public boolean passwordCorresponde(String pw) {    
        //System.out.println("pw login :" + encriptarPassword(pw)) ;
        //System.out.println("pw user :" + this.password) ;
        return this.password.equals(encriptarPassword(pw));
       }
}

