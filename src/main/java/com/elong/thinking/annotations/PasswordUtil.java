package com.elong.thinking.annotations;

import java.util.List;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class PasswordUtil {
    @UseCase(id = 1, description = "validatePassword")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 2, description = "encryptPassword")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 3, description = "checkForNewPassword")
    public boolean checkForNewPassword(List<String> prevPassword, String password) {
        return !prevPassword.contains(password);
    }
}
