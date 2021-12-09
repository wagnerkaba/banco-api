package com.wagner.bancoapi.mapper;

import com.wagner.bancoapi.dto.request.ClienteDTO;
import com.wagner.bancoapi.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
// Esta interface utiliza o mapstruct (https://mapstruct.org/) para fazer o mapeamento do ClienteDTO para Cliente
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);




    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Cliente toModel(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);
}
