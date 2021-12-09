package com.wagner.bancoapi.service;

import com.wagner.bancoapi.dto.request.ClienteDTO;
import com.wagner.bancoapi.dto.response.MessageResponseDTO;
import com.wagner.bancoapi.entity.Cliente;
import com.wagner.bancoapi.mapper.ClienteMapper;
import com.wagner.bancoapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listall() {
        List<Cliente> allClientes = clienteRepository.findAll();
        return allClientes.stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());


    }


    public MessageResponseDTO createCliente(@RequestBody ClienteDTO clienteDTO){

        Cliente clienteToSave = clienteMapper.toModel(clienteDTO);

        Cliente savedCliente = clienteRepository.save(clienteToSave);
        return MessageResponseDTO
                .builder()
                .mensagem("Criado cliente com ID:" + savedCliente.getId())
                .build();
    }
}
