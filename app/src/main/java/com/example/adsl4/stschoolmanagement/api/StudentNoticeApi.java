package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by adsl4 on 5/15/18.
 */

public interface StudentNoticeApi {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("{OrganizationId}/{BranchId}")
    Call<List<StudentNoticeModal>> getNotices(@Path("OrganizationId") int OrganizationId, @Path("BranchId") int BranchId);

}
