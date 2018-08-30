/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Bico;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bico getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bico> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bico> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
