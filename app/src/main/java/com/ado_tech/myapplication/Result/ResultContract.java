package com.ado_tech.myapplication.Result;

import com.ado_tech.myapplication.model.CloseResponse;

public interface ResultContract {

    interface Presenter {
        void evaluateTransaction(String image);
    }

    interface View
    {
        void onNoConnection();
        void onWebServiceStart();
        void onWebServiceStop();
        void finishFlow(boolean result, CloseResponse response, int statusCode);
        void continueFlow(boolean result, int statusCode, CloseResponse response);
    }
}

