package at.htl.workloads.order;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {
    private long itemNo;
    @ManyToOne
    @JsonbTransient
    private Orderr orderr;

    public OrderItemId() {
    }

    public Orderr getOrderr() {
        return orderr;
    }

    public void setOrderr(Orderr orderr) {
        this.orderr = orderr;
    }

    public long getItemNo() {
        return itemNo;
    }

    public void setItemNo(long itemNo) {
        this.itemNo = itemNo;
    }
}
