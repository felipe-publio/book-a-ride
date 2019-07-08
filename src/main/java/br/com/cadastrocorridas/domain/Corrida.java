package br.com.cadastrocorridas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Passageiro não pode estar em branco!")
    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;
    @NotNull(message = "Passageiro não pode estar em branco!")
    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    @NotNull(message = "Valor da corrida não pode estar em branco!")
    private BigDecimal valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
