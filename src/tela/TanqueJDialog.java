package tela;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import postoapplication.DAO.CombustivelDAO;
import postoapplication.DAO.TanqueDAO;
import postoapplication.model.Combustivel;
import postoapplication.model.Tanque;

/**
 *
 * @author Felipe
 */
public class TanqueJDialog extends javax.swing.JDialog {

    TanqueDAO tDao = new TanqueDAO();
    CombustivelDAO cDao = new CombustivelDAO();

    public TanqueJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tDao = new TanqueDAO();
        try {
            tfCodigo.setText(String.valueOf(tDao.getLastId()));
            carregaTable(tDao.getAll());
            carregaComboBox(cDao.getAll());
            tfCodigoBusca.setEnabled(false);
            tfDescricaoBusca.setEnabled(false);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de "
                    + "dados\n ao tentar salvar as informações");
            sqle.printStackTrace();
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

        gpBusca = new javax.swing.ButtonGroup();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        lbCapacidade = new javax.swing.JLabel();
        tfCapacidade = new javax.swing.JTextField();
        lbCombustivel = new javax.swing.JLabel();
        cbCombustivel = new javax.swing.JComboBox<>();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        spTanque = new javax.swing.JScrollPane();
        tbTanque = new javax.swing.JTable();
        lbBuscarPor = new javax.swing.JLabel();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        lbCodigoBusca = new javax.swing.JLabel();
        tfCodigoBusca = new javax.swing.JTextField();
        lbDescricaoBusca = new javax.swing.JLabel();
        tfDescricaoBusca = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbCodigo.setText("Código");

        tfCodigo.setEnabled(false);

        lbDescricao.setText("Descrição");

        lbCapacidade.setText("Capacidade");

        lbCombustivel.setText("Combustivel");

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

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

        tbTanque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Descr.", "Comb.", "Cap."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTanque.setViewportView(tbTanque);

        lbBuscarPor.setText("Buscar por:");

        gpBusca.add(rbCodigo);
        rbCodigo.setText("Código");
        rbCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                codigoStateChanged(evt);
            }
        });

        gpBusca.add(rbDescricao);
        rbDescricao.setText("Descrição");
        rbDescricao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                descricaoStateChanged(evt);
            }
        });

        lbCodigoBusca.setText("Código");

        lbDescricaoBusca.setText("Desc.:");

        btBuscar.setText("🔎");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(lbCodigo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(lbDescricao)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbBuscarPor)
                                    .addComponent(lbCapacidade))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbCombustivel))
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbCodigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btRemover)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(spTanque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbCodigoBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDescricaoBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDescricaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescricao)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCapacidade)
                    .addComponent(tfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCombustivel)
                    .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBuscarPor)
                    .addComponent(rbCodigo)
                    .addComponent(rbDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoBusca)
                    .addComponent(tfCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescricaoBusca)
                    .addComponent(tfDescricaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTanque, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
        try {
            tDao.save(getTanqueInserido());
            carregaTable(tDao.getAll());
            tfCodigo.setText(String.valueOf(tDao.getLastId()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        try {
            if (tbTanque.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Selecione a linha "
                        + "referente \nao registro que deseja remover.");
            } else {
                tDao.delete((int) tbTanque.getValueAt(
                        tbTanque.getSelectedRow(), 0));
                carregaTable(tDao.getAll());
                tfCodigo.setText(String.valueOf(tDao.getLastId()));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        List<Tanque> tanqueList = new ArrayList();
        try {
            if (rbCodigo.isSelected() &&
                    tfCodigoBusca.getText().length() > 0) {
                Tanque tanque = tDao.getById(Integer.parseInt(tfCodigoBusca.getText().trim()));
                tanqueList.add(tanque);
                carregaTable(tanqueList);
            } else if (rbDescricao.isSelected() && 
                    tfDescricaoBusca.getText().length() > 0) {
                carregaTable(tDao.getByName(tfDescricaoBusca.getText()));
            } else if (tfCodigoBusca.getText().trim().length() == 0 &&
                    tfDescricaoBusca.getText().trim().length() == 0) {
                carregaTable(tDao.getAll());
            } else {
                carregaTable(tanqueList);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco.");
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void codigoStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_codigoStateChanged
        habilitaBuscaId();
    }//GEN-LAST:event_codigoStateChanged

    private void descricaoStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_descricaoStateChanged
        habilitaBuscaDs();
    }//GEN-LAST:event_descricaoStateChanged

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
            java.util.logging.Logger.getLogger(TanqueJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TanqueJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TanqueJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TanqueJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TanqueJDialog dialog = new TanqueJDialog(new javax.swing.JFrame(), true);
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

    private void carregaTable(List<Tanque> tanques) {
        if (tanques != null) {
            DefaultTableModel tbTanqueModel
                    = (DefaultTableModel) tbTanque.getModel();
            tbTanqueModel.setRowCount(0);
            for (Tanque t : tanques) {
                tbTanqueModel.addRow(new Object[]{
                    t.getCodigo(),
                    t.getDescricao(),
                    t.getCombustivel().getTipoCombustivel(),
                    t.getCapacidade()
                });
            };
        }

    }
    
    private void carregaComboBox(List<Combustivel> combustivelList) {
        try {
            DefaultComboBoxModel combustivelModel = 
                    new DefaultComboBoxModel(combustivelList.toArray());
            cbCombustivel.setModel(combustivelModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro. contate o suporte.\n[combobox]");
            ex.printStackTrace();
        }
    }

    private Tanque getTanqueInserido() {
        Tanque t = new Tanque();
        t.setCodigo(Integer.parseInt(tfCodigo.getText()));
        t.setDescricao(tfDescricao.getText());
        t.setCapacidade(Double.parseDouble(tfCapacidade.getText()));
        t.setCombustivel((Combustivel) cbCombustivel.getSelectedItem());
        t.setUsuario(1);
        return t;
    }

    private void setEnabledCampos(boolean status) {
        tfCodigo.setEnabled(status);
        tfDescricao.setEnabled(status);
    }

    private void limpaCampos() {
        tfDescricao.setText("");
        tfCapacidade.setText("");
        cbCombustivel.setSelectedIndex(0);
    }
    
    private void habilitaBuscaId() {
        tfCodigoBusca.setEnabled(true); 
        tfDescricaoBusca.setEnabled(false);
        tfDescricaoBusca.setText("");
    }
    
    private void habilitaBuscaDs() {
        tfDescricaoBusca.setEnabled(true);
        tfCodigoBusca.setEnabled(false);
        tfCodigoBusca.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbCombustivel;
    private javax.swing.ButtonGroup gpBusca;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBuscarPor;
    private javax.swing.JLabel lbCapacidade;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCodigoBusca;
    private javax.swing.JLabel lbCombustivel;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbDescricaoBusca;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JScrollPane spTanque;
    private javax.swing.JTable tbTanque;
    private javax.swing.JTextField tfCapacidade;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoBusca;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfDescricaoBusca;
    // End of variables declaration//GEN-END:variables


}
