package com.lotfi.compte.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", length = 4)
public abstract class Compte implements Serializable {

     @Id
     @GeneratedValue(generator = "rib-generator",
     strategy = GenerationType.IDENTITY)
     @GenericGenerator(name = "rib-generator", strategy = "com.lotfi.compte.utils.BaseIdentifierGenerator")
     private String rib;

     @Column(name = "balance")
     private double balance;

     @CreatedDate
     @Column(name = "created_date", nullable = false)
     private Instant createdDate = Instant.now();

     @LastModifiedDate
     @Column(name = "last_modified_date")
     private Instant lastModifiedDate = Instant.now();

     private String cinClient;
}
