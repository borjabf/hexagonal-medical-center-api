package com.borja.hexagonal.infrastructure.adapter.in.web.dto;

import lombok.Data;

import java.util.List;

//  Clase para devolver datos al Front
@Data
public class CenterResponse {

    private String id;
    private String name;
    private String address;
    private List<String> services;

}
