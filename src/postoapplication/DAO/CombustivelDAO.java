/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Combustivel;

/**
 *
 * @author marcelo.braga
 */
public class CombustivelDAO implements GenericDAO<Combustivel>{
    private Connection connection = null;

    @Override
    public void save(Combustivel entity) throws SQLException{
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into combustivel(cd_combustivel, ds_combustivel, tp_combustivel,")
                    .append("cd_unidademedida, dt_record, cd_usuario) values (?,?,?,?,?,?)");
            
            //Preparar a execução do comando
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setString(3, entity.getTipoCombustivel());
            pstm.setInt(4, 1);
            pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(6, entity.getUsuario());
            
            pstm.execute();//Executa o comando no banco
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Combustivel.");
            ex.printStackTrace();
        } finally {//Sempre executa o Finally 
            connection.close();
        }
    }

    @Override
    public void update(Combustivel entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update combustivel set ds_combustivel = ?, ")
                    .append("tp_combustivel = ?, cd_unidademedida = ?, ")
                    .append("dt_update = ?, cd_usuario = ? ")
                    .append("where cd_combustivel = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setString(2, entity.getTipoCombustivel());
            pstm.setInt(3, 1);
            pstm.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(5, entity.getUsuario());
            pstm.setInt(6, entity.getCodigo());
            pstm.execute();//Executa o comando no banco
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Combustivel");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }
    
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Combustivel getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Combustivel getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Combustivel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
