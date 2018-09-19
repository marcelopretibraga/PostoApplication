package postoapplication.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.ItemNF;
import postoapplication.model.NotaFiscal;

/**
 * @author Norton Wagner Martins  
 * @date 12/09/2018
 */
public class NotaFiscalDAO implements GenericDAO<NotaFiscal> {
    private Connection connection = null;
    
    @Override
    public void save(NotaFiscal entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO NOTAFISCAL (CD_NOTAFISCAL, NR_NOTA, DS_SERIE, CD_CLIENTE, DT_EMISSAO, VL_TOTAL) VALUES")
                    .append("(?,?,?,?,?,?)");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getNumeroNota());
            pstm.setString(3, entity.getSerie());
            pstm.setInt(4, entity.getCliente().getCodigo());
            pstm.setDate(5, (Date) entity.getDataEmissao());
            pstm.setDouble(6, entity.getValorTotal());
        
            PreparedStatement pstmItem = connection.prepareStatement(sql.toString()); //Pstm para os Itens
            for (ItemNF inf : entity.getItensNF()) {
                sql.append("INSERT INTO ITEMNF (CD_ITEMNF, CD_NOTAFISCAL, NR_QUANTIDADE, VL_UNITARIO, VL_DESCONTO, VL_TOTALITEM, CD_COMBUSTIVEL)")
                        .append("VALUES (?,?,?,?,?,?,?)");
                
                pstmItem.setInt(1, inf.getCodigo());
                pstmItem.setInt(2, inf.getNotaFiscal().getCodigo());
                pstmItem.setDouble(3, inf.getQuantidade());
                pstmItem.setDouble(4, inf.getValorUnitario());
                pstmItem.setDouble(5, inf.getValorDesconto());
                pstmItem.setDouble(6, inf.getValorTotal());
                pstmItem.setInt(7, inf.getCombustivel().getCodigo());
            }
            
            pstm.execute();
            pstmItem.execute();
            pstm.close();
            pstmItem.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Combustivel.");
            ex.printStackTrace();
        } finally {//Sempre executa o Finally 
            connection.close();
        }
    }

    @Override
    public void update(NotaFiscal entity) throws SQLException {
        
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
                String sql = "DELETE FROM ITEMNF WHERE CD_NOTAFISCAL = " + id;
                sql += "DELETE FROM NOTAFISCAL WHERE CD_NOTAFISCAL = " + id;
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Nota Fiscal");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public NotaFiscal getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaFiscal> getByName(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaFiscal> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
