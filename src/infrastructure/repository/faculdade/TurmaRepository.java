package infrastructure.repository.faculdade;

import domain.faculdade.entity.Turma;
import infrastructure.repository.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TurmaRepository extends Repository<Turma> {
    @Override
    public boolean create(Turma object) {
        return false;
    }

    @Override
    public Optional<Turma> read(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Turma object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<Turma> readAll() {
        List<Turma> list = new ArrayList<>();
        try{
            String query = "select * from turma;";
            Optional<ResultSet> resultOptional = driver.execute(query);

            ResultSet resultSet = resultOptional.get();

            while(resultSet.next()){
                String id = resultSet.getString("id");

                //usando o id da turma, entao consultar tabela de alunos

                Turma turma = new Turma();
                turma.setId(UUID.fromString(id));

                list.add(turma);
            }
        }catch (SQLException exception){
            exception.getStackTrace();
        }
        return list;
    }
}
