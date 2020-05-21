package com.deonolarewaju.foodapptest.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.deonolarewaju.foodapptest.R;
import com.deonolarewaju.foodapptest.Requests.LoginRequest;
import com.deonolarewaju.foodapptest.Requests.RetrofitRequest;
import com.deonolarewaju.foodapptest.Response.LoginResponses;
import com.deonolarewaju.foodapptest.Service.ApiService;
import com.deonolarewaju.foodapptest.Utils.APIError;
import com.deonolarewaju.foodapptest.Utils.AppUtil;
import com.deonolarewaju.foodapptest.Utils.ErrorUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = "funmiayinde11@gmail.com";
                String passWord = "password";

                LoginRequest request = new LoginRequest(email, passWord);

                loginUser(request);

            }
        });


    }


    private void loginUser(LoginRequest loginRequest) {

        ApiService apiService = RetrofitRequest.createService(ApiService.class, MainActivity.this);
        Call<LoginResponses> call = apiService.loginFood(loginRequest);
        call.enqueue(new Callback<LoginResponses>() {
            @Override
            public void onResponse(Call<LoginResponses> call, Response<LoginResponses> response) {
                if (response.code() == 200 & response.body() != null) {
                    String token = response.body().getMeta().getToken();
                    AppUtil.updateToken(token, MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                    startActivity(intent);
                } else if (response.errorBody() != null) {
                    logErrorMessage(response);
                }

            }

            @Override
            public void onFailure(Call<LoginResponses> call, Throwable t) {
                Log.e("login error: ", t.toString());
            }
        });
    }

    public void logErrorMessage(Response response) {
        APIError error = ErrorUtils.parseError(response, getApplicationContext());
        Toast.makeText(this, "error " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
