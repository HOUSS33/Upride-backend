package com.upride.platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;

    @Column(nullable = false)
    private String marque;

    @Column(unique = true, nullable = false)
    private String matricule;

    @Column(nullable = false)
    private Double price;

    private String model;
    private Integer year;
    private String photoUrl;
    private Integer currentKm;
    private LocalDateTime createdAt;
}
