package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorData {
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("vendor_name")
    @Expose
    public String vendorName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
