package com.upride.platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;   // <-- changed from Long to UUID

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicule vehicle;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private LocalDate returnedAt;

    @Column(nullable = false)
    private Double totalAmount;

    private Double monthlyAmount;

    @Column(columnDefinition = "NUMERIC(10,2) DEFAULT 0")
    private Double livraisonFee = 0.0;

    private LocalDateTime createdAt = LocalDateTime.now();
}
