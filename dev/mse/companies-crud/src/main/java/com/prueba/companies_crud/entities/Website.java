package com.prueba.companies_crud.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Website implements Serializable { //se serializará cuando lo mandemos como json
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="category")
    @Enumerated(value= EnumType.STRING)
    private Category category;
    private String description;
}
