package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public abstract class Conta implements ContaInterface {
    protected Cliente dono;
    private int id;
    private int idTipo;
    protected double saldo;
    
    public Conta() {
    }

    public Conta(Cliente dono, int id, int idTipo, double saldo) {
        this.dono = dono;
        this.id = id;
        this.idTipo = idTipo;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public boolean deposita(double valor) {
        if(valor > 0){
            this.saldo += valor;
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean saca(double valor) {
        if(valor > 0){
            this.saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Cliente getDono() {
        return this.dono;
    }

    @Override
    public int getNumero() {
        return this.id;
    }
}
