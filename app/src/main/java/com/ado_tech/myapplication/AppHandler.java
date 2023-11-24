package com.ado_tech.myapplication;

import com.ado_tech.myapplication.model.CloseResponse;

public interface AppHandler {

    void onSuccess(CloseResponse response, int code, String uuidDevice);
    void onFailure(CloseResponse response);
}