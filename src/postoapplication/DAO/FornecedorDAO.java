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
    try{
    this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();   
            sql.append("insert into fornecedor(cd_fornecedor, ds_fornecedor")
                    .append(", cnpj_fornecedor, fone_fornecedor, endereco_fornecedor")
                    .append(", dt_record, dt_update, usuario) values (?,?,?,?,?,?,?,?)");
            
 //           PreparedStatement pstm = connection.prepareStatement(sql);
 //           pstm.setInt(1, );
        
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Falha ao salvar Fornecedor");
        ex.printStackTrace();
    }
    }

    @Override
    public void update(Fornecedor entity) throws SQLException {
    try{
        
        
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Falha ao salvar Fornecedor");
        ex.printStackTrace();
    }
    }

    @Override
    public void delete(int id) throws SQLException {
    try{
        
        
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Falha ao salvar Fornecedor");
        ex.printStackTrace();
    }
    }

    @Override
    public Fornecedor getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fornecedor> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fornecedor> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
