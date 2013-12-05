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
                
                a.registarUser("maleite","atelogo","maleite@hidasa",0);
                a.registarUser("grupista","123456","asadasdadasd@gmail.com",2);
                a.registarUser("jigs","123456","98@gmail.com",1);
                a.registarUser("jigs","123456","sdasdadsad@gmail.com",1);
                a.registarUser("atum","123456","maleite@hidasa",1);
                a.registarUser("jigsdads","123","9adsa8@gmail.com",1);
                                
                /*a.getUsers().get("maleite").setAtivo(true);
                System.out.println(a.getUsers().get("maleite").getAtivo());
                
                a.login("maleite","atelogo");
                a.logout();
                if(a.getEmSessao()==null){ System.out.println("Está em modo convidado!"); }
                else {
                System.out.println(a.getEmSessao().toString());
                }*/
                
                a.criarEscola("Escola Sá Miranda", "Braga", "Dr.Machado Matos");
                System.out.println(a.toString());

                
	}

}
