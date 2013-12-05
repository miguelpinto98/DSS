package Business_Layer;

import java.util.HashSet;

public class Escola {
	
    //variaveis de instancia
    private String nome;
    private String local;
    private Campo campo;
    private HashSet<Equipa> equipas;
    
    //Construtor vazio
    public Escola(){
        this.nome = "";
        this.local = "";
        this.campo = new Campo();
        this.equipas = new HashSet<>();
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
        this.campo = campo;
        this.equipas = new HashSet<Equipa>();
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
     
     public HashSet<Equipa> getEquipas() {
         HashSet<Equipa> aux = new HashSet<>();
         
         for(Equipa e : this.equipas){
             aux.add(e.clone());
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
     
     public void setEquipas(HashSet<Equipa> e){
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


   

    

    
   
}
