package com.wsalquinga.clients.repository;

import com.wsalquinga.clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author wsalquinga on 24/10/2023
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select c from Client c " +
            "where (c.deletedAt IS NULL " +
            "or c.deletedAt > CURRENT_TIMESTAMP)")
    List<Client> findAllValid();

    @Query("select c from Client c " +
            "where (c.deletedAt IS NULL " +
            "or c.deletedAt > CURRENT_TIMESTAMP) " +
            "and c.id = :id")
    Optional<Client> findValidById(Integer id);
}
