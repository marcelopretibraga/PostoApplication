package tela;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import postoapplication.DAO.CombustivelDAO;
import postoapplication.DAO.NotaFiscalDAO;
import postoapplication.DAO.ValorCombustivelDAO;
import postoapplication.model.Combustivel;
import postoapplication.model.ItemNF;
import postoapplication.model.NotaFiscal;
import postoapplication.model.ValorCombustivel;

/**
 *
 * @author Norton Wagner Martins
 */
public class NotaFiscalJDialog extends javax.swing.JDialog {
    
    public static NotaFiscal nota = NotaFiscalCabecalhoJDialog.cabecalhoNota;
    CombustivelDAO combustivelDAO;
    NotaFiscalDAO notaFiscalDAO;
    ValorCombustivelDAO vlCombustivelDAO;

    public NotaFiscalJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        combustivelDAO  = new CombustivelDAO();
        notaFiscalDAO = new NotaFiscalDAO();
        carregaComboCombustivel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpTipoNota = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cbCombustivel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfVlUnit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfQnt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfVlDesconto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfVlTot = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfBuscarCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfBuscarDescricao = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btRemoverItem = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        paAbas1 = new javax.swing.JPanel();
        btCabecalho1 = new javax.swing.JButton();
        btItens1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "Quantidade", "Vl. Unitario", "Vl. Desconto", "Vl. Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItens.getTableHeader().setReorderingAllowed(false);
        tbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbItens);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbCombustivel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCombustivelItemStateChanged(evt);
            }
        });

        jLabel5.setText("Produto:");

        jLabel2.setText("Valor Unitario:");

        jLabel1.setText("Quantidade:");

        jLabel11.setText("Valor Desconto:");

        jLabel6.setText("Valor Total:");

        tfVlTot.setEnabled(false);

        btAdd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btAdd.setText("+");
        btAdd.setEnabled(false);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfVlDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfVlDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfQnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Filtros De Busca:");

        jLabel8.setText("Codigo do Produto");

        jLabel9.setText("Descricao do Produto");

        btBuscar.setText("Buscar");
        btBuscar.setEnabled(false);
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscarDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfBuscarDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBuscar)
                        .addGap(37, 37, 37))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Remover Da Nota?");

        btRemoverItem.setText("Sim");
        btRemoverItem.setEnabled(false);
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(btRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btRemoverItem))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btGravar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btGravar.setText("Gravar Nota");
        btGravar.setEnabled(false);
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btCabecalho1.setText("Cabeçalho");
        btCabecalho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCabecalho1ActionPerformed(evt);
            }
        });

        btItens1.setText("Itens");
        btItens1.setEnabled(false);

        javax.swing.GroupLayout paAbas1Layout = new javax.swing.GroupLayout(paAbas1);
        paAbas1.setLayout(paAbas1Layout);
        paAbas1Layout.setHorizontalGroup(
            paAbas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paAbas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCabecalho1)
                .addGap(6, 6, 6)
                .addComponent(btItens1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        paAbas1Layout.setVerticalGroup(
            paAbas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paAbas1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paAbas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btItens1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paAbas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paAbas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btCabecalho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCabecalho1ActionPerformed
        NotaFiscalCabecalhoJDialog.cabecalhoNota = nota;
        this.dispose();
        NotaFiscalCabecalhoJDialog dialog = new NotaFiscalCabecalhoJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btCabecalho1ActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        try {
            notaFiscalDAO.save(nota);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalJDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btGravarActionPerformed

    private void cbCombustivelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCombustivelItemStateChanged
        try {
            List<ValorCombustivel> vlCombustivelList = (vlCombustivelDAO.getByName(((Combustivel)cbCombustivel.getSelectedItem()).getDescricao()));
            tfVlUnit.setText(String.valueOf(vlCombustivelList.get(vlCombustivelList.size()-1)));
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cbCombustivelItemStateChanged

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        ItemNF item = new ItemNF();
        try {
            item.setCodigo(notaFiscalDAO.getLastIdItem());
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        item.setNotaFiscal(nota);
        item.setQuantidade(Double.parseDouble(tfQnt.getText()));
        item.setValorUnitario(Double.parseDouble(tfVlUnit.getText()));
        item.setValorDesconto(Double.parseDouble(tfVlDesconto.getText()));
        item.setValorTotal(Double.parseDouble(tfVlTot.getText()));
        item.setCombustivel((Combustivel)cbCombustivel.getSelectedItem());
        nota.getItensNF().add(item);
        carregaTabela(nota.getItensNF());
        limpaCampos();
    }//GEN-LAST:event_btAddActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if(tfVlUnit.getText().trim().length() > 0  &&  tfQnt.getText().trim().length() > 0) {
            calculaTotal();
            btAdd.setEnabled(true);
        }else {
            btAdd.setEnabled(false);
        }
        if(nota.getItensNF().size() > 0) {
            btGravar.setEnabled(true);
        }else {
            btGravar.setEnabled(false);
        }
        if(tfBuscarCodigo.getText().trim().length() > 0  ||  tfBuscarDescricao.getText().trim().length() > 0) {
            btBuscar.setEnabled(true);
        }else {
            btBuscar.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        btRemoverItem.setEnabled(true);
    }//GEN-LAST:event_tbItensMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        /*
        Será buscado pelo código por padrão:
        Se ambos os campos estiverem preenchidos, será buscado pelo código.
        */
        try {
            if(tfBuscarCodigo.getText().trim().length() > 0) {
                cbCombustivel.setSelectedItem(combustivelDAO.getById(Integer.parseInt(tfBuscarCodigo.getText())));
            }else {
                List<Combustivel> combustivelList = combustivelDAO.getByName(tfBuscarDescricao.getText());
                if(combustivelList.size() == 1) {
                    cbCombustivel.setSelectedItem(combustivelList.get(0));
                }else {
                    JOptionPane.showMessageDialog(null, "A pesquisa retornou muitos resultados ou nenhum");
                }
            }
        } catch(SQLException sqlex) {
            sqlex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        nota.getItensNF().remove((int) tbItens.getValueAt(tbItens.getSelectedRow(), 0));
        carregaTabela(nota.getItensNF());
        btRemoverItem.setEnabled(false);
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void calculaTotal() {
        Double vlTotal = Double.parseDouble(tfQnt.getText()) * Double.parseDouble(tfVlUnit.getText());
        if(!tfVlDesconto.getText().trim().isEmpty()) {
            vlTotal += Double.parseDouble(tfVlDesconto.getText());
        }
        tfVlTot.setText(String.valueOf(vlTotal));
    }
    
    private void carregaTabela(List<ItemNF> itemList) {
        if (itemList == null)
            return;
        DefaultTableModel model = (DefaultTableModel) tbItens.getModel();
        model.setRowCount(0);
        for (ItemNF inf : itemList) {
            model.addRow(new Object[]{inf.getCodigo(), inf.getCombustivel().getDescricao(),
                inf.getQuantidade(), inf.getValorUnitario(), inf.getValorDesconto(),
                inf.getValorTotal()});
        }
    }
    
    private void carregaComboCombustivel() {
        try {
            DefaultComboBoxModel combustivelModel = new DefaultComboBoxModel(combustivelDAO.getAll().toArray());
            cbCombustivel.setModel(combustivelModel);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de "
                    + "dados\n ao tentar Carregar as informações");
            sqle.printStackTrace(); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar COMBO BOX de COMBUSTIVEL. contate o suporte.\n[combobox]");
            ex.printStackTrace();
        }
    }
    
    private void limpaCampos() {
        tfQnt.setText("");
        tfVlDesconto.setText("");
        tfVlUnit.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(NotaFiscalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaFiscalJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotaFiscalJDialog dialog = new NotaFiscalJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCabecalho1;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btItens1;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbCombustivel;
    private javax.swing.ButtonGroup gpTipoNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paAbas1;
    private javax.swing.JTable tbItens;
    private javax.swing.JTextField tfBuscarCodigo;
    private javax.swing.JTextField tfBuscarDescricao;
    private javax.swing.JTextField tfQnt;
    private javax.swing.JTextField tfVlDesconto;
    private javax.swing.JTextField tfVlTot;
    private javax.swing.JTextField tfVlUnit;
    // End of variables declaration//GEN-END:variables
}
