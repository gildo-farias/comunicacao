package com.comunicacao.domain.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface AgendamentoComunicacaoRepository extends JpaRepository<AgendamentoComunicacaoEntidade, Long> {

    @Query("SELECT a FROM AgendamentoComunicacaoEntidade a WHERE a.codigoRastreiro = ?1")
    Optional<AgendamentoComunicacaoEntidade> buscarPeloCodigoRastreio(String codigoRastreiro);

}