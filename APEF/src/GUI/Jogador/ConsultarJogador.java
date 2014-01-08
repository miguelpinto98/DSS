package GUI.Jogador;

import Business_Layer.Admin;
import Business_Layer.Epoca;
import Business_Layer.Escalao;
import Business_Layer.Escola;
import Business_Layer.Jogador;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Utilizador;
import GUI.Plantel.JPlantelJogador;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.GregorianCalendar;
import GUI.Home2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;


public final class ConsultarJogador extends javax.swing.JDialog {
    
    private Home2 root;
    private Utilizador user;
    private Jogador jogador;
    private Escalao esc;
    private JPlantelJogador pj;
    private Epoca ep;
    
    public ConsultarJogador(Home2 root, Escalao e, Utilizador user, Jogador j, JPlantelJogador pla) throws ParseException{
        this.root = root;
        this.esc=e;
        this.user = user;
        this.jogador = j;
        this.pj = pla;
        GregorianCalendar g = new GregorianCalendar();
        int ano = g.get(GregorianCalendar.YEAR);
        if(!this.root.getSistema().getEpocas().containsKey(ano));
			ano--;
        this.ep = this.root.getSistema().getEpocas().get(ano);
        
        initComponents();        
        reload();   
        reloadListaCompeticoes();
        verificaUser();
        System.out.println(j.getCompeticoes());
    }
    
    public void reload() {
        this.nome_t.setText(this.jogador.getNome());
        this.clube_t.setText(this.jogador.getNomeEquipa());
          
          String s = null; 
          if(this.jogador.getSexo()==0) {s="Não Definido";}
          if(this.jogador.getSexo()==1) {s="Masculino";}
          if(this.jogador.getSexo()==2) {s="Feminino";}          
          this.sexo_t.setText(s);
          
          GregorianCalendar aux = this.jogador.getDataNasc();
          int ano = aux.get(GregorianCalendar.YEAR);
          int mes = ((aux.get(GregorianCalendar.MONTH))+1);
          int dia = aux.get(GregorianCalendar.DAY_OF_MONTH);
          this.nascimento_t.setText(dia+"-"+mes+"-"+ano);
    }
    
    public void verificaUser() throws ParseException{
            if(this.user != null){
                if(this.user instanceof Admin || this.user instanceof ResponsavelEscola) {
                    this.remove(this.jPanel1);
                    this.add(new ConsultarJogador2(root, this.esc, this.jogador, this), BorderLayout.CENTER);
                }
            }
            else 
                this.remove(this.jPanel1);}

    public JPlantelJogador getPlantelJogador() {return this.pj;}
    
          
    public void reloadListaCompeticoes(){
        //ArrayList<String> lcomp = listaComp();
        DefaultListModel<Integer> str = new DefaultListModel<>(); 
        Iterator<Integer> it = this.jogador.getCompeticoes().keySet().iterator(); 
		while (it.hasNext()) {
            Integer idComp = it.next();
                str.addElement(idComp); 
        }
        comp_realizadas.setModel(str);}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        header_texto = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        comp_ativas = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        comp_realizadas = new javax.swing.JList<Integer>();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(153, 153, 153));

        header_texto.setBackground(new java.awt.Color(153, 153, 153));
        header_texto.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        header_texto.setForeground(new java.awt.Color(255, 255, 255));
        header_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header_texto.setText("Perfil Jogador");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_texto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(header_texto)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.add(header, java.awt.BorderLayout.PAGE_START);

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

        comp_ativas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ativas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        comp_ativas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(comp_ativas);

        comp_realizadas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realizadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)));
        comp_realizadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(comp_realizadas);
        comp_realizadas.getAccessibleContext().setAccessibleName("Realizadas");

        javax.swing.GroupLayout competicoesLayout = new javax.swing.GroupLayout(competicoes);
        competicoes.setLayout(competicoesLayout);
        competicoesLayout.setHorizontalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        competicoesLayout.setVerticalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
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
            .addGap(0, 130, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel clube_l;
    private javax.swing.JLabel clube_t;
    private javax.swing.JList comp_ativas;
    private javax.swing.JList<Integer> comp_realizadas;
    private javax.swing.JPanel competicoes;
    private javax.swing.JPanel dados_pessoais;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_texto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nascimento_l;
    private javax.swing.JLabel nascimento_t;
    private javax.swing.JLabel nome_l;
    private javax.swing.JLabel nome_t;
    private javax.swing.JLabel sexo_l;
    private javax.swing.JLabel sexo_t;
    // End of variables declaration//GEN-END:variables
}
