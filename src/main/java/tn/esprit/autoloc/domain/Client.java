package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCient;
    @Column(nullable = false, length = 20)
    private String nom;
    @Column(nullable = false, length = 20)
    private String prenom;
    @Column(nullable = false, length = 20)
    private String elmail;
    @Column(nullable = false, length = 8)
    private Number telephone;
    @Column(nullable = false, length = 20)
    private Number numPermis;
    @Column(nullable = false)
    private Date dateInscription;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
