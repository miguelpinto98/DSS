package Business_Layer;

public class Petizes extends Escalao {
	
    private static final int duracaoJogo = 21;

    //construtor vazio
    public Petizes(){
        super();
    }
    
    //construtor de copia
    public Petizes(Petizes p){
        super(p);
    }
    
    //clone, equals e toString
	@Override
    public Petizes clone() {
	return new Petizes(this);	
    }

	@Override
    public String toString() {
	 StringBuilder str = new StringBuilder("Petizes\n");
		
         return str.toString();
    }

	@Override
	public boolean equals(Object o) {
            if (this == o)
		return true;
            if ((o == null) || (o.getClass() != this.getClass()))
		return false;
            else {
			Petizes b = (Petizes) o;
			return (this.getPlantel() == b.getPlantel());	
		}
	}

}
