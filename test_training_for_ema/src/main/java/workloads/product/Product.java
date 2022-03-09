package workloads.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import workloads.vendingmachine.VendingMachine;

import javax.persistence.*;
import java.math.BigDecimal;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING)
@Entity
public abstract class Product {
    @Id
    private Long productCode;
    private String name;
    private BigDecimal price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private VendingMachine vendingMachine;

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
