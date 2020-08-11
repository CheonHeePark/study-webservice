package com.chpark.shop.member.domain;

import com.chpark.shop.member.exception.PasswordNotMatchException;

public class Member {
    private String password;

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.equals(currentPassword)) throw new PasswordNotMatchException();
        // TODO 패스워드의 유효성 검사 (길이제한, 특수문자포함여부 등등)
        password = newPassword;
    }
}
