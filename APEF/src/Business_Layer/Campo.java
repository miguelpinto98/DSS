package Business_Layer;

public class Campo {    
    
    //Variaveis de Instancia
    private int id;    
    private String nome;   

    //Construtores
    public Campo() {
    	this.id = 0;
    	this.nome = "";
    }

    public Campo(Campo c) {
    	this.id = c.getID();
    	this.nome = c.getNome();
    }

    public Campo(String n) {
        this.id = APEF.IDENTIFICADOR;
        this.nome = n;
        APEF.IDENTIFICADOR++;
    }

    //Getters
    public int getID() {
    	return this.id;
    }

    public String getNome() {
    	return this.nome;
    }

    //Setters
    public void setID(int id){
    	this.id = id;
    }

    public void setNome(String n){
        this.nome = n;
    }
    
    //Equals,Clone,toString
  	public boolean equals(Object o) {
    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Campo campo = (Campo) o;
    	return (this.getID() == campo.getID());
        }
    }
    
    public Campo clone() {
        return new Campo(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
        str.append("\nID Campo: "+this.getID());
        str.append("\nNome Campo: "+this.getNome());

    	return str.toString();
    }
}

