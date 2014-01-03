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
    GregorianCalendar g2 = new GregorianCalendar();
    g2.set(2014, 0, 5);
    Campeonato campeonatoInfantis = new Campeonato("Campeonato APEF - Infantis",g2, new GregorianCalendar(),0,4);
    ep.inserirCampeonato(campeonatoInfantis);
    //EQUIPA - 1
    Campo campo = new Campo("Complexo Poli-Desportivo");
    Escola escola = new Escola("Externato S.Miguel de Refojos", "Cabeceiras de Basto", campo);
    a.inserirEscola(escola);
    Equipa equipa = new Equipa("Benfica");
    a.getEscolas().get(escola.getNome()).inserirEquipa(equipa);
    Escalao escalao = new Escalao(0,equipa.getNome(),escola.getNome());
    
        Jogador lindo1 = new Jogador("Mário Leite", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo2 = new Jogador("Miguel Pinto", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo3 = new Jogador("Serafim Pinto", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo4 = new Jogador("Diana Lemos", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo5 = new Jogador("Mariana Medeiros", new GregorianCalendar(), 2, new Imagem());
    
    escalao.inserirJogador(lindo1);
    escalao.inserirJogador(lindo2);
    escalao.inserirJogador(lindo3);
    escalao.inserirJogador(lindo4);
    escalao.inserirJogador(lindo5);
    Treinador treinador = new Treinador("Mourinho",new Imagem(), new GregorianCalendar(), 0);
    escalao.inserirTreinador(treinador);
    equipa.inserirEscalao(escalao);
    
    /*//EQUIPA - 2
    Campo campo2 = new Campo("Complexo Poli-Desportivo2");
    Escola escola2 = new Escola("Colégio Militar", "Felgueiras", campo2);
    a.inserirEscola(escola2);
    Equipa equipa2 = new Equipa("Porto");
    a.getEscolas().get(escola2.getNome()).inserirEquipa(equipa2);
    Escalao escalao2 = new Escalao(0,equipa2.getNome(),escola2.getNome());
    escalao2.inserirJogador("Mario", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao2.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao2.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao2.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao2.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao2.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao2.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador2 = new Treinador("Pep Guardiola", new Imagem(), new GregorianCalendar(), 0);
    escalao2.inserirTreinador(treinador2);
    equipa2.inserirEscalao(escalao2);
    
    
    //EQUIPA - 3
    Campo campo3 = new Campo("Complexo Poli-Desportivo3");
    Escola escola3 = new Escola("E.B. 2 e 3 de Palmeira", "Braga", campo3);
    a.inserirEscola(escola3);
    Equipa equipa3 = new Equipa("Palmeiras FC");
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa3);
    Escalao escalao3 = new Escalao(0,equipa3.getNome(),escola3.getNome());
    escalao3.inserirJogador("Mario", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao3.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao3.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao3.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao3.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao3.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao3.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador3 = new Treinador("Ancelotti", new Imagem(), new GregorianCalendar(), 0);
    escalao3.inserirTreinador(treinador3);
    equipa3.inserirEscalao(escalao3);
    
    
    //EQUIPA - 4
    Campo campo4 = new Campo("Complexo Poli-Desportivo4");
    Escola escola4 = new Escola("E.B. 2 e 3 de Negreiros", "Negros", campo4);
    a.inserirEscola(escola4);
    Equipa equipa4 = new Equipa("SC Negreiros");
    a.getEscolas().get(escola4.getNome()).inserirEquipa(equipa4);
    Escalao escalao4 = new Escalao(0,equipa4.getNome(),escola4.getNome());
    escalao4.inserirJogador("Marioooooooooooooooooooooooooo", g2, 0, new Imagem());
    escalao4.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao4.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao4.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao4.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao4.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao4.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao4.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador4 = new Treinador("Jorge Jesus", new Imagem(), new GregorianCalendar(), 0);
    escalao4.inserirTreinador(treinador4);
    equipa4.inserirEscalao(escalao4);
  
//EQUIPA - 5
    Campo campo5 = new Campo("Campo de Airaes");
    Escola escola5 = new Escola("E.B. 2 e 3 de Airaes", "Arra", campo5);
    a.inserirEscola(escola5);
    Equipa equipa5 = new Equipa("FC AIRAES");
    a.getEscolas().get(escola5.getNome()).inserirEquipa(equipa5);
    Escalao escalao5 = new Escalao(0,equipa5.getNome(),escola5.getNome());
    escalao5.inserirJogador("Marioooooooooooooooooooooooooo", g2, 0, new Imagem());
    escalao5.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao5.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao5.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao5.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao5.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao5.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao5.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador5 = new Treinador("QUIM QUIM", new Imagem(), new GregorianCalendar(), 0);
    escalao5.inserirTreinador(treinador5);
    equipa5.inserirEscalao(escalao5);
    //EQUIPA - 6
    Campo campo6 = new Campo("LOOOL");
    Escola escola6 = new Escola("E.B. LOOOOOOOOOOOL.", "LOL", campo6);
    a.inserirEscola(escola6);
    Equipa equipa6 = new Equipa("lolololololol");
    a.getEscolas().get(escola6.getNome()).inserirEquipa(equipa6);
    Escalao escalao6 = new Escalao(0,equipa6.getNome(),escola6.getNome());
    escalao6.inserirJogador("Marioooooooooooooooooooooooooo", g2, 0, new Imagem());
    escalao6.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao6.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao6.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao6.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao6.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao6.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao6.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador6 = new Treinador("Jorge JesusSSSSSSSSSSSS", new Imagem(), new GregorianCalendar(), 0);
    escalao6.inserirTreinador(treinador6);
    equipa6.inserirEscalao(escalao6);
     //EQUIPA - 4
    Campo campo7 = new Campo("Complexo VIZELA");
    Escola escola7 = new Escola("VIZELA ESCOLA", "AZUIS", campo7);
    a.inserirEscola(escola7);
    Equipa equipa7 = new Equipa("VIZELAAAAAAAAAAAAAAAAAA");
    a.getEscolas().get(escola7.getNome()).inserirEquipa(equipa7);
    Escalao escalao7 = new Escalao(0,equipa7.getNome(),escola7.getNome());
    escalao7.inserirJogador("Marioooooooooooooooooooooooooo", g2, 0, new Imagem());
    escalao7.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao7.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao7.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao7.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao7.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao7.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao7.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador7 = new Treinador("Jorge", new Imagem(), new GregorianCalendar(), 0);
    escalao7.inserirTreinador(treinador7);
    equipa7.inserirEscalao(escalao7);
     //EQUIPA - 8
    Campo campo8 = new Campo("Desportivo4");
    Escola escola8 = new Escola("Eros", "Neg", campo8);
    a.inserirEscola(escola8);
    Equipa equipa8 = new Equipa("SC FELGUEIRAS");
    a.getEscolas().get(escola8.getNome()).inserirEquipa(equipa8);
    Escalao escalao8 = new Escalao(0,equipa8.getNome(),escola8.getNome());
    escalao8.inserirJogador("Marioooooooooooooooooooooooooo", g2, 0, new Imagem());
    escalao8.inserirJogador("Leite", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Miguel", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Luis", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Serafim", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Pinto", new GregorianCalendar(), 0, new Imagem());
    escalao8.inserirJogador("Ines", new GregorianCalendar(), 1, new Imagem());
    escalao8.inserirJogador("Medeiros", new GregorianCalendar(), 1, new Imagem());
    escalao8.inserirJogador("Mariana", new GregorianCalendar(), 1, new Imagem());
    escalao8.inserirJogador("Diana", new GregorianCalendar(), 1, new Imagem());
    escalao8.inserirJogador("Lemos", new GregorianCalendar(), 1, new Imagem());
    escalao8.inserirJogador("Manuel", new GregorianCalendar(), 0, new Imagem());
    Treinador treinador8 = new Treinador("MAAAAAAATOS", new Imagem(), new GregorianCalendar(), 0);
    escalao8.inserirTreinador(treinador8);
    equipa8.inserirEscalao(escalao8);*/
    
    
    //Users do sistema
    a.registarUser("maleite","pw1234","maleite@gmail.com",0);
    a.registarUser("174Miguel","pw1234","miguel@gmail.com",1);
    a.registarUser("63linda","pw1234","63@gmail.com",2);
    a.registarUser("diana","pw1234","demossbb@gmail.com",2);
    a.registarUser("serafim","pw1234","smcp@gmail.com",2);
    a.registarUser("atuasm","pw1234","atum@gmsaail.com",2);
    a.registarUser("63linsada","pw1234","63sa@gmail.com",2);
    a.registarUser("dianasa","pw1234","demossbsab@gmail.com",2);
    a.registarUser("serafimgsfe","pw1234","smcsap@gmail.com",2);

    
    //Testar "metodos"
    campeonatoInfantis.inscreverEscalao(escalao);
/*    campeonatoInfantis.inscreverEscalao(escalao2);
    campeonatoInfantis.inscreverEscalao(escalao3);
    campeonatoInfantis.inscreverEscalao(escalao4);*/
    
    GregorianCalendar g = new GregorianCalendar();
    g.set(2013, 11, 20);
    campeonatoInfantis.setDataLimiteInscricoes(g);
    GregorianCalendar inicio = new GregorianCalendar();
    inicio.set(2014, 1, 19);
    
    
    /*Equipa equipa5 = new Equipa("teste5");
    Equipa equipa6 = new Equipa("teste6");
    Equipa equipa7 = new Equipa("teste7");
    Equipa equipa8 = new Equipa("teste8");
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa5);
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa6);
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa7);
    a.getEscolas().get(escola3.getNome()).inserirEquipa(equipa8);*/

    Torneio infantis = new Torneio("Taça Infantis", inicio, g, 0, 0, campo);
    ep.inserirTorneio(infantis);
    infantis.inscreverEscalao(escalao);
    /*infantis.inscreverEscalao(escalao2);
    infantis.inscreverEscalao(escalao3);
    infantis.inscreverEscalao(escalao4);
    infantis.inscreverEscalao(escalao5);
    infantis.inscreverEscalao(escalao6);
    infantis.inscreverEscalao(escalao7);
    infantis.inscreverEscalao(escalao8);*/
    
    a.iniciarTorneioTipo1(infantis);
    //System.out.println(a.firstFaseTorneioTipo1(infantis));
    //System.out.println(infantis.getFases());
    //System.out.println(infantis.getFases());
    
    /**GregorianCalendar gg = new GregorianCalendar();
    gg.set(2013, 1, 3);
    campeonatoInfantis.setDataLimiteInscricoes(gg);
    */
    //a.iniciarCampeonato(campeonatoInfantis);
    //System.out.println(a.emprestarJogador(j41, "Porto", 0));
    //System.out.println(campeonatoInfantis.getCalendario());
    //System.out.println(a.getEscolas().get(escola.getNome()));
    /*GregorianCalendar teste = new GregorianCalendar();
    int ano = teste.get(teste.YEAR);
        System.out.println(ano); 
      //System.out.println(a.countArbitros());  
    //System.out.println(a.getUsers().get("diana"));  
        
   /*FORMA
    DadosEstatisticos d = new DadosEstatisticos(); 
    char[] teste = new char[] { 'a', 'l', 'p', 'h', 'a'};    
    char c = 'V';
    d.setForma(teste);
    d.atualizaForma('E');
    
    System.out.println(d);
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
