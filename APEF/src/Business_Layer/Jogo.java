/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business_Layer;

import java.util.GregorianCalendar;

/**
 *
 * @author serafim
 */
public class Jogo {
    private boolean realizado = false;
    
    // Variaveis de Instancia
    private GregorianCalendar data;
    private int hora;
    private Campo campo;
    private Arbitro arbitro;
    private Resultado resultado;
    private Escalao casa;
    private Escalao fora;
}
