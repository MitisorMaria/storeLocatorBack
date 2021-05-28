package com.storelocator.back.bl;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="locationId")
    private long locationId;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;

    public Store(long location, String name, String address) {
        this.locationId = location;
        this.name = name;
        this.address = address;
    }

    public Store() {
    }

    public long getLocation() {
        return locationId;
    }

    public void setLocation(long location) {
        this.locationId = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
