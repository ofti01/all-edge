package com.lotfi.operation.repositories;

import com.lotfi.operation.entities.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperationRepository extends MongoRepository<Operation, String> {
}
