package com.borja.hexagonal.infrastructure.adapter.out.persistence.repository;

import com.borja.hexagonal.infrastructure.adapter.out.persistence.entity.CenterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterMongoRepository extends MongoRepository<CenterEntity, String> {
}
