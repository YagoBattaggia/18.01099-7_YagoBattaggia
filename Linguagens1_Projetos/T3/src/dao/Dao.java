package dao;

import java.util.List;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 02/10/2020
 */
public interface Dao<T> {
    List<T> getAll();
    void create(T t);
    T getOneData(String nome);
}
