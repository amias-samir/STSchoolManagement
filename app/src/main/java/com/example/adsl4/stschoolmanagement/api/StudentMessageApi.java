package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.StudentMessageModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by adsl4 on 5/19/18.
 */

public interface StudentMessageApi {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("{UserId}/{OrganizationId}/{BranchId}")
    Call<List<StudentMessageModal>> getMessage(@Path("UserId") String UserId, @Path("OrganizationId") int OrganizationId, @Path("BranchId") int BranchId);
}
