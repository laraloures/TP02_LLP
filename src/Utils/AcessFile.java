/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import ClassesPedido.Pedido;
import ClassesPedido.Pedido_Item;
import ClassesPedido.Servico;
import ClassesPedido.Servico_Prestador;
import ClassesPedido.Trabalho;
import ClassesUsuario.Administrador;
import ClassesUsuario.Cliente;
import ClassesUsuario.Profissional;
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
    
    public static void limpa_arquivo(String nomeArquivo) {
        String path = "src\\Arquivos\\"+nomeArquivo+".txt";
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
      limpa_arquivo("Servico");
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
      limpa_arquivo("Servico");
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
    
    //Leitura de Servico_Prestador
    
    public static ArrayList<Servico_Prestador> lista_servico_prestador(){
        ArrayList<Servico_Prestador> lista_servicos_prestador_all = new ArrayList();  
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Servico_Prestador.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    Servico servico = new Servico();
                    Servico_Prestador servicoPrestador = new Servico_Prestador();
                    if(linha.contains("Nome do Servico: ")){
                        servico.setNome(linha.substring(linha.indexOf(":")+2,linha.length()));
                        linha = lerArq.readLine();
                        if(linha.contains("Prestador do Servico: ")){
                          servicoPrestador.setPrestador(new Profissional(null,linha.substring(linha.indexOf(":")+2,linha.length()) ,null, null));
                          linha = lerArq.readLine(); 
                          if(linha.contains("Valor: ")){
                            servicoPrestador.setValor(Double.parseDouble(linha.substring(linha.indexOf(":")+2,linha.length())));
                            linha = lerArq.readLine(); 
                            if(linha.contains("---------")){
                                servicoPrestador.setServico(servico);
                                lista_servicos_prestador_all.add(servicoPrestador);
                            }
                          }
                        }
                    }        
                    linha = lerArq.readLine(); 
                }
                return lista_servicos_prestador_all;
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
        return lista_servicos_prestador_all;
    }
    
    public static ArrayList<Servico_Prestador> lista_servico_prestador_nome_servico(String nomeServico) {
        ArrayList<Servico_Prestador> all_registros = AcessFile.lista_servico_prestador();
        ArrayList<Servico_Prestador> finded_list = new ArrayList();
        
        for(int i=0; i<all_registros.size(); i++) {
            if(all_registros.get(i).getServico().getNome().equals(nomeServico)) {
                finded_list.add(all_registros.get(i));
            }
        }
        return finded_list;
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
            buffWrite.write("Nome do cliente: "+pedido.getCliente().getUsuario());
	    buffWrite.newLine();
            buffWrite.write("Lista de itens: ");
            buffWrite.newLine();
            for(int i=0; i<pedido.getItem_list().size(); i++) {
                buffWrite.write(pedido.getItem_list().get(i).getServico().getServico().getNome());
                buffWrite.write("??"+pedido.getItem_list().get(i).getServico().getValor());
                buffWrite.write("@@"+pedido.getItem_list().get(i).getItem_qtd());
                buffWrite.write("$$"+pedido.getItem_list().get(i).getServico().getPrestador().getUsuario());
                buffWrite.write("##"+pedido.getItem_list().get(i).getStatus());
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
                    //System.out.println("    Leitura de linha");
                    //System.out.println(linha);
                    if(linha.contains("Numero do pedido: ")){
                        //System.out.println("        Lendo numero");
                        pedido.setNumero_pedido(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                        linha = lerArq.readLine();
                        //System.out.println(linha);
                        if(linha.contains("Nome do cliente: ")){
                          //System.out.println("      Lendo Cliente");
                          Cliente cliente = new Cliente();
                          cliente.setUsuario(linha.substring(linha.indexOf(":")+2,linha.length()));
                          pedido.setCliente(cliente);
                          linha = lerArq.readLine(); 
                          if(linha.contains("Lista de itens: ")){
                            //System.out.println("        Lendo ItemList");
                            linha = lerArq.readLine();   
                              //System.out.println("LinhaAtual:"+linha);
                            while(!linha.startsWith("Valor: ")){
                                
                                //Objetos a serem povoados para criar a lista de itens no pedido
                                Servico_Prestador servico_Prestador = new Servico_Prestador();
                                Servico servico = new Servico();
                                Pedido_Item pedido_item = new Pedido_Item();

                                
                                int pos_start = 0;
                                //Início ao ?? -> Nome do serviço
                                // O jeito vai ser ler caractere a caractere, pqp
                                String aux = "";
                                boolean limit = false;
                                for(int j=0; j<linha.length(); j++){
                                    if(!limit){
                                        if(linha.charAt(j)=='?') {// && linha.charAt(j+1)!='?'){
                                            //System.out.println("com ? aqui");
                                            if(j+1 < linha.length() ) {
                                                if(linha.charAt(j+1) != '?' ) {
                                                    pos_start = j+1;
                                                    servico.setNome(aux);
                                                    limit = true;
                                                }
                                            }
                                        }else {  //else novo
                                            aux += linha.charAt(j);
                                        }
                                    }
                                }
                                limit=false;
                                //System.out.println("[Nome do servico lido: "+aux+"]");
                                aux = "";
                                //Do ?? ao @@ -> valor
                                for(int j=pos_start; j<linha.length(); j++) {
                                    if(!limit){
                                        if(linha.charAt(j)=='@'){
                                            if(j+1 < linha.length()) {
                                                if(linha.charAt(j+1)=='@') {
                                                    pos_start = j+2;
                                                    
                                                    servico_Prestador.setValor(Double.parseDouble(aux));
                                                    limit = true;
                                                }
                                            }
                                            //aux += linha.charAt(j);
                                        } else {
                                            aux += linha.charAt(j);
                                        }
                                    }
                                }
                                //System.out.println("[Valor lido: "+(aux)+"]");
                                aux = "";
                                limit = false;
                                //Do @@ ao $$ -> Qtdade
                                for(int j=pos_start; j<linha.length(); j++) {
                                    if(!limit){
                                        //System.out.println("{"+linha.charAt(j)+"}");
                                        if(linha.charAt(j)=='$'){
                                            if(j+1 < linha.length()) {
                                                if(linha.charAt(j+1)=='$') {
                                                    pos_start = j+2;
                                                    //servico_Prestador..setValor(Double.parseDouble(aux));
                                                    pedido_item.setItem_qtd(Integer.parseInt(aux));
                                                    limit = true;
                                                }
                                            }
                                            //aux += linha.charAt(j);
                                        } else {
                                            aux += linha.charAt(j);
                                        }
                                    }
                                }
                                //System.out.println("[Qtd lida: "+(aux)+"]");
                                aux = "";
                                limit = false;
                                //Do $$ ao ## -> Prestador
                                /*for(int j=pos_start; j<linha.length(); j++) {
                                    aux += linha.charAt(j);
                                } */   
                                for(int j=pos_start; j<linha.length(); j++) {
                                    if(!limit){
                                        //System.out.println("{"+linha.charAt(j)+"}");
                                        if(linha.charAt(j)=='#'){
                                            if(j+1 < linha.length()) {
                                                if(linha.charAt(j+1)=='#') {
                                                    pos_start = j+2;
                                                    //servico_Prestador..setValor(Double.parseDouble(aux));
                                                    
                                                    limit = true;
                                                }
                                            }
                                            //aux += linha.charAt(j);
                                        } else {
                                            aux += linha.charAt(j);
                                        }
                                    }
                                }
                                //System.out.println("[User Prestador: "+(aux)+"]");
                                servico_Prestador.setPrestador(new Profissional(null, aux, null, null));
                                aux = "";
                                limit = false;
                                //Do ## ao Final -> Status do Trabalho
                                for(int j=pos_start; j<linha.length(); j++) {
                                    aux += linha.charAt(j);
                                }    
                                int statusConverted = Integer.parseInt(aux);
                                //System.out.println("[Status do servico: "+aux+"]");
                            //Popula campos do item do pedido
                                servico_Prestador.setServico(servico);
                                //pedido_item.setStatus(Integer.parseInt(aux));
                                pedido_item.setStatus(statusConverted);
                                //servico_Prestador.setPrestador(new Profissional(null, aux, null, null));
                                pedido_item.setServico(servico_Prestador);
                                
                            //Adiciona o pedido_item à lista de itens do pedido
                                pedido.item_list.add(pedido_item);
                            //le a próxima linha
                                linha = lerArq.readLine(); 
                                //System.out.println("{{"+linha+"}}");
                            }
                            
                            if(linha.contains("Valor: ")) {
                                //System.out.println("        Lendo valor");
                                //System.out.println(linha.substring(linha.indexOf(":")+2,linha.length()));
                                pedido.setValor_total(Double.parseDouble(linha.substring(linha.indexOf(":")+2,linha.length())));
                                //le a próxima linha
                                linha = lerArq.readLine();   
                                if(linha.startsWith("Status do pedido: ")){
                                    //System.out.println("        Lendo status");
                                    pedido.setPedido_status(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                                    //le a próxima linha
                                    linha = lerArq.readLine();
                                    if(linha.startsWith("-----")) {
                                        lista_pedidos_all.add(pedido);
                                        //System.out.println("Pedido adicionado!");
                                    }
                                }
                            }
                          }
                                
                             
                          
                        }
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
        return lista_pedidos_all;
    }
    
    public static Pedido lista_pedido_numero(int numeroPedido) {
        ArrayList<Pedido> pedidos_list = AcessFile.lista_pedidos();
        for(int i=0; i<pedidos_list.size(); i++) {
            if(pedidos_list.get(i).getNumero_pedido() == numeroPedido) {
                return pedidos_list.get(i);
            }
        }
        return null;
    }
    
    public static ArrayList<Pedido> lista_pedido_user(String userName) {
        ArrayList<Pedido> pedidos_list = AcessFile.lista_pedidos();
        ArrayList<Pedido> pedidos_list_filtered = new ArrayList();
        for(int i=0; i<pedidos_list.size(); i++) {
            if(pedidos_list.get(i).getCliente().getUsuario().equals(userName)) {
                pedidos_list_filtered.add(pedidos_list.get(i));
            }
        }
        return pedidos_list_filtered;
    }
    
    public static void alterar_pedido(Pedido pedido){
        ArrayList<Pedido> pedidos_list = AcessFile.lista_pedidos();
        ArrayList<Pedido> new_pedidos_list = new ArrayList();
        limpa_arquivo("Pedido");
        for(int i=0; i<pedidos_list.size(); i++) {
            if(pedidos_list.get(i).getNumero_pedido() != pedido.getNumero_pedido()) {
                cadastra_pedido(pedidos_list.get(i));
            } else{
                cadastra_pedido(pedido);
            }
        }
    }
    //public static Pedido procuraPedidoNumero(int numeroPedido) {}

    public static void add_trabalho(Pedido pedido) {
        String path = "src\\Arquivos\\Trabalho.txt";
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
            for(int i = 0; i < pedido.getItem_list().size(); i++) {
                buffWrite.write("Numero do pedido: "+pedido.getNumero_pedido());
                buffWrite.newLine();
                buffWrite.write("Prestador: "+pedido.getItem_list().get(i).getServico().getPrestador().getUsuario());
                buffWrite.newLine();
                buffWrite.write("Servico: "+pedido.getItem_list().get(i).getServico().getServico().getNome());
                buffWrite.newLine();
                buffWrite.write("Quantidade: "+pedido.getItem_list().get(i).getItem_qtd());
                buffWrite.newLine();
                buffWrite.write("Status: "+pedido.getItem_list().get(i).getStatus());
                buffWrite.newLine();
                buffWrite.write("---------"); 
                buffWrite.newLine();
            }
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
    
    public static void add_single_trabalho(Trabalho trabalho) {
        String path = "src\\Arquivos\\Trabalho.txt";
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
                buffWrite.write("Numero do pedido: "+trabalho.getNumeroPedido());
                buffWrite.newLine();
                buffWrite.write("Prestador: "+trabalho.getPrestador());
                buffWrite.newLine();
                buffWrite.write("Servico: "+trabalho.getNomeServico());
                buffWrite.newLine();
                buffWrite.write("Quantidade: "+trabalho.getQtd());
                buffWrite.newLine();
                buffWrite.write("Status: "+trabalho.getStatusServico());
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
    
    public static ArrayList<Trabalho> lista_trabalho_all() {
        ArrayList<Trabalho> trabalho_list = new ArrayList();
        Trabalho trabalho;
        try {    
            FileReader arq;
            arq = new FileReader("src\\Arquivos\\Trabalho.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha;
                linha = lerArq.readLine(); 
                while (linha != null) {
                    trabalho = new Trabalho();
                    //System.out.println("linha:["+linha+"]");
                    if(linha.contains("Numero do pedido: ")){
                        trabalho.setNumeroPedido(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                        linha = lerArq.readLine();
                        if(linha.contains("Prestador: ")){
                            trabalho.setPrestador(linha.substring(linha.indexOf(":")+2,linha.length()));
                            linha = lerArq.readLine();
                            if(linha.contains("Servico: ")){
                                trabalho.setNomeServico(linha.substring(linha.indexOf(":")+2,linha.length()));
                                linha = lerArq.readLine();
                                if(linha.contains("Quantidade: ")){
                                    trabalho.setQtd(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                                    linha = lerArq.readLine();
                                    if(linha.contains("Status: ")){
                                        trabalho.setStatusServico(Integer.parseInt(linha.substring(linha.indexOf(":")+2,linha.length())));
                                        linha = lerArq.readLine();
                                        if(linha.contains("---")){
                                            trabalho_list.add(trabalho);
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                    linha = lerArq.readLine();
                }
                return trabalho_list;
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
    
    public static ArrayList<Trabalho> lista_trabalho_aberto() {
        ArrayList<Trabalho> trabalhoList = lista_trabalho_all();
        ArrayList<Trabalho> trabalhoAbertoList = new ArrayList();
        
        for(int i=0; i<trabalhoList.size(); i++) {
            if(trabalhoList.get(i).getStatusServico() == 0) {
                trabalhoAbertoList.add(trabalhoList.get(i));
            }
        }
        return trabalhoAbertoList;
    }
    
    public static ArrayList<Trabalho> lista_trabalho_aberto_prestador(String nomePrestador) {
        ArrayList<Trabalho> trabalhoAbertoList = lista_trabalho_aberto();
        ArrayList<Trabalho> trabalhoAbertoPrestador = new ArrayList();
        for(int i=0; i<trabalhoAbertoList.size(); i++) {
            if(trabalhoAbertoList.get(i).getPrestador().equals(nomePrestador)){
                trabalhoAbertoPrestador.add(trabalhoAbertoList.get(i));
            }
        }
        return trabalhoAbertoPrestador;
    }
    
    public static void altera_status_trabalho(Trabalho trabalho) {
        ArrayList<Trabalho> trabalho_list = lista_trabalho_all();
        limpa_arquivo("Trabalho");
        for(int i=0; i<trabalho_list.size(); i++) {
            if(trabalho_list.get(i).getNomeServico().equals(trabalho.getNomeServico()) && trabalho_list.get(i).getNumeroPedido()==trabalho.getNumeroPedido() && trabalho_list.get(i).getPrestador().equals(trabalho.getPrestador())){
                add_single_trabalho(trabalho);
            } else {
                add_single_trabalho(trabalho_list.get(i));
            }
        }
    }

    public static void altera_status_trabalho_pedido(Trabalho trabalho) {
        Pedido pedido = lista_pedido_numero(trabalho.getNumeroPedido());
        for(int i=0; i<pedido.getItem_list().size(); i++) {
            if(pedido.getItem_list().get(i).getServico().getServico().getNome().equals(trabalho.getNomeServico()))                
                if(pedido.getItem_list().get(i).getServico().getPrestador().getUsuario().equals(trabalho.getPrestador()))                
                    if(pedido.getItem_list().get(i).getStatus() == 0) {
                        pedido.getItem_list().get(i).setStatus(trabalho.getStatusServico());
                     
                        
                    }
        }
        alterar_pedido(pedido);
    }

    public static void altera_status_pedido(int numeroPedido) {
        Pedido pedido = lista_pedido_numero(numeroPedido);
        boolean flag_pronto = true;
        for(int i=0; i<pedido.getItem_list().size(); i++) {
            if(pedido.getItem_list().get(i).getStatus() == 0)
                flag_pronto = false;
        }
        if(flag_pronto){
            pedido.setPedido_status(1);
            alterar_pedido(pedido);
        }
        
    }
}

    

