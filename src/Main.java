import domain.faculdade.entity.Curso;
import domain.faculdade.entity.Disciplina;
import domain.faculdade.entity.Horario;
import domain.faculdade.entity.Turma;
import domain.faculdade.enums.DiaDaSemana;
import domain.faculdade.enums.Turno;
import domain.pessoa.entity.Aluno;
import domain.pessoa.entity.Contato;
import domain.pessoa.entity.Professor;
import domain.pessoa.enums.Genero;
import infrastructure.repository.CrudRepository;
import infrastructure.repository.faculdade.HorarioRepository;
import infrastructure.repository.faculdade.TurmaRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Professor professor = new Professor("111.111.111-11", "Professor Fulano", "11111-1", new Date(1975, Calendar.SEPTEMBER, 6), new Contato("mestre@email.com", "00000000"), Genero.MASCULINO).tornarEfetivo();
        Professor professor1 = new Professor("111.111.111-11", "Professora Maria", "11111-1", new Date(1975, Calendar.SEPTEMBER, 6), new Contato("mestre@email.com", "00000000"), Genero.FEMININO).tornarEfetivo();

        Curso curso = new Curso("Tecnologia", "Ciencia da Computacao", 888.0, Turno.NOITE);

        curso.adicionarNovaDisciplina(new Disciplina("Introducao a programacao", 50, new Horario(19,00, DiaDaSemana.SEGUNDA), professor1));
        curso.adicionarNovaDisciplina(new Disciplina("Estrutura de Dados", 50, new Horario(20,30, DiaDaSemana.SEGUNDA), professor));
        curso.adicionarNovaDisciplina(new Disciplina("Arquitetura de Computadores", 50, new Horario(19,00, DiaDaSemana.TERCA), professor));
        curso.adicionarNovaDisciplina(new Disciplina("Analise de Algoritmos", 50, new Horario(20,30, DiaDaSemana.TERCA), professor1));

        Aluno aluno = new Aluno("111.111.111-11", "Jean", "11111-1", new Date(1995, Calendar.SEPTEMBER, 6), new Contato("jean@email.com","898989898"), Genero.MASCULINO);
        Aluno aluno1 = new Aluno("111.111.111-11", "Duarte", "11111-1", new Date(1995, Calendar.SEPTEMBER, 6), new Contato("duarte@email.com","898989898"), Genero.MASCULINO);

        Aluno aluno2 = new Aluno("111.111.111-11", "Jean", "11111-1", new Date(1995, Calendar.SEPTEMBER, 6), new Contato("jean@email.com","898989898"), Genero.MASCULINO);
        Aluno aluno3 = new Aluno("111.111.111-11", "Duarte", "11111-1", new Date(1995, Calendar.SEPTEMBER, 6), new Contato("duarte@email.com","898989898"), Genero.MASCULINO);


        aluno.matricular(curso);
        aluno1.matricular(curso);
        aluno2.matricular(curso);
        aluno3.matricular(curso);

        Turma turma1 = new Turma().adicionarAluno(aluno).adicionarAluno(aluno1);
        Turma turma2 = new Turma().adicionarAluno(aluno2).adicionarAluno(aluno3);

        //CrudRepository repository = new HorarioRepository();
        //List<Horario> list = repository.readAll();

        CrudRepository repositoryTurma = new TurmaRepository();
        List<Turma> listTurma = repositoryTurma.readAll();


    }


}