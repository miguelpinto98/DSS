package GUI.Header;

import Business_Layer.APEF;
import GUI.Home2;
import javax.swing.JDialog;

public class JRegistar extends javax.swing.JDialog {

    private Home2 sys;
    
    public JRegistar(Home2 sistema) {
        initComponents();
        this.buttonGroup1.add(this.resp);
        this.buttonGroup1.add(this.arb);
        this.sys = sistema;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confemail = new javax.swing.JTextField();
        nomeUtilizador = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        cancela = new javax.swing.JButton();
        confirma = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        resp = new javax.swing.JRadioButton();
        arb = new javax.swing.JRadioButton();
        pass = new javax.swing.JPasswordField();
        confpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("APEF - Novo Utilizador");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Confirmar email");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nome de utilizador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Confirmar password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        getContentPane().add(confemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, -1));
        getContentPane().add(nomeUtilizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 210, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 210, -1));

        cancela.setText("Cancelar");
        cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaActionPerformed(evt);
            }
        });
        getContentPane().add(cancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 100, -1));

        confirma.setText("Confirmar");
        confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaActionPerformed(evt);
            }
        });
        getContentPane().add(confirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 100, -1));

        error.setFont(new java.awt.Font("Lucida Grande", 3, 11)); // NOI18N
        error.setText("  ");
        error.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 20));

        resp.setSelected(true);
        resp.setText("Responsável Escola");
        getContentPane().add(resp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        arb.setText("Árbitro");
        getContentPane().add(arb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, -1));
        getContentPane().add(confpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, -1));

        setBounds(0, 0, 411, 346);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaActionPerformed
        // TODO add your handling code here:
        APEF sistema = sys.getSistema();

        String nomeUser = this.nomeUtilizador.getText();
        char[] pw1 = this.pass.getPassword();
        char[] confpw1 = this.confpass.getPassword();
        String mail = this.email.getText();
        String confmail = this.confemail.getText();
        
        StringBuilder p = new StringBuilder();
        for(char c : pw1)
            p.append(c);
        String pw = p.toString();
        
        p = new StringBuilder();
        for(char c : confpw1)
            p.append(c);
        String confpw = p.toString();
        
        boolean a = arb.isSelected();
        boolean re = resp.isSelected();
        boolean inserido = false;
        
        if(pw.length() < 6 || confpw.length() < 6)
            error.setText("Password deve conter mais de 5 caracteres");
        else {
        if(a && re)
            error.setText("Só pode escolher um tipo de Utilizador");
            else {
                if(nomeUser.equals("") || pw.equals("") || confpw.equals("") || mail.equals("") || confmail.equals(""))
                    error.setText("Dados incompletos");
                else {
                    int tipo = -999;
                    if(a)
                        tipo = 2;
                    else
                        tipo = 1;
                
                    inserido = sistema.registarUser(nomeUser, pw, mail, tipo);
                    if(inserido) {
                        error.setText("Utilizador criado com sucesso");
                        this.sys.setEnabled(true);
                        this.dispose();
                    }
                    else
                        error.setText("Utilizador já existe no sistema");
                }
            }
        }
        
        
    }//GEN-LAST:event_confirmaActionPerformed

    private void cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaActionPerformed
        // TODO add your handling code here:
        this.sys.setEnabled(true);
        dispose();
    }//GEN-LAST:event_cancelaActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton arb;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancela;
    private javax.swing.JTextField confemail;
    private javax.swing.JButton confirma;
    private javax.swing.JPasswordField confpass;
    private javax.swing.JTextField email;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeUtilizador;
    private javax.swing.JPasswordField pass;
    private javax.swing.JRadioButton resp;
    // End of variables declaration//GEN-END:variables
}
