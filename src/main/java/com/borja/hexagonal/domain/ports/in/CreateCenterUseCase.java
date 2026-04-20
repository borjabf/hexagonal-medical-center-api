package com.borja.hexagonal.domain.ports.in;

import com.borja.hexagonal.domain.model.Center;

public interface CreateCenterUseCase {

    // Método para crear centro
    Center execute(Center center);
}
