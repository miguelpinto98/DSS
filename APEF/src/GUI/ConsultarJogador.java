package GUI;

import Business_Layer.Admin;
import Business_Layer.Jogador;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Utilizador;
import java.awt.BorderLayout;


public final class ConsultarJogador extends javax.swing.JDialog {
    
    private Home2 root;
    private Utilizador user;
    private Jogador jogador;
    
    public ConsultarJogador(Home2 root, Utilizador user, Jogador j){
        this.root = root;
        this.user = user;
        this.jogador = j;
               
        initComponents();
        
        verificaUser();
    }
    
    public void verificaUser(){
            if(this.user != null){
                if(this.user instanceof Admin || this.user instanceof ResponsavelEscola) {
                    this.remove(this.jPanel1);
                    this.add(new ConsultarJogador2(this.jogador), BorderLayout.CENTER);
                }
            }
            else 
                this.remove(this.jPanel1);}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dados_pessoais = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        nome_l = new javax.swing.JLabel();
        nascimento_l = new javax.swing.JLabel();
        sexo_l = new javax.swing.JLabel();
        clube_l = new javax.swing.JLabel();
        nascimento_t = new javax.swing.JLabel();
        sexo_t = new javax.swing.JLabel();
        clube_t = new javax.swing.JLabel();
        nome_t = new javax.swing.JLabel();
        competicoes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comp_realizadas = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        comp_ativas = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        dados_pessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.jpg"))); // NOI18N

        nome_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome_l.setForeground(new java.awt.Color(102, 102, 102));
        nome_l.setText("Nome:");

        nascimento_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nascimento_l.setForeground(new java.awt.Color(102, 102, 102));
        nascimento_l.setText("Nascimento:");

        sexo_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sexo_l.setForeground(new java.awt.Color(102, 102, 102));
        sexo_l.setText("Sexo:");

        clube_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clube_l.setForeground(new java.awt.Color(102, 102, 102));
        clube_l.setText("Clube:");

        nascimento_t.setText("12-33-1324");

        sexo_t.setText("Não Definido");

        clube_t.setText("Palmeirinhas");

        nome_t.setText("José Manuel Gonçalves Ferreira");

        javax.swing.GroupLayout dados_pessoaisLayout = new javax.swing.GroupLayout(dados_pessoais);
        dados_pessoais.setLayout(dados_pessoaisLayout);
        dados_pessoaisLayout.setHorizontalGroup(
            dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dados_pessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dados_pessoaisLayout.createSequentialGroup()
                        .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nascimento_l)
                            .addComponent(sexo_l)
                            .addComponent(clube_l)
                            .addComponent(nome_l))
                        .addGap(18, 18, 18)
                        .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome_t)
                            .addComponent(clube_t)
                            .addComponent(sexo_t)
                            .addComponent(nascimento_t))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        dados_pessoaisLayout.setVerticalGroup(
            dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dados_pessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome_l)
                    .addComponent(nome_t))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nascimento_l)
                    .addComponent(nascimento_t))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo_l)
                    .addComponent(sexo_t))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clube_l)
                    .addComponent(clube_t))
                .addGap(20, 20, 20))
        );

        jPanel2.add(dados_pessoais, java.awt.BorderLayout.LINE_START);
        dados_pessoais.getAccessibleContext().setAccessibleName("DADOS PESSOAIS");

        competicoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Competições", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        comp_realizadas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realizadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        comp_realizadas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(comp_realizadas);

        comp_ativas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ativas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        comp_ativas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(comp_ativas);

        javax.swing.GroupLayout competicoesLayout = new javax.swing.GroupLayout(competicoes);
        competicoes.setLayout(competicoesLayout);
        competicoesLayout.setHorizontalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        competicoesLayout.setVerticalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );

        jPanel2.add(competicoes, java.awt.BorderLayout.CENTER);
        competicoes.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel clube_l;
    private javax.swing.JLabel clube_t;
    private javax.swing.JList comp_ativas;
    private javax.swing.JList comp_realizadas;
    private javax.swing.JPanel competicoes;
    private javax.swing.JPanel dados_pessoais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nascimento_l;
    private javax.swing.JLabel nascimento_t;
    private javax.swing.JLabel nome_l;
    private javax.swing.JLabel nome_t;
    private javax.swing.JLabel sexo_l;
    private javax.swing.JLabel sexo_t;
    // End of variables declaration//GEN-END:variables
}
