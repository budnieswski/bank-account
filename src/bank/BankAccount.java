package bank;

import bank.dao.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Guilherme
 */
public class BankAccount {

    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
    }
    
}
