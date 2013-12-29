package Business_Layer;

import java.util.HashMap;
import java.util.Iterator;

public class Escola {
	
    //variaveis de instancia
    private String nome;
    private String local;
    private Campo campo;
    private HashMap<String,Equipa> equipas;
    private boolean ativa;
    
    //Construtor vazio
    public Escola(){
        this.nome = "";
        this.local = "";
        this.campo = new Campo();
        this.equipas = new HashMap<>();
        this.ativa = false;
    }
    
    //Construtor de copia
    public Escola(Escola escola) {
        this.nome = escola.getNome();
        this.local = escola.getLocal();
        this.campo = escola.getCampo();
        this.equipas = escola.getEquipas();
    }

    public Escola(String nome, String local, Campo campo) {
        this.nome = nome;
        this.local = local;
        this.campo = campo.clone();
        this.equipas = new HashMap<>();
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
     
     public HashMap<String,Equipa> getEquipas() {
         HashMap<String,Equipa> aux = new HashMap<>();
         
         for(String s : this.equipas.keySet()){
             aux.put(s,this.equipas.get(s));
         }
         
         return aux;
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
     
     public void setEquipas(HashMap<String,Equipa> e){
         this.equipas = e;
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
    /**
    *Metodos Equipa
    */
    /**public boolean existeEquipa(String n) {
        boolean res=false;
        Iterator<Equipa> it = this.equipas.iterator(); 
        while (it.hasNext() && !res) {
            Equipa eq = it.next();
            if (eq.getNome().equals(n)) {
                res = true;
            }
        }
        return res;
    }*/

    public boolean inserirEquipa(Equipa a) {
        boolean res = false;
        if(!this.equipas.containsKey(a.getNome())) {
            this.equipas.put(a.getNome(),a);
            res = true;
        }
        return res;
    }
    
    public void removerEquipa(Equipa a) {
        this.equipas.remove(a);
    }
}
