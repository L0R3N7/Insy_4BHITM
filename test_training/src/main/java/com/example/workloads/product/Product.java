package com.example.workloads.product;

import com.example.workloads.VendingMachine.VendingMachine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Data
public abstract class Product {
    @Id
    private Long productCode;
    private String name;
    private BigDecimal price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    VendingMachine vendingMachine;
}
