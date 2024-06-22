package com.comunicacao.domain.email;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmailServiceImpl implements EmailService {

    private final EmailEntidadeRepository emailEntidadeRepository;


}
