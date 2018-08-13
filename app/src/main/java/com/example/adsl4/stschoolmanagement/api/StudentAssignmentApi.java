package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.StudentAssignmentModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by adsl4 on 5/19/18.
 */

public interface StudentAssignmentApi {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("{OrganizationId}/{BranchId}/{BatchId}/{ClassId}")
    Call<List<StudentAssignmentModal>> getAssignments(@Path("OrganizationId") int OrganizationId, @Path("BranchId") int BranchId, @Path("BatchId") int BatchId, @Path("ClassId") int ClassId);
}
