package at.htl.models;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Integer pCode;
    private BigDecimal pPrice;
    private Integer amount;

    public OrderItemDTO() {
    }

    public Integer getpCode() {
        return pCode;
    }

    public void setpCode(Integer pCode) {
        this.pCode = pCode;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
