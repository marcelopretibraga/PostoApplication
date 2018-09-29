package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
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
        try {
            connection = new ConnectionFactory().getConnection();
            String sql = "INSERT INTO TANQUE(CD_TANQUE, DS_TANQUE,"
                    + "CAPACIDADE_TANQUE, CD_COMBUSTIVEL) VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setDouble(3, entity.getCapacidade());
            pstm.setInt(4, entity.getCombustivel().getCodigo());
            /*pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(6, entity.getUsuario());*/
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Tanque entity) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TANQUE SET DS_TANQUE = ?, ")
                    .append("CAPACIDADE_TANQUE = ?, = ?, ")
                    .append("DT_UPDATE = ?, USUARIO = ? ")
                    .append("WHERE = ?");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
        connection = new ConnectionFactory().getConnection();
        String sql = "DELETE FROM TANQUE WHERE CD_TANQUE = " + id;
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.execute();
        pstm.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        connection.close();
        }
    }

    @Override
    public Tanque getById(int id) throws SQLException {
        Tanque tanque = new Tanque();
        try {
            connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select t.cd_tanque, t.ds_tanque,")
                    .append("t.capacidade_tanque as cp_tanque,")
                    .append("t.usuario as user_tanque,")
                    .append("c.cd_combustivel, c.ds_combustivel,")
                    .append("c.tp_combustivel, unidademedida_combustivel ")
                    .append("as un_combustivel from tanque as t ")
                    .append("inner join combustivel as c ")
                    .append("using (cd_combustivel) ")
                    .append("where t.cd_tanque = ").append(id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setCapacidade(rs.getDouble("CP_TANQUE"));
                tanque.setDescricao(rs.getString("DS_TANQUE"));
                tanque.setUsuario(rs.getInt("USER_TANQUE"));
                tanque.setCombustivel(populaCombustivel(
                        rs.getInt("CD_COMBUSTIVEL"), 
                        rs.getString("DS_COMBUSTIVEL"), 
                        rs.getString("TP_COMBUSTIVEL"), 
                        rs.getInt("USER_TANQUE")
                ));
            }
            pstm.close();
            rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return tanque;
    }

    @Override
    public List<Tanque> getByName(String name) throws SQLException {
        Tanque tanque = null;
        List<Tanque> tanqueList = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append("select t.cd_tanque, t.ds_tanque,")
                    .append("t.capacidade_tanque as cp_tanque,")
                    .append("t.usuario as user_tanque,")
                    .append("c.cd_combustivel, c.ds_combustivel,")
                    .append("c.tp_combustivel, unidademedida_combustivel ")
                    .append("as un_combustivel from tanque as t ")
                    .append("inner join combustivel as c ")
                    .append("using (cd_combustivel) ")
                    .append("where t.ds_tanque like '%").append(name).append("%'");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tanque = new Tanque();
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setDescricao(rs.getString("DS_TANQUE"));
                tanque.setCapacidade(rs.getDouble("CP_TANQUE"));
                tanque.setCombustivel(populaCombustivel(
                        rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"), 
                        rs.getString("TP_COMBUSTIVEL"),
                        rs.getInt("USER_TANQUE")
                ));
                tanqueList.add(tanque);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return tanqueList;
    }

    @Override
    public List<Tanque> getAll() throws SQLException {
        List<Tanque> combustivelList = null;
        Tanque tanque = null;
        try{
            connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT T.CD_TANQUE, T.DS_TANQUE,")
                    .append("T.CAPACIDADE_TANQUE AS CP_TANQUE,")
                    .append("T.USUARIO AS USER_TANQUE,")
                    .append("C.CD_COMBUSTIVEL, C.DS_COMBUSTIVEL,")
                    .append("C.TP_COMBUSTIVEL, UNIDADEMEDIDA_COMBUSTIVEL ")
                    .append("AS UNIDADEMEDIDA_COMBUSTIVEL FROM TANQUE AS T ")
                    .append("INNER JOIN COMBUSTIVEL AS C ")
                    .append("USING (CD_COMBUSTIVEL) ORDER BY T.CD_TANQUE");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            combustivelList = new ArrayList<>();
            while (rs.next()) {
                tanque = new Tanque();
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setCapacidade(rs.getDouble("CP_TANQUE"));
                tanque.setDescricao(rs.getString("DS_TANQUE"));
                tanque.setUsuario(rs.getInt("USER_TANQUE"));
                tanque.setCombustivel(populaCombustivel(
                        rs.getInt("CD_COMBUSTIVEL"),
                        rs.getString("DS_COMBUSTIVEL"),
                        rs.getString("TP_COMBUSTIVEL"),
                        rs.getInt("USER_TANQUE"))
                );
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
        PreparedStatement pstm = null;
        try {
            connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_TANQUE), 0) + 1 AS CODIGO FROM TANQUE";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            return rs.getInt("CODIGO");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
            pstm.close();
        }
        return 1;
    }
    
    public Combustivel populaCombustivel(int codigo, String descricao, String tipo, int usuario) {
        Combustivel comb = new Combustivel();
        comb.setCodigo(codigo);
        comb.setDescricao(descricao);
        comb.setTipoCombustivel(tipo);
        comb.setUsuario(usuario);
        return comb;
    }
}
