package com.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    //一つのカートには多数の商品を入れられるのでManyToOneを使う
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //カートに入れる商品の情報が必要なので、商品Entityをマッピングする
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    //同じ商品を何個入れるかを数えるためのcount
    private int count;
}

