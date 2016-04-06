package com.hector.pocmvp.apiclient;

import com.hector.pocmvp.model.User;

/**
 * Created by hetorres on 2/12/16.
 */
public class LoginAPIClient {

    public LoginAPIClient() {
    }

    public Response<User> loginUser(final String email, final String password) {
        final Response<User> response = new Response<>();

        if (email.equals("hector") && password.equals("123")) {
            response.setData(new User("Hector", "Torres", 29));
        }

        return response;
    }
}
