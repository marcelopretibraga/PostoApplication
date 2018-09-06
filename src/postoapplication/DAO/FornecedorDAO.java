/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Fornecedor;

/**
 *
 * @author eduar
 */
public class FornecedorDAO implements GenericDAO<Fornecedor> {

    private Connection connection = null;

    @Override
    public void save(Fornecedor entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into fornecedor(cd_fornecedor, ds_fornecedor")
                    .append(", cnpj_fornecedor, fone_fornecedor, endereco_fornecedor")
                    .append(", dt_record, dt_update, usuario) values (?,?,?,?,?, current_date, current_date, ?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getCpfcnpj());
            pstm.setString(4, entity.getFone());
            pstm.setString(5, entity.getEndereco());
            pstm.setInt(8, entity.getUsuario());
            pstm.execute();
            pstm.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Fornecedor");
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Fornecedor entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update fornecedor set (ds_fornecedor")
                    .append(", cnpj_fornecedor, fone_fornecedor, endereco_fornecedor")
                    .append(", dt_update, usuario) values (?,?,?,?,current_date,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setString(2, entity.getCpfcnpj());
            pstm.setString(3, entity.getFone());
            pstm.setString(4, entity.getEndereco());
            pstm.setInt(6, entity.getUsuario());
            pstm.execute();
            pstm.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Fornecedor!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar Fornecedor!");
            ex.printStackTrace();
        }
    }

    @Override
    public Fornecedor getById(int id) throws SQLException {
        Fornecedor fornecedor = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM FORNECEDOR WHERE CD_FORNECEDOR = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            fornecedor = new Fornecedor();
            while (rs.next()) {
                fornecedor.setCodigo(rs.getInt("CD_FORNECEDOR"));
                fornecedor.setNome(rs.getString("DS_FORNECEDOR"));
                fornecedor.setCpfcnpj(rs.getString("CNPJ_FORNECEDOR"));
                fornecedor.setFone(rs.getString("FONE_FORNECEDOR"));
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor pelo ID!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fornecedor> getAll() throws SQLException {
        List<Fornecedor> listaFornecedores = null;
        Fornecedor fornecedor = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM FORNECEDOR ORDER BY CD_FORNECEDOR ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaFornecedores = new ArrayList<>();
            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setCodigo(rs.getInt("CD_FORNECEDOR"));
                fornecedor.setNome(rs.getString("DS_FORNECEDOR"));
                fornecedor.setCpfcnpj(rs.getString("CNPJ_FORNECEDOR"));
                fornecedor.setFone(rs.getString("FONE_FORNECEDOR"));
                listaFornecedores.add(fornecedor);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaFornecedores;

    }

    @Override
    public int getLastId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}