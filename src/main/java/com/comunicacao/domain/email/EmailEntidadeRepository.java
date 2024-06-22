package com.comunicacao.domain.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmailEntidadeRepository extends JpaRepository<EmailEntidade, Long> {

}