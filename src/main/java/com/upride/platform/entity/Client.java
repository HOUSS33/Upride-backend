package com.upride.platform.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String nationality;

    @Column(unique = true, nullable = false)
    private String cinNumber;

    @Column(unique = true, nullable = false)
    private String permisNumber;

    private String adresse;
    private String cinImage;
    private String permisImage;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
