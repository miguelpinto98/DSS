/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Campeonato;

import Business_Layer.Jogo;
import Business_Layer.Utilizador;
import GUI.Home2;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Utilizador
 */
public class JCampeonatoClassificacao extends javax.swing.JPanel {

    private Home2 root;
    private int ano;

    public JCampeonatoClassificacao(Home2 aThis, Utilizador user, int ano) {
        this.root = aThis;
        this.ano = ano;
        initComponents();
        
        
        
        
        Object[] columnNames = new String[] {"Posição","Equipa","Vitórias","Empates","Derrotas","G.M.","G.S.","DIF.","Pontos"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);

        //for(Jogo j : ures) {
            //x.addRow(new Object[]{j.getEscalaoCasa().getNomeEquipa(),j.getNumGolosJogoCasa(),j.getNumGolosJogoFora(),j.getEscalaoFora().getNomeEquipa()});
        //}
        tablecamp.setModel(x);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablecamp = new org.jdesktop.swingx.JXTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Classificação"));

        tablecamp.setBackground(new java.awt.Color(241, 241, 241));
        tablecamp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablecamp.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tablecamp.setRowHeight(20);
        jScrollPane2.setViewportView(tablecamp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tablecamp;
    // End of variables declaration//GEN-END:variables
}
