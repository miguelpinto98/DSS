package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

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
                

                APEF a = new APEF();
                Arbitro u = new Arbitro("grupista","123456","asd@gmail.com",new GregorianCalendar());
                ResponsavelEscola r = new ResponsavelEscola("JoaoF","lolololol","jf@hotmail.com",new GregorianCalendar());
                
                a.registarUser("maleite","atelogo","maleite@hidasa",0);
                a.registarUser("grupista","123456","asadasdadasd@gmail.com",2);
                a.registarUser("jigs","123456","98@gmail.com",1);
                a.registarUser("jigs","123456","sdasdadsad@gmail.com",1);
                a.registarUser("atum","123456","maleite@hidasa",1);
                a.registarUser("jigsdads","123","9adsa8@gmail.com",1);
                System.out.println(a.toString());
                           
                a.mudarPermissoes("maleite");
                System.out.println(a.getUsers().get("maleite").isAtivo());
                
                a.login("maleite","atelogo");
                a.logout();
                if(a.getEmSessao()==null){ System.out.println("Est�� em modo convidado!"); }
                else {
                System.out.println(a.getEmSessao().toString());
                }
                /*
                a.criarEscola("Escola S�� Miranda", "Braga", "Dr.Machado Matos");
                System.out.println(a.toString());
                
                */
		
		
		/* TESTAR ADICIONAR RESULTADO A UM JOGO
		 * 
		 *//*
		Arbitro aa = new Arbitro(1000, "manuelQuim", "123", "a@b.c", new GregorianCalendar(1992,7,9));
		System.out.println(aa.toString());
		
		DadosEstatisticos d1 = new DadosEstatisticos();
		DadosEstatisticos d2 = new DadosEstatisticos();
		
		Jogador j11 = new Jogador(1,"aaa", new GregorianCalendar(), 0);
		Jogador j12 = new Jogador(2,"bbb", new GregorianCalendar(), 0);
		Jogador j13 = new Jogador(3,"ccc", new GregorianCalendar(), 0);
		Jogador j14 = new Jogador(4,"ddd", new GregorianCalendar(), 0);
		Jogador j15 = new Jogador(5,"eee", new GregorianCalendar(), 0);
		
		HashMap<Integer,Jogador> plantel1 = new HashMap<>();
		plantel1.put(1, j11);
		plantel1.put(2, j12);
		plantel1.put(3, j13);
		plantel1.put(4, j14);
		plantel1.put(5, j15);
		
		Jogador j21 = new Jogador(6,"zzz", new GregorianCalendar(), 0);
		Jogador j22 = new Jogador(7,"xxx", new GregorianCalendar(), 0);
		Jogador j23 = new Jogador(8,"www", new GregorianCalendar(), 0);
		Jogador j24 = new Jogador(9,"yyy", new GregorianCalendar(), 0);
		Jogador j25 = new Jogador(10,"kkk", new GregorianCalendar(), 0);
		
		HashMap<Integer,Jogador> plantel2 = new HashMap<>();
		plantel2.put(6, j21);
		plantel2.put(7, j22);
		plantel2.put(8, j23);
		plantel2.put(9, j24);
		plantel2.put(10, j25);
		
		Plantel p1 = new Plantel(1001,"Juvenil",null,plantel1,null, d1);
		Plantel p2 = new Plantel(1001,"Juvenil",null,plantel2,null, d2);
		
		Campo c = new Campo(123,"Machado Matos");
		
		Jogo j1 = new Jogo(1000,new GregorianCalendar(), c, aa, p1, p2);
		Jogo j2 = new Jogo(1000,new GregorianCalendar(), c, aa, p2, p1);

		HashSet<Jogo> tsj = new HashSet<>();
		tsj.add(j1);
		tsj.add(j2);
		
		Agenda ag = new Agenda(tsj);
		aa.setAgenda(ag);
		
		/*JOGO 1*/
		/*ArrayList<Integer> golos = new ArrayList<>();
		golos.add(2);
		golos.add(6);
		golos.add(10);
		golos.add(10);
		
		aa.resultadoJogo(4, 9, golos);
		
		
		//System.out.println(j12.toString());
		//System.out.println(j11.toString());
		//System.out.println(j25.toString());
		
		System.out.println(aa.toString());
		
		
		aa.resultadoJogo(1, 1, golos);
		
		System.out.println(aa.toString());
	}*/
        
        APEF a = new APEF();
        Epoca ep = new Epoca(2013);
        a.inserirEpoca(ep);
        Campeonato c = new Campeonato("Campeonato APEF - Infantis", new GregorianCalendar(),0,10);
        ep.inserirCampeonato(c);
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        
        c.geraCalendario(array);
        System.out.println(c.getCalendario().getJornadas().toString());
        
	Jogador j1 = new Jogador("zzz", new GregorianCalendar(), 0,false);
	Jogador j2 = new Jogador("xxx", new GregorianCalendar(), 0,false);
	Jogador j3 = new Jogador("www", new GregorianCalendar(), 0,false);
	Jogador j4 = new Jogador("yyy", new GregorianCalendar(), 0,false);
	Jogador j5 = new Jogador("kkk", new GregorianCalendar(), 0,false);
        Jogador j6 = new Jogador("zzz", new GregorianCalendar(), 0,false);
	Jogador j7 = new Jogador("xxx", new GregorianCalendar(), 0,false);
	Jogador j8 = new Jogador("www", new GregorianCalendar(), 0,false);
	Jogador j9 = new Jogador("yyy", new GregorianCalendar(), 0,false);
	Jogador j10 = new Jogador("kkk", new GregorianCalendar(), 0,false);
        Jogador j11 = new Jogador("zzz", new GregorianCalendar(), 0,false);
	Jogador j12 = new Jogador("xxx", new GregorianCalendar(), 0,false);
	Jogador j13 = new Jogador("www", new GregorianCalendar(), 0,false);
        ArrayList<Jogador> selecionados = new ArrayList<>();
        selecionados.add(j1);
        selecionados.add(j2);
        selecionados.add(j3);
        selecionados.add(j4);
        selecionados.add(j5);
        selecionados.add(j6);
        selecionados.add(j7);
        selecionados.add(j8);
        selecionados.add(j9);
        selecionados.add(j10);
        selecionados.add(j11);
        selecionados.add(j12);
        selecionados.add(j13);
      
        Escalao e = new Escalao(0);
        
        /*Epoca e2 = a.getEpocas().get(2013);
        if(e2 != null) {
            e2.getCampeonatos()[0].inscreverEscalao(e);
            System.out.println("epoca nao esta a null");
        }*/
       
       //a.inscreverCompeticao(2013, c.getID(), e, selecionados);
       //System.out.println(c.toString());
    }
}
