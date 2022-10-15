package com.lotfi.operation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "operation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Operation {
    private String id;
    private String typeOperation;
    private double montant;
    private String cin;
    private String rib;
}
