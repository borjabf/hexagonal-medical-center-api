package com.borja.hexagonal.infrastructure.adapter.out.persistence.adapter;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.domain.ports.out.CenterRepository;
import com.borja.hexagonal.infrastructure.adapter.out.persistence.mapper.CenterPersistenceMapper;
import com.borja.hexagonal.infrastructure.adapter.out.persistence.repository.CenterMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CenterPersistenceAdapter implements CenterRepository {

    // Atributos que utiliza la clase
    private final CenterMongoRepository mongoRepository;
    private final CenterPersistenceMapper mapper;

    // Constructor de la clase (inyección de dependencias)
    public CenterPersistenceAdapter (CenterMongoRepository mongoRepository, CenterPersistenceMapper mapper) {
        this.mongoRepository = mongoRepository;
        this.mapper = mapper;
    }

    // Implementación de métodos de interfaz CenterRepository
    // Guardar centro
    @Override
    public Center save(Center center) {
        // Convertir dominio a entidad Mongo
        var entity = mapper.toEntity(center);
        // Guardar en la base de datos
        var savedEntity = mongoRepository.save(entity);
        // Devolver resultado de nuevo convertido a dominio
        return mapper.toDomain(savedEntity);
    }

    // Buscar centro por "id". Al retornar Optional hay que comprobar si ha retornado un valor con el ".map"
    @Override
    public Optional<Center> findById(String id) {
        return mongoRepository.findById(id).map(mapper::toDomain);
    }

    // Buscar todos los centros
    @Override
    public List<Center> findAll() {
        return mongoRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    // Eliminar centro
    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }




}
