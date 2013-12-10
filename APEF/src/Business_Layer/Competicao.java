package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashMap;

public interface Competicao {
    
    //Getters e Setters
    public int getID();

    public void setID(int id);

    public String getNome();

    public void setNome(String nome);

    public int getNrPlanteis();

    public void setNrPlanteis(int nrPlanteis);

    public HashMap<Integer, Integer> getGoleadores();

    public void setGoleadores(HashMap<Integer, Integer> goleadores);

    public GregorianCalendar getDataInicio();

    public void setDataInicio (GregorianCalendar data);

    public GregorianCalendar getDataFim();

    public void setDataFim (GregorianCalendar data);
    
    //Equals,hashCode,Clone,toString
    public int hashCode();

    public boolean equals(Object o);
    
    public String toString();
}
