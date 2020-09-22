package sample.dao;

import java.util.List;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 21/09/2020
 */
public interface DAO <T> {
    List<T> getAll();
    boolean update(T t);
    void delete(String t);
    void create(T t);

}
