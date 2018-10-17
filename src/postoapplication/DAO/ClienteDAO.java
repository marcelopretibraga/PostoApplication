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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Cliente;

/**
 *
 * @author Luana Mora
 */
public class ClienteDAO implements GenericDAO<Cliente> {

    private Connection connection = null;

    @Override
    public void save(Cliente entity) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CLIENTE(CD_CLIENTE, DS_CLIENTE, CPFCNPJ_CLIENTE,")
                    .append("FONE_CLIENTE, ENDERECO_CLIENTE, DT_RECORD, DT_UPDATE, USUARIO) values (?,?,?,?,?,?,?,?);");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getCpfCnpj());
            pstm.setString(4, entity.getTelefone());
            pstm.setString(5, entity.getEndereco());
            pstm.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(7, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(8, entity.getUsuario());

            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
    }

    @Override
    public void update(Cliente entity) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENTE SET DS_CLIENTE = ?, ")
                    .append("CPFCNPJ_CLIENTE = ?, FONE_CLIENTE = ?, ")
                    .append("ENDERECO_CLIENTE = ?, DT_UPDATE = ?,USUARIO = ? ")
                    .append("WHERE CD_CLIENTE = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setString(2, entity.getCpfCnpj());
            pstm.setString(3, entity.getTelefone());
            pstm.setString(4, entity.getEndereco());
            pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(6, entity.getUsuario());
            pstm.setInt(7, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            String sql = "DELETE FROM CLIENTE WHERE CD_CLIENTE = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao deletar Cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
    }

    @Override
    public Cliente getById(int id) throws SQLException {
        Cliente cliente = null;
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM CLIENTE WHERE CD_CLIENTE = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            cliente = new Cliente();
            while (rs.next()) {
                cliente.setCodigo(rs.getInt("CD_CLIENTE"));
                cliente.setNome(rs.getString("DS_CLIENTE"));
                cliente.setCpfCnpj(rs.getString("CPFCNPJ_CLIENTE"));
                cliente.setTelefone(rs.getString("FONE_CLIENTE"));
                cliente.setEndereco(rs.getString("ENDERECO_CLIENTE"));
                cliente.setUsuario(rs.getInt("USUARIO"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
           JOptionPane.showMessageDialog(null, "Erro ao consultar por  ID", "ERRO", JOptionPane.ERROR_MESSAGE);
           sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getByName(String name) throws SQLException {
        Cliente cliente = null;
        List<Cliente> clienteList = null;
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM CLIENTE WHERE UPPER(DS_CLIENTE) LIKE UPPER('%" + name + "%')";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            clienteList = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("CD_CLIENTE"));
                cliente.setNome(rs.getString("DS_CLIENTE"));
                cliente.setCpfCnpj(rs.getString("CPFCNPJ_CLIENTE"));
                cliente.setTelefone(rs.getString("FONE_CLIENTE"));
                cliente.setEndereco(rs.getString("ENDERECO_CLIENTE"));
                cliente.setUsuario(rs.getInt("USUARIO"));
                clienteList.add(cliente);
            }
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao consultar por nome", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
        return clienteList;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clienteList = null;
        Cliente cliente = null;
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM CLIENTE ORDER BY CD_CLIENTE";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            clienteList = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("CD_CLIENTE"));
                cliente.setNome(rs.getString("DS_CLIENTE"));
                cliente.setCpfCnpj(rs.getString("CPFCNPJ_CLIENTE"));
                cliente.setTelefone(rs.getString("FONE_CLIENTE"));
                cliente.setEndereco(rs.getString("ENDERECO_CLIENTE"));
                cliente.setUsuario(rs.getInt("USUARIO"));
                clienteList.add(cliente);
            }
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao consultar todos os clientes", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
        return clienteList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            connection = new ConnectionFactory().getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CD_CLIENTE),0)+1 AS MAIOR FROM CLIENTE";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
            pstm.close();
        } catch (SQLException sqle) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro ao mostrar  maior ID Cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        } catch (Exception ex) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Erro inesperado ao inserir Cliente.", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            connection.commit();
            connection.close();
        }
        return 1;
    }

}
