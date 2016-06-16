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
}
