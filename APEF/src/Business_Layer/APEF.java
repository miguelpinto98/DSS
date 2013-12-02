package Business_Layer;

import java.util.HashMap;

public class APEF {
	private BancoDados bd;
    
    public APEF() {
    	this.bd = new BancoDados();
    }

	public APEF(APEF a) {
		this.bd = a.getBancoDados();
	}

	public BancoDados getBancoDados() {
		return this.bd;
	}

	public void setBancoDados(BancoDados bd) {
		this.bd = bd;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			APEF apef = (APEF) o;
			return this.bd.equals(apef.getBancoDados());
		}
	}
	
	public APEF clone() {
		return new APEF(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("APEF");
		str.append(this.getBancoDados().toString());
		
		return str.toString(); 
	}
}
