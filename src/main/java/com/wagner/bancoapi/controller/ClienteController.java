package com.wagner.bancoapi.controller;

import com.wagner.bancoapi.dto.request.ClienteDTO;
import com.wagner.bancoapi.dto.response.MessageResponseDTO;
import com.wagner.bancoapi.entity.Cliente;
import com.wagner.bancoapi.repository.ClienteRepository;
import com.wagner.bancoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // O @Valid serve para indicar que o clienteDTO será validado
    public MessageResponseDTO createCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        return clienteService.createCliente(clienteDTO);
    }
}
