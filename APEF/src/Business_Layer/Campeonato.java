package Business_Layer;

import java.util.HashMap;

public class Campeonato {
    private int id;
    private String nome;
    private int nrEquipas;
    private Calendario calendario;
    private Classificacao classificacao;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
}
