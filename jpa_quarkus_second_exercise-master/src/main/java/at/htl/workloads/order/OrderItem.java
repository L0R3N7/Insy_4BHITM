package at.htl.workloads.order;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    private BigDecimal PPrice;
    private Integer Amount;

    public OrderItem() {
    }

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public BigDecimal getPPrice() {
        return PPrice;
    }

    public void setPPrice(BigDecimal PPrice) {
        this.PPrice = PPrice;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public static OrderItem create(Orderr orderr, int pCode, BigDecimal pPrice, int amount){
        OrderItem orderItem = new OrderItem();

        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setOrderr(orderr);
        orderItemId.setPcode(pCode);

        orderItem.setId(orderItemId);
        orderItem.setAmount(amount);
        orderItem.setPPrice(pPrice);

        return orderItem;
    }
}
