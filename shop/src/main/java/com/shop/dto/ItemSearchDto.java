package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemSearchDto {

    //現在の時刻と比べて商品のデータを検索
    private String searchDateType;
    //商品の販売状態を基準に商品のデータを検索
    private ItemSellStatus searchSellStatus;
    //どのようなタイプで検索するかを選択
    //itemNm:商品名、createdBy:商品登録者のID
    private String searchBy;
    //検索した文字列をセーブする変数
    private String searchQuery = "";

}