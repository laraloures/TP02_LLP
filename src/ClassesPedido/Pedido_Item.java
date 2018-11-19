/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPedido;

/**
 *
 * @author Nelore
 */
public class Pedido_Item {
    
        private int item_qtd;
        private Servico_Prestador servico;

        public Pedido_Item(int item_qtd, Servico_Prestador servico) {
            this.item_qtd = item_qtd;
            this.servico = servico;
        }
        public Pedido_Item(){}
        
        public int getItem_qtd() {
            return item_qtd;
        }

        public void setItem_qtd(int item_qtd) {
            this.item_qtd = item_qtd;
        }

        public Servico_Prestador getServico() {
            return servico;
        }

        public void setServico(Servico_Prestador servico) {
            this.servico = servico;
        }
        
        
    
}
