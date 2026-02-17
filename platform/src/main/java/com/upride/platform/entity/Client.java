package com.upride.platform.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;   // <-- changed from Long to UUID


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String nationality;

    @Column(nullable = false, unique = true)
    private String cinNumber;

    @Column(nullable = false, unique = true)
    private String permisNumber;

    private String adresse;
    private String cinImage;
    private String permisImage;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String phoneNumber;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
