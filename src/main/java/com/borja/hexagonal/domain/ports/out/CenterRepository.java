package com.borja.hexagonal.domain.ports.out;

import com.borja.hexagonal.domain.model.Center;
import java.util.List;
import java.util.Optional;

// Interfaz de puerto de salida para tareas con base de datos
public interface CenterRepository {

    // Guarda un centro y devuelve el centro guardado
    Center save(Center center);

    // Busca un centro por su ID. Optional para evitar error si no existe centro
    Optional<Center> findById(String id);

    // Devuelve listado de todo los centros
    List<Center> findAll();

    // Borrar un centro por su ID
    void deleteById(String id);
}
