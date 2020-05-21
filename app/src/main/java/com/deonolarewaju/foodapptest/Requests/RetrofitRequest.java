package com.deonolarewaju.foodapptest.Requests;

import android.content.Context;

import com.deonolarewaju.foodapptest.Utils.AppUtil;
import com.deonolarewaju.foodapptest.Utils.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    private static final String BASE_URL = "https://api.findfood.ng/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());


    private static OkHttpClient.Builder attachProperties(OkHttpClient.Builder httpClient) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpClient
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
    }

    private static OkHttpClient.Builder attachJWTValidation(final Context context) {
        return httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("x-api-key", "findfood_web");


            if (AppUtil.hasToken(context)) {
                LogUtils.write("token" + AppUtil.getToken(context));
                requestBuilder = requestBuilder.header("x-access-token", AppUtil.getToken(context));
            }
            requestBuilder = requestBuilder.method(original.method(), original.body());
            Request request = requestBuilder.build();
            Response response = chain.proceed(request);
            LogUtils.write("CODE : " + response.code());
            LogUtils.write("URL : " + request.url());
            if (request.body() != null) {
                LogUtils.write("BODY : " + request.body().toString());
            }
//            if (AppUtil.hasToken(context) &&
//                    AppUtil.getObject(AuthUser.class, context) != null
//                    && response.code() == 401) {
//                AppUtil.logOut(context, AuthActivity.class);
//            }
            return response;
        });
    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, final Context context) {
        httpClient = attachJWTValidation(context);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = httpClient
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();
        Retrofit retrofit = getRetrofit(client);
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceObservable(Class<S> serviceClass) {
        return createServiceObservable(serviceClass, null);
    }

    public static <S> S createServiceObservable(Class<S> serviceClass, final Context context) {
        httpClient = attachJWTValidation(context);
        OkHttpClient client = attachProperties(httpClient).build();
        Retrofit retrofit = getRetrofit(client);
        return retrofit.create(serviceClass);
    }

    public static Retrofit getRetrofit(OkHttpClient client) {
        if (retrofit == null) {
            retrofit = builder.client(client).build();
        }
        return retrofit;
    }

}
