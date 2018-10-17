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
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO FORNECEDOR(CD_FORNECEDOR, DS_FORNECEDOR")
                    .append(", CNPJ_FORNECEDOR, FONE_FORNECEDOR, ENDERECO_FORNECEDOR")
                    .append(", DT_RECORD, DT_UPDATE, USUARIO) VALUES (?,?,?,?,?, CURRENT_DATE, CURRENT_DATE, ?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getCpfcnpj());
            pstm.setString(4, entity.getFone());
            pstm.setString(5, entity.getEndereco());
            pstm.setInt(6, entity.getUsuario());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Fornecedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao salvar Fornecedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void update(Fornecedor entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE FORNECEDOR SET DS_FORNECEDOR = ?")
                    .append(", CNPJ_FORNECEDOR = ?, FONE_FORNECEDOR = ?, ENDERECO_FORNECEDOR = ?")
                    .append(", USUARIO = ?, DT_UPDATE = CURRENT_DATE ")
                    .append("WHERE CD_FORNECEDOR = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setString(2, entity.getCpfcnpj());
            pstm.setString(3, entity.getFone());
            pstm.setString(4, entity.getEndereco());
            pstm.setInt(5, entity.getUsuario());
            pstm.setInt(6, entity.getCodigo());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Fornecedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Fornecedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "DELETE FROM FORNECEDOR WHERE CD_FORNECEDOR =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar Fornecedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar Fornecedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public Fornecedor getById(int id) throws SQLException {
        Fornecedor fornecedor = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FORNECEDOR WHERE CD_FORNECEDOR = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            fornecedor = new Fornecedor();
            while (rs.next()) {
                fornecedor.setCodigo(rs.getInt("CD_FORNECEDOR"));
                fornecedor.setNome(rs.getString("DS_FORNECEDOR"));
                fornecedor.setCpfcnpj(rs.getString("CNPJ_FORNECEDOR"));
                fornecedor.setFone(rs.getString("FONE_FORNECEDOR"));
                fornecedor.setEndereco(rs.getString("ENDERECO_FORNECEDOR"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getByName(String name) throws SQLException {
        List<Fornecedor> listaFornecedores = null;
        Fornecedor fornecedor = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FORNECEDOR WHERE UPPER(DS_FORNECEDOR) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaFornecedores = new ArrayList<>();
            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setCodigo(rs.getInt("CD_FORNECEDOR"));
                fornecedor.setNome(rs.getString("DS_FORNECEDOR"));
                fornecedor.setCpfcnpj(rs.getString("CNPJ_FORNECEDOR"));
                fornecedor.setFone(rs.getString("FONE_FORNECEDOR"));
                fornecedor.setEndereco(rs.getString("ENDERECO_FORNECEDOR"));
                listaFornecedores.add(fornecedor);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Fornecedor(es)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaFornecedores;
    }

    @Override
    public List<Fornecedor> getAll() throws SQLException {
        List<Fornecedor> listaFornecedores = null;
        Fornecedor fornecedor = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
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
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Fornecedor(es)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaFornecedores;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_FORNECEDOR),0)+1 AS MAIOR FROM FORNECEDOR ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Fornecedor(es)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
