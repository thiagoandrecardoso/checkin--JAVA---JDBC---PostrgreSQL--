package model;

import java.time.LocalTime;

public class Linha {
    private int id;
    private String origem;
    private String destino;
    private LocalTime hora_embarque;
    private LocalTime hora_partida;

    public Linha() {
    }

    public Linha(int id, String origem, String destino, LocalTime hora_embarque, LocalTime hora_partida) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.hora_embarque = hora_embarque;
        this.hora_partida = hora_partida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHora_embarque() {
        return hora_embarque;
    }

    public void setHora_embarque(LocalTime hora_embarque) {
        this.hora_embarque = hora_embarque;
    }

    public LocalTime getHora_partida() {
        return hora_partida;
    }

    public void setHora_partida(LocalTime hora_partida) {
        this.hora_partida = hora_partida;
    }

    @Override
    public String toString() {
        return "linha{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", hora_embarque=" + hora_embarque +
                ", hora_partida=" + hora_partida +
                '}';
    }
}
