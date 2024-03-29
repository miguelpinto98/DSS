package GUI;

import Business_Layer.APEF;
import Business_Layer.Utilizador;
import Business_Layer.Admin;
import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Campeonato;
import Business_Layer.Campo;
import Business_Layer.DadosEstatisticos;
import Business_Layer.Epoca;
import Business_Layer.Equipa;
import Business_Layer.Escalao;
import Business_Layer.Escola;
import Business_Layer.Imagem;
import Business_Layer.Jogador;
import Business_Layer.Jogo;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Torneio;
import Business_Layer.Treinador;
import GUI.Campeonato.JCampeonatoCalendario;
import GUI.Campeonato.JCampeonatoClassificacao;
import GUI.Campeonato.JCampeonatoEstatistica;
import GUI.Campeonato.JCampeonatoJornadas;
import GUI.Campeonato.JCriarCampeonato;
import GUI.Campeonato.jIniciarCampeonato;
import GUI.Campeonato.JInscreverCampeonato;
import GUI.Escola.EscolasMenuAdmin;
import GUI.Header.JEntrar;
import GUI.Header.JMenuAdmin;
import GUI.Header.JMenuArbitro;
import GUI.Header.JMenuResponsavelEscola;
import GUI.Header.JPreencherRegisto;
import GUI.Header.JRegistar;
import GUI.Torneio.JOptions;
import GUI.Torneio.JTorneioInfo;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class Home2 extends JFrame {

    public static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean REGISTADO = false;
    public static String UTILIZADOR = null; 
    
    private APEF sistema;
    private Utilizador user;
    private int ano;
    

    public Home2() {
        this.sistema = new APEF();
        this.user = null;
        
        this.sistema.registarUser("serafim","serafim67","serafim@admin",0);

        /*
        Epoca epo1 = new Epoca(2014);
        Epoca epo2 = new Epoca(2003);
        Epoca epo3 = new Epoca(2010);
        Epoca epo4 = new Epoca(2014);
        Epoca epo5 = new Epoca(1995);
        
        this.sistema.inserirEpoca(epo1);
        this.sistema.inserirEpoca(epo2);
        this.sistema.inserirEpoca(epo3);
        this.sistema.inserirEpoca(epo4);
        this.sistema.inserirEpoca(epo5);
         
        Torneio t1 = new Torneio("Uminho Cup",new GregorianCalendar(),new GregorianCalendar(),2,2,new Campo("UM"));
        Torneio t2 = new Torneio("Uminho Cup",new GregorianCalendar(),new GregorianCalendar(),1,2,new Campo("UM"));
        Campeonato c1 = new Campeonato("Campeonato dos lindos", new GregorianCalendar(),new GregorianCalendar(), 1, 2);
        Campeonato c2 = new Campeonato("Campeonato dos ainda mais lindos", new GregorianCalendar(),new GregorianCalendar(), 2, 2);
        epo1.inserirCampeonato(c1);
        epo1.inserirCampeonato(c2);
        epo1.inserirTorneio(t1);
        epo1.inserirTorneio(t2);
 
        

        //ESCOLAS
        Escola e1 = new Escola("Escola Secundária da Lixa", "Lixa", new Campo("Lixa Futebol"));
        Escola e2 = new Escola("Escola Secundária de Felgueiras", "Felgueiras", new Campo("Dr. Machado Matos"));
        Escola e3 = new Escola("Universidade do Minho", "Braga", new Campo("Rodovia"));
        Escola e4 = new Escola();
        Escola e5 = new Escola();
        
        boolean a = this.sistema.inserirEscola(e1);
        a = this.sistema.inserirEscola(e2);
        a = this.sistema.inserirEscola(e3);
        a = this.sistema.inserirEscola(e4);
        a = this.sistema.inserirEscola(e5);
        
        
        
        //EQUIPAS
        Equipa eq1 = new Equipa("Gelbots");
        Equipa eq2 = new Equipa("LEI");
        Equipa eq3 = new Equipa("CeSIUM");
        
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq1);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq2);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq3);
        
        //ESCALOES
        eq3.criarEscalao(0, "Universidade do Minho", "CeSIUM","Manuel Pato", new Date(), 0, new Imagem());
        Escalao escalao2 = new Escalao(3, "CeSIUM", "Universidade do Minho");
        
        Jogador lindo1 = new Jogador("Mário Leite", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo2 = new Jogador("Miguel Pinto", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo3 = new Jogador("Serafim Pinto", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo4 = new Jogador("Diana Lemos", new GregorianCalendar(), 2, new Imagem());
        Jogador lindo5 = new Jogador("63linda", new GregorianCalendar(), 2, new Imagem());
    
               
        eq3.getEscaloes().get(0).inserirJogador(lindo1);
        eq3.getEscaloes().get(0).inserirJogador(lindo2);
        eq3.getEscaloes().get(0).inserirJogador(lindo3);
        eq3.getEscaloes().get(0).inserirJogador(lindo4);
        eq3.getEscaloes().get(0).inserirJogador(lindo5);
        
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t1.getID());
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t2.getID());
        
        this.sistema.getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").inserirEscalao(escalao2);
        
       
        eq3.atualizaPalmares("Liga dos Campeões Infantis");
        eq3.atualizaPalmares("Liga dos Campeões Infantis");

        
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t1.getID());
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t2.getID());
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t1.getID());
        this.getSistema().getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").getEscaloes().get(0).getJogadores().get(17).addCompeticao(t2.getID());
        
        
        
        this.sistema.getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").inserirEscalao(escalao2);
        this.sistema.getUsers().remove("maleite");
        //TESTE USERS
        this.sistema.registarUser("174Miguel","pw1234","miguel@gmail.com",1);
        this.sistema.registarUser("63linda","pw1234","63@gmail.com",1);
        this.sistema.registarUser("diana","pw12345","demos@gmail.com",0);
        this.sistema.registarUser("serafim","pw1234","smcp@gmail.com",2);
        this.sistema.registarUser("atum","pw1234","atum@gmail.com",2);
        System.out.println(this.sistema.getUsers().size());
        System.out.println(this.sistema.getUsers().isEmpty());
        System.out.println(this.sistema.getUsers().get("serafim"));
        System.out.println(this.sistema.getUsers().get("miguel"));
        Agenda aaa = new Agenda(999,null);
        Utilizador u = new Admin(123,null,0,"ADMIN","serafimpinto","lol@joao","1245213s22","Felgueiras","91568544","784-545",new GregorianCalendar(),false,false,false);
        Utilizador u2 = new ResponsavelEscola(101,null,1,"Rescla","sersfismpinto","ll@josao","1245213s22","Felgueiras","91568544","784-545",new GregorianCalendar(),false,false,false,e1);
        Utilizador u3 = new Arbitro(1001,null,2,"josejose","sersfismpinto","ll@josao","1245213s22","Felgueiras","91568544","784-545",new GregorianCalendar(),false,false,aaa,false);
                
         /* Inicia Aplicação */
        initComponents();  
        verificaUser(user);
        this.JPanelEscolaConvidado.setBackground(new java.awt.Color(248, 247, 247));

        GregorianCalendar g = new GregorianCalendar();
        this.data.setText(g.get(g.DAY_OF_MONTH)+"/"+(g.get(g.MONTH)+1)+"/"+g.get(g.YEAR));
        
        reloadPagIncialHome();
        
        
        /* CENTRAR UMA COLUNA
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        JTabResultados.getColumn("Dia").setCellRenderer( centerRenderer );
        */
           
        reloadListaEscolas();
        reloadTorneios();
        reloadCampeonato();
        reloadPagInicialCampeonato();
    }
    
    public void verificaUser(Utilizador user) {
        if(user != null) {
            
            if(user instanceof Admin) {
                reloadHeaderUserAdmin();
                reloadTabEscolasAdmin();
                reloadOptions();
                verificaOpcoesCamp(true);
            }
            
            if(user instanceof ResponsavelEscola) {
                reloadHeaderUserRespEscola();
                reloadOptions();
                verificaOpcoesCamp(false);
                this.inscreverCamp.setVisible(true);
            }
            
            if(user instanceof Arbitro) {
                reloadHeaderUserArbitro();
                verificaOpcoesCamp(false);
            }     
        }
        
        else {
            reloadHeaderConvidado();
            reloadTabEscolasConvidado();
            verificaOpcoesCamp(false);
        }
    }
    
    public void verificaOpcoesCamp(boolean flag) {
        this.IniciarCamp.setVisible(flag);
        this.inscreverCamp.setVisible(flag);
        this.criarCamp.setVisible(flag);
    }
    
    /** NOVA TAB 
    
    public void reloadArbitro(){
        this.JTabEscolas.addTab("Jogos",new JArbitroOption(this,user));
        this.JTabEscolas.updateUI();
        this.JTabEscolas.validate();
    }
    
    public void reloadAdmin(){
        this.JTabEscolas.addTab("Gerir Aplicação",new JAdminOption(this,user));
        this.JTabEscolas.updateUI();
        this.JTabEscolas.validate();
    }
    
    public void reloadResponsavel(){
        this.JTabEscolas.addTab("Equipas",new JResponsavelOption(this,user));
        this.JTabEscolas.updateUI();
        this.JTabEscolas.validate();
    }
    
     */
    
    public void reloadP(){
        JDialog h = new JPreencherRegisto(this, user);
        h.setLocationRelativeTo(null);
        h.setVisible(true);
    }
    
    public void reloadCampeonato() {
        for(Integer an : this.sistema.getEpocas().keySet()) {
            this.jComboEpocaCampeonato.addItem(an+"/"+(an+1));
            this.ano = an;
        }
    }
    
    public void reloadOptions(){
        this.jPanel5.removeAll();
        this.jPanel5.add(new JOptions(this, user), BorderLayout.CENTER);
        this.jPanel5.updateUI();
        this.jPanel5.validate();
    }
    
    public void reloadHeaderConvidado() {
        this.JPanelHeader.removeAll();
        this.JPanelHeader.add(this.TitleHeader, BorderLayout.NORTH);
        this.JPanelHeader.add(this.JPanelUserLogout, BorderLayout.CENTER);
        this.JPanelHeader.add(this.searchPanel, BorderLayout.SOUTH);
        this.JPanelHeader.updateUI();
        this.JPanelHeader.validate();
    }
    
    public void reloadTabEscolasConvidado() {
        this.JPanelEscolaConvidado.removeAll();
        this.JPanelEscolaConvidado.add(this.panelListaEscolas, BorderLayout.WEST);
        this.JPanelEscolaConvidado.add(this.botoesConvidadoEscola, BorderLayout.EAST);
        this.JPanelEscolaConvidado.updateUI();
        this.JPanelEscolaConvidado.validate();
    }
    
    public void reloadTabEscolasAdmin() {
        this.JPanelEscolaConvidado.remove(this.botoesConvidadoEscola);
        this.JPanelEscolaConvidado.add(new EscolasMenuAdmin(this, user), BorderLayout.EAST);
        this.JPanelEscolaConvidado.updateUI();
        this.JPanelEscolaConvidado.validate();
    }
    
    public void reloadHeaderUserAdmin() {
        this.JPanelHeader.remove(this.JPanelUserLogout);
        this.JPanelHeader.add(new JMenuAdmin(this, user), BorderLayout.CENTER);
        this.JPanelHeader.updateUI();
        this.JPanelHeader.validate();
    } 
    
    public void reloadHeaderUserRespEscola() {
        this.JPanelHeader.remove(this.JPanelUserLogout);
        this.JPanelHeader.add(new JMenuResponsavelEscola(this, user), BorderLayout.CENTER);
        this.JPanelHeader.updateUI();
        this.JPanelHeader.validate();
    }

    public void reloadHeaderUserArbitro() {
        this.JPanelHeader.remove(this.JPanelUserLogout);
        this.JPanelHeader.add(new JMenuArbitro(this, user), BorderLayout.CENTER);
        this.JPanelHeader.updateUI();
        this.JPanelHeader.validate();
    }
    
    public String seleccionadoTorneio1(){
        String s;
        
        if (jList1.getSelectedIndex() != -1){
            s = jList1.getSelectedValue().toString();
        }
        else{s= null;}
        
        jList1.clearSelection();
        
       return s;
    }
    
    public String seleccionadoTorneio2(){
        String s;
        
        if (jList2.getSelectedIndex() != -1){
            s = jList2.getSelectedValue().toString();
        }
        else{s= null;}
        
        jList2.clearSelection();
        
       return s;
    }
    
    public String seleccionadoTorneio3(){
        String s;
        
        if (jList3.getSelectedIndex() != -1){
            s = jList3.getSelectedValue().toString();
        }
        else{s= null;}
        
        jList3.clearSelection();
        
       return s;
    }
    
    public APEF getSistema() {
        return this.sistema;
    }
    
    public void setUser(Utilizador user) {
        this.user = user;
    }
    
    public Utilizador getUtilizador() {
        return this.user;
    }
            
    
    private void pesquisar() {
        
    }
    
    /* TAB ESCOLAS */
    public void reloadListaEscolas() {
        Set<String> lesc = this.sistema.listaEscolas();
        DefaultListModel<String> str = new DefaultListModel<>();
        
        for(String e : lesc) 
            str.addElement(e);
       
        listaEscolas.setModel(str);
    }
    
    public String devolveSeleccionadosEscolas() {
        return (listaEscolas.getSelectedIndex() != -1) ? (listaEscolas.getSelectedValue().toString()) : null ; 
   
    }
    
    /* UTILS */
    public JPanel devolveHeader() {
        return this.JPanelHeader;
    }
    
    public JPanel devolveSearchPanel() {
        return this.searchPanel;
    }
    
    public JPanel devolveUserConvidado() {
        return this.JPanelUserLogout;
    }
    
    /* TAB CAMPEONATO */
    public void reloadPagInicialCampeonato() {
        this.jPanel8.removeAll();
        this.jPanel8.add(this.headerCampeonato, BorderLayout.NORTH);
        this.jPanel8.add(this.panelMelhoresMarcadores, BorderLayout.EAST);           
        this.jPanel8.add(new JCampeonatoClassificacao(this,user,this.ano),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();    
    }    
    
    public void reloadButtonJornada() {
        this.jPanel8.removeAll();
        this.jPanel8.add(this.headerCampeonato, BorderLayout.NORTH);
        this.jPanel8.add(this.panelMelhoresMarcadores, BorderLayout.EAST);
        this.jPanel8.add(new JCampeonatoJornadas(this,user),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();
    } 
    
    public void reloadButtonEstatistica() {
        this.jPanel8.removeAll();
        this.jPanel8.add(this.headerCampeonato, BorderLayout.NORTH);
        this.jPanel8.add(this.panelMelhoresMarcadores, BorderLayout.EAST);
        this.jPanel8.add(new JCampeonatoEstatistica(this,user,this.ano),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();
    }
    
    public void reloadButtonCalendario() {
        this.jPanel8.removeAll();
        this.jPanel8.add(this.headerCampeonato, BorderLayout.NORTH);
        this.jPanel8.add(this.panelMelhoresMarcadores, BorderLayout.EAST);
        this.jPanel8.add(new JCampeonatoCalendario(this,user,this.ano),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();
    }
    
    public void reloadPagIncialHome() { 
        //Últimos Resultados
        ArrayList<Jogo> ures = this.sistema.jogosRealizados(15);
        
        Object[] columnNames = new String[] {"Casa","Golos","Golos","Fora"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);

        for(Jogo j : ures) {
            x.addRow(new Object[]{j.getEscalaoCasa().getNomeEquipa(),j.getNumGolosJogoCasa(),j.getNumGolosJogoFora(),j.getEscalaoFora().getNomeEquipa()});
        }
        JTabResultados.setModel(x);        
        
        //Próximos Jogos
        ArrayList<Jogo> pjogos = this.sistema.proximosJogos(15);
        columnNames = new String[] {"Casa","Dia","Fora"};
        data = new Object[][] {};
        x = new DefaultTableModel(data, columnNames);
        
        
        for(Jogo j :pjogos) {
            x.addRow(new Object[]{j.getEscalaoCasa().getNomeEquipa(),"vs",j.getEscalaoFora().getNomeEquipa()});
        }
        jTabProximos.setModel(x);
    }
    
    /*TAB TORNEIOS*/
    public void reloadTorneios(){
        for(Integer an : this.sistema.getEpocas().keySet()) {
            this.comboEpocas.addItem(an+"/"+(an+1));
            this.ano = an;
        } 
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelHeader = new javax.swing.JPanel();
        TitleHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        data = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JPanelUserLogout = new javax.swing.JPanel();
        registar = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        JTabEscolas = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTabResultados = new org.jdesktop.swingx.JXTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabProximos = new org.jdesktop.swingx.JXTable();
        JPanelEscolaConvidado = new javax.swing.JPanel();
        panelListaEscolas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEscolas = new javax.swing.JList<String>();
        botoesConvidadoEscola = new javax.swing.JPanel();
        consultaEscola = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        headerCampeonato = new javax.swing.JPanel();
        campNome = new javax.swing.JLabel();
        jComboEpocaCampeonato = new javax.swing.JComboBox<String>();
        jPanel1 = new javax.swing.JPanel();
        buttonClassificacao = new javax.swing.JButton();
        jButtonEstatistica = new javax.swing.JButton();
        jButtonCalendario = new javax.swing.JButton();
        jComboEpocaCampeonato2 = new javax.swing.JComboBox<String>();
        inscreverCamp = new javax.swing.JButton();
        IniciarCamp = new javax.swing.JButton();
        criarCamp = new javax.swing.JButton();
        panelMelhoresMarcadores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelAlteracaoesCamp = new javax.swing.JPanel();
        Torneios = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboEpocas = new javax.swing.JComboBox<String>();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelHeader.setLayout(new java.awt.BorderLayout());

        TitleHeader.setBackground(new java.awt.Color(102, 102, 102));
        TitleHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Associação Portuguesa de Escolas de Futebol");

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        javax.swing.GroupLayout TitleHeaderLayout = new javax.swing.GroupLayout(TitleHeader);
        TitleHeader.setLayout(TitleHeaderLayout);
        TitleHeaderLayout.setHorizontalGroup(
            TitleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleHeaderLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TitleHeaderLayout.setVerticalGroup(
            TitleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleHeaderLayout.createSequentialGroup()
                .addGroup(TitleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TitleHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        JPanelHeader.add(TitleHeader, java.awt.BorderLayout.PAGE_START);

        searchPanel.setPreferredSize(new java.awt.Dimension(1022, 52));

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolas", "Jogadores" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(97, 29));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jXSearchField1.setText("Search");
        jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXSearchField1ActionPerformed(evt);
            }
        });
        jXSearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jXSearchField1KeyPressed(evt);
            }
        });

        data.setText("data");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Data:");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(30, 30, 30))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        JPanelHeader.add(searchPanel, java.awt.BorderLayout.PAGE_END);

        JPanelUserLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        registar.setText("Registar");
        registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarActionPerformed(evt);
            }
        });

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelUserLogoutLayout = new javax.swing.GroupLayout(JPanelUserLogout);
        JPanelUserLogout.setLayout(JPanelUserLogoutLayout);
        JPanelUserLogoutLayout.setHorizontalGroup(
            JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelUserLogoutLayout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(registar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        JPanelUserLogoutLayout.setVerticalGroup(
            JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelUserLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(registar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        JPanelHeader.add(JPanelUserLogout, java.awt.BorderLayout.CENTER);

        getContentPane().add(JPanelHeader, java.awt.BorderLayout.PAGE_START);

        JTabEscolas.setBackground(new java.awt.Color(255, 255, 255));
        JTabEscolas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        JTabEscolas.setFocusable(false);
        JTabEscolas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Últimos Resultados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Próximos Jogos");

        JTabResultados.setBackground(new java.awt.Color(240, 240, 240));
        JTabResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"FCP",  new Integer(2),  new Integer(1), "SLB"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Equipa Casa", "Golos", "Golos", "Equipa Fora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTabResultados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTabResultados.setEditable(false);
        JTabResultados.setRowHeight(20);
        JTabResultados.setRowMargin(2);
        JTabResultados.setShowGrid(true);
        JTabResultados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTabResultados);
        if (JTabResultados.getColumnModel().getColumnCount() > 0) {
            JTabResultados.getColumnModel().getColumn(0).setResizable(false);
            JTabResultados.getColumnModel().getColumn(0).setHeaderValue("Equipa Casa");
            JTabResultados.getColumnModel().getColumn(1).setPreferredWidth(37);
            JTabResultados.getColumnModel().getColumn(1).setMaxWidth(37);
            JTabResultados.getColumnModel().getColumn(1).setHeaderValue("Golos");
            JTabResultados.getColumnModel().getColumn(2).setPreferredWidth(37);
            JTabResultados.getColumnModel().getColumn(2).setMaxWidth(37);
            JTabResultados.getColumnModel().getColumn(2).setHeaderValue("Golos");
            JTabResultados.getColumnModel().getColumn(3).setResizable(false);
            JTabResultados.getColumnModel().getColumn(3).setHeaderValue("Equipa Fora");
        }

        jTabProximos.setBackground(new java.awt.Color(240, 240, 240));
        jTabProximos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Equipa Casa", "Dia", "Equipa Visitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabProximos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTabProximos.setColumnMargin(2);
        jTabProximos.setEditable(false);
        jTabProximos.setEditingColumn(1);
        jTabProximos.setEditingRow(1);
        jTabProximos.setName(""); // NOI18N
        jTabProximos.setRowHeight(20);
        jTabProximos.setRowMargin(2);
        jTabProximos.setShowGrid(true);
        jTabProximos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTabProximos);
        if (jTabProximos.getColumnModel().getColumnCount() > 0) {
            jTabProximos.getColumnModel().getColumn(0).setResizable(false);
            jTabProximos.getColumnModel().getColumn(1).setResizable(false);
            jTabProximos.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        JTabEscolas.addTab("Home", jPanel6);

        JPanelEscolaConvidado.setBackground(new java.awt.Color(255, 255, 255));
        JPanelEscolaConvidado.setLayout(new java.awt.BorderLayout());

        panelListaEscolas.setBackground(new java.awt.Color(255, 255, 255));
        panelListaEscolas.setPreferredSize(new java.awt.Dimension(500, 450));

        listaEscolas.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        listaEscolas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaEscolas);

        javax.swing.GroupLayout panelListaEscolasLayout = new javax.swing.GroupLayout(panelListaEscolas);
        panelListaEscolas.setLayout(panelListaEscolasLayout);
        panelListaEscolasLayout.setHorizontalGroup(
            panelListaEscolasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaEscolasLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelListaEscolasLayout.setVerticalGroup(
            panelListaEscolasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaEscolasLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        JPanelEscolaConvidado.add(panelListaEscolas, java.awt.BorderLayout.LINE_START);

        botoesConvidadoEscola.setBackground(new java.awt.Color(248, 247, 247));

        consultaEscola.setText("Consultar");
        consultaEscola.setPreferredSize(new java.awt.Dimension(100, 30));
        consultaEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaEscolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoesConvidadoEscolaLayout = new javax.swing.GroupLayout(botoesConvidadoEscola);
        botoesConvidadoEscola.setLayout(botoesConvidadoEscolaLayout);
        botoesConvidadoEscolaLayout.setHorizontalGroup(
            botoesConvidadoEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesConvidadoEscolaLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(consultaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        botoesConvidadoEscolaLayout.setVerticalGroup(
            botoesConvidadoEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesConvidadoEscolaLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(consultaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        JPanelEscolaConvidado.add(botoesConvidadoEscola, java.awt.BorderLayout.LINE_END);

        JTabEscolas.addTab("Escolas", JPanelEscolaConvidado);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new java.awt.BorderLayout());

        headerCampeonato.setBackground(new java.awt.Color(255, 255, 255));

        campNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campNome.setForeground(new java.awt.Color(102, 102, 102));
        campNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campNome.setText("Campeonato");

        jComboEpocaCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEpocaCampeonatoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonClassificacao.setBackground(new java.awt.Color(255, 255, 255));
        buttonClassificacao.setText("Classificação");
        buttonClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClassificacaoActionPerformed(evt);
            }
        });

        jButtonEstatistica.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEstatistica.setText("Estatística");
        jButtonEstatistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstatisticaActionPerformed(evt);
            }
        });

        jButtonCalendario.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCalendario.setText("Calendário");
        jButtonCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(buttonClassificacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEstatistica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClassificacao)
                    .addComponent(jButtonEstatistica)
                    .addComponent(jButtonCalendario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboEpocaCampeonato2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Infantis", "Benjamis", "Traquinas", "Petizes" }));

        inscreverCamp.setText("Inscrever Plantel");
        inscreverCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscreverCampActionPerformed(evt);
            }
        });

        IniciarCamp.setText("Iniciar");
        IniciarCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarCampActionPerformed(evt);
            }
        });

        criarCamp.setText("Criar");
        criarCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarCampActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerCampeonatoLayout = new javax.swing.GroupLayout(headerCampeonato);
        headerCampeonato.setLayout(headerCampeonatoLayout);
        headerCampeonatoLayout.setHorizontalGroup(
            headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerCampeonatoLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(campNome, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(jComboEpocaCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboEpocaCampeonato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(headerCampeonatoLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(criarCamp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarCamp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(inscreverCamp)
                .addGap(39, 39, 39))
        );
        headerCampeonatoLayout.setVerticalGroup(
            headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerCampeonatoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEpocaCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campNome)
                    .addComponent(jComboEpocaCampeonato2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerCampeonatoLayout.createSequentialGroup()
                        .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inscreverCamp)
                            .addComponent(IniciarCamp)
                            .addComponent(criarCamp))
                        .addContainerGap())))
        );

        jPanel8.add(headerCampeonato, java.awt.BorderLayout.PAGE_START);

        panelMelhoresMarcadores.setBackground(new java.awt.Color(255, 255, 255));
        panelMelhoresMarcadores.setBorder(javax.swing.BorderFactory.createTitledBorder("Melhores Jogadores"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "ssssssssssssssssssss",  new Integer(2)},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Jogadores", "Nº Golos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(26);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(26);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(26);
        }

        javax.swing.GroupLayout panelMelhoresMarcadoresLayout = new javax.swing.GroupLayout(panelMelhoresMarcadores);
        panelMelhoresMarcadores.setLayout(panelMelhoresMarcadoresLayout);
        panelMelhoresMarcadoresLayout.setHorizontalGroup(
            panelMelhoresMarcadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMelhoresMarcadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMelhoresMarcadoresLayout.setVerticalGroup(
            panelMelhoresMarcadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );

        jPanel8.add(panelMelhoresMarcadores, java.awt.BorderLayout.LINE_END);

        panelAlteracaoesCamp.setBackground(new java.awt.Color(255, 255, 255));
        panelAlteracaoesCamp.setMaximumSize(new java.awt.Dimension(703, 338));
        panelAlteracaoesCamp.setMinimumSize(new java.awt.Dimension(703, 338));
        panelAlteracaoesCamp.setPreferredSize(new java.awt.Dimension(703, 338));
        panelAlteracaoesCamp.setLayout(new java.awt.BorderLayout());
        jPanel8.add(panelAlteracaoesCamp, java.awt.BorderLayout.CENTER);

        JTabEscolas.addTab("Campeonatos", jPanel8);

        Torneios.setBackground(new java.awt.Color(255, 255, 255));
        Torneios.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Lista de Torneios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(415, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(256, 256, 256)
                .addComponent(comboEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        Torneios.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(940, 83));
        jPanel3.setPreferredSize(new java.awt.Dimension(940, 83));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel3, java.awt.BorderLayout.CENTER);

        Torneios.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Torneios acabados");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Torneios a decorrer");

        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList3);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Torneios futuros");

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Torneios.add(jPanel7, java.awt.BorderLayout.CENTER);

        JTabEscolas.addTab("Torneios", Torneios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabEscolas, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JTabEscolas, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXSearchField1ActionPerformed

    private void registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarActionPerformed
        JDialog frame = new JRegistar(this);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_registarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jXSearchField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXSearchField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pesquisar();
        }
    }//GEN-LAST:event_jXSearchField1KeyPressed

    private void consultaEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaEscolaActionPerformed
        // TODO add your handling code here:
        String str = devolveSeleccionadosEscolas();
        
        if(str != null) {
            JFrame frame = new ConsultasEscola(this,str);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } 
    }//GEN-LAST:event_consultaEscolaActionPerformed

    private void jButtonEstatisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstatisticaActionPerformed
        // TODO add your handling code here:
        reloadButtonEstatistica();
    }//GEN-LAST:event_jButtonEstatisticaActionPerformed

    private void jButtonCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarioActionPerformed
        // TODO add your handling code here:
        reloadButtonCalendario();
    }//GEN-LAST:event_jButtonCalendarioActionPerformed

    private void buttonClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClassificacaoActionPerformed
        // TODO add your handling code here:
        reloadPagInicialCampeonato();
    }//GEN-LAST:event_buttonClassificacaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String s = seleccionadoTorneio1();
        
        if(s != null) {
            JFrame frame = new JTorneioInfo(this,s);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String s = seleccionadoTorneio2();
        
        if(s != null) {
            JFrame frame = new JTorneioInfo(this,s);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String s = seleccionadoTorneio3();
        
        if(s != null) {
            JFrame frame = new JTorneioInfo(this,s);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /* Janela Para Fazer Login */ 
    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        JDialog frame = new JEntrar(this);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_entrarActionPerformed

    private void criarCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarCampActionPerformed
        // TODO add your handling code here:
        String anos = (String) this.jComboEpocaCampeonato.getSelectedItem();
        String[] ano = anos.split("/");
        int a = Integer.parseInt(ano[0]); System.out.println("ANO EPOCA - "+a);

        JDialog frame = new JCriarCampeonato(this, this.user,a);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_criarCampActionPerformed

    private void inscreverCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscreverCampActionPerformed
        // TODO add your handling code here:
        GregorianCalendar g = new GregorianCalendar();
        int anos = g.get(g.YEAR);
        
        if(!this.sistema.getEpocas().containsKey(anos))
            anos--;
        
        JDialog frame = new JInscreverCampeonato(this,anos);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);        
    }//GEN-LAST:event_inscreverCampActionPerformed

    private void jComboEpocaCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEpocaCampeonatoActionPerformed
        // TODO add your handling code here:
        String anos = (String) this.jComboEpocaCampeonato.getSelectedItem();
        String[] ano = anos.split("/");
        int a = Integer.parseInt(ano[0]); System.out.println("ANO EPOCA COMBOBOX - "+a);
        this.ano = a;
        
        reloadPagInicialCampeonato();
    }//GEN-LAST:event_jComboEpocaCampeonatoActionPerformed

    private void IniciarCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarCampActionPerformed
        // TODO add your handling code here:
        
        String anos = (String) this.jComboEpocaCampeonato.getSelectedItem();
        String[] ano = anos.split("/");
        int a = Integer.parseInt(ano[0]); System.out.println("ANO EPOCA COMBOBOX - "+a);
        this.ano = a;
        
        JDialog frame = new jIniciarCampeonato(this,a);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_IniciarCampActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
		try {
                    final Home2 frame = new Home2();		
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
                    if(isMac())
			enableOSXFullscreen(frame);
					
                    frame.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    }
		}
            });
    }
    
    
    public static boolean isMac() {
	return (OS.indexOf("mac") >= 0);
    }

    public static void enableOSXFullscreen(Window window) {
        try {
            Class<?> util = Class.forName("com.apple.eawt.FullScreenUtilities");
            Class<?> params[] = new Class[] { Window.class, Boolean.TYPE };
            Method method = util.getMethod("setWindowCanFullScreen", params);
            method.invoke(util, window, true);
        } catch (ClassNotFoundException exp) {
	} catch (Exception exp) {
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IniciarCamp;
    private javax.swing.JPanel JPanelEscolaConvidado;
    private javax.swing.JPanel JPanelHeader;
    private javax.swing.JPanel JPanelUserLogout;
    private javax.swing.JTabbedPane JTabEscolas;
    private org.jdesktop.swingx.JXTable JTabResultados;
    private javax.swing.JPanel TitleHeader;
    private javax.swing.JPanel Torneios;
    private javax.swing.JLabel avatar;
    private javax.swing.JPanel botoesConvidadoEscola;
    private javax.swing.JButton buttonClassificacao;
    private javax.swing.JLabel campNome;
    private javax.swing.JComboBox<String> comboEpocas;
    private javax.swing.JButton consultaEscola;
    private javax.swing.JButton criarCamp;
    private javax.swing.JLabel data;
    private javax.swing.JButton entrar;
    private javax.swing.JPanel headerCampeonato;
    private javax.swing.JButton inscreverCamp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCalendario;
    private javax.swing.JButton jButtonEstatistica;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboEpocaCampeonato;
    private javax.swing.JComboBox<String> jComboEpocaCampeonato2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXTable jTabProximos;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JList<String> listaEscolas;
    private javax.swing.JPanel panelAlteracaoesCamp;
    private javax.swing.JPanel panelListaEscolas;
    private javax.swing.JPanel panelMelhoresMarcadores;
    private javax.swing.JButton registar;
    private javax.swing.JPanel searchPanel;
    // End of variables declaration//GEN-END:variables
}
