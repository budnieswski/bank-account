package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public class ContaInvestimento extends Conta{
    private double montanteMinimo;
    private double depositoMinimo;

    public ContaInvestimento(double montanteMinimo, double depositoMinimo, Long id, int idTipo, String nomeTipo, double saldo) {
        super(id, idTipo, nomeTipo, saldo);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }

    @Override
    public boolean saca(double valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void remunera() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean deposita(double valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
