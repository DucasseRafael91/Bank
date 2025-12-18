package bank;

import java.util.List;

public interface Dao<T> {

    void create(T obj);

    void update(T obj);

    void delete(int id);
    
    Object findById(String id);

    List<T> findAll();
}

