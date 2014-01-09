package Business_Layer;

import java.util.GregorianCalendar;

public class Treinador extends Pessoa {
      
    //Constructors
    public Treinador() {
        super();
    }

    public Treinador(String nome, Imagem img ,GregorianCalendar n,int genero) {
        super(nome,img,n,genero);
    }
    
    public Treinador(Treinador t) {
    	super(t);
    }
    public Treinador(int id, String nome, Imagem img, GregorianCalendar g, int sexo) {
        super(id,nome,img,g,sexo);
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {
     	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Treinador t = (Treinador) o;
    	return this.getID() == (t.getID());
        }
    }

    public Treinador clone() {
        return new Treinador(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder("Treinador\n");

    	return str.toString();
    }   
    
    //Metodos
    
}
