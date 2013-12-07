package Business_Layer;

import java.util.GregorianCalendar;

public class HistoricoAcao {    
    
    //Variaveis de Instancia
    private String titulo;    
    private String descricao;
    private GregorianCalendar data; 

    //Construtores
    public HistoricoAcao() {
    	this.titulo = "";
    	this.descricao = "";
        this.data = new GregorianCalendar();
    }

    public HistoricoAcao(HistoricoAcao ha) {
    	this.titulo = ha.getTitulo();
    	this.descricao = ha.getDescricao();
        this.data = ha.getData();
    }

    //Getters
    public String getTitulo() {
    	return this.titulo;
    }

    public String getDescricao() {
    	return this.descricao;
    }

    public GregorianCalendar getData() {
        return (GregorianCalendar) data.clone();
    }

    //Setters
    public void setTitulo(String s){
    	this.titulo = s;
    }

    public void setDescricao (String n){
        this.descricao = n;
    }
    
    public void setDataNasc(GregorianCalendar dn){
        this.data = dn;
    }

    //Equals,Clone,toString
  	public boolean equals(Object o) {
    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	HistoricoAcao ha = (HistoricoAcao) o;
    	return (this.getTitulo().equals(ha.getTitulo()));
        }
    }
    
    public HistoricoAcao clone() {
        return new HistoricoAcao(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Historico--\n") ;
        str.append(getTitulo() + "\n");
        str.append(getDescricao() + "\n");
        str.append(getData() + "\n");

    	return str.toString();
    }
}
