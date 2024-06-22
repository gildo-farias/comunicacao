package com.comunicacao.domain.agendamento;

import com.comunicacao.utils.EntidadeUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = AgendamentoComunicacaoEntidade.NOME_TABELA)
@SequenceGenerator(name = AgendamentoComunicacaoEntidade.GENERATOR, sequenceName = AgendamentoComunicacaoEntidade.SEQUENCE, allocationSize = 1)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PACKAGE)
public class AgendamentoComunicacaoEntidade {

    static final String NOME_TABELA = "agendamentos_comunicacao";
    static final String COLUMN_ID = "id";
    static final String GENERATOR = NOME_TABELA + "_generator";
    static final String SEQUENCE = NOME_TABELA + "_" + COLUMN_ID + "_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @Column(name = "id", columnDefinition = EntidadeUtils.BIGSERIAL)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "destino", columnDefinition = "VARCHAR(150)")
    private String destino;

    @Column(name = "conteudo", columnDefinition = EntidadeUtils.TEXT)
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
    @Column(name = "tentativas", columnDefinition = EntidadeUtils.INT_DEFAULT_0)
    private int tentativas;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private AgendamentoStatus status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo")
    private AgendamentoTipo tipo;

    @Setter(AccessLevel.NONE)
    @Column(name = "log_falha", columnDefinition = EntidadeUtils.TEXT)
    private String logFalha;

    @Setter(AccessLevel.NONE)
    @Column(name = "excluido", columnDefinition = EntidadeUtils.BOOLEAN_DEFAULT_FALSE)
    private boolean excluido;

    @Column(name = "codigo_rastreio", columnDefinition = EntidadeUtils.TEXT)
    private String codigoRastreio;

    final void processando() {
        this.tentativas++;
        this.status = AgendamentoStatus.PROCESSANDO;
    }

    final void enviado() {
        this.status = AgendamentoStatus.ENVIADO;
    }

    final void falha(String causa) {
        this.status = AgendamentoStatus.FALHA;
        this.logFalha = causa;
    }

}