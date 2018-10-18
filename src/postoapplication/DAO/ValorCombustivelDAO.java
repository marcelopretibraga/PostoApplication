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
import postoapplication.model.Combustivel;
import postoapplication.model.ValorCombustivel;

/**
 *
 * @author mathe
 */
public class ValorCombustivelDAO implements GenericDAO<ValorCombustivel>{

    private Connection connection = null;
    //private Combustivel combustivel;
    @Override
    public void save(ValorCombustivel entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO VALORCOMBUSTIVEL(CD_VALORCOMBUSTIVEL, VLUNITARIO_VALORCOMBUSTIVEL, DTEMISSAO_VALORCOMBUSTIVEL,")
                        .append("MARGEM_VALORCOMBUSTIVEL, CD_COMBUSTIVEL, DT_RECORD, DT_UPDATE, USUARIO) VALUES (?,?,?,?,?,?,?,?)");
            
            //Preparar a execução do comando
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setDouble(2, entity.getValorUnitario());
            pstm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDouble(4, entity.getMargem());
            pstm.setInt(5, entity.getCombustivel().getCodigo());
            pstm.setDate(7, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(9, entity.getUsuario());
            
            pstm.execute();//Executa o comando no banco
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Valor de Combustivel.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao inserir Valor de Combustivel");
            ex.printStackTrace();
        } finally {//Sempre executa o Finally 
            connection.close();
        }
    }

    @Override
    public void update(ValorCombustivel entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VALORCOMBUSTIVEL SET VLUNITARIO_VALORCOMBUSTIVEL = ?, ")
                    .append("MARGEM_VALORCOMBUSTIVEL = ?, DT_UPDATE = ?, USUARIO = ?, ")
                    .append("DTEMISSAO_VALORCOMBUSTIVEL = ? WHERE CD_VALORCOMBUSTIVEL = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setDouble(1, entity.getValorUnitario());
            pstm.setDouble(2, entity.getMargem());
            pstm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(4, entity.getUsuario());
            pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(6, entity.getCodigo());
            pstm.execute();//Executa o comando no banco
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao atualizar Valor de Combustivel");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao atualizar Valor de Combustivel");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM VALORCOMBUSTIVEL WHERE CD_VALORCOMBUSTIVEL = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao deletar Valor de Combustivel");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao deletar Valor de Combustivel");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public ValorCombustivel getById(int id) throws SQLException {
        ValorCombustivel valorCombustivel = null;
        CombustivelDAO combustivelDAO = new CombustivelDAO();
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM VALORCOMBUSTIVEL WHERE CD_VALORCOMBUSTIVEL = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            valorCombustivel = new ValorCombustivel();
            while (rs.next()) {
                valorCombustivel.setCodigo(rs.getInt("CD_VALORCOMBUSTIVEL"));
                valorCombustivel.setCombustivel(combustivelDAO.getById(rs.getInt("CD_COMBUSTIVEL")));
                valorCombustivel.setValorUnitario(rs.getDouble("VLUNITARIO_VALORCOMBUSTIVEL"));
                valorCombustivel.setDataEmissao(rs.getDate("DTEMISSAO_VALORCOMBUSTIVEL"));
                valorCombustivel.setMargem(rs.getDouble("MARGEM_VALORCOMBUSTIVEL"));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao buscar Valor de Combustivel por id");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao buscar Valor de Combustivel por id");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return valorCombustivel;
    }

    @Override
    public List<ValorCombustivel> getByName(String name) throws SQLException {
        ValorCombustivel valorCombustivel = null;
        List<ValorCombustivel> valorCombustivelList = null;
        CombustivelDAO combustivelDAO = new CombustivelDAO();
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM VALORCOMBUSTIVEL INNER JOIN COMBUSTIVEL ON " 
                    +"UPPER(DS_COMBUSTIVEL) LIKE UPPER('%"+name+"%') WHERE " 
                    +"VALORCOMBUSTIVEL.CD_COMBUSTIVEL = COMBUSTIVEL.CD_COMBUSTIVEL";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            valorCombustivelList = new ArrayList<>();
            while (rs.next()) {
                valorCombustivel = new ValorCombustivel();
                valorCombustivel.setCodigo(rs.getInt("CD_VALORCOMBUSTIVEL"));
                valorCombustivel.setCombustivel(combustivelDAO.getById(rs.getInt("CD_COMBUSTIVEL")));
                valorCombustivel.setValorUnitario(rs.getDouble("VLUNITARIO_VALORCOMBUSTIVEL"));
                valorCombustivel.setDataEmissao(rs.getDate("DTEMISSAO_VALORCOMBUSTIVEL"));
                valorCombustivel.setMargem(rs.getDouble("MARGEM_VALORCOMBUSTIVEL"));
                valorCombustivelList.add(valorCombustivel);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar por Descricao de Combustivel");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao consultar por Descricao de Combustivel");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return valorCombustivelList;
    }

    @Override
    public List<ValorCombustivel> getAll() throws SQLException {
        List<ValorCombustivel> valorCombustivelList = null;
        ValorCombustivel valorCombustivel = null;
        CombustivelDAO combustivelDAO = new CombustivelDAO();
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM VALORCOMBUSTIVEL ORDER BY CD_VALORCOMBUSTIVEL ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            valorCombustivelList = new ArrayList<>();
            while (rs.next()) {
                valorCombustivel = new ValorCombustivel();
                valorCombustivel.setCodigo(rs.getInt("CD_VALORCOMBUSTIVEL"));
                valorCombustivel.setCombustivel(combustivelDAO.getById(rs.getInt("CD_COMBUSTIVEL")));
                valorCombustivel.setValorUnitario(rs.getDouble("VLUNITARIO_VALORCOMBUSTIVEL"));
                valorCombustivel.setDataEmissao(rs.getDate("DTEMISSAO_VALORCOMBUSTIVEL"));
                valorCombustivel.setMargem(rs.getDouble("MARGEM_VALORCOMBUSTIVEL"));
                valorCombustivelList.add(valorCombustivel);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar todos Valores de Combustivel");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao consultar todos Valores de Combustivel");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return valorCombustivelList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_VALORCOMBUSTIVEL),0)+1 AS MAIOR FROM VALORCOMBUSTIVEL ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro ao recuperar maior ID Valor de Combustivel");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao recuperar maior ID Valor de Combustivel");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
    
    
    
}
