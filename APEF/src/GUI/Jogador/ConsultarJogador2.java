package GUI.Jogador;

import GUI.Home2;
import Business_Layer.Escalao;
import Business_Layer.Jogador;
import java.text.ParseException;
import java.util.GregorianCalendar;

public final class ConsultarJogador2 extends javax.swing.JPanel {    
    private ConsultarJogador cj;
    private Home2 root;
    private Escalao escalao;
    private Jogador jogador;
    
    
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
        String anoa = Integer.toString(aux.get(GregorianCalendar.YEAR));
        String mesa = Integer.toString((aux.get(GregorianCalendar.MONTH))+1);
        String diaa = Integer.toString(aux.get(GregorianCalendar.DAY_OF_MONTH));
        this.dia.setSelectedItem(diaa);
        this.mes.setSelectedItem(mesa);
        this.ano.setSelectedItem(anoa);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        nascimento = new javax.swing.JLabel();
        sexo = new javax.swing.JLabel();
        concluido = new javax.swing.JButton();
        sexo_t = new javax.swing.JComboBox();
        avatar = new javax.swing.JLabel();
        foto_t = new javax.swing.JButton();
        nome_t = new javax.swing.JTextField();
        validadeDados = new javax.swing.JLabel();
        dia = new javax.swing.JComboBox();
        mes = new javax.swing.JComboBox();
        ano = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

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

        dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "1850", "1851", "1852", "1853", "1854", "1855", "1856", "1857", "1858", "1859", "1860", "1861", "1862", "1863", "1864", "1865", "1866", "1867", "1868", "1869", "1870", "1871", "1872", "1873", "1874", "1875", "1876", "1877", "1878", "1879", "1880", "1881", "1882", "1883", "1884", "1885", "1886", "1887", "1888", "1889", "1890", "1891", "1892", "1893", "1894", "1895", "1896", "1897", "1898", "1899", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foto_t, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nome)
                                .addGap(46, 46, 46)
                                .addComponent(nome_t, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(213, 213, 213))))
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
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nascimento)
                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
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
    
    private int mudaSexo(){
        int ok=0;
        String n = sexo_t.getSelectedItem().toString();
            if (n.equals("Masculino")) this.jogador.setSexo(1);
            if (n.equals("Feminino")) this.jogador.setSexo(2);
            if (n.equals("Não Definido")) {ok=1;}
     return ok;
       }
              
    private boolean dataSenil(int d, int m){
        boolean senil=false;
        if (m==3 ||m==5 || m==8 || m==10){
            if(d==31) senil=true;}
        if(m==1 && d>29) senil=true;
    return senil;}
    
    private int mudaNascimento(int ok){
         GregorianCalendar sistema = new GregorianCalendar();
         int diaS= Integer.parseInt(dia.getSelectedItem().toString());
         int mesS= Integer.parseInt(mes.getSelectedItem().toString())-1;
         int anoS= Integer.parseInt(ano.getSelectedItem().toString());
         GregorianCalendar selecionada = new GregorianCalendar(anoS, mesS, diaS);
         if((sistema.after(selecionada)) && (dataSenil(diaS, mesS)==false)){
              this.jogador.setDataNasc(selecionada);}
          else {ok=1;}
    return ok;
    }   
     
 // private void mudaFoto(){}
     
     
     
    
    
    private void concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidoActionPerformed
        int ok;
        mudaNome();
        ok=mudaSexo();
            if(ok==1) {validadeDados.setText("Sexo Indefinido");}
            else{
                ok=mudaNascimento(ok);
                    if(ok==1) {validadeDados.setText("Data Inválida");}
                    else {//mudaFoto();        
                    validadeDados.setText("Dados Alterados com Sucesso");}}
        
        this.cj.reload();
        this.cj.getPlantelJogador().atualizaJogadores();      
    }//GEN-LAST:event_concluidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ano;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton concluido;
    private javax.swing.JComboBox dia;
    private javax.swing.JButton foto_t;
    private javax.swing.JComboBox mes;
    private javax.swing.JLabel nascimento;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField nome_t;
    private javax.swing.JLabel sexo;
    private javax.swing.JComboBox sexo_t;
    private javax.swing.JLabel validadeDados;
    // End of variables declaration//GEN-END:variables
}