/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsuario;

/**
 *
 * @author Loures
 */
public  abstract class Usuario {
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    
    public Usuario(String nome, String usuario, String email, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }
    
    public void criarUsuario(){}
}

