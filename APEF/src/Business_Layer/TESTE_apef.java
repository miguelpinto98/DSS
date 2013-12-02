package Business_Layer;

import java.util.ArrayList;

public class TESTE_apef {

	public static void main(String[] args) {
		Jogo j = new Jogo();
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(123);
		al.add(1);
		al.add(123);
		al.add(123);
		al.add(1400);
		al.add(1);
		
		j.goleadoresJogo(al);
		
		j.listaGoleadores();

	}

}
