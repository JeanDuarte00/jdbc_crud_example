package infrastructure.repository.executor;

import java.sql.ResultSet;
import java.util.Optional;

public interface ISqlDriver {
    Optional<ResultSet> execute(String query);
}
