package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {

    //Entityが生成されてセーブされる場合の日時を自動で保存する
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;

    //Entityの値を変更する場合の日時を自動で保存する。
    @LastModifiedDate
    private LocalDateTime updateTime;
}
