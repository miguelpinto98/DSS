package Business_Layer;

public class Arbitro extends Utilizador {
    private Agenda agenda;
    
    public Arbitro() {
    	super();
    	this.agenda = new Agenda();
    }
    
    
    public Arbitro(Arbitro arbitro) {
		// TODO Auto-generated constructor stub
	}


	public Arbitro clone() {
    	return new Arbitro(this);
    }
}
