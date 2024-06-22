package com.comunicacao.domain;

import com.comunicacao.utils.DateUtils;
import com.comunicacao.utils.EntidadeUtils;
import com.comunicacao.utils.StringUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
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

    public final void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    public final void enviado() {
        this.tentativas++;
        this.falha = false;
        this.enviado = true;
        this.dataEnvio = LocalDateTime.now();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public final void falha(String causa) {
        this.tentativas++;
        this.enviado = false;
        this.falha = true;
        StringBuilder logFalha = new StringBuilder(StringUtils.vazia(this.logFalha) ? "" : this.logFalha);
        this.logFalha = logFalha
                .append("#")
                .append(DateUtils.localDateTimeToString(LocalDateTime.now()))
                .append("#")
                .append(causa)
                .toString();
    }

}
