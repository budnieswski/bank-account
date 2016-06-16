package bank.dao;

import bank.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno e Guilherme
 */
public class ClienteDAO {
    private String stmtAdicionar = "INSERT INTO cliente (nome,sobrenome,rg,cpf,endereco) values (?,?,?,?,?)";
    private String stmtListar = "SELECT * FROM cliente";
    private String stmtAtualizar = "UPDATE cliente set nome=?, sobrenome=?, rg=?, cpf=?, endereco=?, id_conta=? WHERE id=?";
    private String stmtExcluir = "DELETE FROM cliente WHERE id=?";
    private String stmtFiltrar = "SELECT * FROM cliente WHERE nome LIKE ? OR sobrenome LIKE ? OR cpf LIKE ? OR rg LIKE ?";
    
    public void adicionar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAdicionar, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRG());
            stmt.setString(4, cliente.getCPF());
            stmt.setString(5, cliente.getEndereco());
            
            stmt.execute();
            
            // Seta com o ID gerado 
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            cliente.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void excluir(Cliente cliente) throws SQLException {
        Connection con=null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtExcluir);

            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
            
            if (cliente.getIdConta() != 0) {
                ContaDAO conta = new ContaDAO();
                conta.excluir(cliente.getIdConta());
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void atualizar(Cliente cliente) throws SQLException{
        Connection con=null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizar);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRG());
            stmt.setString(4, cliente.getCPF());
            stmt.setString(5, cliente.getEndereco());
            stmt.setInt(6, cliente.getIdConta());
            stmt.setLong(7, cliente.getId()); // Where
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public List<Cliente> listar() throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            List<Cliente> clientes = new ArrayList();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setRG(rs.getString("rg"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setIdConta(rs.getInt("id_conta"));
                
                clientes.add(cliente);
            }
            
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public List<Cliente> filtrar(String filtro) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtFiltrar);
            
            for (int i = 1; i < 5; i++)
                stmt.setString(i, "%"+ filtro +"%");
            
            rs = stmt.executeQuery();
            List<Cliente> clientes = new ArrayList();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setRG(rs.getString("rg"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setIdConta(rs.getInt("id_conta"));
                
                clientes.add(cliente);
            }
            
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }    
}
