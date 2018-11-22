package DAO;

import sql.Conexao;
import modelo.Usuario;
import java.sql.*;

public class UsuarioDAO { 
    
	private Connection connection;
	private String nome;
	private long cpf;
	private String email;
	private String senha;
	private long celular;
    
    public UsuarioDAO(){ 
        this.connection = new Conexao().getConnection();
    } 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public void adicionaUsuario(Usuario usuario){ 
        
    	String sql = "INSERT INTO Usuario(nome,cpf,email,senha,celular) VALUES(?,?,?,?,?)";
        
    	try { 
            
    		PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setLong(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setLong(5, usuario.getCelular());
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
	
	@SuppressWarnings("finally")
	public boolean buscarUsuario(String email, String senha) throws SQLException {
        
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ? ";
        boolean checagem = false;
		
		try {

			stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                checagem = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        
        } finally {
        	stmt.execute();
            stmt.close();
            return checagem;
        }
    }    
}
