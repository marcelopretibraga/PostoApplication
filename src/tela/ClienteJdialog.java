/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import postoapplication.DAO.ClienteDAO;
import postoapplication.model.Cliente;

/**
 *
 * @author joseb
 */
public class ClienteJdialog extends javax.swing.JDialog {

    private ClienteDAO clienteDAO;

    /**
     * Creates new form ClienteJdialog
     */
    public ClienteJdialog(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        clienteDAO = new ClienteDAO();
        try {
            carregaTable(clienteDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(CombustivelJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        btSalvar.setEnabled(false);
        tfCodigoCliente.setEnabled(false);
        desabilitaCampos(false);
        habilitaFiltroCodigo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfCodigoCliente = new javax.swing.JTextField();
        tfEnderecoCliente = new javax.swing.JTextField();
        tfNomeCliente = new javax.swing.JTextField();
        tfCpfCliente = new javax.swing.JTextField();
        tfTelefoneCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btFiltrar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        tfCodigoFt = new javax.swing.JTextField();
        tfNomeFt = new javax.swing.JTextField();
        rbNome = new javax.swing.JRadioButton();
        rbCodigo = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo");

        tfEnderecoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEnderecoClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Endereço");

        jLabel3.setText("CPF/CNPJ");

        jLabel4.setText("Nome");

        jLabel5.setText("Telefone");

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Cpf/Cnpj", "Telefone", "Endereco"
            }
        ));
        jScrollPane2.setViewportView(tbCliente);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNome);
        rbNome.setText("Nome");
        rbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbNomeItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbCodigo);
        rbCodigo.setText("Codigo");
        rbCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCodigoItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Cadastro");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Filtrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigoFt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeFt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(tfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(tfEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btSalvar))
                        .addGap(26, 26, 26))
                    .addComponent(btNovo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeFt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNome)
                    .addComponent(tfCodigoFt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCodigo))
                .addGap(39, 39, 39)
                .addComponent(btFiltrar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btRemover)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEnderecoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEnderecoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEnderecoClienteActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar();

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        filtrar();
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void rbCodigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCodigoItemStateChanged
        habilitaFiltroCodigo();
    }//GEN-LAST:event_rbCodigoItemStateChanged

    private void rbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNomeItemStateChanged
       habilitaFiltroNome();
    }//GEN-LAST:event_rbNomeItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteJdialog dialog = new ClienteJdialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void carregaTable(List<Cliente> clienteList) {
        if (clienteList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbCliente.getModel();
        model.setRowCount(0);
        for (Cliente c : clienteList) {
            model.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getCpfCnpj(), c.getTelefone(), c.getEndereco()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfCodigoFt;
    private javax.swing.JTextField tfCpfCliente;
    private javax.swing.JTextField tfEnderecoCliente;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNomeFt;
    private javax.swing.JTextField tfTelefoneCliente;
    // End of variables declaration//GEN-END:variables

    private void remover() {
        int linhaSelecionada = tbCliente.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Deve-se selecionar uma linha para ser removido");
            return;
        }
        int codigoRemover = (int) tbCliente.getValueAt(linhaSelecionada, 0);
        try {
            clienteDAO.delete(codigoRemover);
            JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso!");
            carregaTable(clienteDAO.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void salvar() {
        Cliente cliente = new Cliente();
        cliente.setCodigo(Integer.parseInt(tfCodigoCliente.getText()));
        cliente.setCpfCnpj(Integer.parseInt(tfCpfCliente.getText()));
        cliente.setEndereco(tfEnderecoCliente.getText());
        cliente.setNome(tfNomeCliente.getText());
        cliente.setTelefone(tfTelefoneCliente.getText());
        try {
            clienteDAO.save(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso");
            limpaCampos();
            carregaTable(clienteDAO.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void limpaCampos() {
        tfCodigoCliente.setText("");
        tfNomeCliente.setText("");
        tfEnderecoCliente.setText("");
        tfCpfCliente.setText("");
        tfTelefoneCliente.setText("");
    }

    private void filtrar() {
        try {
            if (rbCodigo.isSelected() && tfCodigoFt.getText().trim().length() > 0) {
                Cliente cliente = clienteDAO.getById(Integer.parseInt(tfCodigoFt.getText()));
                List<Cliente> clienteList = new ArrayList<>();
                clienteList.add(cliente);
                carregaTable(clienteList);
            } else if (rbNome.isSelected() && tfNomeFt.getText().trim().length() > 0) {
                carregaTable(clienteDAO.getByName(tfNomeFt.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Informe qual filtro desejado para pesquisa");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void desabilitaCampos(boolean ativo) {
        tfCodigoCliente.setEnabled(ativo);
        tfNomeCliente.setEnabled(ativo);
        tfEnderecoCliente.setEnabled(ativo);
        tfCpfCliente.setEnabled(ativo);
        tfTelefoneCliente.setEnabled(ativo);
    }

    private void novo() {
        try {
            tfCodigoCliente.setText(String.valueOf(clienteDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btSalvar.setEnabled(true);
    }

    private void habilitaFiltroCodigo() {
        tfNomeFt.setText("");
        tfNomeFt.setEnabled(false);
        tfCodigoFt.setEnabled(true);
    }

    private void habilitaFiltroNome() {
        tfCodigoFt.setText("");
        tfCodigoFt.setEnabled(false);
        tfNomeFt.setEnabled(true);
    }
}
