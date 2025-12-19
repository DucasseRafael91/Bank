package bank;

import java.util.ArrayList;

public interface Dao<T> {

    void create(T obj);

    void update(T obj);

    void delete(String id);

    T findById(String id);

    ArrayList<T> findAll();
}
