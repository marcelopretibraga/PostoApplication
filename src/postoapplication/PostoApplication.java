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
        System.exit(0);
    }
}
