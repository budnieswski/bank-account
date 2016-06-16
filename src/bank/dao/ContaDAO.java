package bank.dao;

import bank.model.Cliente;
import bank.model.Conta;
import bank.model.ContaCorrente;
import bank.model.ContaInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bruno e Guilherme
 */
public class ContaDAO {
    private String stmtAdicionar = "INSERT INTO conta (id_tipo,saldo,limite,montante_minimo,deposito_minimo) values (?,?,?,?,?)";
    private String stmtListar = "SELECT * FROM conta JOIN cliente ON cliente.id_conta = conta.id WHERE conta.id=?";
    private String stmtGetConta = "SELECT conta.* FROM conta JOIN cliente ON cliente.id_conta = conta.id WHERE cliente.id=?";
    private String stmtAtualizar = "UPDATE conta set id_tipo=?, saldo=?, limite=?, montante_minimo=?, deposito_minimo=? WHERE id=?";
    private String stmtExcluir = "DELETE FROM conta WHERE id=?";
    private String stmtAtualizarVinculo = "UPDATE cliente set id_conta=? WHERE id=?";
    
    public void adicionar(Conta conta) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAdicionar, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, conta.getIdTipo());
            stmt.setDouble(2, conta.getSaldo());
            
            switch(conta.getIdTipo()) {
                case 1:
                    // Conta Corrente                 
                    ContaCorrente cc = (ContaCorrente) conta;
                    stmt.setDouble(3, cc.getLimite()); // Limite
                    stmt.setDouble(4, 0.0);
                    stmt.setDouble(5, 0.0);
                break;
                case 2:
                    // Conta Investimento
                    ContaInvestimento ci = (ContaInvestimento) conta;
                    stmt.setDouble(3, 0.0);
                    stmt.setDouble(4, ci.getMontanteMinimo()); // Montante
                    stmt.setDouble(5, ci.getDepositoMinimo()); // Dep. Minimo
                break;
            }
                        
            stmt.execute();
            
            // Atualiza o Cliente com o ID da Conta
            ClienteDAO daoCliente = new ClienteDAO();
            conta.getDono().setIdConta( conta.getId() );
            daoCliente.atualizar(conta.getDono());
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void excluir(int id) {
        Connection con=null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtExcluir);
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void atualizar(Conta conta) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizar, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, conta.getIdTipo());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setDouble(6, conta.getId());
            
            switch(conta.getIdTipo()) {
                case 1:
                    // Conta Corrente                 
                    ContaCorrente cc = (ContaCorrente) conta;
                    stmt.setDouble(3, cc.getLimite()); // Limite
                    stmt.setDouble(4, 0.0);
                    stmt.setDouble(5, 0.0);
                break;
                case 2:
                    // Conta Investimento
                    ContaInvestimento ci = (ContaInvestimento) conta;
                    stmt.setDouble(3, 0.0);
                    stmt.setDouble(4, ci.getMontanteMinimo()); // Montante
                    stmt.setDouble(5, ci.getDepositoMinimo()); // Dep. Minimo
                break;
            }
                        
            stmt.executeUpdate();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public Conta getConta(Cliente cliente) {        
        Connection con = null;
        PreparedStatement stmt = null;
        Conta conta = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtGetConta, Statement.RETURN_GENERATED_KEYS);            
            stmt.setInt(1, cliente.getId());
            
            ResultSet rs = stmt.executeQuery();
            
            if ( rs.next() ) {
                switch (rs.getInt("id_tipo")) {
                    case 1:
                        // Conta Corrente
                        conta = new ContaCorrente(
                                rs.getDouble("limite"),
                                cliente,
                                rs.getInt("id"),
                                rs.getInt("id_tipo"),
                                rs.getDouble("saldo")
                        );
                    break;
                    case 2:
                        // Conta Corrente
                        conta = new ContaInvestimento(
                                rs.getDouble("montante_minimo"),
                                rs.getDouble("deposito_minimo"),
                                cliente,
                                rs.getInt("id"),
                                rs.getInt("id_tipo"),
                                rs.getDouble("saldo")
                        );
                    break;
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        
        return conta;
    }

    public int getNextContaId() {
        int id;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT id FROM conta ORDER BY id DESC LIMIT 0, 1");
            ResultSet rs = stmt.executeQuery();
            
            if ( rs.next() )
                id = Integer.parseInt(rs.getString("id"));
            else
                id = 0;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        
        return ++id;
    }
}
