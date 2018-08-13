package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.GetClassAsignmentModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetClassAsignmentApi {
    @GET("{OrgId}/{BrnId}/{BatchId}")
    Call<List<GetClassAsignmentModal>> getClassDetail(@Path("OrgId") int OrgId,
                                                      @Path("BrnId") int BrnId,
                                                      @Path("BatchId") int BatchId);
}
