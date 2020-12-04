package dao;

import java.util.List;

/**
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 03/12/2020
 */
public interface Dao<T> {
    List<T> getAll();
    void create(T t);
    void delete(T t);
    void update(T t);
    T getOneData(String nome);
}
