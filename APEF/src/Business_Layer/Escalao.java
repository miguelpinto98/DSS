package Business_Layer;

import java.util.ArrayList;

public abstract class Escalao {
    private ArrayList<Plantel> plantel;
    private Agenda agenda; 			//Jogos	
    private DadosEstatisticos dados;
    private String forma;
    
    public Escalao() {
    	
    }
    
    public abstract Escalao clone();
    
    public abstract String toString();
    
    public abstract boolean equals(Object o);
}
