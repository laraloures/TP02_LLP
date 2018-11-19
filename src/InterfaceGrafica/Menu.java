/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import javax.swing.JFrame;

/**
 *
 * @author Loures
 */
public class Menu extends javax.swing.JFrame {

    private char tipoUsuario;
    private String nomeUsuario;
    private Lista servico;
    private Lista pedido;
    
    public Menu(char tipoUsuario, String nomeUsuario) {
        this.tipoUsuario = tipoUsuario;
        this.nomeUsuario = nomeUsuario;
        servico = new Lista('s', tipoUsuario, nomeUsuario);
        pedido = new Lista('p', tipoUsuario, nomeUsuario);
        initComponents();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        
        //Habilita o botão de Cadastrar Novo serviço somente se o usuário for um admin ou prestador.
        if(this.tipoUsuario == 'a' || this.tipoUsuario == 'p'){
            this.novo_servico.setVisible(true);
            if(this.tipoUsuario == 'p') {
                this.servicos_cadastrados.setVisible(true);
            }
        } else {
            this.novo_servico.setVisible(false);
            this.servicos_cadastrados.setVisible(false);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastro = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        novo_servico = new javax.swing.JMenu();
        servicos_cadastrados = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(524, 371));

        jMenu1.setText("Ferramentas");

        menuCadastro.setText("Cadastro");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastro);

        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Lista");

        jMenuItem5.setText("Pedidos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Serviços");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        novo_servico.setText("Novo Serviço");
        novo_servico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novo_servicoMouseClicked(evt);
            }
        });
        novo_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddServicoActionPerformed(evt);
            }
        });
        jMenuBar1.add(novo_servico);

        servicos_cadastrados.setText("Serviços Cadastrados");
        servicos_cadastrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicos_cadastradosMouseClicked(evt);
            }
        });
        jMenuBar1.add(servicos_cadastrados);

        setJMenuBar(jMenuBar1);

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

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        Cadastro c = new Cadastro(tipoUsuario);
        c.setVisible(true);
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.jPanel1.remove(servico);
        this.jPanel1.add(pedido);
        jPanel1.updateUI();
        this.validate();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.jPanel1.remove(pedido);
        this.jPanel1.add(servico);
        jPanel1.updateUI();
        this.validate();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void AddServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddServicoActionPerformed
        /* Tá no lugar errado, ignora
        //Abrir uma nova janela para cadastro de Novo serviço
        Cadastro_Servico cadastro_servico = new Cadastro_Servico();
        cadastro_servico.setVisible(true);
        */
        
    }//GEN-LAST:event_AddServicoActionPerformed

    private void novo_servicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novo_servicoMouseClicked
         //Abrir uma nova janela para cadastro de Novo serviço
        Cadastro_Servico cadastro_servico = new Cadastro_Servico();
        cadastro_servico.setVisible(true);
    }//GEN-LAST:event_novo_servicoMouseClicked

    private void servicos_cadastradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicos_cadastradosMouseClicked
        // TODO add your handling code here:
        Vinculo_Servico_Prestador vinculo_servico_prestador = new Vinculo_Servico_Prestador();
        vinculo_servico_prestador.setVisible(true);
    }//GEN-LAST:event_servicos_cadastradosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCadastro;
    private javax.swing.JMenu novo_servico;
    private javax.swing.JMenu servicos_cadastrados;
    // End of variables declaration//GEN-END:variables
}
