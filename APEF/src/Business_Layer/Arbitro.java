package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class Arbitro extends Utilizador {
    private Agenda agenda;
    
    public Arbitro() {
    	super();
    	this.agenda = new Agenda();
    }

    public Arbitro(int tipo,String nickname, String password, String email, GregorianCalendar g, APEF a) {
		super(null,tipo,nickname,"",email,password,"","","",g,false,false,false);
		this.agenda = new Agenda();
        APEF.IDENTIFICADOR++; 
	}
    
    public Arbitro(int id, Imagem avatar, int tipo, String nick, String nome, 
            String email, String pw, String morada, String tlmvl, String codPostal, 
            GregorianCalendar dataNasc, boolean ativo, boolean camposP, Agenda a,boolean removido) {
        super(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,codPostal,dataNasc,ativo,camposP,removido);
        this.agenda = a;
    }
    public Arbitro(Arbitro arb) {
    	super(arb);
    	this.agenda = arb.getAgenda();
    }
    
    public Agenda getAgenda() {
		return this.agenda;
        
    }
    
    public void setAgenda(Agenda a) {
    	this.agenda = a;
    }
     

	public Arbitro clone() {
    	return new Arbitro(this);
    }

	public String toString() {
		StringBuilder str = new StringBuilder("Arbitro\n");
		str.append("ID: " + this.getID());
        str.append("\nNickname: " + this.getNomeUser());
        str.append("\nNome: " + this.getNome());
        str.append("\nEmail: " + this.getEmail());
        str.append("\nPassword:" + this.getPass());
        str.append("\nMorada :" + this.getMorada());
        str.append("\nTelemovel: " + this.getTelemovel());
		str.append("\nData de Nascimento: " + this.getDataNasc().get(GregorianCalendar.YEAR) +"/"+this.getDataNasc().get(GregorianCalendar.MONTH) +"/"+this.getDataNasc().get(GregorianCalendar.DAY_OF_MONTH));
        str.append("\nEmail: " + this.getEmail());
        str.append("\nAtivo: " + this.isAtivo());
        str.append("\nCampos Preenchidos: "+  this.isCamposPreenchidos());     
//        str.append("\n"+this.getAgenda().toString());   
        str.append("\n-----------------\n");
		return str.toString();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			Arbitro a = (Arbitro) o;
			return (this.getID() == a.getID());	
		}
	}
	
	public void resultadoJogo(APEF f,int gcasa, int gfora, Map<Integer,Integer> goleadores) {
		Jogo j = null;
		j=this.agenda.addResultadoJogo(gcasa,gfora,goleadores);
		f.addResultadoCompeticao(j);
	}
        
    public void preencheAgendaArbitro(Jogo j) {
        agenda.inserirJogo(j);
    }
} 
