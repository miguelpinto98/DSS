/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Layer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author serafim
 */
public class Equipa {
    
    public static int IDENTIFICADOR=1; 
    
    // Variaveis de Instancia
    private int id;
    private String nome;
    private Imagem emblema;
    private Map<String,Integer> palmares; //<nome da competicao, nr vezes que ganhou>
    private ArrayList<Escalao> escaloes;    
}
