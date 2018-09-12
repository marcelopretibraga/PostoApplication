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
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into cliente(cd_cliente, ds_cliente, cpfcnpj_cliente,")
                    .append("fone_cliente, endereco_cliente, dt_record, dt_update, usuario) values (?,?,?,?,?,?,?,?);");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setInt(3, entity.getCpfCnpj());
            pstm.setString(4, entity.getTelefone());
            pstm.setString(5, entity.getEndereco());
            pstm.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(7, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));           
            pstm.setInt(8, entity.getUsuario());

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Cliente.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Cliente entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nm_cliente = ?, ")
                    .append("nr_cpfcnpj = ?, nr_telefone = ?, ")
                    .append("nr_endereco = ?, dt_update = ?,cd_usuario = ? ")
                    .append("where cd_cliente = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setInt(2, entity.getCpfCnpj());
            pstm.setString(3, entity.getTelefone());
            pstm.setString(4, entity.getEndereco());
            pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(6, entity.getUsuario());
            pstm.setInt(7, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Cliente");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from cliente where cd_cliente = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar Cliente");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
    }

    @Override
    public Cliente getById(int id) throws SQLException {
        Cliente cliente = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from cliente where cd_cliente = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            cliente = new Cliente();
            while (rs.next()) {
                cliente.setCodigo(rs.getInt("cd_cliente"));
                cliente.setNome(rs.getString("ds_cliente"));
                cliente.setCpfCnpj(rs.getInt("cpfcnpj_cliente"));
                cliente.setTelefone(rs.getString("fone_cliente"));
                cliente.setEndereco(rs.getString("endereco_cliente"));
                cliente.setUsuario(rs.getInt("usuario"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar por  ID");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getByName(String name) throws SQLException {
        Cliente cliente = null;
        List<Cliente> clienteList = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from cliente where upper(ds_cliente) like upper('%" + name + "%')";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            clienteList = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cd_cliente"));
                cliente.setNome(rs.getString("ds_cliente"));
                cliente.setCpfCnpj(rs.getInt("cpfcnpj_cliente"));
                cliente.setTelefone(rs.getString("fone_cliente"));
                cliente.setEndereco(rs.getString("endereco_cliente"));
                cliente.setUsuario(rs.getInt("usuario"));
                clienteList.add(cliente);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar por nome");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return clienteList;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clienteList = null;
        Cliente cliente = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from cliente order by cd_cliente";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            clienteList = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cd_cliente"));
                cliente.setNome(rs.getString("ds_cliente"));
                cliente.setCpfCnpj(rs.getInt("cpfcnpj_cliente"));
                cliente.setTelefone(rs.getString("fone_cliente"));
                cliente.setEndereco(rs.getString("endereco_cliente"));
                cliente.setUsuario(rs.getInt("usuario"));
                clienteList.add(cliente);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todos os clientes");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return clienteList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select coalesce(max(cd_cliente),0)+1 as maior from cliente";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao mostrar  maior ID Cliente");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
}