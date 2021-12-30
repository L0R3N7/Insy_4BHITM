package at.htl.workloads.order;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long itemNo;
    @ManyToOne
    private Orderr orderr;
    private long Pcode;


    public OrderItemId() {
    }

    public long getPcode() {
        return Pcode;
    }

    public void setPcode(long pcode) {
        Pcode = pcode;
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
