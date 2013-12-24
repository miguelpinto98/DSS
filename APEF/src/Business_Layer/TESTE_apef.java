package Business_Layer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class TESTE_apef {

    public static void main(String[] args) {
            
    APEF a = new APEF();
    Epoca ep = new Epoca(2013);
    a.inserirEpoca(ep);
    Campeonato campeonatoInfantis = new Campeonato("Campeonato APEF - Infantis", new GregorianCalendar(),0,4);
    ep.inserirCampeonato(campeonatoInfantis);
    
    //EQUIPA - 1
    Campo campo = new Campo("Complexo Poli-Desportivo");
    Escola escola = new Escola("Externato S.Miguel de Refojos", "Cabeceiras de Basto", campo);
    a.inserirEscola(escola);
    Equipa equipa = new Equipa("Benfica");
    a.getEscolas().get(escola.getNome()).inserirEquipa(equipa);
    Escalao escalao = new Escalao(0,equipa.getNome(),escola.getNome());
    Jogador j1 = new Jogador("Mario", new GregorianCalendar(), 0,false);
    Jogador j2 = new Jogador("Leite", new GregorianCalendar(), 0,false);
    Jogador j3 = new Jogador("Miguel", new GregorianCalendar(), 0,false);
    Jogador j4 = new Jogador("Luis", new GregorianCalendar(), 0,false);
    Jogador j5 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j6 = new Jogador("Serafim", new GregorianCalendar(), 0,false);
    Jogador j7 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j8 = new Jogador("Ines", new GregorianCalendar(), 1,false);
    Jogador j9 = new Jogador("Medeiros", new GregorianCalendar(), 1,false);
    Jogador j10 = new Jogador("Mariana", new GregorianCalendar(), 1,false);
    Jogador j11 = new Jogador("Diana", new GregorianCalendar(), 1,false);
    Jogador j12 = new Jogador("Lemos", new GregorianCalendar(), 1,false);
    Jogador j13 = new Jogador("Manuel", new GregorianCalendar(), 0,false);
    escalao.inserirJogador(j1);
    escalao.inserirJogador(j2);
    escalao.inserirJogador(j3);
    escalao.inserirJogador(j4);
    escalao.inserirJogador(j5);
    escalao.inserirJogador(j6);
    escalao.inserirJogador(j7);
    escalao.inserirJogador(j8);
    escalao.inserirJogador(j9);
    escalao.inserirJogador(j10);
    escalao.inserirJogador(j11);
    escalao.inserirJogador(j12);
    escalao.inserirJogador(j13);
    Treinador treinador = new Treinador("Mourinho",0);
    escalao.inserirTreinador(treinador);
    equipa.inserirEscalao(escalao);
    
    //EQUIPA - 2
    Campo campo2 = new Campo("Complexo Poli-Desportivo2");
    Escola escola2 = new Escola("Colégio Militar", "Felgueiras", campo2);
    a.inserirEscola(escola2);
    Equipa equipa2 = new Equipa("Porto");
    a.getEscolas().get(escola2.getNome()).inserirEquipa(equipa2);
    Escalao escalao2 = new Escalao(0,equipa2.getNome(),escola2.getNome());
    Jogador j21 = new Jogador("Mario", new GregorianCalendar(), 0,false);
    Jogador j22 = new Jogador("Leite", new GregorianCalendar(), 0,false);
    Jogador j23 = new Jogador("Miguel", new GregorianCalendar(), 0,false);
    Jogador j24 = new Jogador("Luis", new GregorianCalendar(), 0,false);
    Jogador j25 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j26 = new Jogador("Serafim", new GregorianCalendar(), 0,false);
    Jogador j27 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j28 = new Jogador("Ines", new GregorianCalendar(), 1,false);
    Jogador j29 = new Jogador("Medeiros", new GregorianCalendar(), 1,false);
    Jogador j210 = new Jogador("Mariana", new GregorianCalendar(), 1,false);
    Jogador j211 = new Jogador("Diana", new GregorianCalendar(), 1,false);
    Jogador j212 = new Jogador("Lemos", new GregorianCalendar(), 1,false);
    Jogador j213 = new Jogador("Manuel", new GregorianCalendar(), 0,false);
    escalao2.inserirJogador(j21);
    escalao2.inserirJogador(j22);
    escalao2.inserirJogador(j23);
    escalao2.inserirJogador(j24);
    escalao2.inserirJogador(j25);
    escalao2.inserirJogador(j26);
    escalao2.inserirJogador(j27);
    escalao2.inserirJogador(j28);
    escalao2.inserirJogador(j29);
    escalao2.inserirJogador(j210);
    escalao2.inserirJogador(j211);
    escalao2.inserirJogador(j212);
    escalao2.inserirJogador(j213);
    Treinador treinador2 = new Treinador("Pep Guardiola",0);
    escalao2.inserirTreinador(treinador2);
    equipa2.inserirEscalao(escalao2);
    
    
    //EQUIPA - 3
    Campo campo3 = new Campo("Complexo Poli-Desportivo3");
    Escola escola3 = new Escola("E.B. 2 e 3 de Palmeira", "Braga", campo3);
    a.inserirEscola(escola3);
    Equipa equipa3 = new Equipa("Palmeiras FC");
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa3);
    Escalao escalao3 = new Escalao(0,equipa3.getNome(),escola3.getNome());
    Jogador j31 = new Jogador("Mario", new GregorianCalendar(), 0,false);
    Jogador j32 = new Jogador("Leite", new GregorianCalendar(), 0,false);
    Jogador j33 = new Jogador("Miguel", new GregorianCalendar(), 0,false);
    Jogador j34 = new Jogador("Luis", new GregorianCalendar(), 0,false);
    Jogador j35 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j36 = new Jogador("Serafim", new GregorianCalendar(), 0,false);
    Jogador j37 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j38 = new Jogador("Ines", new GregorianCalendar(), 1,false);
    Jogador j39 = new Jogador("Medeiros", new GregorianCalendar(), 1,false);
    Jogador j310 = new Jogador("Mariana", new GregorianCalendar(), 1,false);
    Jogador j311 = new Jogador("Diana", new GregorianCalendar(), 1,false);
    Jogador j312 = new Jogador("Lemos", new GregorianCalendar(), 1,false);
    Jogador j313 = new Jogador("Manuel", new GregorianCalendar(), 0,false);
    escalao3.inserirJogador(j31);
    escalao3.inserirJogador(j32);
    escalao3.inserirJogador(j33);
    escalao3.inserirJogador(j34);
    escalao3.inserirJogador(j35);
    escalao3.inserirJogador(j36);
    escalao3.inserirJogador(j37);
    escalao3.inserirJogador(j38);
    escalao3.inserirJogador(j39);
    escalao3.inserirJogador(j310);
    escalao3.inserirJogador(j311);
    escalao3.inserirJogador(j312);
    escalao3.inserirJogador(j313);
    Treinador treinador3 = new Treinador("Ancelotti",0);
    escalao3.inserirTreinador(treinador3);
    equipa3.inserirEscalao(escalao3);
    
    
    //EQUIPA - 4
    Campo campo4 = new Campo("Complexo Poli-Desportivo4");
    Escola escola4 = new Escola("E.B. 2 e 3 de Negreiros", "Negros", campo4);
    a.inserirEscola(escola4);
    Equipa equipa4 = new Equipa("SC Negreiros");
    a.getEscolas().get(escola4.getNome()).inserirEquipa(equipa4);
    Escalao escalao4 = new Escalao(0,equipa4.getNome(),escola4.getNome());
    Jogador j41 = new Jogador("Mario", new GregorianCalendar(), 0,false);
    Jogador j42 = new Jogador("Leite", new GregorianCalendar(), 0,false);
    Jogador j43 = new Jogador("Miguel", new GregorianCalendar(), 0,false);
    Jogador j44 = new Jogador("Luis", new GregorianCalendar(), 0,false);
    Jogador j45 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j46 = new Jogador("Serafim", new GregorianCalendar(), 0,false);
    Jogador j47 = new Jogador("Pinto", new GregorianCalendar(), 0,false);
    Jogador j48 = new Jogador("Ines", new GregorianCalendar(), 1,false);
    Jogador j49 = new Jogador("Medeiros", new GregorianCalendar(), 1,false);
    Jogador j410 = new Jogador("Mariana", new GregorianCalendar(), 1,false);
    Jogador j411 = new Jogador("Diana", new GregorianCalendar(), 1,false);
    Jogador j412 = new Jogador("Lemos", new GregorianCalendar(), 1,false);
    Jogador j413 = new Jogador("Manuel", new GregorianCalendar(), 0,false);
    escalao4.inserirJogador(j41);
    escalao4.inserirJogador(j42);
    escalao4.inserirJogador(j43);
    escalao4.inserirJogador(j44);
    escalao4.inserirJogador(j45);
    escalao4.inserirJogador(j46);
    escalao4.inserirJogador(j47);
    escalao4.inserirJogador(j48);
    escalao4.inserirJogador(j49);
    escalao4.inserirJogador(j410);
    escalao4.inserirJogador(j411);
    escalao4.inserirJogador(j412);
    escalao4.inserirJogador(j413);
    Treinador treinador4 = new Treinador("Jorge Jesus",0);
    escalao4.inserirTreinador(treinador4);
    equipa4.inserirEscalao(escalao4);
 

    //Users do sistema
    a.registarUser("maleite","pw1234","maleite@gmail.com",0,a);
    a.registarUser("174Miguel","pw1234","miguel@gmail.com",1,a);
    a.registarUser("63linda","pw1234","63@gmail.com",2,a);
    a.registarUser("diana","pw1234","demossbb@gmail.com",2,a);
    a.registarUser("serafim","pw1234","smcp@gmail.com",2,a);
    a.registarUser("atum","pw1234","atum@gmail.com",0,a);

    
    //Testar "metodos"
    campeonatoInfantis.inscreverEscalao(escalao);
    campeonatoInfantis.inscreverEscalao(escalao2);
    campeonatoInfantis.inscreverEscalao(escalao3);
    campeonatoInfantis.inscreverEscalao(escalao4);
    
    GregorianCalendar g = new GregorianCalendar();
    g.set(2013, 11, 20);
    campeonatoInfantis.setDataLimiteInscricoes(g);
    
    a.iniciarCampeonato(campeonatoInfantis);
    
    //System.out.println(a.getEscolas().get(escola.getNome()));
    System.out.println(campeonatoInfantis.getCalendario());
      //System.out.println(a.countArbitros());  
    System.out.println(a.getUsers().get("diana"));  
        
        
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
        
       /*
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
        */
        /*Epoca e2 = a.getEpocas().get(2013);
        if(e2 != null) {
            e2.getCampeonatos()[0].inscreverEscalao(e);
            System.out.println("epoca nao esta a null");
        }*/
       
       //a.inscreverCompeticao(2013, c.getID(), e, selecionados);
       //System.out.println(c.toString());
    }
}
