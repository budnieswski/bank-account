package bank.model;

/**
 *
 * @author Bruno e Guilherme
 */
public abstract class Conta implements ContaInterface {
    private Long id;
    private int idTipo;
    private String nomeTipo;
    protected double saldo;

    public Conta(Long id, int idTipo, String nomeTipo, double saldo) {
        this.id = id;
        this.idTipo = idTipo;
        this.nomeTipo = nomeTipo;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumero() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
