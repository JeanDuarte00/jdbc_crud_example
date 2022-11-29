package domain.pessoa.entity;

import domain.pessoa.enums.Genero;

import java.util.Date;
import java.util.UUID;

public abstract class Pessoa {
    private UUID id;
    private String cpf;
    private String nome;
    private String identidade;
    private Date dataNascimento;
    private Contato contato;
    private Genero genero;

    public Pessoa(String cpf, String nome, String identidade, Date dataNascimento, Contato contato, Genero genero) {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
        this.nome = nome;
        this.identidade = identidade;
        this.dataNascimento = dataNascimento;
        this.contato = contato;
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Pessoa:{\n" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", identidade='" + identidade + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", contato=" + contato +
                ", genero=" + genero +
                '}';
    }
}
