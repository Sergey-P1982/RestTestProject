package com.epam.producing.testProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TaxiOrder {

    @Id
    @GeneratedValue
    private long id;
    private String clientPhone;

    @OneToMany
    @JoinColumn(name = "taxi_order_id")
    private List<Address> address = new ArrayList<>();

    public TaxiOrder(String clientPhone, List<Address> address) {
        this.clientPhone = clientPhone;
        this.address = address;

    }

    public TaxiOrder() {
    }

    public void addAddress(Address address) {
        if (!this.address.contains(address))
            this.address.add(address);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
