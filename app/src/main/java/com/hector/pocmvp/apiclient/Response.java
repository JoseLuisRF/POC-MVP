package com.hector.pocmvp.apiclient;

/**
 * Created by hetorres on 2/16/16.
 */
public class Response<T> {
    private T data;
    private Throwable error;
    private boolean succes;

    public void setData(T data) {
        this.data = data;
        succes = true;
    }

    public void setError(Throwable error) {
        this.error = error;
        succes = false;
    }

    public boolean isSucces() {
        return succes;
    }

    public T getData() {
        return data;
    }

    public Throwable getError() {
        return error;
    }
}
