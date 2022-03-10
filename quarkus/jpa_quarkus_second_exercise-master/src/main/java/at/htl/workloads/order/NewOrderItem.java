package at.htl.workloads.order;

import java.math.BigDecimal;

public record NewOrderItem(int pCode, BigDecimal pPrice, int amount) {
}
