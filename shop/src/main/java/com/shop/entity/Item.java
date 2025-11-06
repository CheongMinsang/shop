package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Item {

    private Long id; //商品コード
    private String itemNm; //商品名
    private int price; //値段
    private int stockNumber; //在庫数
    private String itemDetail; //商品詳細説明
    private ItemSellStatus itemSellStatus; //商品販売状態
    private LocalDateTime regTime; //登録時刻
    private LocalDateTime updateTime; //修正時刻
}
