package com.upride.platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "agencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agency {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToMany(mappedBy = "agency", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vehicule> vehicules;

    @Column(nullable = false)
    private String name;

    private String city;
    private String country;
    private String phone;
    private LocalDateTime createdAt;
}