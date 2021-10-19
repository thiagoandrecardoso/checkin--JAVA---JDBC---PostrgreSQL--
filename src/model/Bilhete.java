package model;

import java.time.LocalDateTime;

public class Bilhete {
    private String codigo;
    private Integer assento;
    private Passageiro passageiro;
    private Linha linha;
    private LocalDateTime assento_marcado_em;

    public Bilhete() {
    }

    public Bilhete(String codigo, Integer assento, Passageiro passageiro, Linha linha, LocalDateTime assento_marcado_em) {
        this.codigo = codigo;
        this.assento = assento;
        this.passageiro = passageiro;
        this.linha = linha;
        this.assento_marcado_em = assento_marcado_em;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public LocalDateTime getAssento_marcado_em() {
        return assento_marcado_em;
    }

    public void setAssento_marcado_em(LocalDateTime assento_marcado_em) {
        this.assento_marcado_em = assento_marcado_em;
    }

    @Override
    public String toString() {
        return "Bilhete{" +
                "codigo='" + codigo + '\'' +
                ", assento='" + assento + '\'' +
                ", passageiro=" + passageiro +
                ", linha=" + linha +
                ", assento_marcado_em=" + assento_marcado_em +
                '}';
    }
}
