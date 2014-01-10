/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Business_Layer.APEF;
import Business_Layer.Admin;
import Business_Layer.Arbitro;
import Business_Layer.Equipa;
import Business_Layer.Escalao;
import Business_Layer.Escola;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Utilizador;
import GUI.Equipa.JOpcoesAdmin;
import GUI.Escola.jPalmares;
import GUI.Header.JMenuAdmin;
import GUI.Home2;
import GUI.Plantel.JCriarPlantel;
import GUI.Plantel.JPlantelAgenda;
import GUI.Plantel.JPlantelDadosEstatisticos;
import GUI.Plantel.JPlantelJogador;
import GUI.Plantel.JPlantelTreinador;
import GUI.Plantel.JRemoverPlantel;
import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author miguelpinto
 */
public final class ConsultasEscola extends javax.swing.JFrame {

    private Home2 root;
    private Escola esc;
    private Utilizador user;
    private Escalao escalao;
    
    public ConsultasEscola(Home2 root, String str) {
        this.root = root;
        this.esc = this.root.getSistema().getEscolas().get(str);
        this.user = this.root.getUtilizador();
        
        
        
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.root.setEnabled(true);
                

        
        reloadDetalhes();
        ativarComboEscolas();
        
        String eq = (String) this.comboEquipas.getSelectedItem();
        ComboEscalao(eq);
        
        String equ = (String) this.comboEquipas.getSelectedItem();
        String esc = (String) this.comboEscalao.getSelectedItem();
        if(equ != null && esc != null)
            this.escalao = this.esc.getEquipas().get(equ).getEscaloes().get(devolveTipoEscalao(esc));
        reloadOpcaoTreinadorConvidado();
        
        verificaUser(this.user);
    }
    
    public void verificaUser(Utilizador user) {
        if(user != null) {
            if(user instanceof Admin || user instanceof ResponsavelEscola) {
                this.panelGeralEscolas.remove(this.panelOpcoesConvidado);
                this.panelGeralEscolas.add(new JOpcoesAdmin(this, this.root, this.esc,this.user,this),BorderLayout.WEST);
                this.panelGeralEscolas.updateUI();
                this.panelGeralEscolas.validate();
            }
        } else {
            reloadOpcaoTreinadorConvidado();
            reloadOpcaoJogadoresConvidado();
            //this.criarPlantel.setVisible(false);        this.panelGeralEscolas.setBorder(javax.swing.BorderFactory.createTitledBorder(esc.getNome()));

            //this.removerPlantel.setVisible(false);
        }
    }

    public void reloadDetalhes() {
        this.panelGeralEscolas.setBorder(javax.swing.BorderFactory.createTitledBorder(esc.getNome()));
        this.local.setText("Local: " +esc.getLocal());
        this.campo.setText("Campo de Jogo: " +esc.getCampo().getNome());
    }
    
    public void ativarComboEscolas() {
        for(String s : this.esc.getEquipas().keySet())
            this.comboEquipas.addItem((String) s);
    }
    
    public String devolveEscalaoTipo(int i) {
        String res=null;
        
        switch(i) {
            case 0 : res="Infantis"; break;
            case 1 : res="Benjamins"; break;
            case 2 : res="Traquinas"; break;
            case 3 : res="Petizes"; break;
        }
        return res;
    }
    
    public int devolveTipoEscalao(String i) {
        int res=-9999;
        
        switch(i) {
            case "Infantis" : res=0; break;
            case "Benjamins" : res=1; break;
            case "Traquinas" : res=2; break;
            case "Petizes" : res=3; break;
        }
        return res;
    }
    
    public void ComboEscalao(String eq) {
        DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<>();
        int res=0;
        
        if(eq != null) {
        Equipa e = this.esc.getEquipas().get(eq);
        Map<Integer, Escalao> es = e.getEscaloes();
        
        for(int i=0; i<4; i++)
            if(es.containsKey(i)) {
                dcb.addElement(devolveEscalaoTipo(i));
                res++;
            }                
        }
        
        if(res==4)
            this.criarPlantel.setVisible(false);
        
        this.comboEscalao.setModel(dcb);  
    }
    
    public void reloadOpcaoTreinadorConvidado() {
        this.jPanelPlantel.removeAll();
        this.jPanelPlantel.add(this.jPanelOpcoes, BorderLayout.NORTH);
        this.jPanelPlantel.add(new JPlantelTreinador(this.root,this.escalao,this.user));
        this.jPanelPlantel.updateUI();
        this.jPanelPlantel.validate();
    }
    
    public void reloadOpcaoJogadoresConvidado() {
        this.jPanelPlantel.removeAll();
        this.jPanelPlantel.add(this.jPanelOpcoes, BorderLayout.NORTH);
        this.jPanelPlantel.add(new JPlantelJogador(this.root, this.escalao, this.user));
        this.jPanelPlantel.updateUI();
        this.jPanelPlantel.validate();
    }
    
    public void reloadOpcaoAgendaConvidado() {
        this.jPanelPlantel.removeAll();
        this.jPanelPlantel.add(this.jPanelOpcoes, BorderLayout.NORTH);
        this.jPanelPlantel.add(new JPlantelAgenda(this.root,this.user));
        this.jPanelPlantel.updateUI();
        this.jPanelPlantel.validate();
    }
    
    public void reloadOpcaoDadosEstConvidado() {
        this.jPanelPlantel.removeAll();
        this.jPanelPlantel.add(this.jPanelOpcoes, BorderLayout.NORTH);
        this.jPanelPlantel.add(new JPlantelDadosEstatisticos(this.root,this.user));
        this.jPanelPlantel.updateUI();
        this.jPanelPlantel.validate();
    }
    
    
    /* XXX */
    public void reloadPanelEquipaGeral(String equipa) {
        ComboEscalao(equipa);
        
        String esc = (String) this.comboEscalao.getSelectedItem();
        System.out.println(esc);
        
        if(esc != null)
            this.escalao = this.esc.getEquipas().get(equipa).getEscaloes().get(devolveTipoEscalao(esc));
        else
            this.escalao = null;
        
        verificaUser(this.user);
    }
    
    public void setEscalao(Escalao e) {
        this.escalao = e;
    }
    
    public void verificaEscalaoSeleccionado(String eq, String esc) {
        if(esc != null)
            this.escalao = this.esc.getEquipas().get(eq).getEscaloes().get(devolveTipoEscalao(esc));
        else
            this.escalao = null;
        
        verificaUser(this.user);
    }
    
    public JComboBox devolveComboEscalao() {
        return this.comboEscalao;
    }
    
    
    public void verificaButtonCriar() {
        String equipa = (String) this.comboEquipas.getSelectedItem();
        int res=0;
        
        if(equipa != null) {
            Map<Integer, Escalao> escalao = this.esc.getEquipas().get(equipa).getEscaloes();
            for(int i=0; i<escalao.size(); i++)
                 if(escalao.get(i) != null)
                     res++;
            
            if(res==4)
                this.criarPlantel.setVisible(false);
            else
                this.criarPlantel.setVisible(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        panelGeralEscolas = new javax.swing.JPanel();
        jPanelDetalhesEscolaConvidado = new javax.swing.JPanel();
        local = new javax.swing.JLabel();
        campo = new javax.swing.JLabel();
        panelOpcoesConvidado = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboEquipas = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();
        palmares = new javax.swing.JButton();
        avatar = new org.jdesktop.swingx.JXImageView();
        jPanelPlantel = new javax.swing.JPanel();
        jPanelOpcoes = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboEscalao = new javax.swing.JComboBox<String>();
        jButtonTreinador = new javax.swing.JButton();
        jButtonJogadores = new javax.swing.JButton();
        jButtonAgenda = new javax.swing.JButton();
        jButtonDadosEst = new javax.swing.JButton();
        criarPlantel = new javax.swing.JButton();
        removerPlantel = new javax.swing.JButton();
        jPanelPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APEF - Menu Consultas");

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panelGeralEscolas.setBorder(javax.swing.BorderFactory.createTitledBorder("Escola XX"));
        panelGeralEscolas.setLayout(new java.awt.BorderLayout());

        jPanelDetalhesEscolaConvidado.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));

        local.setText("Local:");

        campo.setText("Campo de Jogo:");

        javax.swing.GroupLayout jPanelDetalhesEscolaConvidadoLayout = new javax.swing.GroupLayout(jPanelDetalhesEscolaConvidado);
        jPanelDetalhesEscolaConvidado.setLayout(jPanelDetalhesEscolaConvidadoLayout);
        jPanelDetalhesEscolaConvidadoLayout.setHorizontalGroup(
            jPanelDetalhesEscolaConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalhesEscolaConvidadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDetalhesEscolaConvidadoLayout.setVerticalGroup(
            jPanelDetalhesEscolaConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalhesEscolaConvidadoLayout.createSequentialGroup()
                .addGroup(jPanelDetalhesEscolaConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelGeralEscolas.add(jPanelDetalhesEscolaConvidado, java.awt.BorderLayout.PAGE_START);

        panelOpcoesConvidado.setBorder(new org.jdesktop.swingx.border.IconBorder());

        jLabel4.setText("Seleccione uma Equipa");

        comboEquipas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEquipasActionPerformed(evt);
            }
        });

        palmares.setText("Palmarés");
        palmares.setToolTipText("");
        palmares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palmaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout avatarLayout = new javax.swing.GroupLayout(avatar);
        avatar.setLayout(avatarLayout);
        avatarLayout.setHorizontalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        avatarLayout.setVerticalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelOpcoesConvidadoLayout = new javax.swing.GroupLayout(panelOpcoesConvidado);
        panelOpcoesConvidado.setLayout(panelOpcoesConvidadoLayout);
        panelOpcoesConvidadoLayout.setHorizontalGroup(
            panelOpcoesConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesConvidadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcoesConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEquipas, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(palmares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelOpcoesConvidadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelOpcoesConvidadoLayout.setVerticalGroup(
            panelOpcoesConvidadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesConvidadoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEquipas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(palmares, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelGeralEscolas.add(panelOpcoesConvidado, java.awt.BorderLayout.LINE_START);

        jPanelPlantel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Plantel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelPlantel.setLayout(new java.awt.BorderLayout());

        jPanelOpcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        jLabel6.setText("Seleccione um escalão");

        comboEscalao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEscalao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEscalaoActionPerformed(evt);
            }
        });

        jButtonTreinador.setText("Treinador");
        jButtonTreinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreinadorActionPerformed(evt);
            }
        });

        jButtonJogadores.setText("Jogadores");
        jButtonJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJogadoresActionPerformed(evt);
            }
        });

        jButtonAgenda.setText("Agenda");
        jButtonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendaActionPerformed(evt);
            }
        });

        jButtonDadosEst.setText("Dados Estatisticos");
        jButtonDadosEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDadosEstActionPerformed(evt);
            }
        });

        criarPlantel.setText("Criar");
        criarPlantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarPlantelActionPerformed(evt);
            }
        });

        removerPlantel.setText("Remover");
        removerPlantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPlantelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcoesLayout = new javax.swing.GroupLayout(jPanelOpcoes);
        jPanelOpcoes.setLayout(jPanelOpcoesLayout);
        jPanelOpcoesLayout.setHorizontalGroup(
            jPanelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpcoesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButtonTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonDadosEst, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 68, Short.MAX_VALUE))
                    .addGroup(jPanelOpcoesLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEscalao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(criarPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerPlantel)
                        .addContainerGap())))
        );
        jPanelOpcoesLayout.setVerticalGroup(
            jPanelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcoesLayout.createSequentialGroup()
                .addGroup(jPanelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEscalao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criarPlantel)
                    .addComponent(removerPlantel))
                .addGap(24, 24, 24)
                .addGroup(jPanelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDadosEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButtonTreinador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        jPanelPlantel.add(jPanelOpcoes, java.awt.BorderLayout.PAGE_START);

        jLabel1.setText("jPanelPanel");

        javax.swing.GroupLayout jPanelPanelLayout = new javax.swing.GroupLayout(jPanelPanel);
        jPanelPanel.setLayout(jPanelPanelLayout);
        jPanelPanelLayout.setHorizontalGroup(
            jPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(815, Short.MAX_VALUE))
        );
        jPanelPanelLayout.setVerticalGroup(
            jPanelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jPanelPlantel.add(jPanelPanel, java.awt.BorderLayout.CENTER);

        panelGeralEscolas.add(jPanelPlantel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelGeralEscolas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboEquipasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEquipasActionPerformed
        // TODO add your handling code here:
        String equipa = this.comboEquipas.getSelectedItem().toString();
        
        reloadPanelEquipaGeral(equipa);    
    }//GEN-LAST:event_comboEquipasActionPerformed

    private void palmaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palmaresActionPerformed
        // TODO add your handling code here:
        String str = (String) this.comboEquipas.getSelectedItem();
        
        if(str != null) {
            JDialog frame = new jPalmares(this.root, this.esc.getEquipas().get(str), str);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_palmaresActionPerformed

    private void jButtonTreinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreinadorActionPerformed
        // TODO add your handling code here:
        reloadOpcaoTreinadorConvidado();
    }//GEN-LAST:event_jButtonTreinadorActionPerformed

    private void jButtonJogadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJogadoresActionPerformed
        // TODO add your handling code here:
        reloadOpcaoJogadoresConvidado();
    }//GEN-LAST:event_jButtonJogadoresActionPerformed

    private void jButtonAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendaActionPerformed
        // TODO add your handling code here:
        reloadOpcaoAgendaConvidado();
    }//GEN-LAST:event_jButtonAgendaActionPerformed

    private void jButtonDadosEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDadosEstActionPerformed
        // TODO add your handling code here:
        reloadOpcaoDadosEstConvidado();
    }//GEN-LAST:event_jButtonDadosEstActionPerformed

    private void comboEscalaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEscalaoActionPerformed
        // TODO add your handling code here:
        String escalao = (String) this.comboEscalao.getSelectedItem();
        String equipa = (String) this.comboEquipas.getSelectedItem();

        verificaEscalaoSeleccionado(equipa, escalao);
    }//GEN-LAST:event_comboEscalaoActionPerformed

    private void criarPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarPlantelActionPerformed
        // TODO add your handling code here:
        String equipa = (String) this.comboEquipas.getSelectedItem();

        if(equipa != null) {
            JDialog frame = new JCriarPlantel(this.root, this.esc, this.esc.getEquipas().get(equipa), this);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_criarPlantelActionPerformed

    private void removerPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPlantelActionPerformed
        // TODO add your handling code here:
        String equipa = (String) this.comboEquipas.getSelectedItem();
        
        System.out.println(equipa);
        if(this.escalao != null) {
            JDialog frame = new JRemoverPlantel(this.root, this.escalao, this.esc.getEquipas().get(equipa), this);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            
        }
        
    }//GEN-LAST:event_removerPlantelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXImageView avatar;
    private javax.swing.JLabel campo;
    private javax.swing.JComboBox<String> comboEquipas;
    public javax.swing.JComboBox<String> comboEscalao;
    private javax.swing.JButton criarPlantel;
    private javax.swing.JButton jButtonAgenda;
    private javax.swing.JButton jButtonDadosEst;
    private javax.swing.JButton jButtonJogadores;
    private javax.swing.JButton jButtonTreinador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDetalhesEscolaConvidado;
    private javax.swing.JPanel jPanelOpcoes;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPlantel;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel local;
    private javax.swing.JButton palmares;
    private javax.swing.JPanel panelGeralEscolas;
    private javax.swing.JPanel panelOpcoesConvidado;
    private javax.swing.JButton removerPlantel;
    // End of variables declaration//GEN-END:variables
}
