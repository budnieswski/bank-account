package bank.swing;

import bank.dao.ContaDAO;
import bank.model.Cliente;
import bank.model.Conta;
import bank.model.ContaCorrente;
import bank.model.ContaInvestimento;
import bank.model.FormatMoney;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Guilherme
 */
public class ContaFrame extends javax.swing.JFrame {
    
    private Cliente cliente;
    private Conta conta = null;
    private ContaDAO contaDAO;

    /**
     * Creates new form CriarConta
     */
    public ContaFrame(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(System.getProperty("user.dir")+"/resource/icon.png").getImage());
        
        this.cliente = cliente;
        this.contaDAO = new ContaDAO();
        
        if (this.cliente.getIdConta() != 0) {
            this.conta = this.contaDAO.getConta(cliente);
            
            this.setTitle("Editar Conta");
            
            // Deixa definido o tipo da conta
            if (this.conta.getIdTipo()==1)
                this.fieldTipo.setSelectedIndex(1);
            
            this.viewCheckConta( this.conta.getIdTipo() );
       }
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                new Inicio();
                dispose();
            }
        });
    }
    
    public void viewChangeContaCorrente() {
        // DB id 1
        txtComum1.setText("Limite:");
        txtComum2.setText("Numero:");
        fieldComum2.setEnabled(false); 
        fieldComum2.setHorizontalAlignment( JTextField.CENTER );
        fieldComum2.setText( this.contaDAO.getNextContaId() + "" );
    }
    
    public void viewChangeContaInvestimento() {
        // DB id 2
        txtComum1.setText("Depósito Minimo:");
        txtComum2.setText("Montante Minimo:");
        fieldComum2.setEnabled(true);
        fieldComum2.setHorizontalAlignment( JTextField.RIGHT );
        fieldComum2.setText("");
    }

    public void viewCheckConta(int tipo) {
        switch (tipo) {
                case 1:
                    viewChangeContaCorrente();
                break;
                case 2:
                    viewChangeContaInvestimento();
                break;
        }
        
        if (this.conta != null) {        
            this.fieldDepositoInicial.setEnabled(false);
            this.fieldDepositoInicial.setText( FormatMoney.toString(this.conta.getSaldo()) );
            
            switch (this.conta.getIdTipo()) {
                case 1:
                    ContaCorrente CC = (ContaCorrente) this.conta;
                    
                    this.fieldComum1.setText( FormatMoney.toString(CC.getLimite()) );
                break;
                case 2:
                    ContaInvestimento CI = (ContaInvestimento) this.conta;

                    this.fieldComum1.setText( FormatMoney.toString(CI.getDepositoMinimo()) );
                    this.fieldComum2.setText( FormatMoney.toString(CI.getMontanteMinimo()) );                    
                break;
            }
            
            if (tipo==1)
                this.fieldComum2.setText( this.conta.getId() + "" );
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

        fieldDepositoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldDepositoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldDepositoInicialFocusLost(evt);
            }
        });

        txtComum1.setText("Depósito Minimo:");

        txtComum2.setText("Montante Minimo");

        fieldComum1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldComum1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldComum1FocusLost(evt);
            }
        });

        fieldComum2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldComum2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldComum2FocusLost(evt);
            }
        });

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
        if (fieldTipo.getSelectedIndex()==0)
            viewCheckConta(2);
        else if (fieldTipo.getSelectedIndex()==1)    
            viewCheckConta(1);
        
        
    }//GEN-LAST:event_fieldTipoItemStateChanged

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        new Inicio();
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Conta novaConta = null;
        try {            
            switch (fieldTipo.getSelectedIndex()) {
                case 0:
                    novaConta = new ContaInvestimento(
                        FormatMoney.toDouble(fieldComum2.getText()), // Montante
                        FormatMoney.toDouble(fieldComum1.getText()), // Deposito Min
                        this.cliente,
                        0, // id/numero
                        2, // idTipo
                        FormatMoney.toDouble(fieldDepositoInicial.getText()) // Saldo
                    );
                break;
                case 1:
                    novaConta = new ContaCorrente(
                        FormatMoney.toDouble(fieldComum1.getText()), // Limite
                        this.cliente,
                        0, // id/numero
                        1, // idTipo
                        FormatMoney.toDouble(fieldDepositoInicial.getText()) // Saldo
                    );                    
                break;
            }
            
            // Conta do cliente já existe
            if (this.conta != null) {
                novaConta.setId( this.conta.getId() );
                this.contaDAO.atualizar(novaConta);
                
                JOptionPane.showMessageDialog(null,"Conta atualizada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                novaConta.setId( this.contaDAO.getNextContaId() );
                this.contaDAO.adicionar(novaConta);
                
                JOptionPane.showMessageDialog(null,"Conta criada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao manipular conta. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void fieldDepositoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDepositoInicialFocusLost
        Double valor = FormatMoney.toDouble(this.fieldDepositoInicial.getText() );
        
        this.fieldDepositoInicial.setText( FormatMoney.toString(valor) );
    }//GEN-LAST:event_fieldDepositoInicialFocusLost

    private void fieldComum1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldComum1FocusLost
        Double valor = FormatMoney.toDouble(this.fieldComum1.getText() );
        
        this.fieldComum1.setText( FormatMoney.toString(valor) );
    }//GEN-LAST:event_fieldComum1FocusLost

    private void fieldComum2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldComum2FocusLost
        Double valor = FormatMoney.toDouble(this.fieldComum2.getText() );
        
        this.fieldComum2.setText( FormatMoney.toString(valor) );
    }//GEN-LAST:event_fieldComum2FocusLost

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
