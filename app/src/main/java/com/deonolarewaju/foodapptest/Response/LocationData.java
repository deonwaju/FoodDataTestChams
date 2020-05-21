package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationData {
    @SerializedName("coordinates")
    @Expose
    public List<Object> coordinates = null;


}
