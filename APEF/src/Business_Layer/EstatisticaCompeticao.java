package Business_Layer;

import java.util.HashMap;
import java.util.Objects;

public class EstatisticaCompeticao {
    private HashMap<Integer,DadosEstatisticos> estatistica; //<id equipas, dados estatisticos>

    public EstatisticaCompeticao() {
    	this.estatistica = new HashMap<Integer,DadosEstatisticos>();
    }

    public EstatisticaCompeticao(EstatisticaCompeticao ec){
    	this.estatistica = ec.getEstatistica();
    }

    public HashMap<Integer,DadosEstatisticos> getEstatistica(){
    	HashMap<Integer,DadosEstatisticos> aux = new HashMap<Integer,DadosEstatisticos>();
    	
    	for (Integer i : this.estatistica.keySet())
    	{ aux.put(i,this.estatistica.get(i).clone()); }

    	return aux;
    }

    public void setEstatistica(HashMap<Integer,DadosEstatisticos> h){
    	this.estatistica = h;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.estatistica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstatisticaCompeticao other = (EstatisticaCompeticao) obj;
        return (this.estatistica.equals(other.getEstatistica()));
    }

    public EstatisticaCompeticao clone(){
    	return new EstatisticaCompeticao(this);
    }

    public String toString(){
    StringBuilder s = new StringBuilder();
        s.append("Estatistica da Competicao:" + this.getEstatistica());
        return s.toString();
    }
}

  
    
