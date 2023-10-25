package com.wsalquinga.clients.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author wsalquinga on 24/10/2023
 */
@Data
public class ClientDTO {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    private String fullname;

    @Email
    private String email;

    private String address;
}
