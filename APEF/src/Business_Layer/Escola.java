package Business_Layer;

import Data_Layer.EquipaDAO;
import java.util.HashMap;
import java.util.Map;

public class Escola {	
    //variaveis de instancia
    private String nome;
    private String local;
    private Campo campo;
    private Map<String,Equipa> equipas;
    private int removida;
    
    //Construtor vazio
    public Escola(){
        this.nome = "";
        this.local = "";
        this.campo = new Campo();
        this.equipas = new EquipaDAO(this.nome);
        this.removida = 0;
    }
    
    //Construtor de copia
    public Escola(Escola escola) {
        this.nome = escola.getNome();
        this.local = escola.getLocal();
        this.campo = escola.getCampo();
        this.equipas = escola.getEquipas();
        this.removida = escola.getRemovida();
    }
    
    public Escola(String nome, String local, Campo campo) {
        this.nome = nome;
        this.local = local;
        this.campo = campo;
        this.removida = 0;
        this.equipas = new EquipaDAO(nome);
    }
    
    public Escola(String nome, String local, Campo campo, int rem) {
        this.nome = nome;
        this.local = local;
        this.campo = campo.clone();
        this.equipas = new EquipaDAO(nome);
        this.removida = rem;
    }
    //getters
     public String getNome() {
         return this.nome;
     }
     
     public String getLocal() {
         return this.local;
     }
     
     public Campo getCampo() {
         return this.campo;
     }
 
     public Map<String,Equipa> getEquipas() {
         return this.equipas;
     }
     
     
     //setters
     public void setNome(String n){
         this.nome = n;
     }
     
     public void setLocal(String l){
         this.local = l;
     }
     
     public void setCampo(Campo c){
         this.campo = c;
     }
     
     public void setEquipas(Map<String,Equipa> e){
         this.equipas = e;
     }
     
     public void setRemovida(int rem) {
         this.removida = rem;
     }
     
    //clone, equals e toString
    public Escola clone() {
    	return new Escola(this);
    }
    
     public String toString() {
        StringBuilder str = new StringBuilder(); 
        str.append("Escola\n");
        str.append(this.getNome() + "\n");
        str.append(this.getLocal() + "\n");
        str.append(this.getCampo() + "\n");
        str.append(this.getEquipas() + "\n");
        
        return str.toString(); 
    }
     
    public boolean equals(Object o) {
        if (this == null)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
            Escola t = (Escola) o;
            return this.nome.equals(t.getNome());
        }
    }
    
    public boolean inserirEquipa(Equipa a) {
        boolean res = false;
        if(!this.equipas.containsKey(a.getNome())) {
            this.equipas.put(a.getNome(),a);
            res = true;
        }
        return res;
    }
    
    public void removerEquipa(Equipa a) {
        this.equipas.remove(a.getNome());
    }

    public int getRemovida() {
        return this.removida;
    }
}
