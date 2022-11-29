package domain.pessoa.entity;

import java.util.UUID;

public class Contato {

    private UUID id;
    private String email;
    private String telefone;

    public Contato(String email, String telefone) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Contato:{\n" +
                "email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
