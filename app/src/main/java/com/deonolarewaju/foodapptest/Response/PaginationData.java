package com.deonolarewaju.foodapptest.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PaginationData {

    @SerializedName("total_count")
    @Expose
    public Integer totalCount;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("current")
    @Expose
    public Integer current;
    @SerializedName("current_page")
    @Expose
    public String currentPage;


}
