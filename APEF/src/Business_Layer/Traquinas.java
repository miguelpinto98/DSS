package Business_Layer;

public class Traquinas extends Escalao {
	private static final int duracaoJogo = 45;

        //construtor vazio
        public Traquinas(){
            super();
        }
        
        //construtor de copia
        public Traquinas(Traquinas t){
            super(t);
        }
        
        //clone, equals e toString
	@Override
	public Traquinas clone() {
            return new Traquinas(this);
	}

	@Override
	public String toString() {
            StringBuilder str = new StringBuilder("Traquinas\n");
		
            return str.toString();
	}

	@Override
	public boolean equals(Object o) {
            if (this == o)
		return true;
            if ((o == null) || (o.getClass() != this.getClass()))
		return false;
            else {
			Traquinas b = (Traquinas) o;
			return (this.getPlantel() == b.getPlantel());	
		}
	}

}
