package bank.dao;

/**
 *
 * @author Bruno e Guilherme
 */
public class ContaDAO {
    private String stmtAdicionar = "INSERT INTO conta (id_tipo,saldo,limite,montante_minimo,deposito_minimo) values (?,?,?,?,?)";
    private String stmtListar = "SELECT * FROM conta JOIN cliente ON cliente.id_conta = conta.id";
    private String stmtAtualizar = "UPDATE conta set saldo=? WHERE id=?";
    private String stmtExcluir = "DELETE FROM conta WHERE id=?";
    private String stmtAtualizarVinculo = "UPDATE cliente set id_conta=? WHERE id=?";

}
