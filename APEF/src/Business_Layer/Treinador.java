package Business_Layer;

public class Treinador extends Pessoa {
      
    //Constructors
    public Treinador() {
        super();
    }

    public Treinador(Treinador t) {
    	super(t);
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {
     	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Jogador jogador = (Jogador) o;
    	return this.getID() == (jogador.getID());
        }
    }

    public Treinador clone() {
        return new Treinador(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder("Treinador\n");

    	return str.toString();
    }   
    
    
}
