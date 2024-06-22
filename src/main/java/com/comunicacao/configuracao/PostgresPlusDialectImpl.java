package com.comunicacao.configuracao;

import org.hibernate.dialect.PostgresPlusDialect;
import org.hibernate.dialect.sequence.SequenceSupport;
import org.springframework.context.annotation.Configuration;

@Configuration
class PostgresPlusDialectImpl extends PostgresPlusDialect {

    @Override
    public SequenceSupport getSequenceSupport() {
        return new SequenceSupportImpl();
    }

}
