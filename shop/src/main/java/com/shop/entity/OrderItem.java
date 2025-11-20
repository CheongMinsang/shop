package com.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    //一つの商品はいろんな注文商品で入れることが可能なのでManyToOneを使います。
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    //一回の注文で何個の注文もできるので、ManyToOneを使う。
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //注文総額
    private int orderPrice;

    //注文数
    private int count;

    //private LocalDateTime regTime;

    //private LocalDateTime updateTime;

}
