package com.example.adsl4.stschoolmanagement.network;



import com.example.adsl4.stschoolmanagement.assignedteacherassignment.AssignedAssignmentDetail;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.modals.GetSubjectsAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.TeacherAssignmentModal;
import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;
import com.example.adsl4.stschoolmanagement.teacherattendance.TeacherAttendanceResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Samir on 7/6/2018.
 */

public interface NetworkApiInterface {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/StudentDetails/AllNotices/{OrganizationId}/{BranchId}")
    Observable<List<StudentNoticeModal>> getNotices(@Path("OrganizationId") int OrganizationId, @Path("BranchId") int BranchId);

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/StudentDetails/Login/{Stsid}/{UserType}")
    Observable<StudentDetail> getStudentDetails(@Path("Stsid") String Stsid, @Path("UserType") int UserType);

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/StudentDetails/Login/{Stsid}/{UserType}")
    Observable<TeacherDetailsResponse> getTeacherDetails(@Path("Stsid") String Stsid, @Path("UserType") int UserType);


    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/Attendances/GetAttendanceData/{UserId}/{OrganizationId}/{BranchId}/{BatchId}/{ClassId}/{SectionId}")
    Observable<TeacherAttendanceResponse> getAttendancesDataTeacher(@Path("UserId") String userId, @Path("OrganizationId") int orgId, @Path("BranchId") int branchId,
                                                                    @Path("BatchId") int batchId, @Path("ClassId") int classId, @Path("SectionId") int sectionId );

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("api/Attendances")
    Observable<TeacherAttendanceResponse> uploadAttendance(@Body TeacherAttendanceResponse teacherAttendanceResponse);


    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/Assignments/GetAllAssignment/{OrganizationId}/{BranchId}/{EmployeeDetailId}")
    Observable<List<AssignedAssignmentDetail>> getAssignedAssignmentDetails(@Path("OrganizationId") int OrgId,
                                                          @Path("BranchId") int BrnId,
                                                          @Path("EmployeeDetailId") int employeId);

}

