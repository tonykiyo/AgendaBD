/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Contato;
import modelo.DAO.ContatoDAO;

/**
 *
 * @author Tonykiyo
 */
public class ControladorAgenda {
    ContatoDAO dao;
    
    public ControladorAgenda(){
        dao = new ContatoDAO();
    }
    
    public boolean cadastrarContato(String nome, String telefone, String email){
        Contato contato = new Contato();
        
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        
        return dao.adicionarContato(contato);
    }
    
    public boolean alterarContato (int id, String nome, String telefone, String email) {
	
        Contato contato = new Contato();
		
	contato.setId(id);
	contato.setNome(nome);
	contato.setTelefone(telefone);
	contato.setEmail(email);
	
	return dao.atualizaContato(contato);
		
    }
    
    public String obterContatos(){
        ArrayList<Contato> listaContatos = dao.listarContatos();
        
        String contatos = "";
        
        for(Contato c : listaContatos) {
            contatos += c.getNome() + "|" + c.getNome() + "|" + c.getEmail() + "\n";
        }
        
        return contatos;
    }
    
    public void fecharConexao(){
        dao.encerrarConexao();
    }
    
    public boolean removeContato(int id){
        Contato contato = new Contato();
        contato.setId(id);
        return dao.removeContato(id);
    }
    
    
    
    
}
