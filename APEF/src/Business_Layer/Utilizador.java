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
public class Utilizador {
    
    // Variaveis de Instancia
    private String nomeUtilizador;
    private String nome;
    private String email;
    private String password;
    private String morada;
    private String telemovel;
    private String codigoPostal;
    private GregorianCalendar dataNascimento;
    
    private String tipoUtilizador; // pode ser arbitro, admin ou responsável escola    
}
