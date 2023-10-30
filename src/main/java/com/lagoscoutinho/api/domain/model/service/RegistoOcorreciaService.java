package com.lagoscoutinho.api.domain.model.service;

import com.lagoscoutinho.api.domain.model.Entrega;
import com.lagoscoutinho.api.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistoOcorreciaService {

    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public Ocorrencia registar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }
}
