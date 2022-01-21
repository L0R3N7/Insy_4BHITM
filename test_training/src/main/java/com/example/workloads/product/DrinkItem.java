package com.example.workloads.product;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class DrinkItem extends Product{
    private Double volumn;
}
