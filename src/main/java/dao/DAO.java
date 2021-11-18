package dao;

import entity.Shops;

import java.util.List;

public interface DAO <T> {
    T add(T t);
    boolean delete(T t);
    T finByName(String k);
    T finByID(int id);
    List<T> findAll();
    boolean update(T t);

}
