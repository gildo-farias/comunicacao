package com.comunicacao.domain.email;

import com.comunicacao.domain.EntidadeDadosPadroes;
import com.comunicacao.utils.EntidadeUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = EmailEntidade.NOME_TABELA)
@SequenceGenerator(name = EmailEntidade.GENERATOR, sequenceName = EmailEntidade.SEQUENCE, allocationSize = 1)
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class EmailEntidade {

    static final String NOME_TABELA = "email";
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

    @Embedded
    private EntidadeDadosPadroes dadosPadroes;

    public EmailEntidade() {
        this.dadosPadroes = new EntidadeDadosPadroes();
    }

    @PrePersist
    private void prePersist() {
        this.dadosPadroes.prePersist();
    }

}
