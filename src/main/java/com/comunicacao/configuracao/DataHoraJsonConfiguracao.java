package com.comunicacao.configuracao;

import com.comunicacao.utils.DateUtils;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(JacksonAutoConfiguration.class)
class DataJsonConfiguracao {

    @Bean
    Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperBuilderCustomizer() {
        return jacksonBuilder -> jacksonBuilder
                .serializers(
                        new LocalDateSerializer(DateUtils.FORMATO_PADRAO_DATA),
                        new LocalTimeSerializer(DateUtils.FORMATO_PADRAO_HORA),
                        new LocalDateTimeSerializer(DateUtils.FORMATO_PADRAO_DATA_HORA)
                )
                .deserializers(
                        new LocalDateDeserializer(DateUtils.FORMATO_PADRAO_DATA),
                        new LocalTimeDeserializer(DateUtils.FORMATO_PADRAO_HORA),
                        new LocalDateTimeDeserializer(DateUtils.FORMATO_PADRAO_DATA_HORA)
                );
    }

}
