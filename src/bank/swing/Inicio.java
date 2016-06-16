/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.swing;

import bank.dao.ClienteDAO;
import bank.model.Cliente;
import bank.model.ModeloTabelaContatos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
     private ModeloTabelaContatos modeloTabela;
     private int linhaClicada=-1;
    
    public Inicio() {
        this.modeloTabela = new ModeloTabelaContatos();
        
        initComponents();        
        
        this.listar();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Account");
        setPreferredSize(new java.awt.Dimension(550, 450));
        setResizable(false);

        tabela.setModel(modeloTabela);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
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

        btnCriarConta.setText("Criar Conta");
        btnCriarConta.setEnabled(false);
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInserir)
                        .addGap(152, 152, 152)
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
                    .addComponent(btnCriarConta))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void listar() {
        try {
            ClienteDAO dao = new ClienteDAO();
            modeloTabela.setListaClientes(dao.listar());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCriarConta.setEnabled(true);
       
        linhaClicada = tabela.rowAtPoint(evt.getPoint());
        //Pega o contato da linha clidada
        Cliente contato = modeloTabela.getCliente(linhaClicada);
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse cliente?", "Aviso", JOptionPane.YES_NO_OPTION);

        if (option == 0) {
            try {
                ClienteDAO dao = new ClienteDAO();
                int[] linhasSelecionadas = tabela.getSelectedRows();
                List<Cliente> listaExcluir = new ArrayList();
                for (int i = 0; i < linhasSelecionadas.length; i++) {
                    Cliente cliente = modeloTabela.getCliente(linhasSelecionadas[i]);
                    dao.excluir(cliente);
                    listaExcluir.add(cliente);
                }
                for(Cliente cliente:listaExcluir){
                    modeloTabela.removerCliente(cliente);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao realizar exclusão de contatos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(linhaClicada!=-1){
            Cliente cliente = modeloTabela.getCliente(linhaClicada);
            ClienteFrame telaEditar = new ClienteFrame(cliente);
            telaEditar.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        ClienteFrame tela = new ClienteFrame();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        CriarConta tela = new CriarConta();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCriarContaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JTextField fieldFiltrar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
