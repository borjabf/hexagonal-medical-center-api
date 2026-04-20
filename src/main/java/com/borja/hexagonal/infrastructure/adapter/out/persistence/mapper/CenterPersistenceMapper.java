package com.borja.hexagonal.infrastructure.adapter.out.persistence.mapper;

import com.borja.hexagonal.domain.model.Center;
import com.borja.hexagonal.infrastructure.adapter.out.persistence.entity.CenterEntity;
import org.springframework.stereotype.Component;

@Component // Para usar esta clase como un componente para el resto del proyecto
public class CenterPersistenceMapper {

    // Metodo para traducir el dominio a la entidad de persistencia
    public CenterEntity toEntity (Center domainModel) {
        // Comprobar que no se llame sin parametro
        if (domainModel == null) return null;
        // Si se llama con parametro se instacia un nuevo objeto CenterEntity
        return new CenterEntity(
                domainModel.getId(),
                domainModel.getName(),
                domainModel.getAddress(),
                domainModel.getServices()
        );
    }

        // Metodo para traducir de entidad de persistencia a dominio
        public Center toDomain (CenterEntity entity) {
            // Comprobar que no se llame sin parametro
            if (entity == null) return null;
            // Si se llama con parametro se instacia un nuevo objeto Center
            return new Center(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getServices()
            );
        }


}
