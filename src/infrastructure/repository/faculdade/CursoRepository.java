package infrastructure.repository.faculdade;

import domain.faculdade.entity.Curso;
import infrastructure.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CursoRepository  implements CrudRepository<Curso> {
    @Override
    public boolean create(Curso object) {
        return false;
    }

    @Override
    public Optional<Curso> read(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Curso object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<Curso> readAll() {
        return null;
    }
}
