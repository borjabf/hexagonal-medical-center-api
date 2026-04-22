package com.borja.hexagonal.infrastructure.adapter.in.web.controller;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.domain.ports.in.CreateCenterUseCase;
import com.borja.hexagonal.domain.ports.in.DeleteCenterUseCase;
import com.borja.hexagonal.domain.ports.in.FindCenterUseCase;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterRequest;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterResponse;
import com.borja.hexagonal.infrastructure.adapter.in.web.mapper.CenterWebMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/centers")
public class CenterController {

    // Inyección de dependencias con interfaz que crea centros en base de datos
    // y clase mapper entre front y back
    private final CreateCenterUseCase createCenterUseCase;
    private final DeleteCenterUseCase deleteCenterUseCase;
    private final FindCenterUseCase findCenterUseCase;
    private final CenterWebMapper webMapper;

    public CenterController (CreateCenterUseCase createCenterUseCase,
                             DeleteCenterUseCase deleteCenterUseCase,
                             FindCenterUseCase findCenterUseCase,
                             CenterWebMapper webMapper) {
        this.createCenterUseCase = createCenterUseCase;
        this.deleteCenterUseCase = deleteCenterUseCase;
        this.findCenterUseCase = findCenterUseCase;
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

    // Método para borrar centro de base de datos
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        deleteCenterUseCase.execute(id);
    }

    // Método para buscar centro por id
    @GetMapping("/{id}")
    public CenterResponse findById (@PathVariable String id) {
        var centerSearched = findCenterUseCase.findById(id).orElseThrow();
        return webMapper.toResponse(centerSearched);
    }

    // Método para buscar todos los centros
    @GetMapping
    public List<CenterResponse> findAll(){
        // Buscar todos los centros
        var centersFound = findCenterUseCase.findAll();
        // Lista para meter los centros
        ArrayList<CenterResponse> responses = new ArrayList<CenterResponse>();
        // Bucle para meter centros encontrados en lista de centros
        for (Center c : centersFound) {
            responses.add(webMapper.toResponse(c));
        }
        return responses;
    }
}






