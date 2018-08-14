package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentBatch;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentClass;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentSection;
import com.example.adsl4.stschoolmanagement.api.GetBatchAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.GetClassAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.GetSectionAsignmentApi;
import com.example.adsl4.stschoolmanagement.eventbus.AttendanceStudentSelectEvent;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.modals.GetBatchAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.GetClassAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.GetSectionAsignmentModal;
import com.example.adsl4.stschoolmanagement.teacherattendance.FetchAttendance;
import com.example.adsl4.stschoolmanagement.teacherattendance.TeacherAttendanceAdapter;
import com.example.adsl4.stschoolmanagement.teacherattendance.TeacherAttendanceResponse;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AttendanceTeacher extends AppCompatActivity implements FetchAttendance.AttendanceFetchCompleteListener {
    private static final String TAG = "AttendanceTeacher";

    SharedPreferenceUtils sharedPreferenceUtils ;
    TeacherDetailsResponse teacherDetailsResponse;
    TeacherAttendanceResponse teacherAttendanceResponseToSend;

    RecyclerView recyclerView;


    String  batchName,className,sectionName;
    int orgId,branchId,batchId,bthId,classId,clsid,sectionId,secId;
    Spinner spnAssignmentBatch,spnAssignmentGrade,spnAssignmentSection;
    TextView tvLBLNoDataFound;

    private List<LIstItemAssignmentBatch> lIstItemAssignmentBatches;
    private List<LIstItemAssignmentClass> lIstItemAssignmentClasses;
    private List<LIstItemAssignmentSection> lIstItemAssignmentSections;

    ProgressBar prgTeacherAssignment;
    Button btnSubmitAssignment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_teacher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);


        spnAssignmentBatch=findViewById(R.id.spinnerBatch);
        spnAssignmentGrade=findViewById(R.id.spinnerGrade);
        spnAssignmentSection=findViewById(R.id.spinnerSection);
        prgTeacherAssignment=findViewById(R.id.prgTeacherAssignment);
        tvLBLNoDataFound=findViewById(R.id.tv_no_data_found);
        btnSubmitAssignment=findViewById(R.id.btnSubmit);
        sharedPreferenceUtils = new SharedPreferenceUtils(AttendanceTeacher.this);
        teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(AttendanceTeacher.this);


        recyclerView=findViewById(R.id.recyclerStudentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupListRecycler();

        getBatch();

        btnSubmitAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prgTeacherAssignment.setVisibility(View.VISIBLE);
                FetchAttendance fetchAttendance = new FetchAttendance();
                fetchAttendance.uploadAttendanceToServer(AttendanceTeacher.this,
                        teacherAttendanceResponseToSend, AttendanceTeacher.this);
            }
        });
    }


    private void setupListRecycler() {
        TeacherAttendanceAdapter teacherAttendanceAdapter = new TeacherAttendanceAdapter(R.layout.teacher_attendance_list_item_layout, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(teacherAttendanceAdapter);
    }


    public void getBatch(){

        if((NetworkInfo) ((ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() == null){
            tvLBLNoDataFound.setText("No internet connection");
            return;
        }

        orgId=teacherDetailsResponse.getOrganizationId();
        branchId=teacherDetailsResponse.getBranchId();
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_Batch))
                .build();
        final GetBatchAsignmentApi getBatchAsignmentApi=retrofit.create(GetBatchAsignmentApi.class);
        Call<List<GetBatchAsignmentModal>> batchs=getBatchAsignmentApi.getBatchDetail(orgId,branchId);
        batchs.enqueue(new Callback<List<GetBatchAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetBatchAsignmentModal>> call, Response<List<GetBatchAsignmentModal>> response) {
//                HttpUrl test=call.request().url();
//                for (int i=0;i<10;i++) {
//                    Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
//                }
                List<GetBatchAsignmentModal> getBatchAsignmentModals = response.body();
                lIstItemAssignmentBatches=new ArrayList<>();
//                String hello=new GsonBuilder().setPrettyPrinting().create().toJson(response);
//                txtBatch.setText(hello);
                for (int i=0;i<getBatchAsignmentModals.size();i++){
                    batchId=getBatchAsignmentModals.get(i).getBatchId();
                    batchName=getBatchAsignmentModals.get(i).getBatchName();
                    Log.d(TAG, "onResponse: Batch name and id  "+batchName + " , "+ batchId);
                    LIstItemAssignmentBatch item = new LIstItemAssignmentBatch(batchId, batchName);
                    lIstItemAssignmentBatches.add(item);
                }
                ArrayAdapter<LIstItemAssignmentBatch> assignmentBatchArrayAdapter=new ArrayAdapter<LIstItemAssignmentBatch>(AttendanceTeacher.this,
                        android.R.layout.simple_spinner_item,lIstItemAssignmentBatches);
                assignmentBatchArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentBatch.setAdapter(assignmentBatchArrayAdapter);
                spnAssignmentBatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);
                            LIstItemAssignmentBatch lIstItemAssignmentBatch = (LIstItemAssignmentBatch) spnAssignmentBatch.getSelectedItem();
                            bthId = lIstItemAssignmentBatch.getBatchsId();
                            Log.d(TAG, "onItemSelected: Batch id : "+bthId);
                            ///Toast.makeText(AssignmentTeacher.this, "ID: " + bthId, Toast.LENGTH_SHORT).show();
                            getGrades();
                        }
                        catch (Exception  ex){
                            Toast.makeText(AttendanceTeacher.this, "Error: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetBatchAsignmentModal>> call, Throwable t) {
                prgTeacherAssignment.setVisibility(View.GONE);
                HttpUrl test=call.request().url();
                tvLBLNoDataFound.setText(t.getMessage());
                tvLBLNoDataFound.setVisibility(View.VISIBLE);
                Toast.makeText(AttendanceTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getGrades(){
        orgId=teacherDetailsResponse.getOrganizationId();
        branchId=teacherDetailsResponse.getBranchId();
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_class_url))
                .build();
        final GetClassAsignmentApi getClassAsignmentApi=retrofit.create(GetClassAsignmentApi.class);
        Call<List<GetClassAsignmentModal>> classes=getClassAsignmentApi.getClassDetail(orgId,branchId,bthId);
        classes.enqueue(new Callback<List<GetClassAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetClassAsignmentModal>> call, Response<List<GetClassAsignmentModal>> response) {

                List<GetClassAsignmentModal> getClassAsignmentModalList = response.body();
                lIstItemAssignmentClasses=new ArrayList<>();

                for (int i=0;i<getClassAsignmentModalList.size();i++){
                    classId=getClassAsignmentModalList.get(i).getClassId();
                    className=getClassAsignmentModalList.get(i).getClassName();
                    Log.d(TAG, "onResponse: Class name and id  "+className + " , "+ classId);

                    LIstItemAssignmentClass item = new LIstItemAssignmentClass(classId, className);
                    lIstItemAssignmentClasses.add(item);
                }
                ArrayAdapter<LIstItemAssignmentClass> assignmentClassArrayAdapter=new ArrayAdapter<LIstItemAssignmentClass>(AttendanceTeacher.this,
                        android.R.layout.simple_spinner_item,lIstItemAssignmentClasses);
                assignmentClassArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentGrade.setAdapter(assignmentClassArrayAdapter);
                spnAssignmentGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);
                            LIstItemAssignmentClass lIstItemAssignmentClass = (LIstItemAssignmentClass) spnAssignmentGrade.getSelectedItem();
                            clsid = lIstItemAssignmentClass.getClassId();
                            Log.d(TAG, "onItemSelected: Class id : "+clsid);
                            ///Toast.makeText(AssignmentTeacher.this, "ID: " + clsid, Toast.LENGTH_SHORT).show();
                            getSections();
                        }
                        catch (Exception  ex){
                            Toast.makeText(AttendanceTeacher.this, "Error: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetClassAsignmentModal>> call, Throwable t) {
                prgTeacherAssignment.setVisibility(View.GONE);
                tvLBLNoDataFound.setText(t.getMessage());
                tvLBLNoDataFound.setVisibility(View.VISIBLE);
                HttpUrl test=call.request().url();
                Toast.makeText(AttendanceTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSections(){
        orgId=teacherDetailsResponse.getOrganizationId();
        branchId=teacherDetailsResponse.getBranchId();
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_section_url))
                .build();
        final GetSectionAsignmentApi getSectionAsignmentApi=retrofit.create(GetSectionAsignmentApi.class);
        Call<List<GetSectionAsignmentModal>> classes=getSectionAsignmentApi.getSectionDetail(orgId,branchId,bthId,clsid);
        classes.enqueue(new Callback<List<GetSectionAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetSectionAsignmentModal>> call, Response<List<GetSectionAsignmentModal>> response) {

                List<GetSectionAsignmentModal> getSectionAsignmentModalList = response.body();
                lIstItemAssignmentSections=new ArrayList<>();


                for (int i=0;i<getSectionAsignmentModalList.size();i++){
                    try {

                        sectionId=getSectionAsignmentModalList.get(i).getSectionId();
                        sectionName=getSectionAsignmentModalList.get(i).getSectionName();
                        Log.d(TAG, "onResponse: Section name and id  "+sectionName + " , "+ sectionId);

                        LIstItemAssignmentSection item = new LIstItemAssignmentSection(sectionId, sectionName);
                        lIstItemAssignmentSections.add(item);
                    }catch (NullPointerException e){
                        Toast.makeText(AttendanceTeacher.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
                ArrayAdapter<LIstItemAssignmentSection> assignmentSectionArrayAdapter=new ArrayAdapter<LIstItemAssignmentSection>(AttendanceTeacher.this,
                        android.R.layout.simple_spinner_item,lIstItemAssignmentSections);
                assignmentSectionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentSection.setAdapter(assignmentSectionArrayAdapter);
                spnAssignmentSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);
                            LIstItemAssignmentSection lIstItemAssignmentSection = (LIstItemAssignmentSection) spnAssignmentSection.getSelectedItem();
                            secId = lIstItemAssignmentSection.getBatchsId();
                            Log.d(TAG, "onItemSelected: Section id : "+secId);
                            //Toast.makeText(AssignmentTeacher.this, "Sec ID: " + secId, Toast.LENGTH_SHORT).show();
                            fetchAttendanceList();
                        }
                        catch (Exception  ex){
                            secId=0;
                            Toast.makeText(AttendanceTeacher.this, "Error: "+ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetSectionAsignmentModal>> call, Throwable t) {
                prgTeacherAssignment.setVisibility(View.GONE);
                tvLBLNoDataFound.setText(t.getMessage());
                tvLBLNoDataFound.setVisibility(View.VISIBLE);
                HttpUrl test=call.request().url();
                Toast.makeText(AttendanceTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void fetchAttendanceList(){

        int OrganizationId=10;
        int BranchId=9;
//        String UserId="621e39bf-ec74-4c80-bf51-459748abcb38";
        String UserId="3c5cfc31-f42c-4a6c-8225-8bfd16885610";
                int BatchId=10;
        int ClassId=33;
        int SectionId=37;

        FetchAttendance fetchAttendance = new FetchAttendance();
        fetchAttendance.fetchAttendanceFromServer(AttendanceTeacher.this,
                teacherDetailsResponse.getUserId(),
                teacherDetailsResponse.getOrganizationId(),
                teacherDetailsResponse.getBranchId(),
                bthId,clsid,secId,this
                );

//        FetchAttendance fetchAttendance = new FetchAttendance();
//        fetchAttendance.fetchAttendanceFromServer(AttendanceTeacher.this,
//                UserId, OrganizationId, BranchId, BatchId,ClassId,SectionId,this
//        );


    }

    @Override
    public void onAttendanceFetchError(String errorMessage) {
        prgTeacherAssignment.setVisibility(View.GONE);
        tvLBLNoDataFound.setText(errorMessage);
        tvLBLNoDataFound.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAttendanceUploadError(String errorMessage) {
        prgTeacherAssignment.setVisibility(View.GONE);
        Toast.makeText(this, "Upload Failed!!\n"+errorMessage, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttendanceFetchComplete(TeacherAttendanceResponse teacherAttendanceResponse) {
        prgTeacherAssignment.setVisibility(View.GONE);

        if(teacherAttendanceResponse.getStudentAttendances().size() == 0){
            tvLBLNoDataFound.setVisibility(View.VISIBLE);
            btnSubmitAssignment.setEnabled(false);
            return;
        }
        teacherAttendanceResponseToSend = teacherAttendanceResponse;
        ((TeacherAttendanceAdapter) recyclerView.getAdapter()).replaceData(teacherAttendanceResponse.getStudentAttendances());
        tvLBLNoDataFound.setVisibility(View.GONE);

        Log.d(TAG, "onAttendanceFetchComplete: "+teacherAttendanceResponse.getStudentAttendances().size());

    }

    @Override
    public void onAttendanceUploadComplete(TeacherAttendanceResponse teacherAttendanceResponse) {

        prgTeacherAssignment.setVisibility(View.GONE);

        Toast.makeText(this, "Successfully uploaded", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStudentStatusCheckClick(AttendanceStudentSelectEvent.StudentAttendanceItemClick itemClick) {

        teacherAttendanceResponseToSend.getStudentAttendances()
                .get(itemClick.getAttendanceListChild().getChildPosition())
                .setStudentStatus(itemClick.getAttendanceListChild().getAttendanceStatus());

        Gson gson = new Gson();
        String jsonToString = gson.toJson(teacherAttendanceResponseToSend);

        Log.d(TAG, "onStudentStatusCheckClick: "+jsonToString);

        Toast.makeText(this, ""+itemClick.getAttendanceListChild().getChildPosition(), Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(this,DashboardTeacher.class);
        startActivity(backIntent);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
