package com.example.adsl4.stschoolmanagement.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.DashboardTeacher;
import com.example.adsl4.stschoolmanagement.activities.MainActivity;
import com.example.adsl4.stschoolmanagement.api.StudentLoginApi;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity implements UserLogin.LoginCompleteListener {
    Button btnLogin;
    EditText edtPin;
    TextView txtWrongPin;
    int userType;
    String Student,Organization;
    Spinner spnRole;
    ProgressBar prgLogin;

    SharedPreferenceUtils sharedPreferenceUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setBackgroundColor(Color.parseColor("#FFB6B5B5"));
        btnLogin.setEnabled(false);
        prgLogin=findViewById(R.id.prgLogin);
        prgLogin.setVisibility(View.GONE);

        sharedPreferenceUtils = new SharedPreferenceUtils(Login.this);


        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            btnLogin.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_gray) );
        } else {
            btnLogin.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_gray));
        }
        edtPin=findViewById(R.id.edtEmail3);
        txtWrongPin=findViewById(R.id.txtWrongPin);
        spnRole=findViewById(R.id.spnRole);
        spnRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int spnId=spnRole.getSelectedItemPosition();
                if (spnId == 0 ){
                    btnLogin.setEnabled(false);
                    final int sdk = android.os.Build.VERSION.SDK_INT;
                    if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        btnLogin.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_gray) );
                    } else {
                        btnLogin.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_gray));
                    }
                }
                else{
                    if (spnId==1){
                        userType = 1;
                    }
                    else{
                        userType = 0;
                    }
                    btnLogin.setEnabled(true);
                    final int sdk = android.os.Build.VERSION.SDK_INT;
                    if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        btnLogin.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_green) );
                    } else {
                        btnLogin.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_button_green));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtPin.getText().toString())){
                    txtWrongPin.setText(R.string.msg_wrong_pin);
                    return;
                }
                if (spnRole.getSelectedItemId() == 0){
                    Toast.makeText(Login.this, "Select user type", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    txtWrongPin.setText("");
                    prgLogin.setVisibility(View.VISIBLE);
                    edtPin.setFocusable(false);
                    edtPin.setTextColor(Color.parseColor("#9D9FA2"));
                    edtPin.setEnabled(false);
                    spnRole.setEnabled(false);

                    requestLoginToServer( userType);


//                    Gson gson = new GsonBuilder()
//                            .setLenient()
//                            .create();
//                    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//                    httpClient.addInterceptor(new Interceptor() {
//                        @Override
//                        public okhttp3.Response intercept(Chain chain) throws IOException {
//                            Request request = chain.request().newBuilder().addHeader("parameter", "value").build();
//                            return chain.proceed(request);
//                        }
//                    });
//
//                    final Retrofit retrofit=new Retrofit.Builder()
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .baseUrl(getString(R.string.loginapi_base_url))
//                            .build();
//                    StudentLoginApi studentLoginApi =retrofit.create(StudentLoginApi.class);
//                    String ids=edtPin.getText().toString();
//                    Call<StudentDetail> call = studentLoginApi.getStudentId(ids,0);
//                    call.enqueue(new Callback<StudentDetail>() {
//                        @SuppressLint("LongLogTag")
//                        @Override
//                        public void onResponse(Call<StudentDetail> call, Response<StudentDetail> response) {
//                            prgLogin.setVisibility(View.GONE);
//                            StudentDetail studentDetail=response.body();
//                            if(studentDetail.getStudentId()==null || studentDetail.getUserId()==null){
//                                edtPin.setFocusableInTouchMode(true);
//                                edtPin.setEnabled(true);
//                                edtPin.setTextColor(Color.parseColor("#ffffff"));
//                                spnRole.setEnabled(true);
//                                txtWrongPin.setText(studentDetail.getErrorMessage());
//                            }
//                            else {
//                                if (response.body() == null){
//                                    Toast.makeText(Login.this, "Null Response", Toast.LENGTH_SHORT).show();
//                                    return;
//                                }
//                                // String midName=studentDetail.getMiddleName().toString();
//                                if (userType == 0) {
//                                    Toast.makeText(Login.this, "Us", Toast.LENGTH_SHORT).show();
//                                    if (studentDetail.getFullName() != null) {
//                                        SharedPreferences.Editor stsName = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                        stsName.putString("StsName", studentDetail.getFullName());
//                                        stsName.apply();
//                                    } else {
//                                        SharedPreferences.Editor stsName = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                        stsName.putString("StsName", "User");
//                                        stsName.apply();
//                                    }
//
//                                    SharedPreferences.Editor stsClass = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    stsClass.putString("StsClass", studentDetail.getClass_());
//                                    stsClass.apply();
//
//                                    SharedPreferences.Editor orgName = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                                    orgName.putString("orgName", studentDetail.getOrganization());
//                                    orgName.apply();
//
//
//                                    SharedPreferences.Editor loginStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    loginStatus.putInt("loginStatus", 2);
//                                    loginStatus.apply();
//
//                                    if (studentDetail.getStudentImage() != null) {
//                                        SharedPreferences.Editor stsImage = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                        stsImage.putString("stsImage", studentDetail.getStudentImage().toString());
//                                        stsImage.apply();
//                                    } else {
//                                        SharedPreferences.Editor stsImage = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                        stsImage.putString("stsImage", "1464aeb7fe2a419895e7e1266a15a350.jpg");
//                                        stsImage.apply();
//
//                                    }
//
//                                    SharedPreferences.Editor batchId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    batchId.putInt("batchId", studentDetail.getBatchId());
//                                    batchId.apply();
//
//
//
//                                    SharedPreferences.Editor classId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    classId.putInt("classId", studentDetail.getClassId());
//                                    classId.apply();
//
//                                    SharedPreferences.Editor usrID = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    usrID.putString("userId", studentDetail.getUserId());
//                                    usrID.apply();
//
//                                    SharedPreferences.Editor stsId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                    stsId.putInt("stsId", studentDetail.getStudentId());
//                                    stsId.apply();
//
//                                    SharedPreferences.Editor orgId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                                    orgId.putInt("orgId", studentDetail.getOrganizationId());
//                                    orgId.apply();
//
//                                    SharedPreferences.Editor orgPhone = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                                    orgPhone.putString("orgPhone", String.valueOf(studentDetail.getContactNumber()));
//                                    orgPhone.apply();
//
//                                    SharedPreferences.Editor branchId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                                    branchId.putInt("branchId", studentDetail.getBranchId());
//                                    branchId.apply();
//
//                                    SharedPreferenceUtils sharedPreferenceUtils =new SharedPreferenceUtils(Login.this);
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_NAME, studentDetail.getFullName());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_ClASS, studentDetail.getClass_());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_NAME, studentDetail.getOrganization());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_BATCH_ID, studentDetail.getBatchId());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_CLASS_ID, studentDetail.getClassId());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, studentDetail.getUserId());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_ID, studentDetail.getStudentId());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_ID, studentDetail.getOrganizationId());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_PHONE, studentDetail.getOrganizationContactNumber());
//                                    sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_BRANCH_ID, studentDetail.getBranchId());
//
//                                    JsonAndGsonOperation.saveStudentDetails(Login.this, response.body());
//
//                                    Intent intent = new Intent(Login.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//
////                            txtWrongPin.setText(call.request().url().toString());
//
////                            Log.w("2.0 getFeed > Full json res wrapped in gson => ",new Gson().toJson(response));
////                            txtWrongPin.setText(new GsonBuilder().setPrettyPrinting().create().toJson(response));
////                            Toast.makeText(Login.this, "Ok!!", Toast.LENGTH_SHORT).show();
//                                }
//                                else {
////                                    Intent intent = new Intent(Login.this, DashboardTeacher.class);
////                                    startActivity(intent);
////                                    finish();
//                                    requestLoginToServer( 1);
//                                }
//                            }
//
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<StudentDetail> call, Throwable t) {
//                            prgLogin.setVisibility(View.GONE);
//                            edtPin.setFocusableInTouchMode(true);
//                            edtPin.setEnabled(true);
//                            edtPin.setTextColor(Color.parseColor("#ffffff"));
//                            spnRole.setEnabled(true);
//                            txtWrongPin.setText("Server Error!!!");
//                            //Toast.makeText(Login.this, call.request().url().toString(), Toast.LENGTH_SHORT).show();
//                            Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });

                }

            }
        });

    }


    private void requestLoginToServer (int userType){
        UserLogin userLogin = new UserLogin();
        if(userType == 0){
            userLogin.studentLogin(Login.this, edtPin.getText().toString(), userType, this);
        }

        if(userType == 1){
            userLogin.teacherLogin(Login.this, edtPin.getText().toString(), userType, this);
        }
    }

    @Override
    public void onStudentLoginComplete() {
        txtWrongPin.setText("");
        prgLogin.setVisibility(View.VISIBLE);
        edtPin.setFocusable(false);
        edtPin.setTextColor(Color.parseColor("#9D9FA2"));
        edtPin.setEnabled(false);
        spnRole.setEnabled(false);

        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_IS_USER_LOGGED_IN, true);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, userType);

        startActivity(new Intent(Login.this, MainActivity.class));
        finish();
    }

    @Override
    public void onTeacherLoginComplete() {
        txtWrongPin.setText("");
        prgLogin.setVisibility(View.GONE);
        edtPin.setFocusable(false);
        edtPin.setTextColor(Color.parseColor("#9D9FA2"));
        edtPin.setEnabled(false);
        spnRole.setEnabled(false);

        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_IS_USER_LOGGED_IN, true);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, userType);

        startActivity(new Intent(Login.this, DashboardTeacher.class));
        finish();

    }

    @Override
    public void onLoginError(String errorMessage) {
        prgLogin.setVisibility(View.GONE);
        edtPin.setFocusableInTouchMode(true);
        edtPin.setEnabled(true);
        edtPin.setTextColor(Color.parseColor("#ffffff"));
        spnRole.setEnabled(true);
        txtWrongPin.setText("Server Error!!! \n"+errorMessage);
//        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
