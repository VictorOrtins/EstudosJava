package Interfaces;

import java.util.List;

public interface Dao<T> {
    public abstract void insert(T obj);
    public abstract void update(T obj);
    public abstract void deleteById(Integer id);
    public abstract T findById(Integer id);
    public abstract List<T> findAll();
}
