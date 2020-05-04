/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tonykiyo
 */
public class FabricaConexao {
    
    public static Connection getConexao(){
        
        try {
            //Driver do SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Connection conexao = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;"+
                    "databaseName=agenda;user=admin;password=admin;");
            
            return conexao;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver nao encontrado.");
            ex.printStackTrace();
            return null;
        } catch (SQLException ex){
            System.out.println("Impossivel conectar ao Banco de Dados.");
            ex.printStackTrace();
            return null;
        }
    }
}
