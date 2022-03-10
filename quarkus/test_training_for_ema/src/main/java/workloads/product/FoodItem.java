package workloads.product;

import javax.persistence.Entity;

@Entity
public class FoodItem extends Product{
    private Boolean isVegetarian;

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }
}
