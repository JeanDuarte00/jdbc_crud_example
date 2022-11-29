package domain.faculdade.entity;

import domain.pessoa.entity.Professor;

import java.util.UUID;

public class Disciplina {
    private UUID id;
    private String nome;
    private Integer cargaHoraria;
    private Horario horario;
    private Professor professor;

    public Disciplina(String nome, Integer cargaHoraria, Horario horario, Professor professor) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.horario = horario;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Horario getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Disciplina:{\n" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", horario=" + horario +
                ", professor=" + professor +
                '}';
    }
}
