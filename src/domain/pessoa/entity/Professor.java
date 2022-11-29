package domain.pessoa.entity;

import domain.pessoa.enums.Genero;

import java.util.Date;

public class Professor extends Pessoa {
    private boolean efetivo;
    public Professor(String cpf, String nome, String identidade, Date dataNascimento, Contato contato, Genero genero) {
        super(cpf, nome, identidade, dataNascimento, contato, genero);
        this.efetivo = false;
    }

    public Professor tornarEfetivo(){
        this.efetivo = true;
        return this;
    }

    public boolean isEfetivo(){
        return efetivo;
    }

    @Override
    public String toString() {
        return "Professor:{\n" +
                "efetivo=" + efetivo +
                ", " + super.toString() +
                '}';
    }
}
