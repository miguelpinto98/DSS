package Business_Layer;

import java.util.HashSet;

public class Agenda {
	private HashSet<Jogo> jogos;
        
        public Agenda(){
            this.jogos = new HashSet<>();
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
    
}
