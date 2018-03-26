package com.amco.clarovideo.delegate;

import android.app.Application;

import com.amco.clarovideo.helpers.RestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nekak on 24/03/18.
 */
public class AppDelegate extends Application {
    private RestApi restApi;

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson=gsonBuilder.create();

        final OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mfwkweb-api.clarovideo.net/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        restApi = retrofit.create(RestApi.class);
    }

    /**
     * Provide pet rest api instance.
     *
     * @return petRestApi rest api
     */
    public RestApi getRestApi() {
        return restApi;
    }
}
