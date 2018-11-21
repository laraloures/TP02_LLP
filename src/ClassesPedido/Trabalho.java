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
public class Trabalho {
    
    private int numeroPedido;
    private String prestador;
    private String nomeServico;
    private int qtd;
    private int statusServico;

    public Trabalho(int numeroPedido, String prestador, String nomeServico, int qtd, int statusServico) {
        this.numeroPedido = numeroPedido;
        this.prestador = prestador;
        this.nomeServico = nomeServico;
        this.qtd = qtd;
        this.statusServico = statusServico;
    }

    public Trabalho() {
    }

    
    
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(int statusServico) {
        this.statusServico = statusServico;
    }
    
    
}
