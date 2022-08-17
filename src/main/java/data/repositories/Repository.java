package data.repositories;

import data.dao.DaoInterface;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T> {
    private DaoInterface<T> dao;

    public Repository(DaoInterface<T> dao) {
        this.dao = dao;
    }

    public T find(Predicate<T> predicate) {
        return dao.get().stream().filter(predicate).findFirst().orElse(null);
    }

    public List<T> get(Predicate<T> predicate, Comparator<T> comparator) {
        if (comparator == null) {
            return dao.get().stream().filter(predicate).toList();
        }

        return dao.get().stream().filter(predicate).sorted(comparator).toList();
    }
}
