package com.borja.hexagonal.application.services;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.domain.ports.in.CreateCenterUseCase;
import com.borja.hexagonal.domain.ports.in.DeleteCenterUseCase;
import com.borja.hexagonal.domain.ports.in.FindCenterUseCase;
import com.borja.hexagonal.domain.ports.out.CenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterService implements CreateCenterUseCase, FindCenterUseCase, DeleteCenterUseCase {

    // Puerto de salida para persistencia
    private final CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    // Implementación de CreateCenterUseCase
    @Override
    public Center execute(Center center) {
        // Lógica de negocio.
        System.out.println("Ejecutando caso de uso: creando centro " + center.getName());
        // Persistimos el centro en centerRepository
        return centerRepository.save(center);
    }

    // Implementación de FindCenterUseCase
    @Override
    public Optional<Center> findById(String id) {
        System.out.println("Ejecutando caso de uso: buscando centro por ID");
        return centerRepository.findById(id);
    }

    @Override
    public List<Center> findAll() {
        System.out.println("Ejecutando caso de uso: listando todos los centros");
        return centerRepository.findAll();
    }


    // Implementación de DeleteCenterUseCase
    @Override
    public void execute(String id) {
        System.out.println("Ejecutando caso de uso: borrando centro por id " + id);
        centerRepository.deleteById(id);
    }

}
