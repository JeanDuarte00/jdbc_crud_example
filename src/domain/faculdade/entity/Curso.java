package domain.faculdade.entity;

import domain.faculdade.enums.Turno;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Curso {

    private UUID id;
    private String area;
    private String nome;
    private Double valor;
    private Turno turno;
    private List<Disciplina> disciplinas;

    public Curso(String area, String nome, Double valor, Turno turno) {
        this.id = UUID.randomUUID();
        this.area = area;
        this.nome = nome;
        this.valor = valor;
        this.turno = turno;
        this.disciplinas = new ArrayList<>();
    }

    public void mudarValor(Double novoValor){
        this.valor = novoValor;
    }

    public void adicionarNovaDisciplina(Disciplina novaDisciplina){
        this.disciplinas.add(novaDisciplina);
    }

    public Integer getCargaHorariaTotalCurso(){
        Integer cargaHorariaToral = 0;
        for(Disciplina disciplina: disciplinas){
            cargaHorariaToral += disciplina.getCargaHoraria();
        }
        return cargaHorariaToral;
    }

    public static Curso getCursoBase(){
        return new Curso("Area Inexistente", "Curso Inexistente", 0.0, Turno.MANHA);
    }

    @Override
    public String toString() {
        String disciplinasCurso = "";
        for(Disciplina disciplina: disciplinas){
            disciplinasCurso += disciplina.toString();
        }

        return "Curso:{\n" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", turno=" + turno +
                ", disciplinas=" + disciplinasCurso +
                '}';
    }
}
