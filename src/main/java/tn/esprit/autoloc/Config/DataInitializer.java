package tn.esprit.autoloc.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(VehiculeRepository vehiculeRepository) {
        return args -> {

            if (vehiculeRepository.count() > 0) {
                return;
            }

            Vehicule v1 = new Vehicule();
            v1.setImmatriculation("123 TUN 4567");
            v1.setMarque("Volkswagen");
            v1.setModele("Golf 8");
            v1.setCategorie(CategorieVehicule.CITADINE);
            v1.setTarifJournalier(new BigDecimal("120.00"));
            v1.setStatut(StatutVehicule.DISPONIBLE);

            Vehicule v2 = new Vehicule();
            v2.setImmatriculation("234 TUN 5678");
            v2.setMarque("BMW");
            v2.setModele("Serie 3");
            v2.setCategorie(CategorieVehicule.BERLINE);
            v2.setTarifJournalier(new BigDecimal("180.00"));
            v2.setStatut(StatutVehicule.LOUE);

            Vehicule v3 = new Vehicule();
            v3.setImmatriculation("345 TUN 6789");
            v3.setMarque("Toyota");
            v3.setModele("Yaris");
            v3.setCategorie(CategorieVehicule.SUV);
            v3.setTarifJournalier(new BigDecimal("80.00"));
            v3.setStatut(StatutVehicule.MAINTENANCE);

            vehiculeRepository.save(v1);
            vehiculeRepository.save(v2);
            vehiculeRepository.save(v3);

            System.out.println("Données de démonstration insérées !");
        };
    }
}