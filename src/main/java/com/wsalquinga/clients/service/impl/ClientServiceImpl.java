package com.wsalquinga.clients.service.impl;

import com.wsalquinga.clients.dto.ClientDTO;
import com.wsalquinga.clients.entity.Client;
import com.wsalquinga.clients.exception.ResourceNotFoundException;
import com.wsalquinga.clients.mapper.ClientMapper;
import com.wsalquinga.clients.repository.ClientRepository;
import com.wsalquinga.clients.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wsalquinga on 24/10/2023
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDTO> listAll() {
        return this.clientMapper.toClientDTO(this.clientRepository.findAllValid());
    }

    @Override
    public Client findClientById(Integer id) {
        return this.clientRepository.findValidById(id).orElseThrow(() ->
                new ResourceNotFoundException("No se encontró el cliente con id: " + id)
        );
    }

    @Override
    public ClientDTO findById(Integer id) {
        return this.clientMapper.toClientDTO(this.findClientById(id));
    }

    @Override
    public ClientDTO create(ClientDTO client) {
        return this.clientMapper.toClientDTO(this.clientRepository.save(
                this.clientMapper.toClientEntity(client)
        ));
    }

    @Override
    public ClientDTO update(Integer id, ClientDTO client) {
        Client updateClient = this.findClientById(id);
        updateClient.setName(client.getName());
        updateClient.setLastname(client.getLastname());
        updateClient.setEmail(client.getEmail());
        updateClient.setAddress(client.getAddress());
        updateClient.setUpdatedAt(LocalDateTime.now());
        updateClient.buildFullName();
        return this.clientMapper.toClientDTO(this.clientRepository.save(updateClient));
    }

    @Override
    public void delete(Integer id) {
        Client client = this.findClientById(id);
        client.setDeletedAt(LocalDateTime.now());
        this.clientRepository.save(client);
    }
}
