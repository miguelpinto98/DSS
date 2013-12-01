package Business_Layer;

import java.util.ArrayList;

public class Arbitro extends Utilizador {
    private Agenda agenda;
    
    public Arbitro() {
    	super();
    	this.agenda = new Agenda();
    }
    
    public Arbitro(Arbitro arb) {
    	super(arb);
    	this.agenda = arb.getAgenda();
    }
    
    public Agenda getAgenda() {
		return this.agenda;
        
    }
    
    public void setAgenda(Agenda a) {
    	this.agenda = a;
    }
     

	public Arbitro clone() {
    	return new Arbitro(this);
    }

	public String toString() {
		StringBuilder str = new StringBuilder("Arbitro\n");
		
		return str.toString();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			Arbitro a = (Arbitro) o;
			return (this.getID() == a.getID());	
		}
	}
	
	public void resultadoJogo(int casa, int fora, ArrayList<Integer> goleadores) {
		this.agenda.addResultadoJogo(casa,fora,goleadores);
	}
} 
