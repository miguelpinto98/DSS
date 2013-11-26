/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Layer;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author serafim
 */
public class Campeonato {
    
    public static int IDENTIFICADOR=1; 

    // Variaveis de Instancia
    private int id;
    private String nome;
    private int nrEquipas;
    private Calendario calendario;
    private Classificacao classificacao;
    private HashMap<Integer,Integer> goleadores; //<id do jogador,nr golos>     
}
