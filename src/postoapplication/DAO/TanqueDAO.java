package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import postoapplication.model.Tanque;
import postoapplication.jdbc.ConnectionFactory;

/**
 *
 * @author Felipe
 */
public class TanqueDAO implements GenericDAO<Tanque>{

    Connection connection = null;
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tanque> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tanque> getAll() throws SQLException {
        List<Tanque> combustivelList = null;
        Tanque tanque = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM TANQUE ORDER BY CD_TANQUE";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            combustivelList = new ArrayList<>();
            while (rs.next()) {
                tanque = new Tanque();
                tanque.setCodigo(rs.getInt("CD_TANQUE"));
                tanque.setCapacidade(rs.getF);
                
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
    
}
