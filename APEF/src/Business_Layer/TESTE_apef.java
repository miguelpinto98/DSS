package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TESTE_apef {

	public static void main(String[] args) {
		/*Jogo j = new Jogo();
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(123);
		al.add(1);
		al.add(123);
		al.add(123);
		al.add(1400);
		al.add(1);
		
		j.goleadoresJogo(al);
		
		j.listaGoleadores();*/
                Plantel p = new Plantel();
                Jogador j = new Jogador("Serafim Ronaldo Pinto",new GregorianCalendar(),1);
                Jogador s = new Jogador("Serafim Pinto",new GregorianCalendar(),1);
                Treinador t = new Treinador();
                
                p.inserirJogador(j);
                p.inserirJogador(s);
                
                System.out.println("XXX");
                
                System.out.println(p.toString());

	}

}
