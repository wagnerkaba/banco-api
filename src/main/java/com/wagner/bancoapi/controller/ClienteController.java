package com.wagner.bancoapi.controller;

import com.wagner.bancoapi.dto.request.ClienteDTO;
import com.wagner.bancoapi.dto.response.MessageResponseDTO;
import com.wagner.bancoapi.entity.Cliente;
import com.wagner.bancoapi.exception.ClienteNotFoundException;
import com.wagner.bancoapi.repository.ClienteRepository;
import com.wagner.bancoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    // O @Valid serve para indicar que os dados do clienteDTO deve ser validado
    // How do I customize default error message from spring @Valid validation?
    // https://stackoverflow.com/questions/33663801/how-do-i-customize-default-error-message-from-spring-valid-validation/33664636
    public MessageResponseDTO createCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        return clienteService.createCliente(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> listAllClientes(){
        return clienteService.listall();
    }
    @GetMapping("/{id}")
    public ClienteDTO findClienteById(@PathVariable Long id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }


}
