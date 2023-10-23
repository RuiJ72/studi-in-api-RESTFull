package com.lagoscoutinho.api.domain.model.service;

import com.lagoscoutinho.api.domain.model.Cliente;
import com.lagoscoutinho.api.domain.model.Entrega;
import com.lagoscoutinho.api.domain.model.StatusEntrega;
import com.lagoscoutinho.api.domain.model.exception.NegocioException;
import com.lagoscoutinho.api.domain.repository.ClienteRepository;
import com.lagoscoutinho.api.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {


    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());




        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}
