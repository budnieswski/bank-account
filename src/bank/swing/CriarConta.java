/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.swing;

import bank.dao.ContaDAO;
import bank.model.Cliente;
import bank.model.Conta;
import bank.model.ContaCorrente;
import bank.model.ContaInvestimento;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class CriarConta extends javax.swing.JFrame {
    
    private Cliente cliente;

    /**
     * Creates new form CriarConta
     */
    public CriarConta(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.cliente = cliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTipo = new javax.swing.JLabel();
        fieldTipo = new javax.swing.JComboBox<>();
        txtDepositoInicial = new javax.swing.JLabel();
        fieldDepositoInicial = new javax.swing.JTextField();
        txtComum1 = new javax.swing.JLabel();
        txtComum2 = new javax.swing.JLabel();
        fieldComum1 = new javax.swing.JTextField();
        fieldComum2 = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Criar Conta");
        setResizable(false);

        txtTipo.setText("Tipo:");

        fieldTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Investimento", "Conta Corrente" }));
        fieldTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldTipoItemStateChanged(evt);
            }
        });

        txtDepositoInicial.setText("Depósito Inicial:");

        txtComum1.setText("Depósito Minimo:");

        txtComum2.setText("Montante Minimo");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnFechar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar))
                        .addComponent(fieldComum2)
                        .addComponent(fieldComum1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDepositoInicial, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtComum1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtTipo)
                            .addGap(18, 18, 18)
                            .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fieldDepositoInicial, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtComum2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo)
                    .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtDepositoInicial)
                .addGap(3, 3, 3)
                .addComponent(fieldDepositoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtComum1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldComum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtComum2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldComum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fieldTipoItemStateChanged
        
        if (fieldTipo.getSelectedIndex()==0) {
            // Conta Investimento - DB id 2
            txtComum1.setText("Depósito Minimo:");
            txtComum2.setText("Montante Minimo:");
            fieldComum2.setEnabled(true);
            fieldComum2.setText("");
        }
        else if (fieldTipo.getSelectedIndex()==1) {
            // Conta Corrente - DB id 1
            ContaDAO dao = new ContaDAO();
            
            txtComum1.setText("Limite:");
            txtComum2.setText("Numero:");
            fieldComum2.setEnabled(false);            
            fieldComum2.setText( dao.getNextContaId() + "" );
        }
    }//GEN-LAST:event_fieldTipoItemStateChanged

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        new Inicio();
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ContaDAO dao;
        Conta conta = null;
        
        try {
            dao = new ContaDAO();
            
            switch (fieldTipo.getSelectedIndex()) {
                case 0:
                    conta = new ContaInvestimento(
                        Double.parseDouble(fieldComum2.getText()), // Montante
                        Double.parseDouble(fieldComum1.getText()), // Deposito Min
                        this.cliente,
                        dao.getNextContaId(), // id/numero
                        2, // idTipo
                        Double.parseDouble(fieldDepositoInicial.getText()) // Saldo
                    );
                break;
                case 1:
                    conta = new ContaCorrente(
                        Double.parseDouble(fieldComum1.getText()), // Limite
                        this.cliente,
                        Integer.parseInt(fieldComum2.getText()), // id/numero
                        1, // idTipo
                        Double.parseDouble(fieldDepositoInicial.getText()) // Saldo
                    );                    
                break;
            }
            
            dao.adicionar(conta);
            
            JOptionPane.showMessageDialog(null,"Conta criada!", "Sucesso", JOptionPane.OK_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao criar conta no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField fieldComum1;
    private javax.swing.JTextField fieldComum2;
    private javax.swing.JTextField fieldDepositoInicial;
    private javax.swing.JComboBox<String> fieldTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtComum1;
    private javax.swing.JLabel txtComum2;
    private javax.swing.JLabel txtDepositoInicial;
    private javax.swing.JLabel txtTipo;
    // End of variables declaration//GEN-END:variables
}
