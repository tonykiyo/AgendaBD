/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contato;

/**
 *
 * @author Tonykiyo
 */
public class ContatoDAO {
    
    private Connection conexao;
    
    public ContatoDAO(){
        conexao = FabricaConexao.getConexao();
    }
    
    public void encerrarConexao(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao encerrar a conexao.");
            ex.printStackTrace();
        }
    }
    
    public boolean adicionarContato(Contato c){
        
        String sql = "INSERT INTO contato (nome, telefone, email) VALUES (?,?,?)";
        
        PreparedStatement stmt;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            
            stmt.execute();
            
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Problemas com a excucao do comando.");
            ex.printStackTrace();
            return false;            
        }
    }
    
    public boolean removeContato(int id){
        String sql = "DELETE FROM contato WHERE id = ?";
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            return true;
            
        }catch(SQLException ex){
            System.out.println("Problemas com a excucao do comando.");
            ex.printStackTrace();
            return false; 
        }
    }
    
    public boolean atualizaContato(Contato c){
        String sql = "UPDATE contao SET nome = ? , telefone = ? email = ?  WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            stmt.setInt(4, c.getId());
            
            stmt.execute();
            
            stmt.close();
            return true;
            
            
        } catch (SQLException ex) {
           System.out.println("Problemas com a excucao do comando.");
            ex.printStackTrace();
            return false; 
        }
    }
    
    public ArrayList<Contato> listarContatos(){
        String sql = "SELECT * FROM contato";
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Contato c = new Contato();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                
                contatos.add(c);
            }
            
            rs.close();
            stmt.close();
            
            
        } catch (SQLException ex) {
           System.out.println("Problemas com a excucao do comando.");
           ex.printStackTrace();
           
        }
        return contatos;
        
    }
    
    public Contato buscaContato(int id){
        Contato c = new Contato();
        
        String sql = "SELECT * FROM contato WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
            }
            rs.close();
            stmt.close();
            
            return c;
            
        } catch (SQLException ex) {
           System.out.println("Problemas com a excucao do comando.");
           ex.printStackTrace();
           return null;
        }
    }
        
}
