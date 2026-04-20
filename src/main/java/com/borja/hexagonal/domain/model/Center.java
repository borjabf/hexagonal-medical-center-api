package com.borja.hexagonal.domain.model;

import java.util.List;

// Representa un Centro en nuestro sistema de negocio
public class Center{

    // Atributos
    private String id;
    private String name;
    private String address;
    private List<String> services;

    // Constructor vacío
    public Center() {};

    public Center(String id, String name, String address, List<String> services) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.services = services;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<String> getServices() { return services; }
    public void setServices(List<String> services) { this.services = services; }

    @Override
    public String toString(){
        return "Center{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';    }



}
