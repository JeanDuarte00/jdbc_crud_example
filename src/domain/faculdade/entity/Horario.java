package domain.faculdade.entity;

import domain.faculdade.enums.DiaDaSemana;

public class Horario {

    private String codigoHorario;
    private int hora;
    private int minuto;

    private DiaDaSemana dayOfWeek;

    public Horario(int hora, int minuto, DiaDaSemana day) {
        this.hora = hora;
        this.minuto = minuto;
        this.dayOfWeek = day;
        this.codigoHorario = hora+":"+minuto+day.getValue();
    }

    @Override
    public String toString() {
        return "Horario:{\n" +
                "hora=" + hora +
                ", minuto=" + minuto +
                ", dia=" + dayOfWeek.toString() +
                '}';
    }
}
