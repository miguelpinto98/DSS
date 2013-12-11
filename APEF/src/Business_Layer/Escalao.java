package Business_Layer;

import java.util.ArrayList;
import java.util.HashMap;

public class Escalao {
	private HashMap<Integer,Plantel> planteis;

	public Escalao(){
		this.planteis = new HashMap<>();
	}

	public Escalao(Escalao e){
		this.planteis = e.getPlanteis();
	}

	public HashMap<Integer,Plantel> getPlanteis(){
		HashMap<Integer,Plantel> h = new HashMap<>();

		for(Integer i : this.planteis.keySet())
			h.put(i, this.planteis.get(i));

		return h;
	}

	public void setPlantel(HashMap<Integer,Plantel> planteis){
		this.planteis = planteis;
	}

	public Escalao clone() {
    	return new Escalao(this);
    }

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planteis == null) ? 0 : planteis.hashCode());
		return result;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("Escalao");
		
		return str.toString();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Escalao e = (Escalao) o;
			return (this.planteis.equals(e.getPlanteis()));
		}
	}
    
    public String defineNomePlantel(Equipa e, int tipo) {
        String res="";
        if(tipo==0) res=e.getNome()+"Infantis";
        if(tipo==1) res=e.getNome()+"Benjamins";
        if(tipo==2) res=e.getNome()+"Traquinas";
        if(tipo==3) res=e.getNome()+"Petizes";
        
        return res;
    }
     
    public void criarPlantel(int id, Equipa e, int tipo) {
        String nomePlantel = defineNomePlantel(e, tipo);
        
        if(!(this.planteis.containsKey(id))) {
            Plantel p = new Plantel(id,nomePlantel);
            this.planteis.put(id, p);
        }
    }        
}