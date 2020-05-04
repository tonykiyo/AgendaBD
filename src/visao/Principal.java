/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControladorAgenda;
import java.util.Scanner;

/**
 *
 * @author Tonykiyo
 */
public class Principal {
    public static void main(String[] args){
        ControladorAgenda controlador = new ControladorAgenda();
        
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        
        System.out.println("Bem vindo a agenda! ...");
        System.out.println("Menu:");
        System.out.println("Opcao 1 - cadastrar um contato.");
        System.out.println("Opcao 2 - Editar um contato cadastrado.");
        System.out.println("Opcao 3 - Excluir um contato cadastrado.");
        System.out.println("Opcao 4 - Listar os contatos cadastrado.");
        opcao = scanner.nextInt();
        
        switch(opcao){
            case 1: //Cadastrar
                System.out.print("Digite o nome do contato: ");
                String nome = scanner.nextLine();

                System.out.print("Digite o telefone do contato: ");
                String telefone = scanner.nextLine();

                System.out.print("Digite o email do contato: ");
                String email = scanner.nextLine();

                if(controlador.cadastrarContato(nome, telefone, email)){
                    System.out.println("Contato cadastrado com sucesso!");
                }else{
                    System.out.println("Falha ao cadastrar contato.");
                }      
                controlador.fecharConexao();
                break;
            case 2: //Alterar
                System.out.print("Digite o codigo do contato que deseja Alterar: ");
                int id = scanner.nextInt();
                
                System.out.print("Digite o Novo nome do contato: ");
                nome = scanner.nextLine();

                System.out.print("Digite o Novo telefone do contato: ");
                telefone = scanner.nextLine();

                System.out.print("Digite o Novo email do contato: ");
                email = scanner.nextLine();
                
                if(controlador.alterarContato(id, nome, telefone, email)){
                    System.out.println("Contato Alterado com sucesso!");
                }else{
                    System.out.println("Falha ao Alterar o contato.");
                } 
                controlador.fecharConexao();
                break;
            case 3: //Excluir                
                System.out.print("Digite o codigo do contato que deseja DELETAR: ");
                id = scanner.nextInt();
                
                if(controlador.removeContato(id)){
                    System.out.println("Contato Deletado com sucesso!.");
                }else{
                    System.out.println("Falha ao Deletar o contato.");
                }   
                controlador.fecharConexao();
                break;
            case 4: // Listar
                System.out.println(controlador.obterContatos());      
                controlador.fecharConexao();
                break;
            
            default:
                System.out.println("ERROR: Digite um valor valido entre 1 a 4.");
                controlador.fecharConexao();
        }
        
        
    
    }
}
