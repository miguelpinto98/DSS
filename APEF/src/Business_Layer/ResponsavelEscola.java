package Business_Layer;

import java.util.HashSet;

public class ResponsavelEscola extends Utilizador {
	private HashSet<Equipa> equipas; //???
	
	public ResponsavelEscola(ResponsavelEscola re) {
		super();
		this.equipas = re.getEquipasResponsavel();
	}
	
	public HashSet<Equipa> getEquipasResponsavel() {
		HashSet<Equipa> hse = new HashSet<>();
		
		for(Equipa e : this.equipas)
			hse.add(e.clone());
		
		return null;
	}

	public void setEquipasResponsavel(HashSet<Equipa> es) {
		this.equipas = es;
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
		StringBuilder str = new StringBuilder("Responsavel Escola");
		
		return str.toString();
	}
}
