package com.saran.test.mockitotest.RetroFitTest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by core I5 on 12/29/2016.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("get_problem_types")
    Call<ProblemObject> getProblemDetails(@Field("test") String test);
}
