package infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CrudRepository<T> {
    //CRUD operations
    boolean create(T object);        //C
    Optional<T> read(UUID id);  //R
    boolean update(T object);        //U
    boolean delete(UUID id);    //D
    List<T> readAll();
}
