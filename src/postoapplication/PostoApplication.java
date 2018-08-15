/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import postoapplication.DAO.CombustivelDAO;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Combustivel;

/**
 *
 * @author marcelo.braga
 */
public class PostoApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(1);
        combustivel.setDescricao("Gasolina Comum - Alterado");
        combustivel.setTipoCombustivel("GCa");
        combustivel.setDataAtualizacao(new Date());
        combustivel.setDataCadastro(new Date());
        combustivel.setUsuario(2);
        
        System.out.println("dados Combustivel ----> "+combustivel.toString());
        
        CombustivelDAO combustivelDAO = new CombustivelDAO();
        combustivelDAO.update(combustivel);
        /*
        combustivel = new Combustivel();
        combustivel.setCodigo(2);
        combustivel.setDescricao("Gasolina Aditivada");
        combustivel.setTipoCombustivel("GA");
        combustivel.setDataAtualizacao(new Date());
        combustivel.setDataCadastro(new Date());
        combustivel.setUsuario(1);
        //Salvar
        combustivelDAO.save(combustivel);
        */
    }
    
}
