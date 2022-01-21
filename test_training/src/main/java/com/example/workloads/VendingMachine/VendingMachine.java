package com.example.workloads.VendingMachine;

import com.example.workloads.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MashineType type;
    @OneToMany(
            mappedBy = "vendingMachine",
            cascade = CascadeType.ALL
    )
    private List<Product> products = new ArrayList<>();
}
