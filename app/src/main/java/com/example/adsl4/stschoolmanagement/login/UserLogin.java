package com.example.adsl4.stschoolmanagement.login;

import android.content.Context;
import android.util.Log;

import com.example.adsl4.stschoolmanagement.network.NetworkApiClient;
import com.example.adsl4.stschoolmanagement.network.NetworkApiInterface;
import com.example.adsl4.stschoolmanagement.notices.FetchNoticies;
import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UserLogin {
    private static final String TAG = "UserLogin";

    private LoginCompleteListener listener;

    TeacherDetailsResponse teacherDetailsResponse = new TeacherDetailsResponse();
    StudentDetail studentDetail = new StudentDetail();

    public void studentLogin(final Context context, String userId, int userType, final LoginCompleteListener listener){
        this.listener = listener;

        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);

        Log.d(TAG, "FetchStudentDetails: ");

        apiService.getStudentDetails(userId, userType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<StudentDetail>(){

                    @Override
                    public void onNext(StudentDetail studentDetails) {
                        studentDetail = studentDetails;

                                                Log.d(TAG, "onNext: "+studentDetails.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Teacher Login error "+e.getMessage());
                        Log.d(TAG, "Teacher Login error "+e.getCause());
                        listener.onLoginError(e.getMessage().toString()+" \n"+e.getCause().toString());

                    }

                    @Override
                    public void onComplete() {
                        JsonAndGsonOperation.saveStudentDetails(context, studentDetail);
                        listener.onStudentLoginComplete();
                    }
                });
    }

    public void teacherLogin(final Context context, String userId, int userType, final LoginCompleteListener listener){
        this.listener = listener;

        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);

        Log.d(TAG, "FetchTeacherDetails: ");

        apiService.getTeacherDetails(userId, userType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<TeacherDetailsResponse>(){

                    @Override
                    public void onNext(TeacherDetailsResponse teacherDetailsResponses) {
                        teacherDetailsResponse = teacherDetailsResponses;

                                                Log.d(TAG, "onNext: "+teacherDetailsResponses.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Teacher Login error "+e.getMessage());
                        Log.d(TAG, "Teacher Login error "+e.getCause());
                        listener.onLoginError(e.getMessage().toString()+" \n"+e.getCause().toString());
                    }

                    @Override
                    public void onComplete() {
                        JsonAndGsonOperation.saveTeacherDetails(context, teacherDetailsResponse);
                        listener.onTeacherLoginComplete();
                    }
                });
    }



    public interface LoginCompleteListener {

        void onStudentLoginComplete();

        void onTeacherLoginComplete();

        void onLoginError(String errorMessage);

    }

}
