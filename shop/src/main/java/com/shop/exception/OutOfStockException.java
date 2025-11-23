package com.shop.exception;

//注文した商品の数より在庫ｎ数が少ない場合に実行されるexception
public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message){
        super(message);
    }
}
