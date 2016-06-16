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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Guilherme
 */
public class ManipularFrame extends javax.swing.JFrame {
    
    private Cliente cliente;
    private Conta conta;
    private ContaDAO contaDAO;
    private String messageErroSaque;
    private String messageErroDeposito;

    /**
     * Creates new form ManipularFrame
     */
    public ManipularFrame(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.cliente = cliente;
        this.contaDAO = new ContaDAO();
        this.conta = this.contaDAO.getConta(cliente);
        this.txtSaldo.setText( parseTxtSaldo(this.conta.getSaldo()) );
        
        fieldValor.setHorizontalAlignment(JFormattedTextField.RIGHT);   
        
        // Define as messagens de acordo com o tipo de conta
        this.defineMessages();
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                new Inicio();
                dispose();
            }
        });
    }
    
    private void defineMessages() {
        switch (this.conta.getIdTipo()) {
            case 1:
                ContaCorrente cc = (ContaCorrente) this.conta;
                
                this.messageErroDeposito = "";
                
                this.messageErroSaque = "Saldo insuficiente para saque\n\n";
                this.messageErroSaque+= "Limite: " + this.parseTxtSaldo(cc.getLimite());
                this.messageErroSaque+= "\nSaldo: " + this.parseTxtSaldo(cc.getSaldo());
                this.messageErroSaque+= "\nTotal Disponivel: "+ this.parseTxtSaldo( (cc.getLimite()+cc.getSaldo()) );
            break;
            case 2:
                ContaInvestimento ci = (ContaInvestimento) this.conta;
                
                this.messageErroDeposito = "O valor de deposito deve ser no ";
                this.messageErroDeposito+= "minimo de "+this.parseTxtSaldo(ci.getDepositoMinimo()) ;
                
                this.messageErroSaque = "O saldo final não pode ser menor ";
                this.messageErroSaque+= "que o montante minimo ("+this.parseTxtSaldo(ci.getMontanteMinimo())+")";
            break;
        }
    }
    
    private String parseToString(Double input) {
        String value = "";
        
        NumberFormat format = NumberFormat.getCurrencyInstance();
               
        try {
            value = format.format( input );
        } catch (Exception e) {
            System.out.println("Parse error (toString). E: " + e.getMessage());
        }
        
        return value;
    }
    
    private Double parseToDouble(String input) {
        double value = 0.0;
        
        input = input.replace(".", "");
        input = input.replace(",", ".");
        
        NumberFormat format = NumberFormat.getInstance();
        
        try {
            value = format.parse(input.replaceAll("[^\\d]*([\\d,]*).*", "$1")).doubleValue();
        } catch (Exception e) {
            System.out.println("Parse error (toDouble). E: " + e.getMessage());
        }
        
        return value;
    }
    
    private String parseTxtSaldo(double valor) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        
        return format.format(valor);
    }
    
    private String montaExtrato() {
        String message = "";
        
        String tipoConta = (this.conta.getIdTipo()==2) ? "Conta Investimento" : "Conta Corrente";
        
        message += "Nome: " + this.cliente.getNome() + " " + this.cliente.getSobrenome();
        message += "\nTipo de conta: " + tipoConta;
        message += "\n\nSaldo: " + parseTxtSaldo(this.conta.getSaldo());
        
        switch (this.conta.getIdTipo()) {
            case 1:
                ContaCorrente cc = (ContaCorrente) this.conta;
                message += "\nLimite: " + parseTxtSaldo(cc.getLimite());
                message += "\nTotal Disponivel: " + parseTxtSaldo( (cc.getLimite()+cc.getSaldo()) );
            break;
            case 2:
                ContaInvestimento ci = (ContaInvestimento) this.conta;
                message += "\nDepósito minimo: " + parseTxtSaldo(ci.getDepositoMinimo());
                message += "\nMontante minimo: " + parseTxtSaldo(ci.getMontanteMinimo());
            break;
        }
        
        return message;
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
        btnFechar = new javax.swing.JButton();
        txtAcao = new javax.swing.JLabel();
        fieldAcao = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnExecutar = new javax.swing.JButton();
        txtViewSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        fieldValor = new javax.swing.JFormattedTextField();

        setTitle("Manipular");
        setResizable(false);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        txtAcao.setText("Açao:");

        fieldAcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sacar", "Depositar", "Aplicar Remuneração", "Tirar Extrato" }));
        fieldAcao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldAcaoItemStateChanged(evt);
            }
        });

        txtValor.setText("Valor:");

        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        txtViewSaldo.setText("Saldo: ");

        txtSaldo.setText("0,00");

        fieldValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldValorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtViewSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSaldo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnExecutar)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAcao)
                                .addGap(18, 18, 18)
                                .addComponent(fieldAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnFechar)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValor)
                                .addGap(18, 18, 18)
                                .addComponent(fieldValor)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcao)
                    .addComponent(fieldAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor)
                    .addComponent(fieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnExecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewSaldo)
                    .addComponent(txtSaldo))
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        new Inicio();
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void fieldAcaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fieldAcaoItemStateChanged
        fieldValor.setEnabled(true);
        
        // Remuneracao & Tirar extrato
        if (fieldAcao.getSelectedIndex()==2 || fieldAcao.getSelectedIndex()==3)
            fieldValor.setEnabled(false);
    }//GEN-LAST:event_fieldAcaoItemStateChanged

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
      
        if (fieldAcao.getSelectedIndex()==0) {
            // Sacar
            double valor = this.parseToDouble(this.fieldValor.getText());
            
            if (valor < 0)
                JOptionPane.showMessageDialog(null,"Valor de saque não pode ser menor que 0 (zero)", "Erro", JOptionPane.OK_OPTION);
            else {
                boolean rs = this.conta.saca(valor);
                if (rs) {
                    this.contaDAO.atualizar(this.conta);
                    this.txtSaldo.setText( parseTxtSaldo(this.conta.getSaldo()) );

                    JOptionPane.showMessageDialog(null,"Valor sacado corretamente!", "Sucesso", JOptionPane.OK_OPTION);
                } else
                    JOptionPane.showMessageDialog(null, this.messageErroSaque, "Erro", JOptionPane.OK_OPTION);
            }
        
        } else if (fieldAcao.getSelectedIndex()==1) {
            // Depositar
            double valor = this.parseToDouble(this.fieldValor.getText());
            
            System.out.println(valor);
            
            if (valor < 0)
                JOptionPane.showMessageDialog(null,"Valor de saque não pode ser menor que 0 (zero)", "Erro", JOptionPane.OK_OPTION);
            else {            
                boolean rs = this.conta.deposita(valor);
                if (rs) {
                    this.contaDAO.atualizar(this.conta);
                    this.txtSaldo.setText( parseTxtSaldo(this.conta.getSaldo()) );

                    JOptionPane.showMessageDialog(null,"Valor depositado corretamente!", "Sucesso", JOptionPane.OK_OPTION);
                } else
                    JOptionPane.showMessageDialog(null,this.messageErroDeposito, "Erro", JOptionPane.OK_OPTION);
            }
        }
        else if (fieldAcao.getSelectedIndex()==2) {
            // Remuneracao
            System.out.println("--------------------------");
            System.out.println("Remuneracao");
            System.out.println("Antes: " + this.conta.getSaldo());
            
            this.conta.remunera();
            this.contaDAO.atualizar(this.conta);
            this.txtSaldo.setText( parseTxtSaldo(this.conta.getSaldo()) );
            
            System.out.println("Depois: " + this.conta.getSaldo());
            System.out.println("--------------------------");
        }
        else if (fieldAcao.getSelectedIndex()==3)
            JOptionPane.showMessageDialog(null, this.montaExtrato(), "Extrato", JOptionPane.NO_OPTION);
    }//GEN-LAST:event_btnExecutarActionPerformed

    private void fieldValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldValorFocusLost
        System.out.println("Antes:" + fieldValor.getText() );
        
        Double valor = this.parseToDouble( this.fieldValor.getText() );
        
        this.fieldValor.setText( this.parseToString(valor) );
    }//GEN-LAST:event_fieldValorFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> fieldAcao;
    private javax.swing.JFormattedTextField fieldValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtAcao;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtValor;
    private javax.swing.JLabel txtViewSaldo;
    // End of variables declaration//GEN-END:variables
}
