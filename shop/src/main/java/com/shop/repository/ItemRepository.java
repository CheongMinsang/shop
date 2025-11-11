package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    //　商品名で探す
    List<Item> findByItemNm(String itemNm);
    //　商品名or詳細説明で探す
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    // パラメータより少ない値段を検索
    List<Item> findByPriceLessThan(Integer price);
    // 値段の降順で表示する
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // JPQL
    // 商品に詳細説明を含むデータを検索し、降順に表示
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // @Query-nativeQuery
    @Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
