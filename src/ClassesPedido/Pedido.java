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
    
    
    
    private int numero_pedido;
    public ArrayList<Pedido_Item> item_list;
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

    public ArrayList<Pedido_Item> getItem_list() {
        return item_list;
    }

    public void setItem_list(ArrayList<Pedido_Item> item_list) {
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
