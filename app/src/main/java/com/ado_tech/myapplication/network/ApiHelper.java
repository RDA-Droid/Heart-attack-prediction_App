package com.ado_tech.myapplication.network;

import android.content.Context;

import com.ado_tech.myapplication.model.CloseResponse;
import com.ado_tech.myapplication.model.Newtransaccion;

public interface ApiHelper {

    interface CompletionHandler {
        void onConnectionFailed();
        void onFailure(int statusCode, String error);
    }

    interface ValidateTransactionHandler extends ApiHelper.CompletionHandler {
        void onSuccess(int var1, CloseResponse var2);
    }

    interface NewtransaccionTransactionHandler extends CompletionHandler {
        void onSuccess(int statusCode, CloseResponse response);

    }

    interface NewtransaccionHandler extends CompletionHandler {
        void onSuccess(int statusCode, CloseResponse response);
    }

    void Newtransaccion(Newtransaccion request, NewtransaccionHandler handler, Context mContext);

    void validateTransaction(String txId, ValidateTransactionHandler handler, Context mContext);

}
