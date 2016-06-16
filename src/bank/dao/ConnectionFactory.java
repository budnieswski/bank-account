package bank.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Bruno e Guilherme
 */
public class ConnectionFactory {
    private static Connection con;
    
    public static Connection getConnection() {
                
        try {
            Properties prop = new Properties();
            String propFileName = System.getProperty("user.dir")+"/resources/config.properties";
            
            FileInputStream inputStream = new FileInputStream(propFileName);
                        
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }
            
            String url = "jdbc:mysql://"+prop.getProperty("host");
                   url+= "/"+prop.getProperty("db");
            
            con = DriverManager.getConnection(url,
                    prop.getProperty("user"),
                    prop.getProperty("pass"));
            
            return con;
 
	} catch (Exception e) {
            System.out.println("Exception: " + e);
	}
            
        return con;
    }
    
    public static Connection getConnectionSample() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bankaccount", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

