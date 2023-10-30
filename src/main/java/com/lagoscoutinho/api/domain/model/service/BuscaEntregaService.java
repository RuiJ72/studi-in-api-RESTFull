package com.lagoscoutinho.api.domain.model.service;

import com.lagoscoutinho.api.domain.model.Entrega;
import com.lagoscoutinho.api.domain.repository.EntregaRepository;
import com.lagoscoutinho.api.exceptionhandler.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;
    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não Encontrada"));
    }
}
