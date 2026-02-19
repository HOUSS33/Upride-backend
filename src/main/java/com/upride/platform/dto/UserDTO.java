package com.upride.platform.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.upride.platform.entity.Agency;
import com.upride.platform.entity.Client;
import com.upride.platform.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private UUID id;
    private String email;
    private User.UserRole role;
    private Client client;
    private Agency agency;
    private LocalDateTime createdAt;
}
