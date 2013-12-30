package GUI;

import Business_Layer.Jogador;
import java.util.GregorianCalendar;

public class ConsultarJogador2 extends javax.swing.JPanel {

        Jogador jogador;
        
      public ConsultarJogador2(Jogador jogador) {
          this.jogador = jogador;

        initComponents();
        
        this.nome_t.setText(this.jogador.getNome());
    }
      
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        sexo = new javax.swing.JLabel();
        concluido = new javax.swing.JButton();
        nascimento_t = new org.jdesktop.swingx.JXDatePicker();
        sexo_t = new javax.swing.JComboBox();
        avatar = new javax.swing.JLabel();
        foto_t = new javax.swing.JButton();
        nome_t = new javax.swing.JTextField();
        validadeDados = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome.setForeground(new java.awt.Color(102, 102, 102));
        nome.setText("Nome:");

        nascimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nascimento.setForeground(new java.awt.Color(102, 102, 102));
        nascimento.setText("Nascimento:");

        sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sexo.setForeground(new java.awt.Color(102, 102, 102));
        sexo.setText("Sexo:");

        concluido.setText("Concluído");
        concluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidoActionPerformed(evt);
            }
        });

        sexo_t.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Definido", "Feminino", "Masculino" }));

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.jpg"))); // NOI18N

        foto_t.setText("Foto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foto_t, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nome)
                                .addGap(46, 46, 46)
                                .addComponent(nome_t, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nascimento_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(248, 248, 248))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(sexo_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(concluido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validadeDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome)
                            .addComponent(nome_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexo)
                            .addComponent(sexo_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nascimento_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nascimento))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(concluido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avatar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(foto_t)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(validadeDados)
                                .addGap(26, 26, 26))))))
        );
    }// </editor-fold>//GEN-END:initComponents

     private int mudaNome(int ok){
        String n = nome_t.getText();
            if (n!=null) this.jogador.setNome(n);
            else {validadeDados.setText("Nome Incorreto"); ok=1;}
        return ok;}
    
    
     private int mudaSexo(int ok){
        String n = sexo_t.getSelectedItem().toString();
            if (n.equals("Masculino")) this.jogador.setSexo(1);
            if (n.equals("Feminino")) this.jogador.setSexo(2);
            if (n.equals("Não Definido")) {validadeDados.setText("Sexo Indefinido"); ok=1;}
        return ok;}
     
     private int mudaNascimento(int ok){
         GregorianCalendar sistema = new GregorianCalendar();
         //GregorianCalendar selecionada = nascimento_t.get
//                 if(sistema.after(selecionada))
         {
                     
                 }
         
            
         
     
     return ok;}
     
     private int mudaFoto(int ok){
     
     return ok;}
     
     
     
    
    
    private void concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidoActionPerformed
        int ok=0;
        
        //if ((nome_c.isSelected()==true) && ok==0) this.mudaNome(ok);       
        //if ((sexo_c.isSelected()==true) && ok==0) this.mudaSexo(ok);        
        //if ((nascimento_c.isSelected()==true && ok==0)) this.mudaNascimento(ok);        
        //if ((foto_c.isSelected()==true) && ok==0)this.mudaFoto(ok);
        
        if(ok==0) validadeDados.setText("Dados Alterados com Sucesso");  
    }//GEN-LAST:event_concluidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JButton concluido;
    private javax.swing.JButton foto_t;
    private javax.swing.JLabel nascimento;
    private org.jdesktop.swingx.JXDatePicker nascimento_t;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField nome_t;
    private javax.swing.JLabel sexo;
    private javax.swing.JComboBox sexo_t;
    private javax.swing.JLabel validadeDados;
    // End of variables declaration//GEN-END:variables
}
