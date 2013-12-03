package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Arbitro extends Utilizador {
    private Agenda agenda;
    
    public Arbitro() {
    	super();
    	this.agenda = new Agenda();
    }

    public Arbitro(int id, String nickname, String password, String email, GregorianCalendar g) {
		super(id,null,nickname,"",email,password,"","","",g,false,false);
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
		str.append("ID:" + this.getID() + "\n");
                str.append("Nickname:" + this.getNomeUser()+"\n");
                str.append("Password:" + this.getPass()+"\n");
                str.append("Email:" + this.getEmail()+"\n");
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
