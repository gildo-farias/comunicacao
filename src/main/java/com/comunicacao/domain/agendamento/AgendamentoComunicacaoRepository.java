package com.comunicacao.domain.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface AgendamentoComunicacaoRepository extends JpaRepository<AgendamentoComunicacaoEntidade, Long> {

    @Query("SELECT a FROM AgendamentoComunicacaoEntidade a WHERE NOT a.excluido AND a.codigoRastreio = ?1")
    Optional<AgendamentoComunicacaoEntidade> buscarPeloCodigoRastreio(String codigoRastreiro);

    @Query("SELECT a.status FROM AgendamentoComunicacaoEntidade a WHERE NOT a.excluido AND a.codigoRastreio = ?1")
    Optional<AgendamentoStatus> buscarStatusPeloCodigoRastreio(String codigoRastreiro);

    @Modifying
    @Query("UPDATE AgendamentoComunicacaoEntidade a SET a.excluido = true WHERE a.codigoRastreio = ?1")
    void apagarPeloCodigoDeRastreio(String codigoRastreio);

}