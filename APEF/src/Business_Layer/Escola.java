package Business_Layer;

import java.util.HashSet;

public class Escola {
	private String nome;
    private String local;
    private Campo campo;
    private HashSet<Equipa> equipas;
    
    public Escola(Escola escola) {
		// TODO Auto-generated constructor stub
	}

	public Escola clone() {
    	return new Escola(this);
    }
}
