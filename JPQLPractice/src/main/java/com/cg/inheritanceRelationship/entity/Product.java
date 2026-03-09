package com.cg.inheritanceRelationship.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="product_table")
@Data //to get getter and setter using lombok dependency without actually creating it
public class Product {
    @Id
    private int pid;
    private String name;
    private int qty;
    private int price;
    private LocalDate mfd;
}
