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
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Bico;
import postoapplication.model.Combustivel;
import postoapplication.model.Tanque;

/**
 *
 * @author fag
 */
public class BicoDAO implements GenericDAO<Bico>{
    private Connection connection = null;

    @Override
    public void save(Bico entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into bico(cd_bico, ds_bico, cd_tanque) values (?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setInt(3, entity.getTanque().getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Bico.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Bico entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update combustivel set ds_bico = ?, ")
                    .append("cd_tanque = ?")
                    .append("where cd_bico = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setInt(2, entity.getTanque().getCodigo());
            pstm.setInt(3, entity.getCodigo());
            pstm.execute();
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Combustivel");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from combustivel where cd_bico = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao Deletar Bico");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public Bico getById(int id) throws SQLException {
        Bico bico = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT B.CD_BICO, B.DS_BICO, B.CD_TANQUE, T.DS_TANQUE, "
                    + "T.NR_CAPACIDADE, C.CD_COMBUSTIVEL, C.DS_COMBUSTIVEL, C.TP_COMBUSTIVEL "
                    + "FROM BICO AS B "
                    + "INNER JOIN TANQUE AS T ON (T.CD_TANQUE = B.CD_TANQUE) "
                    + "INNER JOIN COMBUSTIVEL AS C ON (C.CD_COMBUSTIVEL = T.CD_COMBUSTIVEL) "
                    + "WHERE CD_BICO = 1 " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            bico = new Bico();
            while (rs.next()) {
                bico.setCodigo(rs.getInt("CD_BICO"));
                bico.setDescricao(rs.getString("DS_BICO"));
                bico.setTanque(carregaTanque(rs.getInt("CD_TANQUE"), rs.getString("DS_TANQUE"),
                        rs.getDouble("NR_CAPACIDADE"), rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"), rs.getString("TP_COMBUSTIVEL")));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Buscar Bico");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return bico;
    }

    @Override
    public List<Bico> getByName(String name) throws SQLException {
        Bico bico = null;
        List<Bico> bicoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT B.CD_BICO, B.DS_BICO, B.CD_TANQUE, T.DS_TANQUE, "
                    + "T.NR_CAPACIDADE, C.CD_COMBUSTIVEL, "
                    + "C.DS_COMBUSTIVEL, C.TP_COMBUSTIVEL "
                    + "FROM BICO AS B "
                    + "INNER JOIN TANQUE AS T ON (T.CD_TANQUE = B.CD_TANQUE) "
                    + "INNER JOIN COMBUSTIVEL AS C ON (C.CD_COMBUSTIVEL = T.CD_COMBUSTIVEL) "
                    + "WHERE UPPER(DS_BICO) LIKE UPPER('%\"+name+\"%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            bicoList = new ArrayList<>();
            while (rs.next()) {
                bico = new Bico();
                bico.setCodigo(rs.getInt("CD_BICO"));
                bico.setDescricao(rs.getString("DS_BICO"));
                bico.setTanque(carregaTanque(rs.getInt("CD_TANQUE"), rs.getString("DS_TANQUE"),
                        rs.getDouble("NR_CAPACIDADE"), rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"), rs.getString("TP_COMBUSTIVEL")));
                bicoList.add(bico);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar por Nome");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return bicoList;
    }

    @Override
    public List<Bico> getAll() throws SQLException {
        List<Bico> bicoList = null;
        Bico bico = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT B.CD_BICO, B.DS_BICO, B.CD_TANQUE, T.DS_TANQUE, "
                    + "T.NR_CAPACIDADE, C.CD_COMBUSTIVEL, "
                    + "C.DS_COMBUSTIVEL, C.TP_COMBUSTIVEL FROM BICO AS B "
                    + "INNER JOIN TANQUE AS T ON (T.CD_TANQUE = B.CD_TANQUE) "
                    + "INNER JOIN COMBUSTIVEL AS C ON (C.CD_COMBUSTIVEL = T.CD_COMBUSTIVEL) "
                    + "ORDER BY CD_COMBUSTIVEL ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            bicoList = new ArrayList<>();
            while (rs.next()) {
                bico = new Bico();
                bico.setCodigo(rs.getInt("CD_BICO"));
                bico.setDescricao(rs.getString("DS_BICO"));
                bico.setTanque(carregaTanque(rs.getInt("CD_TANQUE"), rs.getString("DS_TANQUE"),
                        rs.getDouble("NR_CAPACIDADE"), rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"), rs.getString("TP_COMBUSTIVEL")));
                bicoList.add(bico);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar todos Bicos");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return bicoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_BICO),0)+1 AS MAIOR FROM BICO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro ao maior ID Combustivel");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

    private Tanque carregaTanque(int tanqueCod, String tanqueDesc, 
            double tanqueCapacidade, int combustivelCod, String combustivelDesc, 
            String combustivelTipo) {
        Combustivel combustivel = new Combustivel();
        Tanque tanque = new Tanque();
        combustivel.setCodigo(combustivelCod);
        combustivel.setDescricao(combustivelDesc);
        combustivel.setTipoCombustivel(combustivelTipo);
        tanque.setCodigo(tanqueCod);
        tanque.setDescricao(tanqueDesc);
        tanque.setCapacidade(tanqueCapacidade);
        tanque.setCombustivel(combustivel);
        return tanque;
    }
    
}
