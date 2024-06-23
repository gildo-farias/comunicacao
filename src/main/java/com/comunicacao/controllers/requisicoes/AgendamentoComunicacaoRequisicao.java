package com.comunicacao.controllers.requisicoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AgendamentoComunicacaoRequisicao(
        @NotNull(message = DATA_HORA_DE_ENVIO_INVALIDA) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraEnvio,
        @NotBlank(message = CONTEUDO_INVALIDO) String conteudo,
        @NotBlank(message = DESTINO_INVALIDO) String destino,
        @NotBlank(message = TIPO_NAO_PODE_SER_VAZIO) @Pattern(regexp = TIPO_DISPONIVEIS, message = TIPO_INVALIDO) String tipo
) {

    static final String DATA_HORA_DE_ENVIO_INVALIDA = "data hora de envio inválida";
    static final String CONTEUDO_INVALIDO = "contéudo inválido";
    static final String DESTINO_INVALIDO = "destino inválido";
    static final String TIPO_NAO_PODE_SER_VAZIO = "tipo inválido";

    private static final String TIPO_DISPONIVEIS = "EMAIL|SMS|PUSH|WHATSAPP";
    static final String TIPO_INVALIDO = "tipo inválido, tipos disponíveis: " + TIPO_DISPONIVEIS;

}
