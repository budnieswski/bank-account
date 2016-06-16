package bank.dao;

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
    private String stmtAtualizar = "UPDATE conta set saldo=? WHERE id=?";
    private String stmtExcluir = "DELETE FROM conta WHERE id=?";
    private String stmtAtualizarVinculo = "UPDATE cliente set id_conta=? WHERE id=?";

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
                id = 1;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        
        return ++id;
    }
}
