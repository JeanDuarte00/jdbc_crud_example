package infrastructure.repository.faculdade;

import domain.faculdade.entity.Horario;
import domain.faculdade.enums.DiaDaSemana;
import infrastructure.repository.CrudRepository;
import infrastructure.repository.Repository;
import infrastructure.repository.executor.ISqlDriver;
import infrastructure.repository.executor.PostgresDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class HorarioRepository extends Repository<Horario> {

    @Override
    public boolean create(Horario object) {
        return false;
    }

    @Override
    public Optional<Horario> read(UUID id) {
        try{
            String query = "select * from horario;"; //buscar pela combinacao
            Optional<ResultSet> resultOptional = driver.execute(query);

            if(resultOptional.isEmpty())
                return Optional.empty();

            ResultSet resultSet = resultOptional.get();
            resultSet.first();

            Integer hora = resultSet.getInt("hora");
            Integer minuto = resultSet.getInt("hora");
            String diaSemana = resultSet.getString("dia_semana");
            return Optional.of(new Horario(hora, minuto, DiaDaSemana.valueOf(diaSemana)));

        }catch (SQLException exception){
            exception.getStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public boolean update(Horario object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<Horario> readAll() {
        List<Horario> list = new ArrayList<>();
        try{
            String query = "select * from horario;";
            Optional<ResultSet> resultOptional = driver.execute(query);

            ResultSet resultSet = resultOptional.get();

            while(resultSet.next()){
                Integer hora = resultSet.getInt("hora");
                Integer minuto = resultSet.getInt("minuto");
                String diaSemana = resultSet.getString("dia_semana");

                list.add(new Horario(hora, minuto, DiaDaSemana.valueOf(diaSemana)));
            }
        }catch (SQLException exception){
            exception.getStackTrace();
        }
        return list;
    }
}
