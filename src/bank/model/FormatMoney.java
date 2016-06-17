package bank.model;

import java.text.NumberFormat;

/**
 *
 * @author Guilherme
 */
public class FormatMoney {
    public static String toString(Double input) {
        String value = "";
        
        NumberFormat format = NumberFormat.getCurrencyInstance();
               
        try {
            value = format.format( input );
        } catch (Exception e) {
            System.out.println("Parse error (toString). E: " + e.getMessage());
        }
        
        return value;
    }
    
    public static Double toDouble(String input) {
        double value = 0.0;
        
        if (input.equals(""))
            input = "0,00";
        
        input = input.replace(".", "");
        input = input.replace(",", ".");
        
        NumberFormat format = NumberFormat.getInstance();
        
        try {
            value = format.parse(input.replaceAll("[^\\d]*([\\d,]*).*", "$1")).doubleValue();
        } catch (Exception e) {
            System.out.println("Parse error (toDouble). E: " + e.getMessage());
        }
        
        return value;
    }
}
