package com.comunicacao.domain.sms;

import com.comunicacao.domain.EntidadeDadosPadroes;
import com.comunicacao.domain.sms.SmsEntidade;
import com.comunicacao.utils.EntidadeUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = SmsEntidade.NOME_TABELA)
@SequenceGenerator(name = SmsEntidade.GENERATOR, sequenceName = SmsEntidade.SEQUENCE, allocationSize = 1)
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class SmsEntidade {

    static final String NOME_TABELA = "sms";
    static final String COLUMN_ID = "id";
    static final String GENERATOR = NOME_TABELA + "_generator";
    static final String SEQUENCE = NOME_TABELA + "_" + COLUMN_ID + "_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @Column(name = "id", columnDefinition = EntidadeUtils.BIGSERIAL)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "destino", columnDefinition = "VARCHAR(20)")
    private String destino;

    @Embedded
    private EntidadeDadosPadroes dadosPadroes;

    public SmsEntidade() {
        this.dadosPadroes = new EntidadeDadosPadroes();
    }

    @PrePersist
    private void prePersist() {
        this.dadosPadroes.prePersist();
    }

}
