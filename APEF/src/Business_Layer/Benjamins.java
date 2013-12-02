package Business_Layer;

public class Benjamins extends Escalao {

    private static final int duracaoJogo = 45;

    
    //construtor vazio
    public Benjamins(){
        super();
    } 
    
    //construtor de copia
    public Benjamins(Benjamins benjamin){
        super(benjamin);
    }
    
    
    //clone, equals e toString
    	@Override
    public Benjamins clone() {
        return new Benjamins(this);
    }

	@Override
    public String toString() {
	StringBuilder str = new StringBuilder("Benjamins\n");
		
	return str.toString();
    }

	@Override
    public boolean equals(Object o) {
	if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			Benjamins b = (Benjamins) o;
			return (this.getPlantel() == b.getPlantel());	
		}	
    }
}
