package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public class ContaCorrente extends Conta {
    private double limite;
    
    public ContaCorrente() {
    }

    public ContaCorrente(double limite, Cliente dono, int id, int idTipo, double saldo) {
        super(dono, id, idTipo, saldo);
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
        if(super.saldo-valor > 0- this.limite){
            return super.saca(valor);
        }
        else{
            return false;
        }
    }
    
    @Override
    public void remunera() {
        super.saldo += super.saldo*0.01;
    }
}
