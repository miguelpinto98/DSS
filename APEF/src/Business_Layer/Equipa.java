package Business_Layer;

import Data_Layer.EquipaDAO;
import Data_Layer.EscalaoDAO;
import Data_Layer.PalmaresDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Equipa {
    private static final int indexInfantis = 0;
    private static final int indexBenjamins = 1;
    private static final int indexTraquinas = 2;
    private static final int indexPetizes = 3;
    private static final int maxEscaloes = 4;
    
    private int id;
    private String nome;
    private Imagem emblema;
    private Map<String,Integer> palmares; //<nome da competicao, nr vezes que ganhou>
    private Map<Integer,Escalao> escaloes; //<tipo de escalao(0,1,2 ou 3), Escalao>  
    
    public Equipa() {
    	this.id = APEF.IDENTIFICADOR;
    	this.nome = new String();
    	this.emblema = new Imagem();
    	this.palmares = new PalmaresDAO();
    	this.escaloes = new EscalaoDAO(this.id);
        APEF.IDENTIFICADOR++;
    }
    
    public Equipa(String n, Imagem e) {
    	this.id = APEF.IDENTIFICADOR;
    	this.nome = n;
    	this.emblema = e;
    	this.palmares = new PalmaresDAO();
    	this.escaloes = new EscalaoDAO(this.id);
    	APEF.IDENTIFICADOR++;	
    }

    public Equipa(String n) {
    	this.id = APEF.IDENTIFICADOR;
    	this.nome = n;
    	this.emblema = new Imagem();
    	this.palmares = new PalmaresDAO();
    	this.escaloes = new EscalaoDAO(this.id);
    	APEF.IDENTIFICADOR++;	
    }
    
    public Equipa(int id, String n) {
    	this.id = id;
    	this.nome = n;
    	this.emblema = new Imagem();
    	this.palmares = new PalmaresDAO();
    	this.escaloes = new EscalaoDAO(this.id);
    }

    public Equipa(Equipa e) {
    	this.id = e.getID();
    	this.nome = e.getNome();
    	this.emblema = e.getEmblema();
    	this.palmares = e.getPalmares();
    	this.escaloes = e.getEscaloes();
	}

	public int getID() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Imagem getEmblema() {
		return this.emblema;
	}

    public Map<String, Integer> getPalmares() {
	return this.palmares;
    }

    public Map<Integer,Escalao> getEscaloes() {
        return this.escaloes;
    }

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public void setEmblema(Imagem emblema) {
		this.emblema = emblema;
	}

	public void setPalmares(Map<String, Integer> palmares) {
		this.palmares = palmares;
	}

	public void setEscaloes(Map<Integer,Escalao> escaloes) {
		this.escaloes = escaloes;
	}

	public Equipa clone() {
    	return new Equipa(this);
    }

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palmares == null) ? 0 : palmares.hashCode());
		return result;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Equipas \n");
		str.append("Nome: "+this.nome.toString());
		
		return str.toString();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Equipa e = (Equipa) o;
			return (this.id == (e.getID()));
		}
	}

	public void atualizaPalmares(String nomeCompeticao) {
		if(this.palmares.containsKey(nomeCompeticao)) {
			int contador = this.palmares.get(nomeCompeticao);
			this.palmares.put(nomeCompeticao,contador+1);
		}
		else
			this.palmares.put(nomeCompeticao,1);
	}

	public void inserirEscalao(Escalao a) {
        this.escaloes.put(a.getTipoEscalao(), a);
	}

	public void removerEscalao(Escalao a) {
		this.escaloes.remove(a);
	}
    
    public boolean criarEscalao(int tipo, String nEscola, String nEquipa, String nTreinador, Date d, int sexo, Imagem img) {
        Calendar g = new GregorianCalendar();
        g.setTime(d);
        
        Treinador t = new Treinador(nTreinador,img, (GregorianCalendar) g,sexo);
        Escalao e = null;
        boolean res = false;
        
        if(this.nome.equals(nEquipa)) {
            e = new Escalao(tipo, nEscola, nEquipa, t);
            this.escaloes.put(tipo, e);
            res = true;
        }     
        return res;
    }       
}
