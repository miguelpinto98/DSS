package GUI.Plantel;

import Business_Layer.Escalao;
import GUI.Home2;


public class JPlantelTreinadorOpcoes extends javax.swing.JPanel {

    private Home2 root;
    private Escalao escalao;

    JPlantelTreinadorOpcoes(Home2 root, Escalao escalao) {
        this.root = root;
        this.escalao = escalao;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subsitituir = new javax.swing.JButton();
        editar = new javax.swing.JButton();

        subsitituir.setText("Substituir");
        subsitituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsitituirActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subsitituir, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subsitituir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
      /*   int ok;
        mudaNome();
        ok=mudaSexo();
            if(ok==1) {validadeDados.setText("Sexo Indefinido");}
            else{
                ok=mudaNascimento(ok);
                    if(ok==1) {validadeDados.setText("Data Inválida");}
                    else {//mudaFoto();        
                    validadeDados.setText("Dados Alterados com Sucesso");}}
        
        this.cj.reload();
        this.cj.getPlantelJogador().atualizaJogadores(); */
    }//GEN-LAST:event_editarActionPerformed

    private void subsitituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsitituirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subsitituirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JButton subsitituir;
    // End of variables declaration//GEN-END:variables
}
