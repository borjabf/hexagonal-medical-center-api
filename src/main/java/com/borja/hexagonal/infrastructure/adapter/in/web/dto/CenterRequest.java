package com.borja.hexagonal.infrastructure.adapter.in.web.dto;

import lombok.Data;

import java.util.List;

// Clase para recibir datos en el back
@Data
public class CenterRequest {

    private String name;
    private String address;
    private List<String> services;

}
