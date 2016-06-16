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
        if(super.saldo-valor >= this.montanteMinimo){
            return super.saca(valor);
        }
        else{
            return false;
        }
    }
    
    @Override
    public void remunera() {
        super.saldo += super.saldo*0.02;
    }
    
    @Override
    public boolean deposita(double valor) {
        if(valor >= this.depositoMinimo){
            return super.deposita(valor);
        }
        else{
            return false;
        }
    }
    
    
}
