package com.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "名前の入力は必須です！")
    private String name;

    @NotEmpty(message = "メールの入力は必須です！")
    @Email(message = "メールの形式に入力してください！")
    private String email;

    @NotEmpty(message = "パスワードの入力は必須です！")
    @Length(min = 8, max = 16, message = "パスワードは８文字以上、16文字以下で入力してください！")
    private String password;

    @NotEmpty(message = "住所の入力は必須です！")
    private String address;
}
