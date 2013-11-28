/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Layer;

/**
 *
 * @author serafim
 */
public class Escalao {
    
    // Variaveis de Instancia
    private String nomeEscalao; //identificador/nome do escal��o
    private Integer duracaoJogo;
    private Plantel plantel;
    private Agenda agenda; //Jogos A realizar	
    private Historico historico; //Jogos passados
    private Epoca epoca;
    private DadosEstatisticos dados;
}
