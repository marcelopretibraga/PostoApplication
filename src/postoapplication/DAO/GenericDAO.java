/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marcelo.braga
 */
public interface GenericDAO<T> {
    public void save(T entity) throws SQLException;
    public void update(T entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public T getById(int id) throws SQLException;
    public T getByName(String name) throws SQLException;
    public List<T> getAll() throws SQLException;
}
