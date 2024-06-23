package com.comunicacao.entidades;

import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.domain.agendamento.AgendamentoTipo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = AgendamentoComunicacaoEntidade.NOME_TABELA, indexes = {
        @Index(columnList = "status", name = "status_idx"),
        @Index(columnList = "excluido", name = "excluido_idx"),
        @Index(columnList = "codigo_rastreio", name = "codigo_rastreio_idx")
})
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = AgendamentoComunicacaoEntidade.GENERATOR, sequenceName = AgendamentoComunicacaoEntidade.SEQUENCE, allocationSize = 1)
public class AgendamentoComunicacaoEntidade implements Serializable {

    @Serial
    private static final long serialVersionUID = 2040768015015828876L;

    static final String NOME_TABELA = "agendamentos_comunicacao";
    static final String COLUMN_ID = "id";
    static final String GENERATOR = NOME_TABELA + "_generator";
    static final String SEQUENCE = NOME_TABELA + "_" + COLUMN_ID + "_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @Column(name = "id", columnDefinition = EntidadeConstants.BIGSERIAL)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "destino", columnDefinition = "VARCHAR(150)")
    private String destino;

    @Column(name = "conteudo", columnDefinition = EntidadeConstants.TEXT)
    private String conteudo;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    @Column(name = "data_ultima_alteracao")
    private LocalDateTime dataUltimaAlteracao;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @Setter(AccessLevel.NONE)
    @Column(name = "tentativas", columnDefinition = EntidadeConstants.INT_DEFAULT_0)
    private int tentativas;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private AgendamentoStatus status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo")
    private AgendamentoTipo tipo;

    @Setter(AccessLevel.NONE)
    @Column(name = "log_falha", columnDefinition = EntidadeConstants.TEXT)
    private String logFalha;

    @Setter(AccessLevel.NONE)
    @Column(name = "excluido", columnDefinition = EntidadeConstants.BOOLEAN_DEFAULT_FALSE)
    private boolean excluido;

    @Column(name = "codigo_rastreio", columnDefinition = EntidadeConstants.TEXT)
    private String codigoRastreio;

    // Esse método seria para o futuro na implementação do envio
    final void processando() {
        this.tentativas++;
        this.status = AgendamentoStatus.PROCESSANDO;
    }

    // Esse método seria para o futuro na implementação do envio
    final void enviado() {
        this.status = AgendamentoStatus.ENVIADO;
    }

    // Esse método seria para o futuro na implementação do envio
    final void falha(String causa) {
        this.status = AgendamentoStatus.FALHA;
        this.logFalha = causa;
    }

}
