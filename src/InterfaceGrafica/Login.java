/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Utils.AcessFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Login extends javax.swing.JFrame {

    private char tipoLogin;
    private boolean menu;
    
    public Login(char tipoLogin, boolean menu) {
        this.tipoLogin = tipoLogin;
        this.menu = menu;
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelLogin = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        LabelSenha = new javax.swing.JLabel();
        ButtonEntrar = new javax.swing.JButton();
        LabelCadastrar = new javax.swing.JLabel();
        ButtonCadastrar = new javax.swing.JButton();
        fieldUsuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelLogin.setText("Login");

        LabelUsuario.setText("Usuario:");

        LabelSenha.setText("Senha:");

        ButtonEntrar.setText("Entrar");
        ButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEntrarActionPerformed(evt);
            }
        });

        LabelCadastrar.setText("Não possui cadastro?");

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });

        fieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(LabelLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LabelCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelUsuario)
                            .addComponent(LabelSenha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelLogin)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(LabelUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(fieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(LabelSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonEntrar)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCadastrar)
                    .addComponent(LabelCadastrar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEntrarActionPerformed
        if(menu){
            boolean logged = false;
            try {
               if(!logged) {
                FileReader arq;
                arq = new FileReader("src\\Arquivos\\ContaCliente.txt");
                BufferedReader lerArq = new BufferedReader(arq);
                try {
                    String linha;
                    linha = lerArq.readLine(); 
                    while (linha != null) {
                        if(linha.contains("Usuario: ")){
                            if(fieldUsuario.getText().equals(linha.split(": ")[1])){
                                String userName = linha.split(": ")[1];
                                linha = lerArq.readLine();
                                if(linha.contains("Senha: ")){
                                    if(password.getText().equals(linha.split(": ")[1])){
                                        Menu m = new Menu('c', userName);
                                        m.setVisible(true);
                                        this.setVisible(false);
                                        logged = true;
                                    }
                                }        
                            }
                        }
                        linha = lerArq.readLine(); 
                    }
                    arq = new FileReader("src\\Arquivos\\ContaProfissional.txt");
                    lerArq = new BufferedReader(arq);
                    linha = lerArq.readLine(); 
                    while (linha != null) {
                        if(linha.contains("Usuario: ")){
                            if(fieldUsuario.getText().equals(linha.split(": ")[1])){
                                String userName = linha.split(": ")[1];
                                linha = lerArq.readLine();
                                if(linha.contains("Senha: ")){
                                    if(password.getText().equals(linha.split(": ")[1])){
                                        Menu m = new Menu('p',userName);
                                        m.setVisible(true);
                                        this.setVisible(false);
                                        logged = true;
                                    }
                                }        
                            }
                        }
                        linha = lerArq.readLine(); 
                    }
                    arq = new FileReader("src\\Arquivos\\ContaAdministrador.txt");
                    lerArq = new BufferedReader(arq);
                    linha = lerArq.readLine(); 
                    while (linha != null) {
                        if(linha.contains("Usuario: ")){
                            if(fieldUsuario.getText().equals(linha.split(": ")[1])){
                                String userName = linha.split(": ")[1];
                                linha = lerArq.readLine();
                                if(linha.contains("Senha: ")){
                                    if(password.getText().equals(linha.split(": ")[1])){
                                        Menu m = new Menu('a', userName);
                                        m.setVisible(true);
                                        this.setVisible(false);
                                        logged = true;
                                    }
                                }        
                            }
                        }
                        linha = lerArq.readLine(); 
                    }
                    if(!logged)
                        JOptionPane.showMessageDialog(null, "Dados de acesso inválidos!");
                  
                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(null,
                        "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                        "Erro",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE
                    );
                }
               }
            } catch (FileNotFoundException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            FileReader arq = null;
            try {
                arq = new FileReader("src\\Arquivos\\ContaAdministrador.txt");
            } catch (FileNotFoundException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = null; 
            try {
                linha = lerArq.readLine();
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
            while (linha != null) {
                if(linha.contains("Usuario: ")){
                    if(fieldUsuario.getText().equals(linha.split(": ")[1])){
                        try {
                            linha = lerArq.readLine();
                        } catch (IOException ex) {
                           JOptionPane.showConfirmDialog(null,
                                "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                                "Erro",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE
                            );
                        }
                        if(linha.contains("Senha: ")){
                            if(password.getText().equals(linha.split(": ")[1])){
                                this.dispose();
                            }
                        }        
                    }
                }
                try { 
                    linha = lerArq.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ButtonEntrarActionPerformed

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarActionPerformed
        Cadastro c = new Cadastro('n');
        c.setVisible(true);
    }//GEN-LAST:event_ButtonCadastrarActionPerformed

    private void fieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login('n', true).setVisible(true);
                //AcessFile.lista_pedidos();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonEntrar;
    private javax.swing.JLabel LabelCadastrar;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
