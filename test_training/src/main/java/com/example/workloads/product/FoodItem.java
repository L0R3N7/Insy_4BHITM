package com.example.workloads.product;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
public class FoodItem extends Product{
    private Boolean isVegan;
}
