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
		
		j.listaGoleadores();
                Plantel p = new Plantel();
                Jogador j = new Jogador("Serafim Ronaldo Pinto",new GregorianCalendar(),1);
                Jogador s = new Jogador("Serafim Pinto",new GregorianCalendar(),1);
                Treinador t = new Treinador();
                
                p.inserirJogador(j);
                p.inserirJogador(s);
                
                System.out.println("XXX");
                p.removerJogador(j);
                System.out.println(p.toString());
                */

                APEF a = new APEF();
        	Arbitro u = new Arbitro(APEF.IDENTIFICADOR,"grupista","123456","asd@gmail.com",new GregorianCalendar());
                ResponsavelEscola r = new ResponsavelEscola(2,"JoaoF","lolololol","jf@hotmail.com",new GregorianCalendar());
                a.inserirUtilizador(u);
                a.inserirUtilizador(r);
                
                System.out.println(a.existeEmail("asd@gmail.com"));
                System.out.println(a.existeUtilizador("grupista","asd@gmail.com"));               
                System.out.println(a.toString());
                
                a.removerUtilizador(u);
                System.out.println(a.toString());



                
	}

}
