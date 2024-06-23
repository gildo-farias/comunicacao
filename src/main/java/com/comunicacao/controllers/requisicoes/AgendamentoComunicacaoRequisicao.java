package com.comunicacao.controllers.requisicoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AgendamentoComunicacaoRequisicao(
        @NotNull(message = "data hora de envio inválida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraEnvio,
        @NotBlank(message = "contéudo inválido") String conteudo,
        @NotBlank(message = "destino inválido") String destino,
        @NotBlank(message = "tipo inválido") @Pattern(regexp = "EMAIL|SMS|PUSH|WHATSAPP") String tipo
) {

}
