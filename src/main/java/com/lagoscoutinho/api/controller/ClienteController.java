package com.lagoscoutinho.api.controller;

import com.lagoscoutinho.api.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {

        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Rui Lagos");
        cliente1.setTelefone("11-95845-1111");
        cliente1.setEmail("lagos@gmail.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Jorge Coutinho");
        cliente2.setTelefone("11-9888-1111");
        cliente2.setEmail("coutinho@gmail.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
