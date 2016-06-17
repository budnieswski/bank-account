package bank.swing;

import bank.dao.ClienteDAO;
import bank.model.Cliente;
import bank.model.TabelaClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
     private TabelaClientes tabelaClientes;
     private int linhaClicada=-1;
    
    public Inicio() {
        this.tabelaClientes = new TabelaClientes();
        
        initComponents();        
        this.setIconImage(new ImageIcon(System.getProperty("user.dir")+"/resource/icon.png").getImage());
        
        this.listar();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.tabela.setAutoCreateRowSorter(true);
    }
    
    private void actionFiltrar() {
        try {
            ClienteDAO dao = new ClienteDAO();
            if (fieldFiltrar.getText().equals(""))
                tabelaClientes.setListaClientes(dao.listar());
            else
                tabelaClientes.setListaClientes( dao.filtrar( fieldFiltrar.getText() ) );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao filtrar. E:"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actionEditar() {
        if(linhaClicada!=-1){
            Cliente cliente = tabelaClientes.getCliente(linhaClicada);
            ClienteFrame telaEditar = new ClienteFrame(cliente);
            telaEditar.setVisible(true);
            dispose();
        }
    }
    
    public void listar() {
        try {
            ClienteDAO dao = new ClienteDAO();
            tabelaClientes.setListaClientes(dao.listar());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        scrollPanel = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        fieldFiltrar = new javax.swing.JTextField();
        btnCriarConta = new javax.swing.JButton();
        btnManipular = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Account");
        setPreferredSize(new java.awt.Dimension(550, 450));
        setResizable(false);

        tabela.setModel(tabelaClientes);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        scrollPanel.setViewportView(tabela);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnFiltrar.setText("FIltrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        fieldFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldFiltrarKeyPressed(evt);
            }
        });

        btnCriarConta.setText("Criar Conta");
        btnCriarConta.setEnabled(false);
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
            }
        });

        btnManipular.setText("Manipular");
        btnManipular.setEnabled(false);
        btnManipular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManipularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnCriarConta)
                        .addGap(18, 18, 18)
                        .addComponent(btnManipular)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInserir)
                        .addGap(159, 159, 159)
                        .addComponent(fieldFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnFiltrar)
                    .addComponent(fieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCriarConta)
                    .addComponent(btnManipular))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        linhaClicada = tabela.rowAtPoint(evt.getPoint());
        Cliente cliente = tabelaClientes.getCliente(linhaClicada);
        
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCriarConta.setEnabled(true);
        
        // So ativa o manipular, se o cliente ja tiver uma conta
        if( cliente.getIdConta() != 0 ) {
            btnCriarConta.setText("Editar Conta");
            btnManipular.setEnabled(true);
        }
        else {
            btnCriarConta.setText("Criar Conta");
            btnManipular.setEnabled(false);
        }
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int option = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir esse cliente?" +
                 "\nTodas as contas associadas serão apagadas !!"
                , "Aviso", JOptionPane.YES_NO_OPTION);

        if (option == 0) {
            try {
                ClienteDAO dao = new ClienteDAO();
                int[] linhasSelecionadas = tabela.getSelectedRows();
                List<Cliente> listaExcluir = new ArrayList();
                for (int i = 0; i < linhasSelecionadas.length; i++) {
                    Cliente cliente = tabelaClientes.getCliente(linhasSelecionadas[i]);
                    dao.excluir(cliente);
                    listaExcluir.add(cliente);
                }
                for(Cliente cliente:listaExcluir){
                    tabelaClientes.removerCliente(cliente);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao realizar exclusão de contatos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.actionEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        ClienteFrame tela = new ClienteFrame();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        Cliente cliente = tabelaClientes.getCliente(linhaClicada);
        ContaFrame tela = new ContaFrame(cliente);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCriarContaActionPerformed

    private void btnManipularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManipularActionPerformed
        Cliente cliente = tabelaClientes.getCliente(linhaClicada);
        ManipularFrame tela = new ManipularFrame(cliente);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManipularActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        this.actionFiltrar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void fieldFiltrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFiltrarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)
            this.actionFiltrar();
    }//GEN-LAST:event_fieldFiltrarKeyPressed

    private void tabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMousePressed
        if (evt.getClickCount() == 2) {
            this.actionEditar();
        }
    }//GEN-LAST:event_tabelaMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnManipular;
    private javax.swing.JTextField fieldFiltrar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
