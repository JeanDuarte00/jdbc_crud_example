package domain.faculdade.entity;

import domain.pessoa.entity.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Turma {

    private UUID id;
    private List<Aluno> alunos;
    public Turma() {
        this.id = UUID.randomUUID();
        this.alunos = new ArrayList<>();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Turma adicionarAluno(Aluno aluno){
        alunos.add(aluno);
        return  this;
    }

    public int getQuantidadeAlunos(){
        return this.alunos.size();
    }

    @Override
    public String toString() {
        String alunosTurma = "";
        for (Aluno aluno: alunos){
            alunosTurma += aluno;
        }
        return "Turma:{\n" +
                "id=" + id +
                ", alunos=" + alunosTurma +
                '}';
    }
}
