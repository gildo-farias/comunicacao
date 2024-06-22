package com.comunicacao.domain.email;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmailServiceImpl implements EmailService {

    private final EmailEntidadeRepository emailEntidadeRepository;

    @Bean
    void criarRegistro() {
        emailEntidadeRepository.deleteAll();
        EmailEntidade emailEntidade = new EmailEntidade();
        emailEntidade.setDestino("gildo@gmail.com");
        emailEntidadeRepository.saveAndFlush(emailEntidade);
    }

}
