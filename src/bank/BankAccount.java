package bank;

import bank.dao.ConnectionFactory;
import bank.swing.Inicio;
import java.sql.Connection;

/**
 *
 * @author Guilherme
 */
public class BankAccount {

    public static void main(String[] args) { 
        Inicio window = new Inicio();
        window.setVisible(true);
        window.listar();
    }
    
}
