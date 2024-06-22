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
        EmailEntidade emailEntidade = new EmailEntidade();
        emailEntidadeRepository.findAll();
    }

}
