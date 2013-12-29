package Business_Layer;

import java.util.ArrayList;
import java.util.HashSet;

public class Grupo extends Fase {    
    
    //Variaveis de Instancia
    private EstatisticaCompeticao classificacao;

    //Construtores
    public Grupo() {
    	super();
    	this.classificacao = new EstatisticaCompeticao();
    }

    public Grupo(String n, HashSet<Escalao> le){
        super(n,le);
        this.classificacao = new EstatisticaCompeticao();
    }

    public Grupo(Grupo g) {
    	super(g);
    	this.classificacao = g.getClassificacao();
    }

    //Getters Setters

    public EstatisticaCompeticao getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(EstatisticaCompeticao classificacao) {
        this.classificacao = classificacao;
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {

    	if(this == o)
    		return true;
    	if ( (o == null) || (this.getClass() != o.getClass()) )
    		return false;
        else {
    	Grupo grupo = (Grupo) o;
    	return (this.getClassificacao().equals(grupo.getClassificacao()));
        }
    }
    
    public Grupo clone() {
        return new Grupo(this);
    }

    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("--Grupo--") ;
        str.append(this.getListaEscaloes());
        str.append(this.getCalendario()+"  ");
        str.append(this.getClassificacao());
    	return str.toString();
    }  	
    //Metodos
}
