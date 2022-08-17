package data.dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> get();
    void insert(T t);
    void delete(T t);
    void update(T t);
}
