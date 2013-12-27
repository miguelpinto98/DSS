/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Business_Layer.APEF;
import Business_Layer.Utilizador;
import Business_Layer.Admin;
import Business_Layer.Arbitro;
import Business_Layer.Campo;
import Business_Layer.Equipa;
import Business_Layer.Escalao;
import Business_Layer.Escola;
import Business_Layer.Jogo;
import Business_Layer.ResponsavelEscola;
import GUI.Escola.EscolasMenuAdmin;
import GUI.Escola.jConsultasEscola;
import GUI.Header.JEntrar;
import GUI.Header.JMenuAdmin;
import GUI.Header.JMenuArbitro;
import GUI.Header.JMenuResponsavelEscola;
import GUI.Header.JRegistar;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
        
        /* EQUIPAS */
        Equipa eq1 = new Equipa("Gelbots");
        Equipa eq2 = new Equipa("LEI");
        Equipa eq3 = new Equipa("CeSIUM");
        
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq1);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq2);
        this.sistema.getEscolas().get("Universidade do Minho").inserirEquipa(eq3);

        /* TESTE USERS*/
        this.sistema.registarUser("maleite","pw1234","maleite@gmail.com",0,sistema);
        this.sistema.registarUser("174Miguel","pw1234","miguel@gmail.com",1,sistema);
        this.sistema.registarUser("63linda","pw1234","63@gmail.com",2,sistema);
        this.sistema.registarUser("diana","pw1234","demossbb@gmail.com",2,sistema);
        this.sistema.registarUser("serafim","pw1234","smcp@gmail.com",2,sistema);
        this.sistema.registarUser("atum","pw1234","atum@gmail.com",0,sistema);
        
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
        this.jComboBox1.setModel(new DefaultComboBoxModel<Object>(new String[]{"Escolas","Jogadores"}));
        
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
        listaEscolas = new javax.swing.JList();
        botoesConvidadoEscola = new javax.swing.JPanel();
        consultaEscola = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboEpocasCampeonato = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(639, Short.MAX_VALUE)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(registar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        JPanelUserLogoutLayout.setVerticalGroup(
            JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelUserLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelUserLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        JTabEscolas.addTab("Home", jPanel6);

        JPanelEscolaConvidado.setBackground(new java.awt.Color(255, 255, 255));
        JPanelEscolaConvidado.setLayout(new java.awt.BorderLayout());

        panelListaEscolas.setBackground(new java.awt.Color(248, 247, 247));
        panelListaEscolas.setPreferredSize(new java.awt.Dimension(500, 450));

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
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(consultaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        JPanelEscolaConvidado.add(botoesConvidadoEscola, java.awt.BorderLayout.LINE_END);

        JTabEscolas.addTab("Escolas", JPanelEscolaConvidado);

        jPanel8.setBackground(new java.awt.Color(248, 247, 247));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ComboEpocasCampeonato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Época 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Campeonato");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(255, 255, 255)
                .addComponent(ComboEpocasCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(ComboEpocasCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Melhores Jogadores"));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "", "Jogador", "Nº Golos"
            }
        ));
        jTable3.setRowHeight(26);
        jScrollPane7.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(30);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable3.getColumnModel().getColumn(1).setMinWidth(200);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable3.getColumnModel().getColumn(2).setMinWidth(60);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Classificação");

        jButton2.setText("Jornadas");

        jButton4.setText("Estatística");

        jButton5.setText("Calendário");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.getAccessibleContext().setAccessibleName("Estatística");

        jPanel8.add(jPanel3, java.awt.BorderLayout.CENTER);

        JTabEscolas.addTab("Campeonatos", jPanel8);

        jPanel9.setBackground(new java.awt.Color(248, 247, 247));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.add(jPanel4, java.awt.BorderLayout.PAGE_START);

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
                .addComponent(JTabEscolas, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
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
            JFrame frame = new jConsultasEscola(this,str);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } 
    }//GEN-LAST:event_consultaEscolaActionPerformed

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
    private javax.swing.JComboBox ComboEpocasCampeonato;
    private javax.swing.JPanel JPanelEscolaConvidado;
    private javax.swing.JPanel JPanelHeader;
    private javax.swing.JPanel JPanelUserLogout;
    private javax.swing.JTabbedPane JTabEscolas;
    private org.jdesktop.swingx.JXTable JTabResultados;
    private javax.swing.JPanel TitleHeader;
    private javax.swing.JPanel botoesConvidadoEscola;
    private javax.swing.JButton consultaEscola;
    private javax.swing.JButton entrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXTable jTabProximos;
    private javax.swing.JTable jTable3;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JList listaEscolas;
    private javax.swing.JPanel panelListaEscolas;
    private javax.swing.JButton registar;
    private javax.swing.JPanel searchPanel;
    // End of variables declaration//GEN-END:variables

}
