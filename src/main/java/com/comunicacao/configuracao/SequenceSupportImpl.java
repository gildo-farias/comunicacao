package com.comunicacao.configuracao;

import org.hibernate.MappingException;
import org.hibernate.dialect.sequence.SequenceSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class SequenceSupportImpl implements SequenceSupport {

    @Override
    public String getSelectSequenceNextValString(String sequenceName) throws MappingException {
        return "nextval('" + sequenceName + "')";
    }

    @Override
    @Primary
    public String getCreateSequenceString(String sequenceName) throws MappingException {
        return "create sequence if not exists " + sequenceName;
    }

}
