package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponses {
    @SerializedName("_meta")
    @Expose
    public LoginMeta meta;
    @SerializedName("data")
    @Expose
    public LoginData data;


    public LoginMeta getMeta() {
        return meta;
    }

    public void setMeta(LoginMeta meta) {
        this.meta = meta;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }
}
