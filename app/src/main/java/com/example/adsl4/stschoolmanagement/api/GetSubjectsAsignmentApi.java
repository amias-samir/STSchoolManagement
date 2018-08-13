package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.GetSubjectsAsignmentModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetSubjectsAsignmentApi {
    @GET("{OrgId}/{BrnId}/{BatchId}/{ClassId}")
    Call<List<GetSubjectsAsignmentModal>> getSubjectDetail(@Path("OrgId") int OrgId,
                                                         @Path("BrnId") int BrnId,
                                                         @Path("BatchId") int BatchId,
                                                         @Path("ClassId") int ClassId);
}
