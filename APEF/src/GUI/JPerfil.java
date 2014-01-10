package GUI;

import Business_Layer.APEF;
import Business_Layer.Utilizador;
import java.util.GregorianCalendar;


public class JPerfil extends javax.swing.JDialog {

    private Home2 root;
    private Utilizador utilizador;
    private APEF sistema;
    
    
     public JPerfil(Home2 root, Utilizador u){
        this.utilizador=u;
        this.root = root;
        this.sistema=this.root.getSistema();
        initComponents();                 
        reloadDadosUtilizador();  
    }

     public final void reloadDadosUtilizador(){
        this.nome_t.setText(this.utilizador.getNome());
        this.nome_uti_t.setText(this.utilizador.getNomeUser());
        this.mail_t.setText(this.utilizador.getEmail());
        this.morada_t.setText(this.utilizador.getMorada());
        this.tlm_t.setText(this.utilizador.getTelemovel());
        this.cod_t.setText(this.utilizador.getCodPostal());
        
        GregorianCalendar aux = this.utilizador.getDataNasc();
        String anoa = Integer.toString(aux.get(GregorianCalendar.YEAR));
        String mesa = Integer.toString((aux.get(GregorianCalendar.MONTH))+1);
        String diaa = Integer.toString(aux.get(GregorianCalendar.DAY_OF_MONTH));
        this.dia.setSelectedItem(diaa);
        this.mes.setSelectedItem(mesa);
        this.ano.setSelectedItem(anoa);        
    }
     
     private void mudaNome(){ 
        String n = nome_t.getText();
        if (n!=null) this.utilizador.setNome(n);}
     
     private int mudaNomeUtilizador(int ok){
        String n = nome_uti_t.getText();
        if(this.sistema.existeNickname(n) && (!(n.equals(this.utilizador.getNomeUser())))) {ok=1;}
        else 
            if (n!=null && (n.equals(this.utilizador.getNomeUser()))) this.utilizador.setNomeUser(n);
        return ok;}
     
     private void mudaPass(){
        String n = pass_t.getText();
        if (n!=null) this.utilizador.setPass(n);}
     
     private int mudaEmail(int ok){
        String n = mail_t.getText();
        if(this.sistema.existeEmail(n) && (!(n.equals(this.utilizador.getEmail())))) {ok=1;}
        else{
            if (n!=null && (n.equals(this.utilizador.getPass()))) {this.utilizador.setEmail(n);}
        }
        return ok;}
     
     private void mudaMorada(){
        String n = morada_t.getText();
        if (n!=null) this.utilizador.setMorada(n);}
     
     private void mudaTelemovel(){
        String n = tlm_t.getText();
        if (n!=null) this.utilizador.setTelemovel(n);}
     
     private void mudaCodPostal(){
        String n = cod_t.getText();
        if (n!=null) this.utilizador.setCodPostal(n);}
     
     private boolean dataSenil(int d, int m){
        boolean senil=false;
        if (m==3 ||m==5 || m==8 || m==10){
            if(d==31) senil=true;}
        if(m==1 && d>29) senil=true;
    return senil;}
    
     private int mudaNascimento(int ok){
         GregorianCalendar sis = new GregorianCalendar();
         int diaS= Integer.parseInt(dia.getSelectedItem().toString());
         int mesS= Integer.parseInt(mes.getSelectedItem().toString())-1;
         int anoS= Integer.parseInt(ano.getSelectedItem().toString());
         GregorianCalendar selecionada = new GregorianCalendar(anoS, mesS, diaS);
         if((sis.after(selecionada)) && (dataSenil(diaS, mesS)==false)){
              this.utilizador.setDataNasc(selecionada);}
          else {ok=1;}
    return ok;
    } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        validadeDados = new javax.swing.JLabel();
        alterar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        telemovel = new javax.swing.JLabel();
        morada = new javax.swing.JLabel();
        codpostal = new javax.swing.JLabel();
        nome_utilizador = new javax.swing.JLabel();
        cod_t = new javax.swing.JTextField();
        nome_t = new javax.swing.JTextField();
        pass_t = new javax.swing.JTextField();
        mail_t = new javax.swing.JTextField();
        morada_t = new javax.swing.JTextField();
        tlm_t = new javax.swing.JTextField();
        dia = new javax.swing.JComboBox();
        mes = new javax.swing.JComboBox();
        ano = new javax.swing.JComboBox();
        foto = new javax.swing.JButton();
        nome_uti_t = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conta Pessoal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(validadeDados, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validadeDados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alterar)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Os meus dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.jpg"))); // NOI18N
        avatar.setText("jLabel2");

        nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome.setText("Nome:");

        email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email.setText("E-mail:");

        password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password.setText("Password:");

        nascimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nascimento.setText("Nascimento:");

        telemovel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        telemovel.setText("Telemóvel:");

        morada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        morada.setText("Morada:");

        codpostal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codpostal.setText("Código-Postal:");

        nome_utilizador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome_utilizador.setText("Nome Utilizador:");

        dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "1850", "1851", "1852", "1853", "1854", "1855", "1856", "1857", "1858", "1859", "1860", "1861", "1862", "1863", "1864", "1865", "1866", "1867", "1868", "1869", "1870", "1871", "1872", "1873", "1874", "1875", "1876", "1877", "1878", "1879", "1880", "1881", "1882", "1883", "1884", "1885", "1886", "1887", "1888", "1889", "1890", "1891", "1892", "1893", "1894", "1895", "1896", "1897", "1898", "1899", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));

        foto.setActionCommand("Foto");
        foto.setLabel("Foto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(nome_utilizador))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(nome))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(password))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email)
                            .addComponent(morada)
                            .addComponent(telemovel)
                            .addComponent(nascimento)
                            .addComponent(codpostal))))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mail_t)
                    .addComponent(cod_t)
                    .addComponent(nome_t)
                    .addComponent(pass_t)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tlm_t)
                    .addComponent(morada_t)
                    .addComponent(nome_uti_t))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome)
                            .addComponent(nome_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome_utilizador)
                            .addComponent(nome_uti_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password)
                            .addComponent(pass_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email)
                            .addComponent(mail_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nascimento)
                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tlm_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telemovel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(morada_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(morada))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codpostal))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);
        jPanel4.getAccessibleContext().setAccessibleName("Editar dados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
          System.out.println("ok");int ok=0;
        mudaNome();
        mudaMorada();
        mudaCodPostal();
        mudaTelemovel();
        mudaPass();
        ok=mudaNomeUtilizador(ok);
            if (ok==1){validadeDados.setText("Escolha outro Nome de Utilizador");}
            else {
                ok=mudaEmail(ok);
                if(ok==1){validadeDados.setText("E-mail Inválido");}
                else{
                    ok=mudaNascimento(ok);
                    if(ok==1) {validadeDados.setText("Data Inválida");}
                    else {        
            validadeDados.setText("Dados Alterados com Sucesso");}}}
    }//GEN-LAST:event_alterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.root.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JComboBox ano;
    private javax.swing.JLabel avatar;
    private javax.swing.JTextField cod_t;
    private javax.swing.JLabel codpostal;
    private javax.swing.JComboBox dia;
    private javax.swing.JLabel email;
    private javax.swing.JButton foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField mail_t;
    private javax.swing.JComboBox mes;
    private javax.swing.JLabel morada;
    private javax.swing.JTextField morada_t;
    private javax.swing.JLabel nascimento;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField nome_t;
    private javax.swing.JTextField nome_uti_t;
    private javax.swing.JLabel nome_utilizador;
    private javax.swing.JTextField pass_t;
    private javax.swing.JLabel password;
    private javax.swing.JLabel telemovel;
    private javax.swing.JTextField tlm_t;
    private javax.swing.JLabel validadeDados;
    // End of variables declaration//GEN-END:variables
}
