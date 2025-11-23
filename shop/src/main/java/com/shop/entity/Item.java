package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import com.shop.exception.OutOfStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //商品コード

    @Column(nullable = false, length = 50)
    private String itemNm; //商品名

    @Column(name = "price", nullable = false)
    private int price; //値段

    @Column(nullable = false)
    private int stockNumber; //在庫数

    @Lob
    @Column(nullable = false)
    private String itemDetail; //商品詳細説明c

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //商品販売状態

    //private LocalDateTime regTime; //登録時刻
    //private LocalDateTime updateTime; //修正時刻

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    //商品を注文すると在庫か減少するメソッド
    public void removeStock(int stockNumber){
        int restStock = this.stockNumber - stockNumber;
        //在庫が場合
        if(restStock<0){
            throw new OutOfStockException("商品の在庫が不足しています。 (現在庫数: " + this.stockNumber + ")");
        }
        this.stockNumber = restStock;
    }

    //商品の在庫を増加させるメソッド(注文取り消し用)
    public void addStock(int stockNumber){
        this.stockNumber += stockNumber;
    }

}
