package at.htl.workloads.order;

import at.htl.models.OrderItemDTO;
import at.htl.workloads.person.Person;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.criterion.Order;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orderr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "DATAREG_OrderNumber")
    private Long orderNo;
    private LocalDate orderDate;
    @ManyToOne
    @JsonbTransient
    private Person person;
    @OneToMany(mappedBy = "id.orderr", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Orderr() {
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItemList.add(orderItem);
    }

    public static Orderr createOrderr(Person p, List<NewOrderItem> items){
        Orderr orderr = new Orderr();

        long itemNo = 1;
        for (NewOrderItem newOrderItem : items){
            orderr.addOrderItem(OrderItem.create(orderr, newOrderItem.pCode(), newOrderItem.pPrice(), newOrderItem.amount(), itemNo));
            itemNo++;
        }
        p.addOrderrs(orderr);

        orderr.setOrderDate(LocalDate.now());
        orderr.setPerson(p);

        return orderr;
    }
}
