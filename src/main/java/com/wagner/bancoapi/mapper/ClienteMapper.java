package com.wagner.bancoapi.mapper;

import com.wagner.bancoapi.dto.request.ClienteDTO;
import com.wagner.bancoapi.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
// Esta interface utiliza o mapstruct para fazer o mapeamento do ClienteDTO para Cliente
// Para entender o funcionamento do mapstruct, visite: https://mapstruct.org/
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);


    // O atribute birthDate de Cliente é LocalDate
    // O atribute birthDate de ClienteDTO é String
    // É preciso informar essa diferença para o mapstruct através da anotação @Mapping
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Cliente toModel(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);
}
