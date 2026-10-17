package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(nullable = false)
    private Date dateDebut;
    @Column(nullable = false)
    private Date dateFin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutReservation statut;
    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne
    private Client client;
    @OneToOne (fetch = FetchType.LAZY)
    private Contrat contrat;
}
