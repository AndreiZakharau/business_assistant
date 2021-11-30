package dao;

import java.util.List;

public interface DAO <T> {
    T add(T t);
    boolean delete(T t);
    T finByName(String k);
    T finByID(long id);
    List<T> findAll();
    boolean update(T t);

}
