package com.borja.hexagonal.domain.ports.in;

import com.borja.hexagonal.domain.model.Center;

import java.util.List;
import java.util.Optional;

public interface FindCenterUseCase {

    Optional<Center> findById(String id);

    List<Center> findAll();

}
