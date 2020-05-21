package com.deonolarewaju.foodapptest.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deonolarewaju.foodapptest.Adapter.FoodDataAdapter;
import com.deonolarewaju.foodapptest.R;
import com.deonolarewaju.foodapptest.Requests.RetrofitRequest;
import com.deonolarewaju.foodapptest.Response.FoodDetailsResponse;
import com.deonolarewaju.foodapptest.Response.FoodDetailsResponseData;
import com.deonolarewaju.foodapptest.Service.ApiService;
import com.deonolarewaju.foodapptest.Utils.APIError;
import com.deonolarewaju.foodapptest.Utils.ErrorUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Map<String, String> query = new HashMap<>();
    private FoodDataAdapter adapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details_activity);

        dialog = new ProgressDialog(this);
        dialog.setMessage("loading....");
        dialog.show();

        query.put("populate", "[\"sub_category\", \"images\"]");
        query.put("account", "5eaac49ba88a101268c6a31a");

        loadFood(query);

    }

    public void loadFood(Map<String, String> query) {

        ApiService apiService = RetrofitRequest.createService(ApiService.class, FoodActivity.this);

        Call<FoodDetailsResponse> call = apiService.fetchFood(query);
        call.enqueue(new Callback<FoodDetailsResponse>() {
            @Override
            public void onResponse(Call<FoodDetailsResponse> call, Response<FoodDetailsResponse> response) {
                dialog.dismiss();
                if (response.code() == 200 & response.body() != null) {
                    generatedList(response.body().getData());
                } else if (response.errorBody() != null) {
                    logErrorMessage(response);
                }
            }

            @Override
            public void onFailure(Call<FoodDetailsResponse> call, Throwable t) {
                dialog.dismiss();

                Toast.makeText(FoodActivity.this, "Error, please try again", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void generatedList(List<FoodDetailsResponseData> foodList) {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new FoodDataAdapter(foodList, FoodActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FoodActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void logErrorMessage(Response response) {
        APIError error = ErrorUtils.parseError(response, getApplicationContext());
        Toast.makeText(this, "error " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
