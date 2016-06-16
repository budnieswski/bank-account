package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public interface ContaInterface {
    public boolean deposita(double valor);
    public boolean saca(double valor);
    public Cliente getDono();
    public int getNumero();
    public double getSaldo();
    public void remunera();
    
    // Tipos para Conta Corrente
    //public double getLimite();
    //public void setLimite(double valor);
    
    // Tipos para Conta Investimento
    //public double getMontanteMinimo();
    //public void setMontanteMinimo(double montanteMinimo);
    //public double getDepositoMinimo();
    //public void setDepositoMinimo(double depositoMinimo);
}
