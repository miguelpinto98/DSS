/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Plantel;

import Business_Layer.Admin;
import Business_Layer.Escalao;
import Business_Layer.Jogador;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Utilizador;
import GUI.Jogador.ConsultarJogador;
import GUI.Home2;
import GUI.Jogador.JAdicionarJogador;
import GUI.Jogador.JRemoverJogador;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;


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
        
        this.adicionar.setVisible(false);
        this.empresto.setVisible(false);
        this.remover.setVisible(false);
        
        if(escalao != null) {
            atualizaJogadores();
            verificaOpcoes();
        }
        else {
            this.jPanel1.setVisible(false);
            this.consultaJog.setVisible(false);
            this.add(new JLabel("Nenhum Plantel Registado Nesta Equipa!"));
        }       
    }
    
    public void verificaOpcoes() {
        if(this.user != null) {
            if(this.user instanceof Admin || this.user instanceof ResponsavelEscola) {
                this.adicionar.setVisible(true);
                this.empresto.setVisible(true);
                this.remover.setVisible(true);
            }
        }
    }
    
    public void atualizaJogadores() {
        Collection<Jogador> lesc = this.root.getSistema().getEscolas().get(this.escalao.getNomeEscola()).getEquipas().get(this.escalao.getNomeEquipa()).getEscaloes().get(this.escalao.getTipoEscalao()).getJogadores().values();

        Object[] columnNames = new String[] {"ID","Nome"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);
        
        for(Jogador j : lesc) 
            x.addRow(new Object[]{j.getID(), j.getNome()});
        
        listaJogadores.setModel(x); 
        listaJogadores.getColumnExt("ID").setVisible(false);
    }

    public JXTable getTableJogadores() {
        return this.listaJogadores;
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
        listaJogadores = new org.jdesktop.swingx.JXTable();
        panelOpcoes = new javax.swing.JPanel();
        consultaJog = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        empresto = new javax.swing.JButton();
        remover = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Jogadores"));
        setLayout(new java.awt.BorderLayout());

        listaJogadores.setBackground(new java.awt.Color(246, 246, 246));
        listaJogadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(100), "arroz"}
            },
            new String [] {
                "ID", "Jogadores"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listaJogadores.setAlignmentX(1.0F);
        listaJogadores.setAlignmentY(1.0F);
        listaJogadores.setShowGrid(true);
        listaJogadores.setShowVerticalLines(false);
        listaJogadores.getTableHeader().setReorderingAllowed(false);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        consultaJog.setText("Consultar");
        consultaJog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaJogActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        empresto.setText("Emprestar");

        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcoesLayout = new javax.swing.GroupLayout(panelOpcoes);
        panelOpcoes.setLayout(panelOpcoesLayout);
        panelOpcoesLayout.setHorizontalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultaJog, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empresto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelOpcoesLayout.setVerticalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultaJog, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(empresto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        add(panelOpcoes, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void consultaJogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaJogActionPerformed
        // TODO add your handling code here:
        this.listaJogadores.getColumnExt("ID").setVisible(true);
        
        int row = this.listaJogadores.getSelectedRow();
        
        if(row != -1) {
            int id = (int) this.listaJogadores.getValueAt(row, 0);
            JDialog frame = null;
            
            try {
                frame = new ConsultarJogador(this.root, this.escalao, this.user, this.escalao.getJogadores().get(id),this);
            } catch (ParseException ex) {
                Logger.getLogger(JPlantelJogador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            frame.setVisible(true);
            atualizaJogadores();
        }
    }//GEN-LAST:event_consultaJogActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        // TODO add your handling code here:
        JDialog frame = new JAdicionarJogador(root, this.escalao, this);
        frame.setVisible(true);
    }//GEN-LAST:event_adicionarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        // TODO add your handling code here:
        this.listaJogadores.getColumnExt("ID").setVisible(true);
        int row = this.listaJogadores.getSelectedRow();
        
        if(row != -1) {
            int id = (int) this.listaJogadores.getValueAt(row, 0);
            JDialog frame = new JRemoverJogador(this.root, escalao, this, this.escalao.getJogadores().get(id));
            frame.setVisible(true);
        }
    }//GEN-LAST:event_removerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton consultaJog;
    private javax.swing.JButton empresto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable listaJogadores;
    private javax.swing.JPanel panelOpcoes;
    private javax.swing.JButton remover;
    // End of variables declaration//GEN-END:variables
}
