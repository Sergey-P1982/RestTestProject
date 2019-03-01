package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.TaxiOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiOrderRepository extends JpaRepository<TaxiOrder, Long> {
}
