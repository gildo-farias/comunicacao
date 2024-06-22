package com.comunicacao.domain;

import com.comunicacao.utils.EntidadeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Embeddable
public class EntidadeDadosPadroes {

    @Setter(AccessLevel.NONE)
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @Column(name = "tentativas", columnDefinition = EntidadeUtils.INT_DEFAULT_0)
    private int tentativas;

    @Column(name = "enviado", columnDefinition = EntidadeUtils.BOOLEAN_DEFAULT_FALSE)
    private boolean enviado;

    @Column(name = "falha", columnDefinition = EntidadeUtils.BOOLEAN_DEFAULT_FALSE)
    private boolean falha;

    @Column(name = "log_falha", columnDefinition = EntidadeUtils.TEXT)
    private String logFalha;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

}
