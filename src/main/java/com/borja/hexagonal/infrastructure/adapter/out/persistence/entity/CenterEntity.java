package com.borja.hexagonal.infrastructure.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "centers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CenterEntity {

    @Id
    private String id;

    private String name;
    private String address;
    private List<String> services;
}

