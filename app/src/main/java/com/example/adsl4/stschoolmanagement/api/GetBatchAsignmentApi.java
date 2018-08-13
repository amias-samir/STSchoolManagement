package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.GetBatchAsignmentModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetBatchAsignmentApi {
    @GET("{OrgId}/{BrnId}")
    Call<List<GetBatchAsignmentModal>> getBatchDetail(@Path("OrgId") int OrgId, @Path("BrnId") int BrnId);
}
