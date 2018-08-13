package com.example.adsl4.stschoolmanagement.login;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.ChooseLogin;
import com.example.adsl4.stschoolmanagement.activities.DashboardTeacher;
import com.example.adsl4.stschoolmanagement.activities.MainActivity;
import com.example.adsl4.stschoolmanagement.api.StudentLoginApi;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;
import com.google.zxing.Result;

import java.io.IOException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.Manifest.permission.CAMERA;

public class QrScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler, UserLogin.LoginCompleteListener{
    private  static final int REQUEST_CAMERA=1;
    private ZXingScannerView scannerView;
    String[] listItems;
    int userType;
    String Student,Organization,user,userId;

    SharedPreferenceUtils sharedPreferenceUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);
        listItems=new String[]{"Teacher","Parent"};
        //askLoginType();

        sharedPreferenceUtils = new SharedPreferenceUtils(QrScanner.this);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkPermission()){

            }
            else{
                requestPermission();
            }
        }
        checkPermission();

    }

//    private void askLoginType() {
//        AlertDialog.Builder builder= new AlertDialog.Builder(this);
//        builder.setTitle("Tell Me Who You Are")
//                .setIcon(R.drawable.sheshaya)
//                .setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (which==0){
//                            userType=1;
//                            user="Teacher";
//                        }
//                        else if(which==1){
//                            userType=0;
//                            user="Parent";
//                        }
//                        dialog.dismiss();
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//        AlertDialog dialog=builder.create();
//        dialog.show();
//    }



    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(QrScanner.this, CAMERA)== PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA},REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult(int requestCode, String permission[], int grantResults[]){
        switch (requestCode)
        {
            case REQUEST_CAMERA:
                if(grantResults.length>0){
                    boolean cameraAccepted=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                displayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
            break;
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
            if (checkPermission()){
                if(scannerView==null){
                    scannerView=new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
            else {
                requestPermission();
            }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scannerView.stopCamera();
    }

    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(QrScanner.this)
                .setMessage(message)
                .setPositiveButton("Ok",listener)
                .setNegativeButton("Cancel",null)
                .create()
                .show();
    }
    @Override
    public void handleResult(Result result) {
        try {
            final String scanResult = result.getText();
            String[] splitResult = scanResult.split("/");
            userId = splitResult[0];
            userType = Integer.parseInt(splitResult[1]);
        }
        catch (Exception e){
            failedLogin();
        }
        if(TextUtils.isEmpty(userId)){
            return;
        }
        requestLoginToServer(userId, userType);

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request request = chain.request().newBuilder().addHeader("parameter", "value").build();
//                return chain.proceed(request);
//            }
//        });
//
//        final Retrofit retrofit=new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(getString(R.string.loginapi_base_url))
//                .build();
//        StudentLoginApi studentLoginApi =retrofit.create(StudentLoginApi.class);
//        Call<StudentDetail> call = studentLoginApi.getStudentId(userId,userType);
//        call.enqueue(new Callback<StudentDetail>() {
//            @SuppressLint("LongLogTag")
//            @Override
//            public void onResponse(Call<StudentDetail> call, Response<StudentDetail> response) {
//                StudentDetail studentDetail = response.body();
//
//                if(userType==0) {
//
//                    if (studentDetail.getUserId() != null) {
//
//                        if (studentDetail.getFullName() != null) {
//                            SharedPreferences.Editor stsName = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                            stsName.putString("StsName", studentDetail.getFullName());
//                            stsName.apply();
//                        } else {
//                            SharedPreferences.Editor stsName = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                            stsName.putString("StsName", "User");
//                            stsName.apply();
//                        }
//
//                        SharedPreferences.Editor stsAddress = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                        stsAddress.putString("StsClass", studentDetail.getClass_());
//                        stsAddress.apply();
//
//                        if (studentDetail.getStudentImage() != null) {
//                            SharedPreferences.Editor stsImage = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                            stsImage.putString("stsImage", studentDetail.getStudentImage().toString());
//                            stsImage.apply();
//                        } else {
//                            SharedPreferences.Editor stsImage = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                            stsImage.putString("stsImage", "1464aeb7fe2a419895e7e1266a15a350.jpg");
//                            stsImage.apply();
//
//                        }
//                        SharedPreferences.Editor batchId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                        batchId.putInt("batchId", studentDetail.getBatchId());
//                        batchId.apply();
//
//                        SharedPreferences.Editor classId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                        classId.putInt("classId", studentDetail.getClassId());
//                        classId.apply();
//
//                        SharedPreferences.Editor orgName = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgName.putString("orgName", studentDetail.getOrganization());
//                        orgName.apply();
//
//                        SharedPreferences.Editor usrID = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                        usrID.putString("userId", studentDetail.getUserId());
//                        usrID.apply();
//
//                        SharedPreferences.Editor stsId = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                        stsId.putInt("stsId", studentDetail.getStudentId());
//                        stsId.apply();
//
//
//                        SharedPreferences.Editor orgId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgId.putInt("orgId", studentDetail.getOrganizationId());
//                        orgId.apply();
//
//                        SharedPreferences.Editor orgPhone = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgPhone.putString("orgPhone", String.valueOf(studentDetail.getContactNumber()));
//                        orgPhone.apply();
//
//                        SharedPreferences.Editor branchId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        branchId.putInt("branchId", studentDetail.getBranchId());
//                        branchId.apply();
//
//                        SharedPreferenceUtils sharedPreferenceUtils =new SharedPreferenceUtils(QrScanner.this);
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_NAME, studentDetail.getFullName());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_ClASS, studentDetail.getClass_());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_NAME, studentDetail.getOrganization());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_BATCH_ID, studentDetail.getBatchId());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_CLASS_ID, studentDetail.getClassId());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, studentDetail.getUserId());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_STUDENT_ID, studentDetail.getStudentId());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_ID, studentDetail.getOrganizationId());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_ORG_PHONE, studentDetail.getOrganizationContactNumber());
//                        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_BRANCH_ID, studentDetail.getBranchId());
//
//
//
//                        Intent intent = new Intent(QrScanner.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                }
//                    else {
//
//                        SharedPreferences.Editor teachName = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        teachName.putString("teachName", studentDetail.getFullName());
//                        teachName.apply();
//
//                        SharedPreferences.Editor teachPost = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        teachPost.putString("teachPost", studentDetail.getEmployeePost());
//                        teachPost.apply();
//
//                        SharedPreferences.Editor teachId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        teachId.putString("teachId", studentDetail.getUserId());
//                        teachId.apply();
//
//                        SharedPreferences.Editor teachDetailId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        teachDetailId.putInt("teachDetailId", studentDetail.getEmployeeDetailId());
//                        teachDetailId.apply();
//
//                        SharedPreferences.Editor orgName = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgName.putString("orgName", studentDetail.getOrganization());
//                        orgName.apply();
//
//                        SharedPreferences.Editor orgId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgId.putInt("orgId", studentDetail.getOrganizationId());
//                        orgId.apply();
//
//                        SharedPreferences.Editor orgPhone = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        orgPhone.putString("orgPhone", String.valueOf(studentDetail.getContactNumber()));
//                        orgPhone.apply();
//
//                        SharedPreferences.Editor branchId = getSharedPreferences(Organization, MODE_PRIVATE).edit();
//                        branchId.putInt("branchId", studentDetail.getBranchId());
//                        branchId.apply();
//
//                        Intent intent = new Intent(QrScanner.this, DashboardTeacher.class);
//                        startActivity(intent);
//                        finish();
//                    }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<StudentDetail> call, Throwable t) {
//                failedLogin();
//
//                //Toast.makeText(Login.this, call.request().url().toString(), Toast.LENGTH_SHORT).show();
////                        Toast.makeText(QrScanner.this, t.getMessage(), Toast.LENGTH_SHORT).show();
////                        scannerView.resumeCameraPreview(QrScanner.this);
//
//            }
//        });
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle("Are you want to login with this ID?");
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.setNeutralButton("Scan Again", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                scannerView.resumeCameraPreview(QrScanner.this);
//
////                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
////                startActivity(intent);
//            }
//        });
//        builder.setMessage(scanResult);
//        AlertDialog alert=builder.create();
//        alert.show();
    }

    private void failedLogin() {

        new AlertDialog.Builder(QrScanner.this)
                .setTitle("Error Login!!!")
                .setIcon(R.drawable.sheshaya)
                .setCancelable(false)
                .setMessage("Please make sure you that are using correct QR Code !!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(QrScanner.this,ChooseLogin.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void requestLoginToServer (String userId, int userType){
        UserLogin userLogin = new UserLogin();
        if(userType == 0){
            userLogin.studentLogin(QrScanner.this, userId, userType, this);
        }

        if(userType == 1){
            userLogin.teacherLogin(QrScanner.this, userId, userType, this);
        }
    }

    @Override
    public void onStudentLoginComplete() {
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_IS_USER_LOGGED_IN, true);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, userType);
        startActivity(new Intent(QrScanner.this, MainActivity.class));
        finish();
    }

    @Override
    public void onTeacherLoginComplete() {
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_IS_USER_LOGGED_IN, true);
        sharedPreferenceUtils.setValue(SharedPreferenceUtils.KEY_USER_ID, userType);
        startActivity(new Intent(QrScanner.this, DashboardTeacher.class));
        finish();
    }

    @Override
    public void onLoginError(String errorMessage) {
        failedLogin();
    }
}
