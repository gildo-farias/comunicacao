package com.comunicacao.repositories;

import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AgendamentoComunicacaoRepository extends JpaRepository<AgendamentoComunicacaoEntidade, Long> {

    @Query("SELECT a.status FROM AgendamentoComunicacaoEntidade a WHERE NOT a.excluido AND a.codigoRastreio = ?1")
    Optional<AgendamentoStatus> buscarStatusPeloCodigoRastreio(String codigoRastreiro);

    @Modifying
    @Transactional
    @Query("UPDATE AgendamentoComunicacaoEntidade a SET a.excluido = true WHERE a.codigoRastreio = ?1")
    void apagarPeloCodigoDeRastreio(String codigoRastreio);

}