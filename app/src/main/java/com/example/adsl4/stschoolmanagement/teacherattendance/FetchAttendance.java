package com.example.adsl4.stschoolmanagement.teacherattendance;

import android.content.Context;
import android.util.Log;

import com.example.adsl4.stschoolmanagement.network.NetworkApiClient;
import com.example.adsl4.stschoolmanagement.network.NetworkApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FetchAttendance {
    private String TAG = "FetchAttendance";
    private AttendanceFetchCompleteListener listener;

    TeacherAttendanceResponse teacherAttendanceResponses = new TeacherAttendanceResponse();
    public void fetchAttendanceFromServer(Context context, String userId, int organizationId, int branchId, int batchId,
                                          int classId, int sectionId,  final AttendanceFetchCompleteListener listener){
        this.listener = listener;


        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);
        Log.d(TAG, "FetchAttendance: method  ");

        apiService.getAttendancesDataTeacher(userId, organizationId, branchId, batchId, classId, sectionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<TeacherAttendanceResponse>(){

                    @Override
                    public void onNext(TeacherAttendanceResponse teacherAttendanceResponse) {
                        teacherAttendanceResponses = teacherAttendanceResponse;
                        Log.d(TAG, "onNext: "+teacherAttendanceResponses.getStudentAttendances().size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onAttendanceFetchError( e.getMessage().toString());
                        Log.d(TAG, "FetchAttendance: error message "+e.getMessage());
                        Log.d(TAG, "FetchAttendance: error cause "+e.getCause());
                        Log.d(TAG, "FetchAttendance: error "+e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: "+teacherAttendanceResponses.getStudentAttendances().size());

                        listener.onAttendanceFetchComplete( teacherAttendanceResponses);

                    }
                });
    }

    public void uploadAttendanceToServer(Context context,TeacherAttendanceResponse teacherAttendanceResponse,
                                         final AttendanceFetchCompleteListener listener){
        this.listener = listener;


        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);
        Log.d(TAG, "uploadAttendance: method  ");

        apiService.uploadAttendance(teacherAttendanceResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<TeacherAttendanceResponse>(){

                    @Override
                    public void onNext(TeacherAttendanceResponse teacherAttendanceResponse) {
                        teacherAttendanceResponses = teacherAttendanceResponse;
//                        Log.d(TAG, "uploadAttendance onNext: "+teacherAttendanceResponses.getStudentAttendances().size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "uploadAttendance: error "+e.getMessage());
                        Log.d(TAG, "uploadAttendance: error "+e.getCause());
                        listener.onAttendanceUploadError(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {
//                        Log.d(TAG, "uploadAttendance onComplete: "+teacherAttendanceResponses.getStudentAttendances().size());
                        Log.d(TAG, "uploadAttendance Complete: ");

                        listener.onAttendanceUploadComplete( teacherAttendanceResponses);

                    }
                });
    }


    public interface AttendanceFetchCompleteListener {
        void onAttendanceFetchError(String errorMessage);

        void onAttendanceUploadError(String errorMessage);

        void onAttendanceFetchComplete(TeacherAttendanceResponse teacherAttendanceResponse);

        void onAttendanceUploadComplete(TeacherAttendanceResponse teacherAttendanceResponse);

    }
}
