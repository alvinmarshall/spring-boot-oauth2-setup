package com.cheise_proj.orderservice.domain.model;

import com.cheise_proj.orderservice.common.OrderStatus;
import lombok.*;

import javax.persistence.*;

@Table(name = "tbl_order")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order extends BaseModel {
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
