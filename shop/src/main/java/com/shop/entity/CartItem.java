package com.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    //一つのカートには多数の商品を入れられるのでManyToOneを使う
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //カートに入れる商品の情報が必要なので、商品Entityをマッピングする
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //同じ商品を何個入れるかを数えるためのcount
    private int count;

    //カートに入れる商品
    public static CartItem createCartItem(Cart cart, Item item, int count) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(count);
        return cartItem;
    }

    //カートに同じ商品を追加で入れる場合
    public void addCount(int count){
        this.count += count;
    }

    //カートに入れた商品の数を変更するメソッド
    public void updateCount(int count){
        this.count = count;
    }
}

