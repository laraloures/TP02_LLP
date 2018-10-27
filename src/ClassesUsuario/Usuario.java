/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsuario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Loures
 */
public  abstract class Usuario {
    protected String nome;
    protected String usuario;
    protected String email;
    protected String senha;
    
    public Usuario(String nome, String usuario, String email, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }
    
    public void criarUsuario(String tipo){
        String path = "src\\Arquivos\\Conta"+tipo+".txt";
        File arquivo = new File(path);
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                "Erro ao criar o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
            }
        }
        BufferedWriter buffWrite= null;
        try {
            buffWrite = new BufferedWriter(new FileWriter(arquivo, true));
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        try {
            buffWrite.write("Nome: "+nome);
	    buffWrite.newLine();
            buffWrite.write("Usuario: "+usuario);
	    buffWrite.newLine();
            buffWrite.write("Senha: "+senha);
	    buffWrite.newLine();
            buffWrite.write("Email: "+email); 
	    buffWrite.newLine();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao escrever o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        try {
            buffWrite.close();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao fechar o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

