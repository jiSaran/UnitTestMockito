package com.saran.test.mockitotest.RetroFitTest;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by core I5 on 12/29/2016.
 */

public class DataClass {
    private RetrofitClass retroClass = new RetrofitClass();

    public List<String> getProblems(){
        final List<String> problem_items = new ArrayList<>();

        Retrofit retrofit = this.retroClass.setRetrofitClient();

        APIService apiService = retrofit.create(APIService.class);

        Call<ProblemObject> call = apiService.getProblemDetails("1");

        call.enqueue(new Callback<ProblemObject>() {
            @Override
            public void onResponse(Call<ProblemObject> call, Response<ProblemObject> response) {
                if(response.isSuccessful()){
                    for(int i=0;i<response.body().problemTypes.size();i++){
                        problem_items.add(response.body().problemTypes.get(i).title);
                    }
                }
                else{
                    Log.e("Error","Unsuccessful response");
                }
            }

            @Override
            public void onFailure(Call<ProblemObject> call, Throwable t) {
                Log.e("Error","No response");
            }
        });

        return problem_items;
    }
}
