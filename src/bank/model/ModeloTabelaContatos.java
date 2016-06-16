package bank.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael
 */
public class ModeloTabelaContatos extends AbstractTableModel{
    private String[] colunas = new String[]
        {"ID", "Nome", "Sobrenome", "RG", "CPF"};

    private List<Cliente> lista=new ArrayList();

    public ModeloTabelaContatos() {}
    
    public ModeloTabelaContatos(List<Cliente> lista){
        this.lista=lista;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();
            case 1: return customer.getNome();
            case 2: return customer.getSobrenome();
            case 3: return customer.getCPF();
            case 4: return customer.getRG();
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Cliente customer = lista.get(row);
            switch (col) {
                case 0:
                    customer.setId((int) value); //if column 0 (code)
                    break;
                case 1:
                    customer.setNome((String) value);
                    break;
                case 2:
                    customer.setSobrenome((String) value);
                    break;
                case 3:
                    customer.setRG((String) value);
                    break;
                case 4:
                    customer.setCPF((String) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean removerCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void adicionarCliente(Cliente customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaClientes(List<Cliente> clientes) {
        this.lista = clientes;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limparTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }
    
    public List<Cliente> getLista(int[] indices){
        List<Cliente> lista = new ArrayList();
        for(int i=0; i<indices.length;i++){
            lista.add(this.lista.get(indices[i]));
        }
        return lista;
    }
}
