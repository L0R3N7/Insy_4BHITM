package at.htl.workloads.order;

import java.math.BigDecimal;

public record RevenueRecord (long personId, String name, BigDecimal revenue){}
