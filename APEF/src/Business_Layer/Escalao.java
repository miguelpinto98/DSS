package Business_Layer;

import java.util.ArrayList;

public abstract class Escalao {
    
    //Variaveis de instancia
    private ArrayList<Plantel> plantel;
    private Agenda agenda; 			//Jogos	
    private DadosEstatisticos dados;
    private String forma;
    
    //construtor vazio
    public Escalao() {
    	this.plantel = new ArrayList<>();
        this.agenda = new Agenda();
        this.dados = new DadosEstatisticos();
        this.forma = "";
    }
    
  
    public Escalao(Escalao e){
        this.plantel = e.getPlantel();
        this.agenda = e.getAgenda();
        this.dados = e.getDados();
        this.forma = e.getForma();
    }
    
    
    //getters
    public ArrayList<Plantel> getPlantel() {
        ArrayList<Plantel> aux = new ArrayList<Plantel>();
        
        for(Plantel p : this.plantel){
            aux.add(p.clone());
        }
        return aux;
    } 
   
    public Agenda getAgenda() {
        return this.agenda;
    }
    
    public DadosEstatisticos getDados() {
        return this.dados;
    }
    
    public String getForma(){
        return this.forma;
    }

    
    //setters
    public void setPlantel(ArrayList<Plantel> plantel){
        this.plantel = plantel;
    }
    
    public void setAgenda(Agenda agenda){
        this.agenda = agenda;
    }
    
    public void setDados(DadosEstatisticos dados){
        this.dados = dados;
    }
    
    public void setForma(String f){
        this.forma = f;
    }
    
    
    //clone, equals e toString
    public abstract Escalao clone();
    
    public abstract String toString();
    
    public abstract boolean equals(Object o);

    

    
    
}
