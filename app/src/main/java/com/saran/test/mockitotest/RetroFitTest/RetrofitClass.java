package com.saran.test.mockitotest.RetroFitTest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by core I5 on 12/29/2016.
 */

public class RetrofitClass {
    private Retrofit retrofit;
    private OkHttpClient client;
    private final String url = "http://ci.draftserver.com/hornsbyapp/webservice/";

    public Retrofit setRetrofitClient(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();


        this.client = okHttpBuilder.build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.client)
                .build();
        return this.retrofit;
    }
}
