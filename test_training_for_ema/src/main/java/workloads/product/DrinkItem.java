package workloads.product;

import javax.persistence.Entity;

@Entity
public class DrinkItem extends Product {
    private Double volume;

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}
