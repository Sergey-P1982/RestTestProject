package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.TaxiOrderNotFoundException;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.TaxiOrder;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.TaxiOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxiOrderController {
    @Autowired
    private final TaxiOrderRepository repository;
    private final AddressRepository addressRepository;

    public TaxiOrderController(TaxiOrderRepository repository, AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.repository = repository;
    }

    @GetMapping("/orders")
    public List<TaxiOrder> getTaxiOrder(){
        return repository.findAll();
    }

    @PostMapping("/orders")
    ResponseEntity<TaxiOrder> newTaxiOrder(@RequestBody TaxiOrder newTaxiOrder) {
        return new ResponseEntity<>(repository.save(newTaxiOrder), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    TaxiOrder one(@PathVariable Long id) {
        return  repository.findById(id)
                .orElseThrow(() ->new TaxiOrderNotFoundException(id));
    }

    @PutMapping("/orders/{id}")
    TaxiOrder replaceEmployee(@RequestBody TaxiOrder newTaxiOrder, @PathVariable Long id) {

        return repository.findById(id)
                .map(taxiOrder -> {
                   taxiOrder.setClientPhone(newTaxiOrder.getClientPhone());
                    return repository.save(taxiOrder);
                })
                .orElseGet(() -> {
                    newTaxiOrder.setId(id);
                    return repository.save(newTaxiOrder);
                });
    }
    @GetMapping("/orders/{id}/addresses")
    List<Address> allAddressesByUserId(@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new TaxiOrderNotFoundException(id))
                .getAddress();
    }

}
