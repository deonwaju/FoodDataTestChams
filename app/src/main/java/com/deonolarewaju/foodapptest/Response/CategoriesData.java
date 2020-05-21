package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CategoriesData {

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
