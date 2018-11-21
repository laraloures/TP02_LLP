/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import ClassesPedido.Pedido;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nelore
 */
public class VerPedido extends javax.swing.JFrame {
    
    private Pedido pedido;
    private String viewMode;
    
    DefaultListModel model;
    /**
     * Creates new form VerPedido
     */
    public VerPedido(Pedido pedido, String viewMode) {
        this.pedido = pedido;
        this.viewMode = viewMode;
        
        model = new DefaultListModel();
        
        //gambs
        String shortName;
        String shortPrestador;
        String statusServico;
        
        //another gambs
        for(int i=0; i<pedido.getItem_list().size(); i++) {
            pedido.setValor_total(pedido.getValor_total()+(pedido.getItem_list().get(i).getItem_qtd()*pedido.getItem_list().get(i).getServico().getValor()));
        }
        
        
        if(viewMode.equals("Pedido aberto")){
            for(int i=0; i < pedido.getItem_list().size(); i++) {
                if(pedido.getItem_list().get(i).getServico().getServico().getNome().length()>20){
                    shortName = pedido.getItem_list().get(i).getServico().getServico().getNome().substring(0, 17)+"...";
                } else{
                    shortName = pedido.getItem_list().get(i).getServico().getServico().getNome();
                }
                if(pedido.getItem_list().get(i).getServico().getPrestador().getUsuario().length()>20){
                    shortPrestador = pedido.getItem_list().get(i).getServico().getPrestador().getUsuario().substring(0, 17)+"...";
                } else {
                    shortPrestador = pedido.getItem_list().get(i).getServico().getPrestador().getUsuario();
                }
                model.add(i, shortName +" | " + shortPrestador + " | " + pedido.getItem_list().get(i).getServico().getValor()+" | x"+pedido.getItem_list().get(i).getItem_qtd());
            }
        }
        if(viewMode.equals("Pedido fechado")) {
            for(int i=0; i < pedido.getItem_list().size(); i++) {
                if(pedido.getItem_list().get(i).getServico().getServico().getNome().length()>20){
                    shortName = pedido.getItem_list().get(i).getServico().getServico().getNome().substring(0, 17)+"...";
                } else{
                    shortName = pedido.getItem_list().get(i).getServico().getServico().getNome();
                }
                if(pedido.getItem_list().get(i).getServico().getPrestador().getUsuario().length()>20){
                    shortPrestador = pedido.getItem_list().get(i).getServico().getPrestador().getUsuario().substring(0, 17)+"...";
                } else {
                    shortPrestador = pedido.getItem_list().get(i).getServico().getPrestador().getUsuario();
                }
                if(pedido.getItem_list().get(i).getStatus() == 0){
                    statusServico = "Em aberto";
                } else {
                    statusServico = "Pronto";
                }
                model.add(i, shortName +" | " + shortPrestador + " | " + pedido.getItem_list().get(i).getServico().getValor()+" | x"+pedido.getItem_list().get(i).getItem_qtd() + " | "+statusServico);
            }
        }
        initComponents();
        jLabel2.setText(pedido.getNumero_pedido()+"");
        jLabel4.setText(pedido.getCliente().getUsuario());
        valorTotal.setText(pedido.getValor_total()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(752, 351));
        setResizable(false);
        setSize(new java.awt.Dimension(752, 351));

        jLabel1.setText("Número do Pedido");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setText("Cliente:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("jLabel4");

        jList1.setModel(model);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel5.setText("Valor Total:");

        valorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valorTotal.setText("jLabel6");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 49, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(6, 6, 6)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
