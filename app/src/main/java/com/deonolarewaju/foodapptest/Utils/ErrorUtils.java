package com.deonolarewaju.foodapptest.Utils;

import android.content.Context;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {
    public static APIError parseError(Response<?> response, Context context) {
        Converter<ResponseBody, APIError> converter = HttpHelper.getInstance(context).getRetrofit()
                .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());

        } catch (Exception ex) {
            return new APIError(response.errorBody().toString());
        }

        return error;

    }
}
