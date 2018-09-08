package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import postoapplication.model.Tanque;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Combustivel;

/**
 *
 * @author Felipe
 */
public class TanqueDAO implements GenericDAO<Tanque>{

    private Connection connection = null;
    
    @Override
    public void save(Tanque entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Tanque entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tanque getById(int id) throws SQLException {
        Tanque tanque = new Tanque();
        try { 
            connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TANQUE WHERE CD_TANQUE = " + id + " LIMIT 1";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setCapacidade(rs.getDouble("CAPACIDADE_TANQUE"));
                tanque.setDescricao(rs.getString("DS_TANQUE"));
                tanque.setUsuario(rs.getInt("USUARIO"));
            }
            pstm.close();
            rs.close();
        } catch (SQLException sqle) {
            System.out.println("Erro ao executar a instrução SQL\n");
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tanque;
    }

    @Override
    public List<Tanque> getByName(String name) throws SQLException {
        Tanque tanque = null;
        List<Tanque> tanqueList = new ArrayList<>();
        
        connection = new ConnectionFactory().getConnection();
        
//        SELECT T.*, C.* FROM TANQUE AS T
//          JOIN COMBUSTIVEL AS C
//          ON T.CD_COMBUSTIVEL = C.CD_COMBUSTIVEL
//        WHERE T.DS_TANQUE = 'Tanque 1';
        String sql = "SELECT T.*, C.* FROM TANQUE AS T "
                + "INNER JOIN COMBUSTIVEL AS C ON "
                + "T.CD_COMBUSTIVEL = C.CD_COMBUSTIVEL "
                        + "WHERE T.DS_TANQUE = %" + name + "%";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            tanque = new Tanque();
            tanque.setCodigo(rs.getInt("CD_TANQUE"));
            tanque.setDescricao(rs.getString("DS_TANQUE"));
            tanque.setCapacidade(rs.getDouble("CAPACIDADE_TANQUE"));
            tanque.setCombustivel(populaCombustivel(rs.getInt(""), sql, sql, 0));
        }
        return tanqueList;
    }

    @Override
    public List<Tanque> getAll() throws SQLException {
        List<Tanque> combustivelList = null;
        Tanque tanque = null;
        try{
            connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TANQUE ORDER BY CD_TANQUE";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            combustivelList = new ArrayList<>();
            while (rs.next()) {
                tanque = new Tanque();
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setCapacidade(rs.getDouble("CAPACIDADE_TANQUE"));
                tanque.setDescricao("DS_TANQUE");
                tanque.setUsuario(rs.getInt("USUARIO"));
                tanque.setCombustivel(populaCombustivel(rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"), rs.getString("TP_COMBUSTIVEL"), rs.getInt("USUARIO")));
                combustivelList.add(tanque);
            }
            pstm.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return combustivelList;
    }

    @Override
    public int getLastId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Combustivel populaCombustivel(int codigo, String descricao, String tipoCombustivel, int usuario) {
        Combustivel comb = new Combustivel();
        comb.setCodigo(codigo);
        comb.setDescricao(descricao);
        comb.setTipoCombustivel(tipoCombustivel);
        comb.setUsuario(usuario);
        return comb;
    }
}
