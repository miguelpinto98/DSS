package Business_Layer;

import java.util.ArrayList;

public class Epoca {
    private String nome;
    private Campeonato campeonato;
    private ArrayList<Torneio> torneios;
    
    public Epoca(Epoca epoca) {
		// TODO Auto-generated constructor stub
	}

	public Epoca clone() {
    	return new Epoca(this);
    }
}
