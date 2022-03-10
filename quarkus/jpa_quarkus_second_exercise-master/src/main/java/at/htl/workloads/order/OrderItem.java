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
    private long Pcode;



    public OrderItem() {
    }


    public long getPcode() {
        return Pcode;
    }

    public void setPcode(long pcode) {
        Pcode = pcode;
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

    public static OrderItem create(Orderr orderr, long pCode, BigDecimal pPrice, int amount, long itemNo){
        OrderItem orderItem = new OrderItem();

        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setOrderr(orderr);
        orderItemId.setItemNo(itemNo);

        orderItem.setId(orderItemId);
        orderItem.setAmount(amount);
        orderItem.setPPrice(pPrice);

        return orderItem;
    }
}
