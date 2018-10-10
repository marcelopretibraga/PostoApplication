/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication;


import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import postoapplication.DAO.CombustivelDAO;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Combustivel;
import postoapplication.model.Tanque;
import tela.MenuInicial;

/**
 *
 * @author marcelo.braga
 */
public class PostoApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        MenuInicial dialog = new MenuInicial(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        if (!dialog.isActive())
            System.exit(0);

        
        /*Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(1);
        combustivel.setDescricao("Gasolina Comum ");
        combustivel.setTipoCombustivel("GCa");
        combustivel.setDataAtualizacao(new Date());
        combustivel.setDataCadastro(new Date());
        combustivel.setUsuario(2);
        */
        //System.out.println("dados Combustivel ----> "+combustivel.toString());
        
        CombustivelDAO combustivelDAO = new CombustivelDAO();
        List<Combustivel> combustivelList = combustivelDAO.getAll();
        System.out.println(combustivelList);
        
        
        
        //combustivelDAO.delete(1);
        //Combustivel combustivel = combustivelDAO.getByName("Gasolina Aditivada");
        
       // System.out.println("Combustivel consulta -> "+combustivel.toString());
        
       // combustivelDAO.update(combustivel);
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
