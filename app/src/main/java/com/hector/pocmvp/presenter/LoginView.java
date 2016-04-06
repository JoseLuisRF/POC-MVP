package com.hector.pocmvp.presenter;

import com.hector.pocmvp.model.User;

/**
 * Created by hetorres on 2/12/16.
 */
public interface LoginView {

    void showMessage(String message);

    void showLoader(boolean show);

    void printLoggedUser(User user);

}
