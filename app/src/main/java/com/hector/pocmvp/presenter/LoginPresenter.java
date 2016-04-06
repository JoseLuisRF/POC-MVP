package com.hector.pocmvp.presenter;

import com.hector.pocmvp.apiclient.LoginResponseListener;
import com.hector.pocmvp.apiclient.Response;
import com.hector.pocmvp.manager.LoginManager;
import com.hector.pocmvp.model.User;

/**
 * Created by hetorres on 2/12/16.
 */
public class LoginPresenter implements LoginResponseListener {

    private LoginView loginView;
    private LoginManager loginManager;

    public LoginPresenter(LoginView loginView) {
        this.loginManager = new LoginManager(this);
        this.loginView = loginView;
    }

    public void signin(String email, String password) {
        loginView.showLoader(true);
        loginManager.login(email, password);
    }

    @Override
    public void onResponse(Response response) {
        loginView.showLoader(false);
        if (response.isSucces()) {
            loginView.printLoggedUser((User) response.getData());
        } else {
            loginView.showMessage("Fail!");
        }
    }
}
