package com.saran.test.mockitotest.RetroFitTest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by core I5 on 12/29/2016.
 */
public class ProblemType {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("is_deleted")
    @Expose
    public String isDeleted;
}
