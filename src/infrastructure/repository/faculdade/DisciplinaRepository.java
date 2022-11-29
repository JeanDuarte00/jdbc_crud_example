package infrastructure.repository.faculdade;

import domain.faculdade.entity.Disciplina;
import infrastructure.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DisciplinaRepository  implements CrudRepository<Disciplina> {
    @Override
    public boolean create(Disciplina object) {
        return false;
    }

    @Override
    public Optional<Disciplina> read(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Disciplina object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<Disciplina> readAll() {
        return null;
    }
}
