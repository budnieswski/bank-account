package bank.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme
 */
public class TabelaClientes extends AbstractTableModel {
    private static final int COLUMN_ID          = 0;
    private static final int COLUMN_NOME        = 1;
    private static final int COLUMN_SOBRENOME   = 2;
    private static final int COLUMN_RG          = 3;
    private static final int COLUMN_CPF         = 4;
    
    private String[] colunas = {"ID", "Nome", "Sobrenome", "RG", "CPF"};
    private List<Cliente> lista=new ArrayList();

    public TabelaClientes() {}
    
    public TabelaClientes(List<Cliente> lista){
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
    public Class<?> getColumnClass(int columnIndex) {
        if (lista.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case COLUMN_ID: return customer.getId();
            case COLUMN_NOME: return customer.getNome();
            case COLUMN_SOBRENOME: return customer.getSobrenome();
            case COLUMN_CPF: return customer.getCPF();
            case COLUMN_RG: return customer.getRG();
            default : throw new IllegalArgumentException("Invalid column index");
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Cliente customer = lista.get(row);
            switch (col) {
                case COLUMN_ID:
                    customer.setId((int) value);
                    break;
                case COLUMN_NOME:
                    customer.setNome((String) value);
                    break;
                case COLUMN_SOBRENOME:
                    customer.setSobrenome((String) value);
                    break;
                case COLUMN_RG:
                    customer.setRG((String) value);
                    break;
                case COLUMN_CPF:
                    customer.setCPF((String) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean removerCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        
        // Update a JTable
        this.fireTableRowsDeleted(linha, linha);
        return result;
    }

    public void adicionarCliente(Cliente cliente) {
        this.lista.add(cliente);
        
        // Update a JTable
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);
    }

    public void setListaClientes(List<Cliente> clientes) {
        this.lista = clientes;
        this.fireTableDataChanged();
        // Update a JTable
        // this.fireTableRowsInserted(0,contatos.size()-1);
    }

    public void limparTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        
        // Update a JTable
        this.fireTableRowsDeleted(0,indice);
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
