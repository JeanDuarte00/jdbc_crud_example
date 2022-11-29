package infrastructure.repository.executor;

import infrastructure.configuration.PropertiesConfigurator;

import java.sql.ResultSet;
import java.util.Optional;

public class PostgresDriver extends SqlDriver {


    public PostgresDriver(String user, String senha, String url) {
        super(user, senha, url);
        withDriver(PropertiesConfigurator.getProperty("driver.postgres"));
    }

    public PostgresDriver() {
        user = PropertiesConfigurator.getProperty("aws.db.postgres.user");
        senha = PropertiesConfigurator.getProperty("aws.db.postgres.password");
        url = PropertiesConfigurator.getProperty("aws.db.postgres.url");
        withDriver(PropertiesConfigurator.getProperty("driver.postgres"));
    }

    @Override
    public Optional<ResultSet> execute(String query) {
        ResultSet result = super.execute(query).get();
        if (result == null)
            return Optional.empty();
        return Optional.of(result);
    }


}
