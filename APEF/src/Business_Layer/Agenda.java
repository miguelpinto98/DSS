package Business_Layer;

import java.util.ArrayList;
import java.util.HashSet; /*FAZER UM COMPARE PARA ORDENAR POR DATA*/

public class Agenda {
	private HashSet<Jogo> jogos;
        
        public Agenda(){
            this.jogos = new HashSet<>();
        }
        
        public Agenda(HashSet<Jogo> j){
            this.jogos = j;
        }
        
        public Agenda(Agenda a){
            this.jogos = a.getJogos();
        }

        public HashSet<Jogo> getJogos() {
            HashSet<Jogo> aux = new HashSet<Jogo>();
            for(Jogo j: this.jogos) aux.add(j);
            return aux;
        }
    
        public void setJogos(HashSet<Jogo> jogo){
            this.jogos = new HashSet<Jogo>();
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

	public void addResultadoJogo(int casa, int fora, ArrayList<Integer> goleadores) {
		boolean mudou = false;
		
		for(Jogo j : this.jogos) {
			if(!j.isJogoRealizado() && !mudou) {
				j.resultadoJogo(casa, fora);
				j.goleadoresJogo(goleadores);
				j.atualizaPlantel();
				j.setRealizado(true);
			
				mudou=true;
			}
		}
	}
}
