/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPedido;

import ClassesUsuario.Profissional;
import ClassesUsuario.Usuario;

/**
 *
 * @author Nelore
 */
public class Servico_Prestador {
    private Servico servico;
    private Usuario prestador;
    private double valor;

    public Servico_Prestador() {
    }

    public Servico_Prestador(Servico servico, Usuario prestador, double valor) {
        this.servico = servico;
        this.prestador = prestador;
        this.valor = valor;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getPrestador() {
        return prestador;
    }

    public void setPrestador(Profissional prestador) {
        this.prestador = prestador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
