package infrastructure.repository.executor;

import java.sql.*;
import java.util.Optional;

public abstract class SqlDriver implements ISqlDriver{

    protected String user = "attwvxyq";
    protected String senha = "ZzyjHYp7Vs5DL-vM2wa16O7BdP_4myOF";
    protected String url = "jdbc:postgresql://babar.db.elephantsql.com:5432/attwvxyq";
    private String driver = "org.postgresql.Driver";

    public SqlDriver() {}
    public SqlDriver(String user, String senha, String url) {
        this.user = user;
        this.senha = senha;
        this.url = url;
    }

    @Override
    public Optional<ResultSet> execute(String query){
        ResultSet result = null;
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            connection.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(result);
    }

    protected SqlDriver withDriver(String driver){
        try {
            this.driver = driver;
            Class.forName(this.driver);
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        }
        return this;
    }

    private Connection getDBConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, senha);
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return connection;
    }

}
