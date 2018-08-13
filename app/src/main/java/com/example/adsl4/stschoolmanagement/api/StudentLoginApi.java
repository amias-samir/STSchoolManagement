package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.login.StudentDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by adsl4 on 5/3/18.
 */

public interface StudentLoginApi {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("Login/{Stsid}/{UserType}")
    Call<StudentDetail> getStudentId(@Path("Stsid") String Stsid, @Path("UserType") int UserType);

}

