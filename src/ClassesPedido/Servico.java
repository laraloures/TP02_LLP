/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPedido;

import ClassesUsuario.Profissional;

/**
 *
 * @author Nelore
 */
public class Servico {
    
    private String nome;
    private String descricao;
    //private double valor;
    //private Profissional prestador;
    private boolean servico_ativado;
    
    public Servico(String nome, String descricao,  boolean servico_ativado) {
        this.nome = nome;
        this.descricao = descricao;
        //this.valor = valor;
        //this.prestador = prestador;
        //O serviço sempre é inicializado como não ativado, até que um Admin o ative
        this.servico_ativado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isServico_ativado() {
        return servico_ativado;
    }

    public void setServico_ativado(boolean servico_ativado) {
        this.servico_ativado = servico_ativado;
    }
    
    
}
