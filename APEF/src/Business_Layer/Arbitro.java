package Business_Layer;

public class Arbitro extends Utilizador {
    private Agenda agenda;
    
    public Arbitro() {
    	super();
    	this.agenda = new Agenda();
    } 
    
    public Arbitro(Arbitro arbitro) {
	
    }
    
     private Agenda getAgenda() {
        
    }

	public Arbitro clone() {
    	return new Arbitro(this);
    }
   
} 
