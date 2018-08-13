package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.TeacherAssignmentModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UploadAssignmentApi {
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("Assignments")
    Call<List<TeacherAssignmentModal>> uploadAssignment(@Body TeacherAssignmentModal teacherAssignmentModal);
}
