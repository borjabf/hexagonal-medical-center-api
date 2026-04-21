package com.borja.hexagonal.infrastructure.adapter.in.web.mapper;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterRequest;
import com.borja.hexagonal.infrastructure.adapter.in.web.dto.CenterResponse;
import org.springframework.stereotype.Component;

// Clase con métodos para traducir los datos de entrada del front a dominio, y de dominio a datos de front
@Component
public class CenterWebMapper {

    // Método para convertir datos de entrada "request" a datos de dominio "Center"
    public Center toDomain(CenterRequest request) {
        // Retornar null si no se pasa parámetro
        if (request == null) return null;
        // Creación de objeto Center con datos de objeto CenterRequest
        Center center = new Center();
        center.setId(null); // "id" null porque se genera en en ddbb
        center.setName(request.getName());
        center.setAddress(request.getAddress());
        center.setServices(request.getServices());

        return center;
    }

    // Método para convertir datos de dominio "Center" a datos de para el front "Response"
    public CenterResponse toResponse(Center domain) {
        // Retornar null si no se pasa parámetro
        if (domain == null) return null;
        //
        CenterResponse response = new CenterResponse();
        response.setId(domain.getId());
        response.setName(domain.getName());
        response.setAddress(domain.getAddress());
        response.setServices(domain.getServices());

        return response;

    }


}
