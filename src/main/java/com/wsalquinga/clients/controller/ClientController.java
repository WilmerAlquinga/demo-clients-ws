package com.wsalquinga.clients.controller;

import com.wsalquinga.clients.dto.ClientDTO;
import com.wsalquinga.clients.service.impl.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Client Controller", description = "Demo management Clients APIs")
public class ClientController {
    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Get all valid Clients", tags = {"clients", "get"})
    public ResponseEntity<List<ClientDTO>> listAll() {
        return ResponseEntity.ok(this.clientService.listAll());
    }

    @GetMapping("/{clientId}")
    @Operation(summary = "Get valid Client by client ID", tags = {"clients", "get"})
    public ResponseEntity<ClientDTO> findById(@PathVariable(name = "clientId") Integer id) {
        return ResponseEntity.ok(this.clientService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new Clients", tags = {"clients", "post"})
    public ResponseEntity<ClientDTO> create(
            @Valid @RequestBody ClientDTO client
    ) {
        return ResponseEntity.ok(this.clientService.create(client));
    }

    @PutMapping("/{clientId}")
    @Operation(summary = "Update existing Client by ID", tags = {"clients", "put"})
    public ResponseEntity<ClientDTO> update(
            @PathVariable(name = "clientId") Integer id,
            @Valid @RequestBody ClientDTO clientDTO
    ) {
        return ResponseEntity.ok(this.clientService.update(id, clientDTO));
    }

    @DeleteMapping("/{clientId}")
    @Operation(summary = "Delete Client by client ID", tags = {"clients", "delete"})
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable(name = "clientId") Integer id) {
        this.clientService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Cliente eliminado correctamente", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
