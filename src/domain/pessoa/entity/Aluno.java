package domain.pessoa.entity;

import domain.faculdade.entity.Curso;
import domain.pessoa.enums.Genero;

import java.util.Date;

public class Aluno extends Pessoa {
    private boolean bolsista;
    private Curso curso;
    public Aluno(String cpf, String nome, String identidade, Date dataNascimento, Contato contato, Genero genero) {
        super(cpf, nome, identidade, dataNascimento, contato, genero);
        this.curso = Curso.getCursoBase();
        this.bolsista = false;
    }
    public void matricular(Curso cursoParaMatricular){
        this.curso = cursoParaMatricular;
    }

    public void receberBolsa(){
        this.bolsista = true;
    }

    public boolean isBolsista(){
        return bolsista;
    }

    @Override
    public String toString() {
        return "Aluno:{\n" +
                "bolsa=" + bolsista +
                ", " + super.toString() +
                ", curso=" + curso +
                '}';
    }
}
