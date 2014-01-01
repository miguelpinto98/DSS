package GUI;

import Business_Layer.APEF;
import Business_Layer.Utilizador;
import Business_Layer.Admin;
import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Campo;
import Business_Layer.DadosEstatisticos;
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
import GUI.Escola.EscolasMenuAdmin;
import GUI.Header.JEntrar;
import GUI.Header.JMenuAdmin;
import GUI.Header.JMenuArbitro;
import GUI.Header.JMenuResponsavelEscola;
import GUI.Header.JRegistar;
import GUI.Torneio.JPrincipalTorneio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miguelpinto
 */
public final class Home2 extends JFrame {

    public static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean REGISTADO = false;
    public static String UTILIZADOR = null; 
    
    private APEF sistema;
    private Utilizador user;
    
    /**
     * Creates new form Home2
     */
    public Home2() {
        this.sistema = new APEF();
        this.user = null;
        
        /* ESCOLAS */
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
        
        /**TORNEIOS*/
        Torneio t1 = new Torneio("Uminho Cup",new GregorianCalendar(),new GregorianCalendar(),2,2,new Campo("UM"));
        
        
        /* EQUIPAS */
        Equipa eq1 = new Equipa("Gelbots");
        Equipa eq2 = new Equipa("LEI");
        Equipa eq3 = new Equipa("CeSIUM");
        
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq1);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq2);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq3);
        
        /* ESCALOES */
        eq3.criarEscalao(0, "Universidade do Minho", "CeSIUM","Manuel Pato", new Date(), 0, new Imagem());
        Escalao escalao2 = new Escalao(3, "CeSIUM", "Universidade do Minho");
        
        eq3.getEscaloes()[0].inserirJogador("Mário Leite", new GregorianCalendar(), 2, new Imagem());
        eq3.getEscaloes()[0].inserirJogador("Miguel Pinto",new GregorianCalendar(), 2, new Imagem());
        eq3.getEscaloes()[0].inserirJogador("Serafim Pinto", new GregorianCalendar(), 2, new Imagem());
        eq3.getEscaloes()[0].inserirJogador("Diana Lemos", new GregorianCalendar(), 2, new Imagem());
        eq3.getEscaloes()[0].inserirJogador("Mariana Medeiros", new GregorianCalendar(), 2, new Imagem());
        
        //this.sistema.getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").inserirEscalao(escalao1);
        this.sistema.getEscolas().get("Universidade do Minho").getEquipas().get("CeSIUM").inserirEscalao(escalao2);
        

        /* TESTE USERS */
        this.sistema.registarUser("maleite","pw1234","maleite@gmail.com",0);
        this.sistema.registarUser("174Miguel","pw1234","miguel@gmail.com",1);
        this.sistema.registarUser("63linda","pw1234","63@gmail.com",2);
        this.sistema.registarUser("diana","pw1234","demossbb@gmail.com",2);
        this.sistema.registarUser("serafim","pw1234","smcp@gmail.com",2);
        this.sistema.registarUser("atum","pw1234","atum@gmail.com",0);
        
        /* TESTE JOGO COM ESCALOES */
        ArrayList<Jogo> tj = new ArrayList<>();
        Escalao esc1 = new Escalao(0, "LEI", "UMINHO");
        Escalao esc2 = new Escalao(0, "ESF", "ESF");
        
        Jogo j1 = new Jogo(1000, new GregorianCalendar(2013, 12, 21), null, null, esc1, esc2);
        Jogo j2 = new Jogo(1000, new GregorianCalendar(2013, 12, 21), null, null, esc2, esc1);
        
        j2.setNumGolosJogoCasa(10);
        j2.setRealizado(true);
        
        tj.add(j1);
        tj.add(j2);
        
        /* Inicia Aplicação */
        initComponents();  
        verificaUser(user);
        this.JPanelEscolaConvidado.setBackground(new java.awt.Color(248, 247, 247));
        
        GregorianCalendar g = new GregorianCalendar();
        this.data.setText(g.get(g.DAY_OF_MONTH)+"/"+(g.get(g.MONTH)+1)+"/"+g.get(g.YEAR));
        
        /* CENTRAR UMA COLUNA
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        JTabResultados.getColumn("Dia").setCellRenderer( centerRenderer );
        */
        
        /* Últimos Resultados */
        ArrayList<Jogo> ures = this.sistema.jogosRealizados(15);
        
        Object[] columnNames = new String[] {"Casa","Golos","Golos","Fora"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);

        for(Jogo j : tj) {
            x.addRow(new Object[]{j.getEscalaoCasa().getNomeEquipa(),j.getNumGolosJogoCasa(),j.getNumGolosJogoFora(),j.getEscalaoFora().getNomeEquipa()});
        }
        JTabResultados.setModel(x); 
        
        
        /* Próximos Jogos */
        ArrayList<Jogo> pjogos = this.sistema.proximosJogos(15);
        columnNames = new String[] {"Casa","Dia","Fora"};
        data = new Object[][] {};
        x = new DefaultTableModel(data, columnNames);
        
        
        for(Jogo j : tj) {
            x.addRow(new Object[]{j.getEscalaoCasa().getNomeEquipa(),"XX",j.getEscalaoFora().getNomeEquipa()});
        }
        jTabProximos.setModel(x);
        
        /* XXXX */
        
        reloadListaEscolas();
        reloadPagInicialCampeonato();
        reloadTorneios();
    }
    
    public void verificaUser(Utilizador user) {
        if(user != null) {
            if(user instanceof Admin) {
                reloadHeaderUserAdmin();
                reloadTabEscolasAdmin();
            }
            if(user instanceof ResponsavelEscola) {
                reloadHeaderUserRespEscola();
            }
            if(user instanceof Arbitro) {
                reloadHeaderUserArbitro();
            }     
        }
        else {
            reloadHeaderConvidado();
            reloadTabEscolasConvidado();
        }
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
        this.jPanel8.add(new JCampeonatoClassificacao(this,user),BorderLayout.CENTER);
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
        this.jPanel8.add(new JCampeonatoEstatistica(this,user),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();
    }
    
    public void reloadButtonCalendario() {
        this.jPanel8.removeAll();
        this.jPanel8.add(this.headerCampeonato, BorderLayout.NORTH);
        this.jPanel8.add(this.panelMelhoresMarcadores, BorderLayout.EAST);
        this.jPanel8.add(new JCampeonatoCalendario(this,user),BorderLayout.CENTER);
        this.jPanel8.updateUI();
        this.jPanel8.validate();
    }
    
    /*TAB TORNEIOS*/
    
    public void reloadTorneios(){
        this.JTabEscolas.remove(jPanel9);
        this.JTabEscolas.add("Torneios",new JPrincipalTorneio(this,user));
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelHeader = new javax.swing.JPanel();
        TitleHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        data = new javax.swing.JLabel();
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
        jLabel5 = new javax.swing.JLabel();
        jComboEpocaCampeonato = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        buttonClassificacao = new javax.swing.JButton();
        jButtonJornada = new javax.swing.JButton();
        jButtonEstatistica = new javax.swing.JButton();
        jButtonCalendario = new javax.swing.JButton();
        jComboEpocaCampeonato2 = new javax.swing.JComboBox();
        panelMelhoresMarcadores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelAlteracaoesCamp = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboEpocaCampeonato1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelHeader.setLayout(new java.awt.BorderLayout());

        TitleHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Associação Portuguesa de Escolas de Futebol");

        javax.swing.GroupLayout TitleHeaderLayout = new javax.swing.GroupLayout(TitleHeader);
        TitleHeader.setLayout(TitleHeaderLayout);
        TitleHeaderLayout.setHorizontalGroup(
            TitleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitleHeaderLayout.setVerticalGroup(
            TitleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPanelHeader.add(TitleHeader, java.awt.BorderLayout.PAGE_START);

        searchPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(data)))
                .addContainerGap())
        );

        JPanelHeader.add(searchPanel, java.awt.BorderLayout.PAGE_END);

        JPanelUserLogout.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addGap(639, 639, 639)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(registar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        JPanelUserLogoutLayout.setVerticalGroup(
            JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelUserLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(entrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        JPanelHeader.add(JPanelUserLogout, java.awt.BorderLayout.CENTER);

        getContentPane().add(JPanelHeader, java.awt.BorderLayout.PAGE_START);

        JTabEscolas.setBackground(new java.awt.Color(255, 255, 255));
        JTabEscolas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        JTabEscolas.setFocusable(false);
        JTabEscolas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(248, 247, 247));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Últimos Resultados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        JTabEscolas.addTab("Home", jPanel6);

        JPanelEscolaConvidado.setBackground(new java.awt.Color(255, 255, 255));
        JPanelEscolaConvidado.setLayout(new java.awt.BorderLayout());

        panelListaEscolas.setBackground(new java.awt.Color(248, 247, 247));
        panelListaEscolas.setPreferredSize(new java.awt.Dimension(500, 450));

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
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(consultaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        JPanelEscolaConvidado.add(botoesConvidadoEscola, java.awt.BorderLayout.LINE_END);

        JTabEscolas.addTab("Escolas", JPanelEscolaConvidado);

        jPanel8.setBackground(new java.awt.Color(248, 247, 247));
        jPanel8.setLayout(new java.awt.BorderLayout());

        headerCampeonato.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Campeonato");

        jComboEpocaCampeonato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Época", " " }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonClassificacao.setBackground(new java.awt.Color(255, 255, 255));
        buttonClassificacao.setText("Classificação");
        buttonClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClassificacaoActionPerformed(evt);
            }
        });

        jButtonJornada.setBackground(new java.awt.Color(255, 255, 255));
        jButtonJornada.setText("Jornadas");
        jButtonJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJornadaActionPerformed(evt);
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
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(buttonClassificacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEstatistica, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClassificacao)
                    .addComponent(jButtonJornada)
                    .addComponent(jButtonEstatistica)
                    .addComponent(jButtonCalendario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboEpocaCampeonato2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "escalao 1", "escalao 3", "escalao4", " " }));

        javax.swing.GroupLayout headerCampeonatoLayout = new javax.swing.GroupLayout(headerCampeonato);
        headerCampeonato.setLayout(headerCampeonatoLayout);
        headerCampeonatoLayout.setHorizontalGroup(
            headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerCampeonatoLayout.createSequentialGroup()
                .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerCampeonatoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboEpocaCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerCampeonatoLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(jComboEpocaCampeonato2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        headerCampeonatoLayout.setVerticalGroup(
            headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerCampeonatoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEpocaCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerCampeonatoLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerCampeonatoLayout.createSequentialGroup()
                        .addComponent(jComboEpocaCampeonato2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        jPanel8.add(panelMelhoresMarcadores, java.awt.BorderLayout.LINE_END);

        panelAlteracaoesCamp.setBackground(new java.awt.Color(255, 255, 255));
        panelAlteracaoesCamp.setMaximumSize(new java.awt.Dimension(703, 338));
        panelAlteracaoesCamp.setMinimumSize(new java.awt.Dimension(703, 338));
        panelAlteracaoesCamp.setPreferredSize(new java.awt.Dimension(703, 338));

        javax.swing.GroupLayout panelAlteracaoesCampLayout = new javax.swing.GroupLayout(panelAlteracaoesCamp);
        panelAlteracaoesCamp.setLayout(panelAlteracaoesCampLayout);
        panelAlteracaoesCampLayout.setHorizontalGroup(
            panelAlteracaoesCampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        panelAlteracaoesCampLayout.setVerticalGroup(
            panelAlteracaoesCampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel8.add(panelAlteracaoesCamp, java.awt.BorderLayout.CENTER);

        JTabEscolas.addTab("Campeonatos", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Lista de Torneios");

        jComboEpocaCampeonato1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Época" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(185, 185, 185)
                .addComponent(jComboEpocaCampeonato1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboEpocaCampeonato1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        JTabEscolas.addTab("Torneios", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabEscolas, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JTabEscolas)
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

    /* Janela Para Fazer Login */
    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        JDialog frame = new JEntrar(this);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_entrarActionPerformed

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

    private void jButtonJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJornadaActionPerformed
        // TODO add your handling code here:
        reloadButtonJornada();
    }//GEN-LAST:event_jButtonJornadaActionPerformed

    private void buttonClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClassificacaoActionPerformed
        // TODO add your handling code here:
        reloadPagInicialCampeonato();
    }//GEN-LAST:event_buttonClassificacaoActionPerformed

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
    private javax.swing.JPanel JPanelEscolaConvidado;
    private javax.swing.JPanel JPanelHeader;
    private javax.swing.JPanel JPanelUserLogout;
    private javax.swing.JTabbedPane JTabEscolas;
    private org.jdesktop.swingx.JXTable JTabResultados;
    private javax.swing.JPanel TitleHeader;
    private javax.swing.JPanel botoesConvidadoEscola;
    private javax.swing.JButton buttonClassificacao;
    private javax.swing.JButton consultaEscola;
    private javax.swing.JLabel data;
    private javax.swing.JButton entrar;
    private javax.swing.JPanel headerCampeonato;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCalendario;
    private javax.swing.JButton jButtonEstatistica;
    private javax.swing.JButton jButtonJornada;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboEpocaCampeonato;
    private javax.swing.JComboBox jComboEpocaCampeonato1;
    private javax.swing.JComboBox jComboEpocaCampeonato2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
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
