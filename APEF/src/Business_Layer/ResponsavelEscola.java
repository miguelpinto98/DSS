package Business_Layer;

import java.util.HashSet;
import java.util.GregorianCalendar;

public class ResponsavelEscola extends Utilizador {
	private Escola escola; //???
	
	public ResponsavelEscola() {
		super();
		this.escola = new Escola();
	}

	public ResponsavelEscola(int id, String nickname, String password, String email, GregorianCalendar g) {
		super(id,null,nickname,"",email,password,"","","",g,false,false);
		this.escola = new Escola(); 
	}

	public ResponsavelEscola(ResponsavelEscola re) {
		super(re);
		this.escola = re.getEscola();
	}
	
	public Escola getEscola() {
		return this.escola;
	}

	public void setEscola(Escola es) {
		this.escola = es;
	}

	public ResponsavelEscola clone() {
		return new ResponsavelEscola(this);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			ResponsavelEscola re = (ResponsavelEscola) o;
			return (this.getID() == re.getID());	
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Responsavel Escola\n");
                str.append("ID:" + this.getID() + "\n");
                str.append("Nickname:" + this.getNomeUser()+"\n");
                str.append("Password:" + this.getPass()+"\n");
                str.append("Email:" + this.getEmail()+"\n");
		
		return str.toString();
	}
}
