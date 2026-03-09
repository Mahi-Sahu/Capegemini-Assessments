package com.cg.inheritanceRelationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private int price;
    private LocalDate date;
}
