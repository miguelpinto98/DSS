package Business_Layer;

import java.util.HashSet;

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
		
		s.append("Agenda");
		s.append(this.getJogos() + "\n");
		return s.toString();
	}
}
