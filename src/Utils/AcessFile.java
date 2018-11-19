/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import ClassesPedido.Pedido;
import ClassesPedido.Pedido.Pedido_item;
import ClassesPedido.Servico;
import ClassesPedido.Servico_Prestador;
import ClassesUsuario.Administrador;
import ClassesUsuario.Cliente;
import ClassesUsuario.Usuario;
import InterfaceGrafica.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nelore
 */
public class AcessFile {
    
    //Funções para cadastro de Serviços
    
    public static void cadastro_servico(String nome, String descricao, boolean servico_ativado){
        String path = "src\\Arquivos\\Servico.txt";
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
            buffWrite.write("Descricao: "+descricao);
	    buffWrite.newLine();
            buffWrite.write("Status: "+servico_ativado);
	    buffWrite.newLine();
            buffWrite.write("---------"); 
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
    
    public static void limpa_arquivo() {
        String path = "src\\Arquivos\\Servico.txt";
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
            buffWrite = new BufferedWriter(new FileWriter(arquivo, false));
            
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        try {
            buffWrite.write("\n");
	    
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
    
    // Funções de Leitura de Serviços
    public static ArrayList<Servico> lista_servicos_all(){
        ArrayList<Servico> lista_servicos_all = new ArrayList();  
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Servico.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    Servico servico = new Servico();
                    if(linha.contains("Nome: ")){
                        servico.setNome(linha.substring(linha.indexOf(":")+2,linha.length()));
                        linha = lerArq.readLine();
                        if(linha.contains("Descricao: ")){
                          servico.setDescricao(linha.substring(linha.indexOf(":")+2,linha.length()));
                          linha = lerArq.readLine(); 
                          if(linha.contains("Status: ")){
                            String result = linha.substring(linha.indexOf(":")+2,linha.length());
                            if(result.equals("false")) {
                                servico.setServico_ativado(false);
                            } else {
                                servico.setServico_ativado(true);
                            }
                            linha = lerArq.readLine(); 
                            if(linha.contains("---------")){
                                lista_servicos_all.add(servico);
                            }
                          }
                        }
                    }        
                    linha = lerArq.readLine(); 
                }
                return lista_servicos_all;
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        return lista_servicos_all;
    }
    
    public static ArrayList<Servico> lista_servicos_ativos(){
        ArrayList<Servico> lista_servicos_all = new ArrayList();  
        
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Servico.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    Servico servico = new Servico();
                    boolean servico_ativo = false;
                    if(linha.contains("Nome: ")){
                        servico.setNome(linha.substring(linha.indexOf(":")+2,linha.length()));
                        linha = lerArq.readLine();
                        if(linha.contains("Descricao: ")){
                          servico.setDescricao(linha.substring(linha.indexOf(":")+2,linha.length()));
                          linha = lerArq.readLine(); 
                          if(linha.contains("Status: ")){
                            String result = linha.substring(linha.indexOf(":")+2,linha.length());
                            if(result.equals("false")) {
                                servico.setServico_ativado(false);
                            } else {
                                servico.setServico_ativado(true);
                                servico_ativo = true;
                            }
                            linha = lerArq.readLine(); 
                            if(linha.contains("---------")){
                              if(servico_ativo)
                                lista_servicos_all.add(servico);
                            }
                          }
                        }

                    }        
                    linha = lerArq.readLine(); 
                }
                return lista_servicos_all;
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        return lista_servicos_all;
    }
    
    public static ArrayList<Servico> lista_servicos_inativos(){
        ArrayList<Servico> lista_servicos = new ArrayList();  
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Servico.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    Servico servico = new Servico();
                    boolean servico_ativo = false;
                    if(linha.contains("Nome: ")){
                        servico.setNome(linha.substring(linha.indexOf(":")+2,linha.length()));
                        linha = lerArq.readLine();
                        if(linha.contains("Descricao: ")){
                          servico.setDescricao(linha.substring(linha.indexOf(":")+2,linha.length()));
                          linha = lerArq.readLine(); 
                          if(linha.contains("Status: ")){
                            String result = linha.substring(linha.indexOf(":")+2,linha.length());
                            if(result.equals("false")) {
                                servico.setServico_ativado(false);
                            } else {
                                servico.setServico_ativado(true);
                                servico_ativo = true;
                            }
                            linha = lerArq.readLine(); 
                            if(linha.contains("---------")){
                              if(!servico_ativo)
                                lista_servicos.add(servico);
                            }
                          }
                        }

                    }        
                    linha = lerArq.readLine(); 
                }
                return lista_servicos;
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        return lista_servicos;
    }
    
    //Funções para alteração de Serviços
    public static void alterar_status_servico(String nomeServico, boolean status) {
      ArrayList<Servico> servico_list = lista_servicos_all();
        
      for(int i=0; i<servico_list.size(); i++) {
        if(servico_list.get(i).getNome().equals(nomeServico)){
          servico_list.get(i).setServico_ativado(status);
        }
      }
      limpa_arquivo();
      for(int j=0; j<servico_list.size(); j++) {
        cadastro_servico(servico_list.get(j).getNome(), servico_list.get(j).getDescricao(), servico_list.get(j).isServico_ativado());
      }
        
    }
    
    public static void apaga_servico(String nomeServico) {
      ArrayList<Servico> servico_list = lista_servicos_all();
      ArrayList<Servico> servico_list_new = new ArrayList();
      for(int i=0; i<servico_list.size(); i++) {
        if(!servico_list.get(i).getNome().equals(nomeServico)){
          servico_list_new.add(servico_list.get(i));
        }
      }
      limpa_arquivo();
      for(int i=0; i<servico_list.size(); i++) {
        cadastro_servico(servico_list.get(i).getNome(), servico_list.get(i).getDescricao(), servico_list.get(i).isServico_ativado());
      }
    }
    
    // Leitura de ContaProfissional, ContaCliente, ContaAdministrador
    public static Usuario lista_conta(char tipoConta, String userName){
        try {    
            FileReader arq;
            switch(tipoConta){
                case 'a':
                    arq = new FileReader("src\\Arquivos\\ContaAdministrador.txt");
                    break;
                case 'p':
                    arq = new FileReader("src\\Arquivos\\ContaProfissional.txt");
                    break;
                case 'c':
                default:
                    arq = new FileReader("src\\Arquivos\\ContaCliente.txt");
            }
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    if(linha.contains("Nome: ")){
                        String nome = linha.substring(linha.indexOf(":")+2,linha.length());
                        linha = lerArq.readLine();
                        String usuario = linha.substring(linha.indexOf(":")+2,linha.length());
                        if(usuario.equals(userName)){
                            linha = lerArq.readLine();
                            String senha = linha.substring(linha.indexOf(":")+2,linha.length());
                            linha = lerArq.readLine();
                            String email = linha.substring(linha.indexOf(":")+2,linha.length());
                            Usuario user = new Usuario(nome, userName, email, senha) {};
                            return user;
                        }
                        linha = lerArq.readLine();
                        
                    }        
                    linha = lerArq.readLine(); 
                }
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        return null;
    }
    
    //Cadastros de servico_prestador
    
    public static void cadastro_servico_prestador(Servico_Prestador servicoPrestador) {
    
        String path = "src\\Arquivos\\Servico_Prestador.txt";
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
            buffWrite.write("Nome do Servico: "+servicoPrestador.getServico().getNome());
	    buffWrite.newLine();
            buffWrite.write("Prestador do Servico: "+servicoPrestador.getPrestador().getUsuario());
	    buffWrite.newLine();
            buffWrite.write("Valor: "+servicoPrestador.getValor());
	    buffWrite.newLine();
            buffWrite.write("---------"); 
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
    
    public static void cadastra_pedido(Pedido pedido){
        String path = "src\\Arquivos\\Pedido.txt";
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
            buffWrite.write("Numero do pedido: "+pedido.getNumero_pedido());
	    buffWrite.newLine();
            buffWrite.write("Nome do cliente: "+pedido.getCliente().getNome());
	    buffWrite.newLine();
            buffWrite.write("Lista de itens: ");
            buffWrite.newLine();
            for(int i=0; i<pedido.getItem_list().size(); i++) {
                buffWrite.write(pedido.getItem_list().get(i).getServico().getServico().getNome());
                buffWrite.write("??"+pedido.getItem_list().get(i).getServico().getValor());
                buffWrite.write("@@"+pedido.getItem_list().get(i).getItem_qtd());
                buffWrite.write("$$"+pedido.getItem_list().get(i).getServico().getPrestador().getUsuario());
                buffWrite.newLine();
            }
            buffWrite.write("Valor: "+ Double.toString(pedido.getValor_total())) ;
	    buffWrite.newLine();
            buffWrite.write("Status do pedido: "+ pedido.getPedido_status());
	    buffWrite.newLine();
            buffWrite.write("---------"); 
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
    
    public static ArrayList<Pedido> lista_pedidos() {
        ArrayList<Pedido> lista_pedidos_all = new ArrayList();  
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Pedido.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    Pedido pedido = new Pedido();
                    if(linha.contains("Numero: ")){
                        pedido.setNumero_pedido(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                        linha = lerArq.readLine();
                        if(linha.contains("Nome do Cliente: ")){
                          Cliente cliente = new Cliente();
                          cliente.setNome(linha.substring(linha.indexOf(":")+2,linha.length()));
                          pedido.setCliente(cliente);
                          linha = lerArq.readLine(); 
                          if(linha.contains("Lista de itens: ")){
                            linha = lerArq.readLine();   
                            while(!linha.startsWith("Valor :")){
                                //Início ao ?? -> Nome do serviço
                                // O jeito vai ser ler caractere a caractere, pqp
                                String aux = null;
                                for(int j=0; j<linha.length(); j++){
                                    if(linha.charAt(j)!='?' && linha.charAt(j+1)!='?'){
                                        aux += linha.charAt(j);
                                    }
                                }
                                Pedido_item itemList = new Pedido_item();
                                pedido.item_list.
                                String result = linha.substring(linha.indexOf(":")+2,linha.length());
                            }
                            String result = linha.substring(linha.indexOf(":")+2,linha.length());
                            if(result.equals("false")) {
                                servico.setServico_ativado(false);
                            } else {
                                servico.setServico_ativado(true);
                            }
                            linha = lerArq.readLine(); 
                            if(linha.contains("---------")){
                                lista_servicos_all.add(servico);
                            }
                          }
                        }
                    }        
                    linha = lerArq.readLine(); 
                }
                return lista_servicos_all;
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null,
                    "Erro ao ler o arquivo. mensagem"+"\n"+ex.getMessage(),
                    "Erro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null,
                "Erro ao abrir o arquivo. mensagem"+"\n"+ex.getMessage(),
                "Erro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE
            );
        }
        return lista_servicos_all;
    }
}

    

