package com.wsalquinga.clients.mapper;

import com.wsalquinga.clients.dto.ClientDTO;
import com.wsalquinga.clients.entity.Client;
import org.mapstruct.Mapper;

/**
 * @author wsalquinga on 24/10/2023
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toClientDTO(Client client);

    Client toClientEntity(ClientDTO client);
}
