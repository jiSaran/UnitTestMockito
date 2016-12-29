package com.saran.test.mockitotest.RetroFitTest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by core I5 on 12/29/2016.
 */
public class ProblemObject {
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("problem_types")
    @Expose
    public List<ProblemType> problemTypes = null;
}
