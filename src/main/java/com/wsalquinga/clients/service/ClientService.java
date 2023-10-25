package com.wsalquinga.clients.service;

import com.wsalquinga.clients.dto.ClientDTO;
import com.wsalquinga.clients.entity.Client;

import java.util.List;

/**
 * @author wsalquinga on 24/10/2023
 */
public interface ClientService {
    public List<ClientDTO> listAll();

    public Client findClientById(Integer id);

    public ClientDTO findById(Integer id);

    public ClientDTO create(ClientDTO client);

    public ClientDTO update(Integer id, ClientDTO client);

    public void delete(Integer id);
}
