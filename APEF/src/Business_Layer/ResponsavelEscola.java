package Business_Layer;

import java.util.HashSet;

public class ResponsavelEscola extends Utilizador {
	private HashSet<Equipa> equipas;
	
	
	public ResponsavelEscola(ResponsavelEscola responsavelEscola) {
	}


	public ResponsavelEscola clone() {
		return new ResponsavelEscola(this);
	}
	
}
