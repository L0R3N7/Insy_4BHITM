package at.htl.models;

import java.util.List;

public class OrderDTO {
    private Long personId;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
