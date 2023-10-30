package com.lagoscoutinho.api.domain.model.service;

import com.lagoscoutinho.api.domain.model.Entrega;
import com.lagoscoutinho.api.domain.model.StatusEntrega;
import com.lagoscoutinho.api.domain.model.exception.NegocioException;
import com.lagoscoutinho.api.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.fnalizar();

        entregaRepository.save(entrega);
    }
}
