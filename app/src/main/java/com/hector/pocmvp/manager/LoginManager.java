package com.hector.pocmvp.manager;

import com.hector.pocmvp.apiclient.LoginAPIClient;
import com.hector.pocmvp.apiclient.LoginResponseListener;
import com.hector.pocmvp.apiclient.Response;
import com.hector.pocmvp.model.User;

/**
 * Created by hetorres on 2/12/16.
 */
public class LoginManager {

    private LoginAPIClient loginAPIClient;
    private LoginResponseListener managerListener;

    public LoginManager(LoginResponseListener listener) {
        loginAPIClient = new LoginAPIClient();
        this.managerListener = listener;
    }

    public void login(final String email, final String password) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // do the call to the apiclient
                Response<User> response = loginAPIClient.loginUser(email, password);

                try {
                    Thread.sleep(4000); //simulating the time on the response.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //get the response and do more stuff before to notify the response.
                managerListener.onResponse(response);
            }
        }).start();
    }
}
