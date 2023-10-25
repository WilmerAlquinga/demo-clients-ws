package com.wsalquinga.clients.repository;

import com.wsalquinga.clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wsalquinga on 24/10/2023
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
