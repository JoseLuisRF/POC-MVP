/* (c) Disney. All rights reserved. */
package com.hector.pocmvp;

import com.hector.pocmvp.apiclient.Response;
import com.hector.pocmvp.model.User;
import com.hector.pocmvp.presenter.LoginPresenter;
import com.hector.pocmvp.presenter.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hetorres on 2/12/16.
 */
public class LoginPresenterTest {

    @Mock
    LoginView view;

    @Mock
    Response response;

    @Mock
    User user;

    private LoginPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(view);
    }

    @Test
    public void successResponse() {
        when(response.isSucces()).thenReturn(true);
        when(response.getData()).thenReturn(user);

        presenter.onResponse(response);

        verify(view).showLoader(false);
        verify(response).isSucces();
        verify(view).printLoggedUser((User) response.getData());
    }

    @Test
    public void failureResponse() {
        when(response.isSucces()).thenReturn(false);

        presenter.onResponse(response);

        verify(view).showLoader(false);
        verify(view).showMessage("Fail!");
    }
}
