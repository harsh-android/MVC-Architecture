package com.example.a3idiots.Controller;

import com.example.a3idiots.Model.User;
import com.example.a3idiots.View.ILoginVIew;

public class LoginController implements ILoginController{

    ILoginVIew loginVIew;

    public LoginController(ILoginVIew loginVIew) {
        this.loginVIew = loginVIew;
    }

    @Override
    public void OnLogin(String email, String password) {

        User user = new User(email, password);
        int logincode = user.isValid();

        if (logincode == 0) {
            loginVIew.onLognFailed("Please Enter Email");
        } else if (logincode == 1) {
            loginVIew.onLognFailed("Enter Valid Email");
        } else if (logincode == 2) {
            loginVIew.onLognFailed("Please Enter Password");
        } else if (logincode == 3) {
            loginVIew.onLognFailed("Please Enter Password Min 6 Character");
        } else if (logincode == -1) {
            loginVIew.onLoginSuccess("Login Success");
        }

    }
}
