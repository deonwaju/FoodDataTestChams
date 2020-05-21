package com.deonolarewaju.foodapptest.Response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodDetailsResponse {
    @SerializedName("_meta")
    @Expose
    public MetaData metaData;
    @SerializedName("data")
    @Expose
    public List<FoodDetailsResponseData> data = null;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public List<FoodDetailsResponseData> getData() {
        return data;
    }

    public void setData(List<FoodDetailsResponseData> data) {
        this.data = data;
    }
}
