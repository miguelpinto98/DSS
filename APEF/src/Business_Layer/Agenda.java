package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Agenda {
	private TreeSet<Jogo> jogos;
        
        public Agenda(){
            this.jogos = new TreeSet<>();
        }
        
        public Agenda(TreeSet<Jogo> j){
            this.jogos = j;
        }
        
        public Agenda(Agenda a){
            this.jogos = a.getJogos();
        }

        public TreeSet<Jogo> getJogos() {
            TreeSet<Jogo> aux = new TreeSet<Jogo>();
            for(Jogo j: this.jogos) aux.add(j);
            return aux;
        }
    
        public void setJogos(TreeSet<Jogo> jogo){
            this.jogos = new TreeSet<Jogo>();
            for(Jogo j : jogo) this.jogos.add(j);
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
		for(Jogo j : this.jogos)
			s.append(j.toString());
		
		s.append("\n******************\n");

		return s.toString();
	}

	public void inserirJogo(Jogo j) {
		if(!this.jogos.contains(j))
			this.jogos.add(j);
	}

	public void removerJogo(Jogo j) {
		this.jogos.remove(j);
	}

	public Jogo addResultadoJogo(int casa, int fora, ArrayList<Integer> goleadores) {
		boolean mudou = false;
		Jogo jg = null;
		
		for(Jogo j : this.jogos) {
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
}
