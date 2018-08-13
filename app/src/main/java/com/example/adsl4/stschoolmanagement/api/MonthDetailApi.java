package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.MonthDetailModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by adsl4 on 5/15/18.
 */

public interface MonthDetailApi {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("GetMonth")
    Call<List<MonthDetailModal>> getMonths();

}
