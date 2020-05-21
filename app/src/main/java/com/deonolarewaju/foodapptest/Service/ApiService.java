package com.deonolarewaju.foodapptest.Service;

import com.deonolarewaju.foodapptest.Requests.LoginRequest;
import com.deonolarewaju.foodapptest.Response.FoodDetailsResponse;
import com.deonolarewaju.foodapptest.Response.LoginResponses;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {

    @POST("api/v1/login")
    Call<LoginResponses> loginFood(@Body LoginRequest loginRequest);

    @GET("api/v1/product/items")
    Call<FoodDetailsResponse> fetchFood(@QueryMap Map<String, String> query);

}
