package GUI;

import Business_Layer.APEF;
import Business_Layer.Escalao;
import Business_Layer.Jogador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultarJogador2 extends javax.swing.JPanel {
    
    private ConsultarJogador cj;
    private Home2 root;
    private Escalao escalao;
        
        Jogador jogador;
        
      public ConsultarJogador2(Home2 root, Escalao e, Jogador jogador, ConsultarJogador cj) throws ParseException {
          this.root = root;
          this.escalao = e;
          this.cj = cj;
          this.jogador = this.root.getSistema().getEscolas().get(escalao.getNomeEscola()).getEquipas().get(escalao.getNomeEquipa()).getEscaloes()[escalao.getTipoEscalao()].getJogadores().get(jogador.getID());

          initComponents();
          
          reloadDadosJogador();     
    }
    
    public void reloadDadosJogador() throws ParseException {
    this.nome_t.setText(this.jogador.getNome());
          
          String s = null; 
          if(this.jogador.getSexo()==0) {s="Não Definido";}
          if(this.jogador.getSexo()==1) {s="Masculino";}
          if(this.jogador.getSexo()==2) {s="Feminino";}          
          this.sexo_t.setSelectedItem(s);
          
          GregorianCalendar aux = this.jogador.getDataNasc();
          int ano = aux.get(GregorianCalendar.YEAR);
          int mes = aux.get(GregorianCalendar.MONTH);
          int dia = aux.get(GregorianCalendar.DAY_OF_MONTH);
          SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
          Date date1 = df.parse(dia+"."+mes+"."+ano);
          this.nascimento_t.setDate(date1);
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

        concluido.setText("Alterar");
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

     private void mudaNome(){
        String n = nome_t.getText();
        if (n!=null) this.jogador.setNome(n);}
    
    private void mudaSexo(){
        String n = sexo_t.getSelectedItem().toString();
            if (n.equals("Masculino")) this.jogador.setSexo(1);

            if (n.equals("Feminino")) this.jogador.setSexo(2);
            if (n.equals("Não Definido")) {validadeDados.setText("Sexo Indefinido");}
       }
     
     
     
    public static GregorianCalendar DateToCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (GregorianCalendar)cal;
}
    
     private void mudaNascimento(){
         Date sistema = new Date();
         Date selecionada = nascimento_t.getDate();
            if(sistema.after(selecionada)) this.jogador.setDataNasc(DateToCalendar(sistema));}
     
     private void mudaFoto(){
     
     }
     
     
     
    
    
    private void concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidoActionPerformed
        mudaNome();
        mudaSexo();
        mudaNascimento();
        //mudaFoto();        
        validadeDados.setText("Dados Alterados com Sucesso");
        
        
        this.cj.reload();
        this.cj.getPlantelJogador().atualizaJogadores();
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