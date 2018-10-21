package postoapplication.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Combustivel;
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
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO NOTAFISCAL (CD_NOTAFISCAL, NUMERO_NOTAFISCAL, ")
                    .append("SERIE_NOTAFISCAL, DTEMISSAO_NOTAFISCAL, VLTOTAL_NOTAFISCAL, ")
                    .append("CD_CLIENTE, DT_RECORD, DT_UPDATE) VALUES (?,?,?,?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getNumeroNota());
            pstm.setInt(3, Integer.parseInt(entity.getSerie()));
            pstm.setDate(4, (Date) entity.getDataEmissao());
            pstm.setDouble(5, entity.getValorTotal());
            pstm.setInt(6, entity.getCliente().getCodigo());
            pstm.setDate(7, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.execute();
            StringBuilder sqlItem = new StringBuilder();
                sqlItem.append("INSERT INTO ITEMNF (CD_ITEMNF, QT_ITEMNF, VLUNITARIO_ITEMNF, ")
                        .append("DESCONTO_ITEMNF, VLTOTAL_ITEMNF, CD_COMBUSTIVEL, CD_NOTAFISCAL, ")
                        .append("DT_RECORD, DT_UPDATE) VALUES (?,?,?,?,?,?,?,?,?)");
                pstm = connection.prepareStatement(sqlItem.toString());
            for (ItemNF inf : entity.getItensNF()) {
                pstm.setInt(1, inf.getCodigo());
                pstm.setDouble(2, inf.getQuantidade());
                pstm.setDouble(3, inf.getValorUnitario());
                pstm.setDouble(4, inf.getValorDesconto());
                pstm.setDouble(5, inf.getValorTotal());
                pstm.setInt(6, inf.getCombustivel().getCodigo());
                pstm.setInt(7, inf.getNotaFiscal().getCodigo());
                pstm.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                pstm.setDate(9, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                pstm.execute();
            }
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao inserir NF-e.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao inserir NF-e");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            connection.close();
        }
    }

    @Override
    public void update(NotaFiscal entity) throws SQLException {
        //METODO NAO UTILIZADO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM ITEMNF WHERE CD_NOTAFISCAL = " + id + ";")
                .append(" DELETE FROM NOTAFISCAL WHERE CD_NOTAFISCAL = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Nota Fiscal");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Deletar Nota Fiscal");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public NotaFiscal getById(int id) throws SQLException {
        //METODO NAO UTILIZADO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaFiscal> getByName(String name) throws SQLException {
        //METODO NAO UTILIZADO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaFiscal> getAll() throws SQLException {
        //METODO NAO UTILIZADO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_NOTAFISCAL),0)+1 AS MAIOR FROM NOTAFISCAL ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro ao recuperar maior ID Nota Fiscal");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao recuperar maior ID Nota Fiscal");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
    
    public int getLastIdItem() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_ITEMNF),0)+1 AS MAIOR FROM ITEMNF ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro ao recuperar maior ID ItemNF");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao recuperar maior ID ItemNF");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
}
