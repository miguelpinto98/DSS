/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Plantel;

import Business_Layer.Escalao;
import Business_Layer.Jogador;
import Business_Layer.Utilizador;
import GUI.ConsultarJogador;
import GUI.Home2;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;


/**
 *
 * @author miguelpinto
 */
public class JPlantelJogador extends javax.swing.JPanel {

    private Home2 root;
    private Utilizador user;
    private Escalao escalao;

    public JPlantelJogador(Home2 root, Escalao esc, Utilizador user) {
        this.root = root;
        this.user = user;
        this.escalao = esc;
        initComponents();
        
        if(escalao != null)
            atualizaJogadores();
        else {
            this.jPanel1.setVisible(false);
            this.consultaJog.setVisible(false);
            
            JLabel text = new JLabel("Nenhum Plantel Registado Nesta Equipa!");
            this.add(text);
        }       
    }
    
    public void atualizaJogadores() {
        Collection<Jogador> lesc = this.root.getSistema().getEscolas().get(this.escalao.getNomeEscola()).getEquipas().get(this.escalao.getNomeEquipa()).getEscaloes()[this.escalao.getTipoEscalao()].getJogadores().values();
        DefaultListModel<String> str = new DefaultListModel<>();
        
        for(Jogador j : lesc) 
            str.addElement(j.getNome());
        
        listaJogadores.setModel(str);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJogadores = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        consultaJog = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Jogadores"));
        setLayout(new java.awt.BorderLayout());

        listaJogadores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaJogadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaJogadoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaJogadores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        consultaJog.setText("Consultar");
        consultaJog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaJogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultaJog, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultaJog, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void listaJogadoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaJogadoresKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaJogadoresKeyPressed

    private void consultaJogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaJogActionPerformed
        // TODO add your handling code here:
        String jog = (String) this.listaJogadores.getSelectedValue();
        Iterator t = this.escalao.getJogadores().values().iterator();
        boolean encontrou = false;
        Jogador j = null;
        
        while(t.hasNext() && !encontrou) {
            j = (Jogador) t.next();
            if(j.getNome().equals(jog))
                encontrou = true;
            System.out.println("ARRROZ");
        }
        
        JDialog frame = null;
        try {
            frame = new ConsultarJogador(this.root, this.escalao, this.user, j,this);
        } catch (ParseException ex) {
            Logger.getLogger(JPlantelJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
        atualizaJogadores();
    }//GEN-LAST:event_consultaJogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultaJog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaJogadores;
    // End of variables declaration//GEN-END:variables
}
