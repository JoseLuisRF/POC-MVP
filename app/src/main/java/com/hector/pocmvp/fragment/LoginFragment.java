package com.hector.pocmvp.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hector.pocmvp.R;
import com.hector.pocmvp.model.User;
import com.hector.pocmvp.presenter.LoginPresenter;
import com.hector.pocmvp.presenter.LoginView;

/**
 * Created by hetorres on 2/12/16.
 */
public class LoginFragment extends Fragment implements LoginView {

    private View loginView;
    private LoginPresenter loginPresenter;
    private ProgressBar loader;
    private TextView results;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.layout_login, container, false);

        final EditText email = (EditText) loginView.findViewById(R.id.email);
        final EditText password = (EditText) loginView.findViewById(R.id.password);
        Button signIn = (Button) loginView.findViewById(R.id.btn_sign_in);
        loader = (ProgressBar) loginView.findViewById(R.id.login_progress);
        results = (TextView) loginView.findViewById(R.id.results);

        //instantiating Presenter
        loginPresenter = new LoginPresenter(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setVisibility(View.INVISIBLE);
                loginPresenter.signin(email.getText().toString(), password.getText().toString());
            }
        });

        return loginView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    //===========================================================================================================
    //===============================================   Presenter actions    ====================================
    //===========================================================================================================

    @Override
    public void showMessage(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                results.setVisibility(View.VISIBLE);
                results.setText(message);
            }
        });
    }

    @Override
    public void showLoader(final boolean show) {
        loader.post(new Runnable() {
            @Override
            public void run() {
                loader.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    public void printLoggedUser(final User user) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                builder.append(user.getFirstName())
                       .append(", ")
                       .append(user.getLastName());

                Snackbar.make(loginView, String.format(getString(R.string.result_success), builder.toString()), Snackbar.LENGTH_LONG).show();
                results.setVisibility(View.VISIBLE);
                results.setText(builder.toString());
            }
        });
    }
}
