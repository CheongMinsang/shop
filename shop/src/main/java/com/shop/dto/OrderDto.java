
package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Getter @Setter
public class OrderDto {

    @NotNull(message = "商品のIDは必須項目です")
    private Long itemId;

    @Min(value = 1, message = "最低注文数量は1個です。")
    @Max(value = 999, message = "最大注文数量は999個です。")
    private int count;

}
