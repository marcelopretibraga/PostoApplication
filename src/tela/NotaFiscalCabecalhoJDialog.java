/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import postoapplication.DAO.ClienteDAO;
import postoapplication.DAO.FornecedorDAO;
import postoapplication.DAO.NotaFiscalDAO;
import postoapplication.model.Cliente;
import postoapplication.model.Fornecedor;
import postoapplication.model.NotaFiscal;

/**
 *
 * @author Norton Wagner Martins
 */
public class NotaFiscalCabecalhoJDialog extends javax.swing.JDialog {

    public static NotaFiscal cabecalhoNota;
    ClienteDAO clienteDAO;
    FornecedorDAO fornecedorDAO;
    NotaFiscalDAO nfeDAO;

    public NotaFiscalCabecalhoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clienteDAO = new ClienteDAO();
        fornecedorDAO = new FornecedorDAO();
        nfeDAO = new NotaFiscalDAO();
        setTfCodigo();
        try {
            verificaTipoNota(true);
            carregaComboCliente(clienteDAO.getAll());
            carregaComboFornecedor(fornecedorDAO.getAll());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de "
                    + "dados\n ao tentar Carregar as informações");
            sqle.printStackTrace();
        } 
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbTipoNota = new javax.swing.ButtonGroup();
        paAbas = new javax.swing.JPanel();
        btCabecalho = new javax.swing.JButton();
        btItens = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rbSaida = new javax.swing.JRadioButton();
        rbEntrada = new javax.swing.JRadioButton();
        tfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDataEmissao = new javax.swing.JFormattedTextField();
        lbEmissao = new javax.swing.JLabel();
        lbEntrada = new javax.swing.JLabel();
        tfDataEntrada = new javax.swing.JFormattedTextField();
        paCliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        paFornecedor = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btSairCabecalho = new javax.swing.JButton();
        btRodapeItens = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cabeçalho Nota Fiscal");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        btCabecalho.setText("Cabeçalho");
        btCabecalho.setEnabled(false);

        btItens.setText("Itens");
        btItens.setEnabled(false);
        btItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paAbasLayout = new javax.swing.GroupLayout(paAbas);
        paAbas.setLayout(paAbasLayout);
        paAbasLayout.setHorizontalGroup(
            paAbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paAbasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCabecalho)
                .addGap(6, 6, 6)
                .addComponent(btItens, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        paAbasLayout.setVerticalGroup(
            paAbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paAbasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paAbasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btItens, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Nota", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        gbTipoNota.add(rbSaida);
        rbSaida.setSelected(true);
        rbSaida.setText("Saída");
        rbSaida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSaidaItemStateChanged(evt);
            }
        });

        gbTipoNota.add(rbEntrada);
        rbEntrada.setText("Entrada");
        rbEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEntradaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbSaida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(rbEntrada)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSaida)
                    .addComponent(rbEntrada))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tfCodigo.setEnabled(false);

        jLabel1.setText("Código:");

        jLabel2.setText("Número:");

        jLabel4.setText("Série:");

        try {
            tfDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbEmissao.setText("Data de Emissão");

        lbEntrada.setText("Data de Entrada");

        try {
            tfDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel4))
                                    .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbEmissao)
                                .addGap(4, 4, 4)
                                .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lbEntrada)
                                .addGap(6, 6, 6)
                                .addComponent(tfDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Cliente:");

        jLabel7.setText("Cod. Cliente");

        jButton3.setText("Buscar");

        javax.swing.GroupLayout paClienteLayout = new javax.swing.GroupLayout(paCliente);
        paCliente.setLayout(paClienteLayout);
        paClienteLayout.setHorizontalGroup(
            paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paClienteLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        paClienteLayout.setVerticalGroup(
            paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paFornecedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Fornecedor");

        jLabel9.setText("Cod. Fornecedor");

        jButton4.setText("Buscar");

        javax.swing.GroupLayout paFornecedorLayout = new javax.swing.GroupLayout(paFornecedor);
        paFornecedor.setLayout(paFornecedorLayout);
        paFornecedorLayout.setHorizontalGroup(
            paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paFornecedorLayout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        paFornecedorLayout.setVerticalGroup(
            paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSairCabecalho.setText("Sair");
        btSairCabecalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairCabecalhoActionPerformed(evt);
            }
        });

        btRodapeItens.setText("Itens");
        btRodapeItens.setEnabled(false);
        btRodapeItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRodapeItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(paFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSairCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btRodapeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(paAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(paAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(paFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSairCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRodapeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btItensActionPerformed
        chamaNotaFiscalJDialog();
    }//GEN-LAST:event_btItensActionPerformed

    private void btRodapeItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRodapeItensActionPerformed
        chamaNotaFiscalJDialog();
    }//GEN-LAST:event_btRodapeItensActionPerformed

    private void btSairCabecalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairCabecalhoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairCabecalhoActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if(tfNumero.getText().trim().length() > 0  &&  tfSerie.getText().trim().length() > 0  && (tfDataEmissao.getText().trim().length() == 10  ||  tfDataEntrada.getText().trim().length() == 10)) {
            btItens.setEnabled(true);
            btRodapeItens.setEnabled(true);
        }else {
            btItens.setEnabled(false);
            btRodapeItens.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

    private void rbSaidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSaidaItemStateChanged
        tfDataEntrada.setText("");
        verificaTipoNota(true);
    }//GEN-LAST:event_rbSaidaItemStateChanged

    private void rbEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEntradaItemStateChanged
        tfDataEmissao.setText("");
        verificaTipoNota(false);
    }//GEN-LAST:event_rbEntradaItemStateChanged

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
            java.util.logging.Logger.getLogger(NotaFiscalCabecalhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalCabecalhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalCabecalhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalCabecalhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotaFiscalCabecalhoJDialog dialog = new NotaFiscalCabecalhoJDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCabecalho;
    private javax.swing.JButton btItens;
    private javax.swing.JButton btRodapeItens;
    private javax.swing.JButton btSairCabecalho;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbFornecedor;
    private javax.swing.ButtonGroup gbTipoNota;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbEmissao;
    private javax.swing.JLabel lbEntrada;
    private javax.swing.JPanel paAbas;
    private javax.swing.JPanel paCliente;
    private javax.swing.JPanel paFornecedor;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfDataEmissao;
    private javax.swing.JFormattedTextField tfDataEntrada;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfSerie;
    // End of variables declaration//GEN-END:variables

    
    private void verificaTipoNota(boolean visible) {
        paFornecedor.setVisible(!visible);
        tfDataEntrada.setVisible(!visible);
        lbEntrada.setVisible(!visible);
        paCliente.setVisible(visible);
        tfDataEmissao.setVisible(visible);
        lbEmissao.setVisible(visible);
    }
    
    private void carregaComboCliente(List<Cliente> listCliente) {
        try {
            DefaultComboBoxModel clienteModel = new DefaultComboBoxModel(listCliente.toArray());
            cbCliente.setModel(clienteModel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar COMBO BOX de CLIENTE. contate o suporte.\n[combobox]");
            ex.printStackTrace();
        }
    }

    private void carregaComboFornecedor(List<Fornecedor> listFornecedor) {
        try {
            DefaultComboBoxModel fornecedorModel = new DefaultComboBoxModel(listFornecedor.toArray());
            cbFornecedor.setModel(fornecedorModel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar COMBO BOX de CLIENTE. contate o suporte.\n[combobox]");
            ex.printStackTrace();
        }
    }
    
    private void setTfCodigo() {
        try {
            tfCodigo.setText(String.valueOf(nfeDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void chamaNotaFiscalJDialog() {
        cabecalhoNota.setCodigo(Integer.parseInt(tfCodigo.getText()));
        cabecalhoNota.setNumeroNota(Integer.parseInt(tfNumero.getText()));
        cabecalhoNota.setSerie(tfSerie.getText());
        cabecalhoNota.setCliente((Cliente)cbCliente.getSelectedItem());
        cabecalhoNota.setDataEmissao(Date.valueOf(tfDataEmissao.getText()));
        this.dispose();
        NotaFiscalJDialog dialog = new NotaFiscalJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }
}
