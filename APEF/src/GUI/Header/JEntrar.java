/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Header;

import Business_Layer.APEF;
import Business_Layer.Utilizador;
import GUI.ConsultasEscola;
import GUI.Home2;
import javax.swing.JDialog;

/**
 *
 * @author serafim
 */
public class JEntrar extends JDialog {

    /**
     * Creates new form Entrar
     */
    private Home2 root;

    public JEntrar(Home2 root) {
        initComponents();
        this.root = root;
        setTitle("APEF - Entrar");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        root.setEnabled(false);
        
        loginpane.setBannerText("Entrar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        loginpane = new org.jdesktop.swingx.JXLoginPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jXSearchField1.setText("jXSearchField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Entrar");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(loginpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginpane, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        APEF sistema = root.getSistema();
        String username = loginpane.getUserName();
        String password = new String(loginpane.getPassword());
        
        if(!sistema.login(username, password))
            loginpane.setMessage("Não existe nenhum utilizador com essa password");
        else {     
            Utilizador user = sistema.getUsers().get(username);
            
            Home2.UTILIZADOR = username;
            Home2.REGISTADO = true;
            root.setUser(user);
            root.verificaUser(user);
            root.setEnabled(true);
            dispose();
        }
    }                                        
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        root.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         root.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private org.jdesktop.swingx.JXLoginPane loginpane;
    // End of variables declaration//GEN-END:variables
}
