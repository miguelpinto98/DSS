package Business_Layer;

import Data_Layer.AgendaDAO;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Agenda {
    private int idAgenda;
    private Map<Integer,Jogo> jogos;
        
        public Agenda(){
            this.jogos = new AgendaDAO();
        }
        
        public Agenda(Map<Integer,Jogo> j){
            this.idAgenda = APEF.IDENTIFICADOR;
            this.jogos = j;
            APEF.IDENTIFICADOR++;
        }
        
        public Agenda(Agenda a){
            this.idAgenda = APEF.IDENTIFICADOR;
            this.jogos = a.getJogos();
            APEF.IDENTIFICADOR++;
        }

        public Map<Integer,Jogo> getJogos() {
            Map<Integer,Jogo> aux = new AgendaDAO();
         for(Integer s : this.jogos.keySet()){
             aux.put(s,this.jogos.get(s));
         }
         return aux;
        }
    
        public void setJogos(Map<Integer,Jogo> jogos){
            this.jogos = jogos;
        }
    
        public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Agenda a = (Agenda) o;
			return (this.jogos.equals(a.getJogos()));
		}
        }
                
        public Agenda clone() {
		return new Agenda(this);
	}
        
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("***** Agenda *****");
		Iterator<Jogo> it = this.jogos.values().iterator(); 
		while (it.hasNext()) {
            Jogo j = it.next();
			s.append(j.toString());
        }
		s.append("\n******************\n");

		return s.toString();
	}

	public void inserirJogo(Jogo j) {
		if(!this.jogos.containsValue(j))
			this.jogos.put(j.getID(), j);
	}

	public void removerJogo(Jogo j) {
		this.jogos.remove(j);
	}

	public Jogo addResultadoJogo(int casa, int fora, ArrayList<Integer> goleadores) {
		boolean mudou = false;
		Jogo jg = null;
		
		Iterator<Jogo> it = this.jogos.values().iterator(); 
		while (it.hasNext()) {
            Jogo j = it.next();
			if(!j.isJogoRealizado() && !mudou) {
				j.resultadoJogo(casa, fora);
				j.goleadoresJogo(goleadores);
				j.atualizaEscalao();
				j.setRealizado(true);
			
				jg = j.clone();
				mudou=true;
			}
		}
		return jg;
	}

	public void atualizaAgenda(GregorianCalendar dia) {
		// TODO Auto-generated method stub
		
	}

	public Jogo getUltimoJogoRealizado() {
		Jogo j = null;
		GregorianCalendar g = null;
		
		Iterator<Jogo> it = this.jogos.values().iterator(); 
		while (it.hasNext()) {
            Jogo jg = it.next();
			g = jg.getDiaJogo();
			DateTime dj = new DateTime(g.get(g.YEAR),g.get(g.MONTH),g.get(g.DAY_OF_MONTH),g.get(g.HOUR_OF_DAY),g.get(g.MINUTE));
			if(jg.isJogoRealizado() && Days.daysBetween(dj, new DateTime()).getDays()<7);
				return jg;
		}
		return j;
	}

    public Jogo getProximoJogo() {
        Jogo j = null;
        GregorianCalendar g = null;
		
        Iterator<Jogo> it = this.jogos.values().iterator(); 
		while (it.hasNext()) {
            Jogo jg = it.next();
            g = jg.getDiaJogo();
            DateTime dj = new DateTime(g.get(g.YEAR),g.get(g.MONTH),g.get(g.DAY_OF_MONTH),g.get(g.HOUR_OF_DAY),g.get(g.MINUTE));
            
            if(!jg.isJogoRealizado() && Days.daysBetween(new DateTime(), dj).getDays()<7);
		return jg;
            }
	return j;
    }
}
