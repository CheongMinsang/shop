package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetailDto {

    //カート商品ID
    private Long cartItemId;

    //商品名
    private String itemNm;

    //商品価額
    private int price;

    //数
    private int count;

    //商品イメージ経路
    private String imgUrl;

    //カートページに渡すデータをパラメータに
    public CartDetailDto(Long cartItemId, String itemNm, int price, int count, String imgUrl){
        this.cartItemId = cartItemId;
        this.itemNm = itemNm;
        this.price = price;
        this.count = count;
        this.imgUrl = imgUrl;
    }

}