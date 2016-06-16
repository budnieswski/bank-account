package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(double limite, Long id, int idTipo, String nomeTipo, double saldo) {
        super(id, idTipo, nomeTipo, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public boolean saca(double valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void remunera() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
