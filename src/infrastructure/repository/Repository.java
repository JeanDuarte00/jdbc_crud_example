package infrastructure.repository;

import infrastructure.repository.executor.ISqlDriver;
import infrastructure.repository.executor.PostgresDriver;

public abstract class Repository<T> implements CrudRepository<T>{

    protected ISqlDriver driver;
    public Repository(ISqlDriver driver){
        this.driver = driver;
    }

}
