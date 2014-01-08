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
    g2.set(2014, 0, 12);
    Campeonato campeonatoInfantis = new Campeonato("Campeonato APEF - Infantis",g2, new GregorianCalendar(),0,4);
    ep.inserirCampeonato(campeonatoInfantis);
    //EQUIPA - 1
    Campo campo = new Campo("Complexo Poli-Desportivo");
    Escola escola = new Escola("Externato S.Miguel de Refojos", "Cabeceiras de Basto", campo);
    a.inserirEscola(escola);
    Equipa equipa = new Equipa("Benfica");
    a.getEscolas().get(escola.getNome()).inserirEquipa(equipa);
    Escalao escalao = new Escalao(0,equipa.getNome(),escola.getNome());
     Jogador j11 = new Jogador("Mario", new GregorianCalendar(), 0,new Imagem());
     Jogador j12 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j13 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j14 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j15 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j16 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j17 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j18 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j19 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j10 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j143 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j144 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j333 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
     escalao.inserirJogador(j11);
     escalao.inserirJogador(j12);
     escalao.inserirJogador(j13);
     escalao.inserirJogador(j14);
     escalao.inserirJogador(j15);
     escalao.inserirJogador(j16);
     escalao.inserirJogador(j17);
     escalao.inserirJogador(j18);
     escalao.inserirJogador(j19);
     escalao.inserirJogador(j10);
     escalao.inserirJogador(j143);
     escalao.inserirJogador(j144);
     escalao.inserirJogador(j333);
    Treinador treinador = new Treinador("Mourinho",new Imagem(), new GregorianCalendar(), 0);
    escalao.inserirTreinador(treinador);
    equipa.inserirEscalao(escalao);
    
    //EQUIPA - 2
    Campo campo2 = new Campo("Complexo Poli-Desportivo2");
    Escola escola2 = new Escola("Colégio Militar", "Felgueiras", campo2);
    a.inserirEscola(escola2);
    Equipa equipa2 = new Equipa("Porto");
    a.getEscolas().get(escola2.getNome()).inserirEquipa(equipa2);
    Escalao escalao2 = new Escalao(0,equipa2.getNome(),escola2.getNome());
     Jogador j21 = new Jogador("Mario", new GregorianCalendar(), 0, new Imagem());
     Jogador j22 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j23 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j24 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j25 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j26 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j27 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j28 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j29 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j210 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j211 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j212 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j213 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
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
     Jogador j31 = new Jogador("Mario", new GregorianCalendar(), 0,new Imagem());
     Jogador j32 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j33 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j34 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j35 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j36 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j37 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j38 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j39 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j310 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j311 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j312 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j313 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
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
     Jogador j41 = new Jogador("Marioooooooooooooooooooooooooo", g2, 0,new Imagem());
     Jogador j42 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j43 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j44 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j45 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j46 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j47 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j48 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j49 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j410 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j411 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j412 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j413 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
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
     Jogador j51 = new Jogador("Marioooooooooooooooooooooooooo", g2, 0,new Imagem());
     Jogador j52 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j53 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j54 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j55 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j56 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j57 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j58 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j59 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j510 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j511 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j512 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j513 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
     escalao5.inserirJogador(j51);
     escalao.inserirJogador(j52);
     escalao5.inserirJogador(j53);
     escalao5.inserirJogador(j54);
     escalao5.inserirJogador(j55);
     escalao5.inserirJogador(j56);
     escalao5.inserirJogador(j57);
     escalao5.inserirJogador(j58);
     escalao5.inserirJogador(j59);
     escalao5.inserirJogador(j510);
     escalao5.inserirJogador(j511);
     escalao5.inserirJogador(j512);
     escalao5.inserirJogador(j513);
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
     Jogador j61 = new Jogador("Marioooooooooooooooooooooooooo", g2, 0,new Imagem());
     Jogador j62 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j63 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j64 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j65 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j66 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j67 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j68 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j69 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j610 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j611 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j612 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j613 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
     escalao6.inserirJogador(j61);
     escalao6.inserirJogador(j62);
     escalao6.inserirJogador(j63);
     escalao6.inserirJogador(j64);
     escalao6.inserirJogador(j65);
     escalao6.inserirJogador(j66);
     escalao6.inserirJogador(j67);
     escalao6.inserirJogador(j68);
     escalao6.inserirJogador(j69);
     escalao6.inserirJogador(j610);
     escalao6.inserirJogador(j611);
     escalao6.inserirJogador(j612);
     escalao6.inserirJogador(j613);
    Treinador treinador6 = new Treinador("Jorge JesusSSSSSSSSSSSS", new Imagem(), new GregorianCalendar(), 0);
    escalao6.inserirTreinador(treinador6);
    equipa6.inserirEscalao(escalao6);
     //EQUIPA - 7
    Campo campo7 = new Campo("Complexo VIZELA");
    Escola escola7 = new Escola("VIZELA ESCOLA", "AZUIS", campo7);
    a.inserirEscola(escola7);
    Equipa equipa7 = new Equipa("VIZELAAAAAAAAAAAAAAAAAA");
    a.getEscolas().get(escola7.getNome()).inserirEquipa(equipa7);
    Escalao escalao7 = new Escalao(0,equipa7.getNome(),escola7.getNome());
     Jogador j71 = new Jogador("Marioooooooooooooooooooooooooo", g2, 0,new Imagem());
     Jogador j72 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j73 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j74 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j75 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j76 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j77 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j78 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j79 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j710 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j711 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j712 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j713 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
     escalao7.inserirJogador(j71);
     escalao7.inserirJogador(j72);
     escalao7.inserirJogador(j73);
     escalao7.inserirJogador(j74);
     escalao7.inserirJogador(j75);
     escalao7.inserirJogador(j76);
     escalao7.inserirJogador(j77);
     escalao7.inserirJogador(j78);
     escalao7.inserirJogador(j79);
     escalao7.inserirJogador(j710);
     escalao7.inserirJogador(j711);
     escalao7.inserirJogador(j712);
     escalao7.inserirJogador(j713);
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
     Jogador j81 = new Jogador("Marioooooooooooooooooooooooooo", g2, 0,new Imagem());
     Jogador j82 = new Jogador("Leite", new GregorianCalendar(), 0,new Imagem());
     Jogador j83 = new Jogador("Miguel", new GregorianCalendar(), 0,new Imagem());
     Jogador j84 = new Jogador("Luis", new GregorianCalendar(), 0,new Imagem());
     Jogador j85 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j86 = new Jogador("Serafim", new GregorianCalendar(), 0,new Imagem());
     Jogador j87 = new Jogador("Pinto", new GregorianCalendar(), 0,new Imagem());
     Jogador j88 = new Jogador("Ines", new GregorianCalendar(), 1,new Imagem());
     Jogador j89 = new Jogador("Medeiros", new GregorianCalendar(), 1,new Imagem());
     Jogador j810 = new Jogador("Mariana", new GregorianCalendar(), 1,new Imagem());
     Jogador j811 = new Jogador("Diana", new GregorianCalendar(), 1,new Imagem());
     Jogador j812 = new Jogador("Lemos", new GregorianCalendar(), 1,new Imagem());
     Jogador j813 = new Jogador("Manuel", new GregorianCalendar(), 0,new Imagem());
     escalao8.inserirJogador(j81);
     escalao8.inserirJogador(j82);
     escalao8.inserirJogador(j83);
     escalao8.inserirJogador(j84);
     escalao8.inserirJogador(j85);
     escalao8.inserirJogador(j86);
     escalao8.inserirJogador(j87);
     escalao8.inserirJogador(j88);
     escalao8.inserirJogador(j89);
     escalao8.inserirJogador(j810);
     escalao8.inserirJogador(j811);
     escalao8.inserirJogador(j812);
     escalao8.inserirJogador(j813);
    Treinador treinador8 = new Treinador("MAAAAAAATOS", new Imagem(), new GregorianCalendar(), 0);
    escalao8.inserirTreinador(treinador8);
    equipa8.inserirEscalao(escalao8);
    
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

    //Campeonato
    campeonatoInfantis.inscreverEscalao(escalao);
    campeonatoInfantis.inscreverEscalao(escalao2);
    campeonatoInfantis.inscreverEscalao(escalao3);
    campeonatoInfantis.inscreverEscalao(escalao4);
    
    GregorianCalendar g = new GregorianCalendar();
    g.set(2013, 11, 20);
    campeonatoInfantis.setDataLimiteInscricoes(g);
    GregorianCalendar inicio = new GregorianCalendar();
    inicio.set(2014, 0, 19);
    //a.iniciarCampeonato(campeonatoInfantis);
            
    //Torneio
    Torneio infantis = new Torneio("Taça Infantis", inicio, g,0,1, 0, campo);
    ep.inserirTorneio(infantis);
    infantis.inscreverEscalao(escalao);
    infantis.inscreverEscalao(escalao2);
    infantis.inscreverEscalao(escalao3);
    infantis.inscreverEscalao(escalao4);
    infantis.inscreverEscalao(escalao5);
    infantis.inscreverEscalao(escalao6);
    infantis.inscreverEscalao(escalao7);
    infantis.inscreverEscalao(escalao8);    
    a.iniciarTorneioTipo2(infantis);
    //System.out.println(a.iniciarTorneioTipo2(infantis));
    System.out.println(infantis.getFases());
    //System.out.println(infantis.getFases());

    a.iniciarTorneioTipo1(infantis);  
       

    
    
    
    
    
   /*FORMA
    DadosEstatisticos d = new DadosEstatisticos(); 
    char[] teste = new char[] { 'a', 'l', 'p', 'h', 'a'};    
    char c = 'V';
    d.setForma(teste);
    d.atualizaForma('E');
    }
           */
}
}
