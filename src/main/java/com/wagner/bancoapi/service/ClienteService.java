package com.wagner.bancoapi.service;

import com.wagner.bancoapi.dto.response.MessageResponseDTO;
import com.wagner.bancoapi.entity.Cliente;
import com.wagner.bancoapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public MessageResponseDTO createCliente(@RequestBody Cliente cliente){
        Cliente savedCliente = clienteRepository.save(cliente);
        return MessageResponseDTO
                .builder()
                .mensagem("Criado cliente com ID:" + savedCliente.getId())
                .build();
    }
}
