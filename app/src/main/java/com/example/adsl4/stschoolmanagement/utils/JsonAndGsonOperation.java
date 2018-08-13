package com.example.adsl4.stschoolmanagement.utils;

import android.content.Context;

import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.google.gson.Gson;

public class JsonAndGsonOperation{

    public static void saveStudentDetails (Context context, StudentDetail studentDetail){
        Gson gson = new Gson();
        // 2. Java object to JSON, and assign to a String
        String jsonInString = gson.toJson(studentDetail);

        SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(context);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_DETAILS, jsonInString);

    }

    public static StudentDetail getStudentDetails (Context context){

        Gson gson = new Gson();
        // 2. JSON to Java object, read it from a Json String.
        SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(context);
        String jsonInString = sharedPreferenceUtils.getStringValue(SharedPreferenceUtils.KEY_STUDENT_DETAILS, null);
        StudentDetail studentDetail = gson.fromJson(jsonInString, StudentDetail.class);

        return studentDetail;
    }

    public static void saveTeacherDetails (Context context, TeacherDetailsResponse teacherDetailsResponse){
        Gson gson = new Gson();
        // 2. Java object to JSON, and assign to a String
        String jsonInString = gson.toJson(teacherDetailsResponse);

        SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(context);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_TEACHER_DETAILS, jsonInString);

    }

    public static TeacherDetailsResponse getTeacherDetails (Context context){

        Gson gson = new Gson();
        // 2. JSON to Java object, read it from a Json String.
        SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(context);
        String jsonInString = sharedPreferenceUtils.getStringValue(SharedPreferenceUtils.KEY_TEACHER_DETAILS, null);
        TeacherDetailsResponse teacherDetailsResponse = gson.fromJson(jsonInString, TeacherDetailsResponse.class);

        return teacherDetailsResponse;
    }

}
