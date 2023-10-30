package com.lagoscoutinho.api.controller;

import com.lagoscoutinho.api.assembler.OcorrenciaAssembler;
import com.lagoscoutinho.api.domain.model.Entrega;
import com.lagoscoutinho.api.domain.model.Ocorrencia;
import com.lagoscoutinho.api.domain.model.OcorrenciaModel;
import com.lagoscoutinho.api.domain.model.service.BuscaEntregaService;
import com.lagoscoutinho.api.domain.model.service.RegistoOcorreciaService;
import com.lagoscoutinho.api.model.input.OcorrenciaInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistoOcorreciaService registoOcorreciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registar(@PathVariable Long entregaId,
                                    @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

        Ocorrencia ocorrenciaRegistada = registoOcorreciaService
                .registar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
