/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import postoapplication.DAO.ClienteDAO;
import postoapplication.DAO.NotaFiscalDAO;
import postoapplication.model.Cliente;
import postoapplication.model.NotaFiscal;

/**
 *
 * @author Norton Wagner Martins
 */
public class NotaFiscalCabecalhoJDialog extends javax.swing.JDialog {

    public static NotaFiscal cabecalhoNota = new NotaFiscal();
    ClienteDAO clienteDAO;
    NotaFiscalDAO nfeDAO;

    public NotaFiscalCabecalhoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clienteDAO = new ClienteDAO();
        nfeDAO = new NotaFiscalDAO();
        setTfCodigo();
        try {
            carregaComboCliente(clienteDAO.getAll());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de "
                    + "dados\n ao tentar Carregar as informações");
            sqle.printStackTrace();
        } 
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paAbas = new javax.swing.JPanel();
        btCabecalho = new javax.swing.JButton();
        btItens = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDataEmissao = new javax.swing.JFormattedTextField();
        lbEmissao = new javax.swing.JLabel();
        paCliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfCodigoCliente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(tfSerie)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmissao))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        paCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Cliente:");

        jLabel7.setText("Cod. Cliente");

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                .addGroup(paClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paClienteLayout.createSequentialGroup()
                        .addComponent(tfCodigoCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
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
                    .addComponent(paAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSairCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRodapeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(paCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRodapeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSairCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if(tfNumero.getText().trim().length() > 0  &&  tfSerie.getText().trim().length() > 0  && tfDataEmissao.getText().trim().length() == 10) {
            btItens.setEnabled(true);
            btRodapeItens.setEnabled(true);
        }else {
            btItens.setEnabled(false);
            btRodapeItens.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        filtrarCodigoCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbEmissao;
    private javax.swing.JPanel paAbas;
    private javax.swing.JPanel paCliente;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JFormattedTextField tfDataEmissao;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfSerie;
    // End of variables declaration//GEN-END:variables

    
    private void carregaComboCliente(List<Cliente> listCliente) {
        try {
            DefaultComboBoxModel clienteModel = new DefaultComboBoxModel(listCliente.toArray());
            cbCliente.setModel(clienteModel);
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
        cabecalhoNota.setDataEmissao(Date.valueOf(formatarData(tfDataEmissao.getText())));
        this.dispose();
        NotaFiscalJDialog dialog = new NotaFiscalJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }
    
    private String formatarData(String data) {
        return data.substring(6, 10)+"-"+data.substring(3, 5)+"-"+data.substring(0, 2);
    }
    
    private void filtrarCodigoCliente() {
        try {
            Cliente cliente = clienteDAO.getById(Integer.parseInt(tfCodigoCliente.getText()));
            List<Cliente> clienteList = new ArrayList<>();
            for (Cliente cli : clienteDAO.getAll()) {
                if (cli.getCodigo() == Integer.parseInt(tfCodigoCliente.getText())) {
                    clienteList.add(cliente);
                    carregaComboCliente(clienteList);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "O código inserido não está cadastrado!");
            carregaComboCliente(clienteDAO.getAll());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a busca pelo cliente, tente novamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Inesperado ao buscar cliente!");
        }
    }
}