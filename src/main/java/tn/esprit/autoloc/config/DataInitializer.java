package tn.esprit.autoloc.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.enums.StatutVehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(VehiculeRepository vehiculeRepository) {
        return args -> {
            if (vehiculeRepository.count() == 0) {
                Vehicule v1 = new Vehicule(null, "Renault", "Clio", "123 TU 4567", 2022, StatutVehicule.DISPONIBLE);
                Vehicule v2 = new Vehicule(null, "Peugeot", "208", "789 TU 1234", 2023, StatutVehicule.DISPONIBLE);
                Vehicule v3 = new Vehicule(null, "Volkswagen", "Golf", "456 TU 7890", 2021, StatutVehicule.LOUE);

                vehiculeRepository.save(v1);
                vehiculeRepository.save(v2);
                vehiculeRepository.save(v3);

                System.out.println("✅ 3 véhicules de démonstration insérés en base.");
            }
        };
    }
}