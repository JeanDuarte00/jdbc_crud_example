package domain.faculdade.enums;

public enum DiaDaSemana {
    DOMINGO("DOMINGO"),
    SEGUNDA("SEGUNDA"),
    TERCA("TERCA"),
    QUARTA("QUARTA"),
    QUINTA("QUINTA"),
    SEXTA("SEXTA"),
    SABADO("SABADO");

    private final String value;

    DiaDaSemana(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
