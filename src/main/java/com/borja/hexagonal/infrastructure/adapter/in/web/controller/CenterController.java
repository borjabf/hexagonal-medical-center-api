package com.borja.hexagonal.infrastructure.adapter.in.web.controller;

import com.borja.hexagonal.domain.ports.in.CreateCenterUseCase;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterRequest;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterResponse;
import com.borja.hexagonal.infrastructure.adapter.in.web.mapper.CenterWebMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/centers")
public class CenterController {

    // Inyección de dependencias con interfaz que crea centros en base de datos
    // y clase mapper entre front y back
    private final CreateCenterUseCase createCenterUseCase;
    private final CenterWebMapper webMapper;

    public CenterController (CreateCenterUseCase createCenterUseCase, CenterWebMapper webMapper) {
        this.createCenterUseCase = createCenterUseCase;
        this.webMapper = webMapper;
    }

    // Método que recibe datos de entrada "request", los persiste en la dddbb
    // y los devuelve al front como "response"
    @PostMapping
    public CenterResponse create(@RequestBody CenterRequest request) {

        var centerToCreate = webMapper.toDomain(request);
        var createdCenter = createCenterUseCase.execute(centerToCreate);
        return webMapper.toResponse(createdCenter);

    }



}
