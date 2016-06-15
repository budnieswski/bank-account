package bank;

import bank.dao.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Budnieswski
 */
public class BankAccount {

    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
    }
    
}
