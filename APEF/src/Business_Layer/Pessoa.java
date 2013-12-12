package Business_Layer;

import java.util.GregorianCalendar;

public abstract class Pessoa {
    
	//Variaveis de Instancia
    private int id;
    private String nome;
    private Imagem foto;
    private GregorianCalendar dataNascimento;
    private int sexo; //0 - nao esta definido, 1 - masc , 2 - fem

    //Construtores
	public Pessoa() {
		this.id = -1;
		this.nome = "";
		this.foto = null;
		this.dataNascimento = new GregorianCalendar();
		this.sexo = 0;
	}

	public Pessoa(String name, Imagem img, 
					GregorianCalendar data, int genero) {
		this.id = APEF.IDENTIFICADOR;
		this.nome = name;
		this.foto = img;
		this.dataNascimento = data;
		this.sexo = genero;
        APEF.IDENTIFICADOR++;
	}

	public Pessoa(Pessoa p) {
		this.id = p.getID();
		this.nome = p.getNome();
		this.foto = p.getFoto();
		this.dataNascimento = p.getDataNasc();
		this.sexo = p.getSexo();
	}

	//Getters
 	public int getID() {
        return this.id;
    }

	public String getNome() {
        return this.nome;
    }    
    
    public Imagem getFoto() {
        return this.foto;
    }

    public GregorianCalendar getDataNasc() {
    	return (GregorianCalendar) dataNascimento.clone();
	}
    
    public int getSexo() {
    	return this.sexo;
    }	
    
	//Setters
    public void setID(int id) {
    	this.id = id;
    }

    public void setNome(String name) {
    	this.nome = name;
    }

    public void setFoto(Imagem img) {
    	this.foto = img;
    }

    public void setDataNasc(GregorianCalendar data) {
    	this.dataNascimento = data;
    }

    public void setSexo(int genero) {
    	this.sexo = genero;
    }

    //Equals,Clone,toString
  	public abstract Pessoa clone(); 
   
    public abstract String toString();
    
    public abstract boolean equals(Object o);

    /**metodos*/
    public void atualizaDados (String nome, Imagem foto, GregorianCalendar dataNascimento, int sexo) {

    }
    
}
