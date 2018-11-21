/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import ClassesPedido.Pedido;
import ClassesPedido.Servico;
import ClassesPedido.Trabalho;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import Utils.AcessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Loures
 */
public class Lista extends javax.swing.JPanel {
    private char tipoLista;
    private char tipoUsuario;
    private String nomeUsuario;
    private ArrayList<Servico> servico_list;
    private ArrayList<Pedido> pedido_list;
    private DefaultListModel model;
    
    //Vou fazer funcionar, não importa como
    private ArrayList<Trabalho> trabalho_list;
    private String convert_int_str;
    
    public Lista(char tipoLista, char tipoUsuario, String nomeUsuario) {
        this.tipoUsuario = tipoUsuario;
        this.tipoLista = tipoLista;
        this.nomeUsuario = nomeUsuario;
        model = new DefaultListModel();
        //System.out.println("tipo usuario: "+this.tipoUsuario);
        //System.out.println("tipoLista: "+this.tipoLista);
        if(this.tipoUsuario=='a'){
            if(this.tipoLista == 'p') {
                //Se for Admin, vai ver todos os pedidos
                pedido_list = AcessFile.lista_pedidos();
                for(int i=0; i<pedido_list.size(); i++){
                    if(pedido_list.get(i).getPedido_status() == 0)
                        convert_int_str = "Em aberto";
                    else
                        convert_int_str = "Pronto";
                    model.add(i, pedido_list.get(i).getNumero_pedido()+" | "+convert_int_str+" | "+pedido_list.get(i).getValor_total());
                }
            } 
            if(this.tipoLista == 's') {
                //Se for Admin, vai ver todos os serviços
                servico_list = AcessFile.lista_servicos_all();
                for(int i=0; i<servico_list.size(); i++){
                    model.add(i, servico_list.get(i).getNome());
                }
            }
        } 
        if(this.tipoUsuario == 'c'){
            if(this.tipoLista == 'p') {
                //Se for cliente, só vai ver os próprios pedidos
                pedido_list = AcessFile.lista_pedido_user(nomeUsuario);
                for(int i=0; i<pedido_list.size(); i++) {
                    if(pedido_list.get(i).getPedido_status() == 0)
                        convert_int_str = "Em aberto";
                    else
                        convert_int_str = "Pronto";
                    model.add(i, pedido_list.get(i).getNumero_pedido()+" | "+convert_int_str+" | "+pedido_list.get(i).getValor_total());
                }
            }
            if(this.tipoLista == 's') {
                //Se for cliente, só vai ver os Serviços ativos
                servico_list = AcessFile.lista_servicos_ativos();
                for(int i=0; i<servico_list.size(); i++){
                    model.add(i, servico_list.get(i).getNome());
                }
            }
        }
        if(this.tipoUsuario == 'p'){
            if(this.tipoLista == 'p'){
                //Se for Profissional, só vai ver os itens dos pedidos que ele tem que fazer.
                
                    //GAMBIARRA MUITO DA DOIDA
                    trabalho_list = AcessFile.lista_trabalho_aberto_prestador(nomeUsuario);
                    //trabalho_list = AcessFile.lista_trabalho_all();
                    for(int i=0; i<trabalho_list.size(); i++) {
                        model.add(i, trabalho_list.get(i).getNomeServico() + " | x"+trabalho_list.get(i).getQtd() +" | "+trabalho_list.get(i).getNumeroPedido());
                        //model.add(i, "a");
                    }
                
            }
            if(this.tipoLista == 's'){
                //Se for Profissional, vai ver todos os serviços habilitados
                servico_list = AcessFile.lista_servicos_ativos();
                for(int i=0; i<servico_list.size(); i++){
                    model.add(i, servico_list.get(i).getNome());
                }
            }
        }
        /*
        else {
            servico_list = AcessFile.lista_servicos_ativos();
        }
        for(int i=0; i<servico_list.size(); i++) {
            model.add(i, servico_list.get(i).getNome());
        }
        */
        initComponents();
        if(this.tipoUsuario=='p' ||this.tipoUsuario=='c' || this.tipoLista == 'p'){
            button_habilitar.setVisible(false);
        }
        if(this.tipoUsuario != 'p' || this.tipoLista == 'p') {
            button_vincular.setVisible(false);
        }
        if(this.tipoUsuario != 'c' && this.tipoLista != 'p'){
            this.verPedido.setVisible(false);
        }
        if(this.tipoLista == 's'){
            this.verPedido.setVisible(false);
        }
        if(this.tipoUsuario == 'p'){
            this.verPedido.setVisible(false);
        }
        if(this.tipoLista != 'p' || this.tipoUsuario!='p'){
            this.button_Servico_Feito.setVisible(false);
        }
        
        this.setVisible(true);
        this.tipoLista = tipoLista;
        if(tipoLista == 's') {
            jLabel1.setText("Lista de serviços");
            //ArrayList<Servico> servico_list = AcessFile.lista_servicos_all();
        }
        else 
           jLabel1.setText("Lista de pedidos");
        
        button_habilitar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        button_habilitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button_vincular = new javax.swing.JButton();
        verPedido = new javax.swing.JButton();
        button_Servico_Feito = new javax.swing.JButton();

        jList1.setModel(model);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        button_habilitar.setText("Habilitar");
        button_habilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_habilitarActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista de");

        button_vincular.setText("Agregar como Serviço");
        button_vincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_vincularActionPerformed(evt);
            }
        });

        verPedido.setText("Ver Pedido");
        verPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPedidoActionPerformed(evt);
            }
        });

        button_Servico_Feito.setText("Finalizar Servico");
        button_Servico_Feito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Servico_FeitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_vincular, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(button_habilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_Servico_Feito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_Servico_Feito)
                        .addGap(18, 18, 18)
                        .addComponent(button_habilitar)
                        .addGap(18, 18, 18)
                        .addComponent(button_vincular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verPedido)
                        .addGap(62, 62, 62))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_habilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_habilitarActionPerformed

        if(tipoUsuario == 'a') {
            if(tipoLista == 's'){
                int indice = jList1.getSelectedIndex();
                servico_list = AcessFile.lista_servicos_all();
                AcessFile.alterar_status_servico(servico_list.get(indice).getNome(), true);
                //System.out.println("Alterado!");
                /*
                //Bloco abaixo é pra teste
                model = new DefaultListModel();
                servico_list = AcessFile.lista_servicos_all();
                for(int i=0; i<servico_list.size(); i++) {
                    model.add(i, servico_list.get(i).getNome());
                }
                */
                for(int i = 0; i < jList1.getModel().getSize(); i++) {
                    if(i == indice) {
                        //texto = jList1.getSelectedValue().contains("Habilitado") ? jList1.getSelectedValue().replace("Habilitado", "Desabilitado") : jList1.getSelectedValue().replace("Desabilitado", "Habilitado");
                    } else {
                        //modelo.addElement(jList1.getModel().getElementAt(i));
                    }
                }
                //jList1.setModel(modelo);
                // salvar a nova jList no arquivo
            }
        }
    }//GEN-LAST:event_button_habilitarActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        button_habilitar.setEnabled(jList1.getSelectedIndex() != -1);
        if(tipoUsuario == 'a'){
            if(tipoLista == 's'){
                String texto = jList1.getSelectedValue().contains("Habilitado") ? "Desabilitar" : "Habilitar";
                button_habilitar.setText(texto);
            }
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void button_vincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_vincularActionPerformed
        
        //Vincular o serviço ao prestador
        if(tipoLista == 's'){
            int indice = jList1.getSelectedIndex();
            servico_list = AcessFile.lista_servicos_ativos();
            Vinculo_Servico_Prestador confirmar_vinculo = new Vinculo_Servico_Prestador(servico_list.get(indice), nomeUsuario);
            confirmar_vinculo.setVisible(true);
        }
    }//GEN-LAST:event_button_vincularActionPerformed

    private void verPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPedidoActionPerformed
        // TODO add your handling code here:
        try{
            int index = jList1.getSelectedIndex();
            VerPedido verPedido = new VerPedido(pedido_list.get(index), "Pedido fechado");
            verPedido.setVisible(true);
        } catch(ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Servico para adicionar!", "Dados incompletos", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_verPedidoActionPerformed

    private void button_Servico_FeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Servico_FeitoActionPerformed
        // Lançar o Serviço como feito
        /*Passos
            Mudar o status do serviço na classe servico
            
            Mudar o status do serviço na classe de pedidos
        
            Mudar o status do Pedido se todos os serviços estiverem prontos
            
            Tirar o último serviço finalizado dessa lista
        */
        //Passo 0: Pegar o Serviço que eu quero nessa interface
        try{
            int index = jList1.getSelectedIndex();
            trabalho_list.get(index).setStatusServico(1);
            
            //Passo 1: Mudar o status do Serviço na classe Serviço
            AcessFile.altera_status_trabalho(trabalho_list.get(index));
            
            //Passo 2: Mudar o status do serviço na classe de pedidos (dentro do objeto de serviço)
            AcessFile.altera_status_trabalho_pedido(trabalho_list.get(index));
            
            //Passo 3: Mudar o status do Pedido se todos os serviços estiverem prontos
            AcessFile.altera_status_pedido(trabalho_list.get(index).getNumeroPedido());
            
            //Passo 4: Tirar o último serviço finalizado dessa lista
            
        } catch(ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Servico para adicionar!", "Dados incompletos", JOptionPane.ERROR_MESSAGE );
        }
        
    }//GEN-LAST:event_button_Servico_FeitoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Servico_Feito;
    private javax.swing.JButton button_habilitar;
    private javax.swing.JButton button_vincular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton verPedido;
    // End of variables declaration//GEN-END:variables
}
