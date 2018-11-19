/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPedido;

import ClassesUsuario.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Nelore
 */


public class Pedido {
    
    public class Pedido_item {
        private int item_qtd;
        private Servico_Prestador servico;

        public Pedido_item(int item_qtd, Servico_Prestador servico) {
            this.item_qtd = item_qtd;
            this.servico = servico;
        }
        public Pedido_item(){}
        
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
    
    private int numero_pedido;
    public ArrayList<Pedido_item> item_list;
    private Cliente cliente;
    private double valor_total;
    private int pedido_status;

    public Pedido(int numero_pedido, Cliente cliente, int pedido_status) {
        this.numero_pedido = numero_pedido;
        this.cliente = cliente;
        this.pedido_status = pedido_status;
    }
    
    public Pedido(){}
    
    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public ArrayList<Pedido_item> getItem_list() {
        return item_list;
    }

    public void setItem_list(ArrayList<Pedido_item> item_list) {
        this.item_list = item_list;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getPedido_status() {
        return pedido_status;
    }

    public void setPedido_status(int pedido_status) {
        this.pedido_status = pedido_status;
    }
    
    
    
}
