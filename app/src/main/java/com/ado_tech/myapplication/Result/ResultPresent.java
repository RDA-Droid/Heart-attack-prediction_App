package com.ado_tech.myapplication.Result;

import android.content.Context;
import android.os.Handler;

import com.ado_tech.myapplication.model.CloseResponse;
import com.ado_tech.myapplication.network.ApiHelper;
import com.ado_tech.myapplication.network.RetrofitClient;

public class ResultPresent implements ResultContract.Presenter {

    private ResultContract.View view;
    private Context context;

    ResultPresent(ResultContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void evaluateTransaction(String transactionId) {
        view.onWebServiceStart();
        new RetrofitClient().validateTransaction(transactionId,
                new ApiHelper.ValidateTransactionHandler() {
                    @Override
                    public void onSuccess(int statusCode, CloseResponse response) {
                        if (response.getother_info().equals("RESULTADO")) {
                            ResultPresent.delay(10, new DelayCallback() {
                                @Override
                                public void afterDelay() {
                                    evaluateTransaction(transactionId);
                                }
                            });
                        } else
                            view.continueFlow(true, statusCode, response);
                    }

                    @Override
                    public void onConnectionFailed() {
                        view.onNoConnection();
                    }

                    @Override
                    public void onFailure(int statusCode, String error) {
                        view.onWebServiceStop();
                        view.finishFlow(false, null, statusCode);
                    }
                }, context);
    }

    public interface DelayCallback {
        void afterDelay();
    }

    public static void delay(int secs, final DelayCallback delayCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, secs * 1000); // afterDelay will be executed after (secs*1000) milliseconds.
    }

}
