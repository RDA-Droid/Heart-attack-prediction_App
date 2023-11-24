package com.ado_tech.myapplication.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public class CloseResponse extends ResponseBody {

    public CloseResponse() {
    }

    @SerializedName("other_info")
    @Expose
    private String other_info;

    @SerializedName("probability")
    @Expose
    private String probability;

    @SerializedName("transaction_id")
    @Expose
    private String transaction_id;


    public String getother_info() {
        return other_info;
    }

    public void setprobability(String probability) {
        this.probability = probability;
    }

    public String gettransaction_id() {
        return transaction_id;
    }

    @Override
    public long contentLength() {
        return 0;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return null;
    }

    @NonNull
    @Override
    public BufferedSource source() {
        return null;
    }
}
