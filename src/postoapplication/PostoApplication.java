/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import postoapplication.DAO.ClienteDAO;
import postoapplication.DAO.CombustivelDAO;
import postoapplication.jdbc.ConnectionFactory;
import postoapplication.model.Cliente;
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

        /*Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(100);
        combustivel.setDescricao("Gasolina Comum ");
        combustivel.setTipoCombustivel("GCa");
        combustivel.setDataAtualizacao(new Date());
        combustivel.setDataCadastro(new Date());
        combustivel.setUsuario(2);*/
        //System.out.println("dados Combustivel ----> "+combustivel.toString());
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();

        /*cliente.setCodigo(3);
        cliente.setNome("João");
        cliente.setCpfCnpj(1111111);
        cliente.setTelefone("997451256");
        cliente.setEndereco("Rua teste 1");
        cliente.setDataAtualizacao(new Date());
        cliente.setDataCadastro(new Date());
        cliente.setUsuario(1);*/
        // clienteDAO.save(cliente);

        /*List<Cliente> clienteList = clienteDAO.getAll();
          System.out.println(clienteList);*/
 /*CombustivelDAO combustivelDAO = new CombustivelDAO();
        List<Combustivel> combustivelList = combustivelDAO.getAll();
        System.out.println(combustivelList);*/
        //clienteDAO.delete(1);
        /*   List<Cliente> clienteName = new ArrayList<>(); 
         clienteName = clienteDAO.getByName("João");
        System.out.println(clienteName);*/
        int numero;
        numero = clienteDAO.getLastId();
        System.out.println(numero);

        //Combustivel combustivel = combustivelDAO.getByName("Gasolina Aditivada");
        // System.out.println("Combustivel consulta -> "+combustivel.toString());
        // clienteDAO.update(cliente);
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
