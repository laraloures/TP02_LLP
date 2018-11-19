/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import ClassesPedido.Servico;
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
      for(int i=0; i<servico_list.size(); i++) {
        cadastro_servico(servico_list.get(i).getNome(), servico_list.get(i).getDescricao(), servico_list.get(i).isServico_ativado());
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
      for(int i=0; i<servico_list.size(); i++) {
        cadastro_servico(servico_list.get(i).getNome(), servico_list.get(i).getDescricao(), servico_list.get(i).isServico_ativado());
      }
    }
}

    

