package sample.dao;

import java.util.List;

public interface DAO <T> {
    List<T> getAll();
    boolean update(T t);
    void delete(String t);
    void create(T t);

}
