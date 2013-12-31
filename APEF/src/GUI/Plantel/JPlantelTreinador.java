/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Plantel;

import Business_Layer.Admin;
import Business_Layer.Escalao;
import Business_Layer.ResponsavelEscola;
import Business_Layer.Treinador;
import Business_Layer.Utilizador;
import GUI.Home2;
import java.awt.BorderLayout;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author miguelpinto
 */
public class JPlantelTreinador extends javax.swing.JPanel {

    private Home2 root;
    private Escalao escalao;
    private Utilizador user;

    public JPlantelTreinador(Home2 root, Escalao esc,Utilizador user) {
        this.root = root;
        this.escalao = esc;
        this.user = user;
        initComponents();
        
        if(this.escalao != null) {
            atualizaDadosTreinador(this.escalao.getTreinador());
            verificaOpcoes();
        }
        else
            atualizaDadosTreinadorNULL();
    }
    
    public void verificaOpcoes() {
        if(this.user != null) {
            if(this.user instanceof Admin || this.user instanceof ResponsavelEscola) {
                this.remove(this.jOptionsTreinador);
                this.add(new JPlantelTreinadorOpcoes(this.root, this.escalao),BorderLayout.EAST);
                this.updateUI();
                this.validate();
            }
        }
    }
    
    public void atualizaDadosTreinador(Treinador t) {
        this.nome.setText(t.getNome());
        
        GregorianCalendar g = t.getDataNasc();
        this.data.setText(g.get(g.YEAR)+"/"+(g.get(g.MONTH)+1)+"/"+g.get(g.DAY_OF_MONTH));
   
        String res=null;
        if(t.getSexo() == 0)
            res = "Não definido";
        else {
            if(t.getSexo() == 1)
                res = "Masculino";
            else
                res = "Feminino";
        }  
        this.sexo.setText(res);
    }
    
    public void atualizaDadosTreinadorNULL() {
        this.avatar.setVisible(false);
        this.data.setVisible(false);
        this.sexo.setVisible(false);
        this.nome.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jLabel2.setVisible(false);
        this.jLabel3.setVisible(false);

        JLabel text = new JLabel("Nenhum Plantel Registado Nesta Equipa!");
        this.add(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        sexo = new javax.swing.JLabel();
        jOptionsTreinador = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Treinador"));
        setLayout(new java.awt.BorderLayout());

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Data de Nascimento");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Sexo");

        nome.setText(" Manuel Quim Arraas da Ponte");

        data.setText("10/15/1900");

        sexo.setText("Não Definido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jOptionsTreinadorLayout = new javax.swing.GroupLayout(jOptionsTreinador);
        jOptionsTreinador.setLayout(jOptionsTreinadorLayout);
        jOptionsTreinadorLayout.setHorizontalGroup(
            jOptionsTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        jOptionsTreinadorLayout.setVerticalGroup(
            jOptionsTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        add(jOptionsTreinador, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jOptionsTreinador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel sexo;
    // End of variables declaration//GEN-END:variables
}
