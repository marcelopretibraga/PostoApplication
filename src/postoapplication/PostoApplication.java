/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication;


import java.sql.SQLException;
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
    }
}
