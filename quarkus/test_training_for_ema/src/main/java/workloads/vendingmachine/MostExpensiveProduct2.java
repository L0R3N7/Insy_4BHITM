package workloads.vendingmachine;

import java.math.BigDecimal;

public record MostExpensiveProduct2(Long MachineId,
                                    BigDecimal Price,
                                    Long ProductCode) {}
