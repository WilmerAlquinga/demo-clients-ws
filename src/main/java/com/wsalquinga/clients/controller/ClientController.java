package com.wsalquinga.clients.controller;

import com.wsalquinga.clients.dto.ClientDTO;
import com.wsalquinga.clients.service.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsalquinga on 25/10/2023
 */
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> listAll() {
        return ResponseEntity.ok(this.clientService.listAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> findById(@PathVariable(name = "clientId") Integer id) {
        return ResponseEntity.ok(this.clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(
            @Valid @RequestBody ClientDTO client
    ) {
        return ResponseEntity.ok(this.clientService.create(client));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> update(
            @PathVariable(name = "clientId") Integer id,
            @Valid @RequestBody ClientDTO clientDTO
    ) {
        return ResponseEntity.ok(this.clientService.update(id, clientDTO));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable(name = "clientId") Integer id) {
        this.clientService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Cliente eliminado correctamente", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
