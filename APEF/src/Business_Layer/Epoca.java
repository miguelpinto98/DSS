package Business_Layer;

import java.util.ArrayList;

public class Epoca {
    
    //variaveis de instancia
    private String nome;
    private Campeonato campeonato;
    private ArrayList<Torneio> torneios;
    
    
    //construtor vazio
    public Epoca(){
        this.nome = "";
        this.campeonato = new Campeonato();
        this.torneios = new ArrayList<>();
    }
    
    //construtor de copia
    public Epoca(Epoca epoca) {
        this.nome = epoca.getNome();
        this.campeonato = epoca.getCampeonato();
        this.torneios = epoca.getTorneios();
    }
    
    //construtor por partes
    public Epoca(String n, Campeonato c, ArrayList<Torneio> t){
        this.nome = n;
        this.campeonato = c;
        this.torneios = t;
    }

    
    //getters
    public String getNome() {
        return this.nome;
    }
    
     public Campeonato getCampeonato() {
         return this.campeonato;
     }

     public ArrayList<Torneio> getTorneios() {
         ArrayList<Torneio> aux = new ArrayList<>();
         
         for(Torneio t : this.torneios){
             aux.add(t.clone()); //
         }
         
         return aux;
     }

     //setters
     public void setNome(String nome){
         this.nome = nome;
     }
     
     public void setCampeonato(Campeonato c){
         this.campeonato = c;
     }
     
     public void setTorneios(ArrayList<Torneio> t){
         this.torneios = t;
     }
   
     
    //clone, equals e 
    public Epoca clone() {
    	return new Epoca(this);
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
	
        str.append("Banco de Dados");
	str.append(this.getNome() + "\n");
	str.append(this.getCampeonato() + "\n");
	str.append(this.getTorneios() + "\n");
                
        return str.toString();
    }
    
    public boolean equals(Object o) {
            if (this == o)
		return true;
            if ((o == null) || (o.getClass() != this.getClass()))
		return false;
            else {
			Epoca b = (Epoca) o;
			return (this.getNome().equals(b.getNome()));	
		}
	}

    
    
}
