/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import ClassesUsuario.Administrador;
import ClassesUsuario.Cliente;
import ClassesUsuario.Profissional;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Cadastro extends javax.swing.JFrame {

    private char tipo;
    
    public Cadastro(char tipo) {
        this.tipo = tipo;
        initComponents();
        this.setLocationRelativeTo(this);
        radioCliente.setSelected(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupRadioButton = new javax.swing.ButtonGroup();
        LabelCadastro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioProf = new javax.swing.JRadioButton();
        radioCliente = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ButtonCadastro = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        confirmacaoSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelCadastro.setText("Cadastro");

        jLabel1.setText("*Nome Completo:");

        jLabel2.setText("*Usuario:");

        jLabel3.setText("*Email:");

        jLabel4.setText("*Confirmação do email:");

        jLabel5.setText("*Senha:");

        jLabel6.setText("*Confirmação da senha:");

        GroupRadioButton.add(radioAdmin);
        radioAdmin.setText("Administrador");
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdminActionPerformed(evt);
            }
        });

        GroupRadioButton.add(radioProf);
        radioProf.setText("Profissional");

        GroupRadioButton.add(radioCliente);
        radioCliente.setText("Cliente");

        jLabel7.setText("*Tipo da Conta:");

        ButtonCadastro.setText("Cadastrar");
        ButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastroActionPerformed(evt);
            }
        });

        jLabel8.setText("Campos que começam com * são obrigatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(ButtonCadastro))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(radioAdmin))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jTextField4)
                                .addComponent(jTextField3)
                                .addComponent(jTextField2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioProf)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioCliente))
                                .addComponent(senha)
                                .addComponent(confirmacaoSenha)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LabelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(confirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAdmin)
                    .addComponent(radioProf)
                    .addComponent(radioCliente))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCadastro)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdminActionPerformed
        if(tipo != 'a'){
            JOptionPane.showConfirmDialog(null,
                "Para criar uma conta de administrador, você deverá fazer o login como administrador",
                "Conta Administrador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
            radioCliente.setSelected(true);
        }
        
    }//GEN-LAST:event_radioAdminActionPerformed

    private void ButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastroActionPerformed
       if(jTextField1.getText().equals("")){
            JOptionPane.showConfirmDialog(null,
                "*Nome Completo* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       } else if(jTextField2.getText().equals("")){
             JOptionPane.showConfirmDialog(null,
                "*Usuario* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       } else if(jTextField3.getText().equals("")){
            JOptionPane.showConfirmDialog(null,
                "*Email* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       } else if(jTextField4.getText().equals("")){
            JOptionPane.showConfirmDialog(null,
                "*Confirmação do email* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       }else if(senha.getText().equals("")){
            JOptionPane.showConfirmDialog(null,
                "*Senha* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       }else if(confirmacaoSenha.getText().equals("")){
            JOptionPane.showConfirmDialog(null,
                "*Confirmação da senha* é obrigatorio",
                "Campo Obrigatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
       } else {
           if(!jTextField3.getText().equals(jTextField4.getText())){
                JOptionPane.showConfirmDialog(null,
                    "Email e confirmação do email estão com valores diferente",
                    "Email incorreto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );
           } else if(!senha.getText().equals(confirmacaoSenha.getText())){
                JOptionPane.showConfirmDialog(null,
                    "Senha e confirmação da senha estão com valores diferente",
                    "Senha incorreta",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );
           }
       }
       if(radioCliente.isSelected()|| tipo == 'c'){
           Cliente c = new Cliente (jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),senha.getText());
           c.criarUsuario("Cliente");
           Login l = new Login('c');
           this.setVisible(false);
       } else if(radioProf.isSelected() || tipo == 'p'){
           Profissional p = new Profissional (jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),senha.getText());
           p.criarUsuario("Profissional");
           Login l = new Login('p');
           this.setVisible(false);
       } else if(radioAdmin.isSelected() || tipo == 'a'){
           Administrador a = new Administrador (jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),senha.getText());
           a.criarUsuario("Admnistrador");
           Login l = new Login('a');
           this.setVisible(false);
       }
    }//GEN-LAST:event_ButtonCadastroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadastro;
    private javax.swing.ButtonGroup GroupRadioButton;
    private javax.swing.JLabel LabelCadastro;
    private javax.swing.JPasswordField confirmacaoSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioCliente;
    private javax.swing.JRadioButton radioProf;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
