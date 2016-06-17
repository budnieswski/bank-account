package bank.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Bruno e Guilherme
 */
public class ConnectionFactory {
    private static Connection con;
    public static String user;
    public static String pass;
    public static String host;
    public static String db;
    
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
            
            ConnectionFactory.user = prop.getProperty("user");
            ConnectionFactory.pass = prop.getProperty("pass");
            ConnectionFactory.host = prop.getProperty("host");
            ConnectionFactory.db = prop.getProperty("db");
            
            String url = "jdbc:mysql://"+ConnectionFactory.host;
                   url+= "/"+ConnectionFactory.db;
            
            con = DriverManager.getConnection(url,
                    ConnectionFactory.user,
                    ConnectionFactory.pass);
            
            return con;
 
	} catch (Exception e) {
            System.out.println("Exception: " + e);
	}
            
        return con;
    }
    
//    public static Connection getConnectionSample() {
//        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost/bankaccount", "root", "");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

