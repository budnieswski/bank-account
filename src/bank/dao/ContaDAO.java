package bank.dao;

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
    private String stmtAdicionar = "INSERT INTO conta (id_tipo,id_cliente,saldo,limite,montante_minimo,deposito_minimo) values (?,?,?,?,?,?)";
    private String stmtListar = "SELECT * FROM conta JOIN cliente ON cliente.id_conta = conta.id WHERE conta.id=?";
    private String stmtAtualizar = "UPDATE conta set saldo=? WHERE id=?";
    private String stmtExcluir = "DELETE FROM conta WHERE id=?";
    private String stmtAtualizarVinculo = "UPDATE cliente set id_conta=? WHERE id=?";
    
    public void adicionar(Conta conta) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAdicionar, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, conta.getIdTipo());
            stmt.setInt(2, conta.getDono().getId()); // Cliente ID
            stmt.setDouble(3, conta.getSaldo());
            
            // Default
            stmt.setDouble(4, 0.0);
            stmt.setDouble(5, 0.0);
            stmt.setDouble(6, 0.0);
            
            switch(conta.getIdTipo()) {
                case 1:
                    // Conta Corrente                 
                    ContaCorrente cc = (ContaCorrente) conta;
                    stmt.setDouble(4, cc.getLimite());
                break;
                case 2:
                    // Conta Investimento
                    ContaInvestimento ci = (ContaInvestimento) conta;
                    stmt.setDouble(5, ci.getMontanteMinimo()); // Montante
                    stmt.setDouble(6, ci.getDepositoMinimo()); // Dep. Minimo
                break;
            }
                        
            stmt.execute();
            
            // Seta com o ID gerado 
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            //cliente.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
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
