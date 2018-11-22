package sql;

import java.sql.*;

public class Conexao {
   
    public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","josealfreu");
		
		 } catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
    }
    
    /*public static void main(String[] args) throws SQLException {
       
    	Connection connection = new Conexao().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }*/
}