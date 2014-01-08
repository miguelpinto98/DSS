package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public interface Competicao {
    
    //Getters e Setters
    public int getID();

    public void setID(int id);

    public String getNome();

    public void setNome(String nome);

    public int getNrEscaloes();

    public void setNrEscaloes(int nrPlanteis);

    public Map<Integer, Integer> getGoleadores();

    public void setGoleadores(HashMap<Integer, Integer> goleadores);

    public GregorianCalendar getDataInicio();

    public void setDataInicio (GregorianCalendar data);

    public GregorianCalendar getDataLimiteInscricoes();

    public void setDataLimiteInscricoes (GregorianCalendar data);
    
    //Equals,hashCode,Clone,toString
    public int hashCode();

    public boolean equals(Object o);
    
    public String toString();
}
