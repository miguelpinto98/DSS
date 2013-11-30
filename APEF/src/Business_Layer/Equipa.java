package Business_Layer;

import java.util.ArrayList;
import java.util.HashMap;

public class Equipa {
    private int id;
    private String nome;
    private Imagem emblema;
    private HashMap<String,Integer> palmares; //<nome da competicao, nr vezes que ganhou>
    private ArrayList<Escalao> escaloes;
    
    public Equipa(Equipa equipa) {
		// TODO Auto-generated constructor stub
	}

	public Equipa clone() {
    	return new Equipa(this);
    }
}
