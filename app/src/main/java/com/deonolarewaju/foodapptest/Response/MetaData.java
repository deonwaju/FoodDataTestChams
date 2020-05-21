package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class MetaData {

    @SerializedName("status_code")
    @Expose
    public Integer statusCode;
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("paginationData")
    @Expose
    public PaginationData paginationData;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public PaginationData getPaginationData() {
        return paginationData;
    }

    public void setPaginationData(PaginationData paginationData) {
        this.paginationData = paginationData;
    }
}
