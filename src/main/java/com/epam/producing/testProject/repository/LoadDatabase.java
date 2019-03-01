package com.epam.producing.testProject.repository;



import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.TaxiOrder;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.TaxiOrderRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase (TaxiOrderRepository repository, AddressRepository addressRepository){
        return args -> {
            List<Address> kyivDistr = Arrays.asList(addressRepository.save(new Address("Kyiv", "Prorizna, 8")),
                    addressRepository.save(new Address( "Kyiv", "Gagarina, 12")),
                    addressRepository.save(new Address("Boryspil", "Peremohy, 3")),
                    addressRepository.save(new Address("Vyshgorod", "Shevchenka, 22")));

            List<Address> kharkivDistr = Arrays.asList(addressRepository.save(new Address("Kharkiv", "Prorizna, 8")),
                    addressRepository.save(new Address( "Kharkiv", "Gagarina, 12")),
                    addressRepository.save(new Address("Izium", "Peremohy, 3")),
                    addressRepository.save(new Address("Balakleya", "Shevchenka, 22")));

            List<Address> lvivDistr = Arrays.asList(addressRepository.save(new Address("Lviv", "Svobody, 8")),
                    addressRepository.save(new Address( "Lviv", "Bandery, 12")),
                    addressRepository.save(new Address("Truskavets", "Peremohy, 3")),
                    addressRepository.save(new Address("Slavsko", "Shevchenka, 22")));

            log.info("PreLoading" + repository.save(new TaxiOrder("+380 66 111 22 33", kyivDistr)));
            log.info("PreLoading" + repository.save(new TaxiOrder("+380 50 222 33 44", kharkivDistr)));
            log.info("PreLoading" + repository.save(new TaxiOrder("+380 99 555 22 00", lvivDistr)));
        };
    }
}
