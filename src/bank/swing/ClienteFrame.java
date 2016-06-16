package bank.swing;

import bank.dao.ClienteDAO;
import bank.model.Cliente;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Guilherme
 */
public class ClienteFrame extends javax.swing.JFrame {

    private Cliente cliente;
    
    /**
     * Creates new form ClienteFrame
     */
    public ClienteFrame() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        
    }
    
    public ClienteFrame(Cliente cliente) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        if (cliente != null) {
            this.cliente = cliente;
                
            fieldNome.setText( cliente.getNome() );
            fieldSobrenome.setText(cliente.getSobrenome());
            fieldEndereco.setText(cliente.getEndereco());
            fieldCPF.setText(cliente.getCPF());
            fieldRG.setText(cliente.getRG());
            
            // Faz um 'polimorfismo' do botão
            // Evita criar 2 telas para basicamente a mesma função 'cadast/edit'
            btnSalvar.setText("Atualizar");
            btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
            
        }
    }
    
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ClienteDAO dao = null;
        
        System.out.println("Antes: "+ cliente.getNome());
        
        // Atualizando os dados no objeto
        this.cliente.setNome(fieldNome.getText());
        this.cliente.setSobrenome(fieldSobrenome.getText() );
        this.cliente.setEndereco(fieldEndereco.getText() );
        this.cliente.setCPF(fieldCPF.getText() );
        this.cliente.setRG(fieldRG.getText() );
        
        System.out.println("Depois: "+ cliente.getNome());
        
        // Atualizando com o banco
        try {
            dao = new ClienteDAO();
            dao.atualizar(this.cliente);
            JOptionPane.showMessageDialog(null,"Cliente atualizado !", "Sucesso", JOptionPane.OK_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        txtNome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JLabel();
        fieldSobrenome = new javax.swing.JTextField();
        fieldNome = new javax.swing.JTextField();
        fieldEndereco = new javax.swing.JTextField();
        txtCPF = new javax.swing.JLabel();
        fieldCPF = new javax.swing.JTextField();
        txtRG = new javax.swing.JLabel();
        fieldRG = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Editar Cliente");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        txtNome.setText("Nome:");

        txtSobrenome.setText("Sobrenome:");

        txtEndereco.setText("Endereço:");

        txtCPF.setText("CPF:");

        txtRG.setText("RG:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtNome)
                        .addGap(18, 18, 18)
                        .addComponent(fieldNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEndereco)
                            .addComponent(txtSobrenome)
                            .addComponent(txtCPF))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldSobrenome)
                            .addComponent(fieldEndereco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtRG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSobrenome))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco)
                    .addComponent(fieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCPF))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRG)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Previne ação duplicada, por conta do polimorfismo do botão
        if (this.cliente == null) {
            ClienteDAO dao = null;
            Cliente cliente = new Cliente();
            
            cliente.setNome(fieldNome.getText());
            cliente.setSobrenome(fieldSobrenome.getText() );
            cliente.setEndereco(fieldEndereco.getText() );
            cliente.setCPF(fieldCPF.getText() );
            cliente.setRG(fieldRG.getText() );

            try {
                dao = new ClienteDAO();
                dao.adicionar(cliente);
                JOptionPane.showMessageDialog(null,"Cliente cadastrado !", "Sucesso", JOptionPane.OK_OPTION);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar no banco de dados. E="+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        new Inicio();
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField fieldCPF;
    private javax.swing.JTextField fieldEndereco;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldRG;
    private javax.swing.JTextField fieldSobrenome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtCPF;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtRG;
    private javax.swing.JLabel txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
