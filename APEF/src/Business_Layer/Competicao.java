package Business_Layer;

import java.util.HashMap;

public interface Competicao {
    
    //Getters e Setters
    public int getID();

    public void setID(int id);

    public String getNome();

    public void setNome(String nome);

    public int getNrEquipas();

    public void setNrEquipas(int nrEquipas);

    public HashMap<Integer, Integer> getGoleadores();

    public void setGoleadores(HashMap<Integer, Integer> goleadores);

    //Equals,hashCode,Clone,toString
    public int hashCode();

    public boolean equals(Object o);
    
    public String toString();
}
