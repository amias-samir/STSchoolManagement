package com.example.adsl4.stschoolmanagement.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentBatch;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentClass;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentSection;
import com.example.adsl4.stschoolmanagement.adapters.LIstItemAssignmentSubjects;
import com.example.adsl4.stschoolmanagement.api.GetBatchAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.GetClassAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.GetSectionAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.GetSubjectsAsignmentApi;
import com.example.adsl4.stschoolmanagement.api.MessageToAdmin;
import com.example.adsl4.stschoolmanagement.api.UploadAssignmentApi;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.modals.GetBatchAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.GetClassAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.GetSectionAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.GetSubjectsAsignmentModal;
import com.example.adsl4.stschoolmanagement.modals.MessageToAdminModal;
import com.example.adsl4.stschoolmanagement.modals.TeacherAssignmentModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AssignmentTeacher extends AppCompatActivity {
    Activity activity;
    String Student, Organization, batchName, className, sectionName, subjectName;
    int orgId, branchId, batchId, bthId, classId, clsid, sectionId, secId, subjectId, subId;
    private List<LIstItemAssignmentBatch> lIstItemAssignmentBatches;
    private List<LIstItemAssignmentClass> lIstItemAssignmentClasses;
    private List<LIstItemAssignmentSection> lIstItemAssignmentSections;
    private List<LIstItemAssignmentSubjects> lIstItemAssignmentSubjects;
    ProgressBar prgTeacherAssignment;
    Button btnSubmitAssignment;
    EditText edtAssignDetail;

    Spinner spnAssignmentBatch, spnAssignmentGrade, spnAssignmentSection, spnAssignmentSubject;
    TextView txtBatch;

    SharedPreferenceUtils sharedPreferenceUtils;
    TeacherDetailsResponse teacherDetailsResponse;
    private static final String TAG = "AssignmentTeacher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_teacher);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        sharedPreferenceUtils = new SharedPreferenceUtils(AssignmentTeacher.this);
        teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(AssignmentTeacher.this);

        RelativeLayout myLayout = this.findViewById(R.id.relMain);
        myLayout.requestFocus();
        spnAssignmentBatch = findViewById(R.id.spnAssignmentBatch);
        spnAssignmentGrade = findViewById(R.id.spnAssignmentGrade);
        spnAssignmentSection = findViewById(R.id.spnAssignmentSection);
        spnAssignmentSubject = findViewById(R.id.spnAssignmentSubject);
        prgTeacherAssignment = findViewById(R.id.prgTeacherAssignment);
        edtAssignDetail = findViewById(R.id.edtAssignDetail);
        btnSubmitAssignment = findViewById(R.id.btnSubmitAssignment);


        btnSubmitAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String assignmentDetail = edtAssignDetail.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = df.format(currentTime);
                Log.d(TAG, "onClick: dateFormat" + formattedDate);

                String usrId = teacherDetailsResponse.getUserId();
                int teachDetailId = teacherDetailsResponse.getEmployeeDetailId();


//                TeacherAssignmentModal teacherAssignmentModal= new TeacherAssignmentModal(
//                        bthId,clsid,secId,currentTime.toString(),teachDetailId,subId,assignmentDetail,usrId,
//                        currentTime.toString());

                TeacherAssignmentModal teacherAssignmentModal = new TeacherAssignmentModal(orgId, branchId, batchId, classId, sectionId,
                        formattedDate.toString(), teachDetailId, subjectId, assignmentDetail, usrId, formattedDate.toString());

                Gson gson = new Gson();
                // 2. Java object to JSON, and assign to a String
                String jsonInString = gson.toJson(teacherAssignmentModal);
                Log.d("AssignmentTeacher", "onClick: " + jsonInString);

                uploadAssignment(teacherAssignmentModal);
            }
        });
        txtBatch = findViewById(R.id.txtBatch);
        getBatch();
    }

    private void uploadAssignment(TeacherAssignmentModal teacherAssignmentModal) {
        prgTeacherAssignment.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mobile.sheshayapathshala.com.np/api/")
                .build();
        final UploadAssignmentApi uploadAssignmentApi = retrofit.create(UploadAssignmentApi.class);
        Call<List<TeacherAssignmentModal>> messages = uploadAssignmentApi.uploadAssignment(teacherAssignmentModal);
        messages.enqueue(new Callback<List<TeacherAssignmentModal>>() {
            @Override
            public void onResponse(Call<List<TeacherAssignmentModal>> call, Response<List<TeacherAssignmentModal>> response) {
                prgTeacherAssignment.setVisibility(View.GONE);
                String hello = new GsonBuilder().setPrettyPrinting().create().toJson(response.body());

                Log.d(TAG, "onResponse: message " + response.message());

//                    Toast.makeText(AssignmentTeacher.this, "Uploaded Successfuly " + call.request().url() +"\n "+hello, Toast.LENGTH_LONG).show();
                Toast.makeText(AssignmentTeacher.this, "Uploaded Successfuly ", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<TeacherAssignmentModal>> call, Throwable t) {
                prgTeacherAssignment.setVisibility(View.GONE);
                Log.d(TAG, "onFailure: message " + t.getMessage());
                Log.d(TAG, "onFailure: cause " + t.getCause());
                Log.d(TAG, "onFailure: cause " + t.toString());
                Toast.makeText(AssignmentTeacher.this, "Upload Failed!" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getBatch() {

        orgId = teacherDetailsResponse.getOrganizationId();
        branchId = teacherDetailsResponse.getBranchId();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_Batch))
                .build();
        final GetBatchAsignmentApi getBatchAsignmentApi = retrofit.create(GetBatchAsignmentApi.class);
        Call<List<GetBatchAsignmentModal>> batchs = getBatchAsignmentApi.getBatchDetail(orgId, branchId);
        batchs.enqueue(new Callback<List<GetBatchAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetBatchAsignmentModal>> call, Response<List<GetBatchAsignmentModal>> response) {
//                HttpUrl test=call.request().url();
//                for (int i=0;i<10;i++) {
//                    Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
//                }
                List<GetBatchAsignmentModal> getBatchAsignmentModals = response.body();
                lIstItemAssignmentBatches = new ArrayList<>();
//                String hello=new GsonBuilder().setPrettyPrinting().create().toJson(response);
//                txtBatch.setText(hello);
                for (int i = 0; i < getBatchAsignmentModals.size(); i++) {
                    batchId = getBatchAsignmentModals.get(i).getBatchId();
                    batchName = getBatchAsignmentModals.get(i).getBatchName();
                    LIstItemAssignmentBatch item = new LIstItemAssignmentBatch(batchId, batchName);
                    lIstItemAssignmentBatches.add(item);
                }
                ArrayAdapter<LIstItemAssignmentBatch> assignmentBatchArrayAdapter = new ArrayAdapter<LIstItemAssignmentBatch>(AssignmentTeacher.this,
                        android.R.layout.simple_spinner_item, lIstItemAssignmentBatches);
                assignmentBatchArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentBatch.setAdapter(assignmentBatchArrayAdapter);
                prgTeacherAssignment.setVisibility(View.GONE);
                spnAssignmentBatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);
                            LIstItemAssignmentBatch lIstItemAssignmentBatch = (LIstItemAssignmentBatch) spnAssignmentBatch.getSelectedItem();
                            bthId = lIstItemAssignmentBatch.getBatchsId();
                            ///Toast.makeText(AssignmentTeacher.this, "ID: " + bthId, Toast.LENGTH_SHORT).show();
                            getGrades();
                        } catch (Exception ex) {
                            Toast.makeText(AssignmentTeacher.this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
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
                HttpUrl test = call.request().url();
                Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getGrades() {
        orgId = teacherDetailsResponse.getOrganizationId();
        branchId = teacherDetailsResponse.getBranchId();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_class_url))
                .build();
        final GetClassAsignmentApi getClassAsignmentApi = retrofit.create(GetClassAsignmentApi.class);
        Call<List<GetClassAsignmentModal>> classes = getClassAsignmentApi.getClassDetail(orgId, branchId, bthId);
        classes.enqueue(new Callback<List<GetClassAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetClassAsignmentModal>> call, Response<List<GetClassAsignmentModal>> response) {

                List<GetClassAsignmentModal> getClassAsignmentModalList = response.body();
                lIstItemAssignmentClasses = new ArrayList<>();

                for (int i = 0; i < getClassAsignmentModalList.size(); i++) {
                    classId = getClassAsignmentModalList.get(i).getClassId();
                    className = getClassAsignmentModalList.get(i).getClassName();
                    LIstItemAssignmentClass item = new LIstItemAssignmentClass(classId, className);
                    lIstItemAssignmentClasses.add(item);
                }
                ArrayAdapter<LIstItemAssignmentClass> assignmentClassArrayAdapter = new ArrayAdapter<LIstItemAssignmentClass>(AssignmentTeacher.this,
                        android.R.layout.simple_spinner_item, lIstItemAssignmentClasses);
                assignmentClassArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentGrade.setAdapter(assignmentClassArrayAdapter);
                spnAssignmentGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);

                            LIstItemAssignmentClass lIstItemAssignmentClass = (LIstItemAssignmentClass) spnAssignmentGrade.getSelectedItem();
                            clsid = lIstItemAssignmentClass.getClassId();
                            ///Toast.makeText(AssignmentTeacher.this, "ID: " + clsid, Toast.LENGTH_SHORT).show();
                            getSections();
                        } catch (Exception ex) {
                            Toast.makeText(AssignmentTeacher.this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetClassAsignmentModal>> call, Throwable t) {
                HttpUrl test = call.request().url();
                Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSections() {
        orgId = teacherDetailsResponse.getOrganizationId();
        branchId = teacherDetailsResponse.getBranchId();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_section_url))
                .build();
        final GetSectionAsignmentApi getSectionAsignmentApi = retrofit.create(GetSectionAsignmentApi.class);
        Call<List<GetSectionAsignmentModal>> classes = getSectionAsignmentApi.getSectionDetail(orgId, branchId, bthId, clsid);
        classes.enqueue(new Callback<List<GetSectionAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetSectionAsignmentModal>> call, Response<List<GetSectionAsignmentModal>> response) {

                List<GetSectionAsignmentModal> getSectionAsignmentModalList = response.body();
                lIstItemAssignmentSections = new ArrayList<>();

                for (int i = 0; i < getSectionAsignmentModalList.size(); i++) {
                    sectionId = getSectionAsignmentModalList.get(i).getSectionId();
                    sectionName = getSectionAsignmentModalList.get(i).getSectionName();
                    LIstItemAssignmentSection item = new LIstItemAssignmentSection(sectionId, sectionName);
                    lIstItemAssignmentSections.add(item);
                }
                ArrayAdapter<LIstItemAssignmentSection> assignmentSectionArrayAdapter = new ArrayAdapter<LIstItemAssignmentSection>(AssignmentTeacher.this,
                        android.R.layout.simple_spinner_item, lIstItemAssignmentSections);
                assignmentSectionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnAssignmentSection.setAdapter(assignmentSectionArrayAdapter);
                spnAssignmentSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            prgTeacherAssignment.setVisibility(View.VISIBLE);

                            LIstItemAssignmentSection lIstItemAssignmentSection = (LIstItemAssignmentSection) spnAssignmentSection.getSelectedItem();
                            secId = lIstItemAssignmentSection.getBatchsId();
                            //Toast.makeText(AssignmentTeacher.this, "Sec ID: " + secId, Toast.LENGTH_SHORT).show();
                            getSubjects();
                        } catch (Exception ex) {
                            secId = 0;
                            Toast.makeText(AssignmentTeacher.this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetSectionAsignmentModal>> call, Throwable t) {
                HttpUrl test = call.request().url();
                Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSubjects() {
        orgId = teacherDetailsResponse.getOrganizationId();
        branchId = teacherDetailsResponse.getBranchId();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_subjects_url))
                .build();
        final GetSubjectsAsignmentApi getSubjectsAsignmentApi = retrofit.create(GetSubjectsAsignmentApi.class);
        Call<List<GetSubjectsAsignmentModal>> classes = getSubjectsAsignmentApi.getSubjectDetail(orgId, branchId, bthId, clsid);
        classes.enqueue(new Callback<List<GetSubjectsAsignmentModal>>() {
            @Override
            public void onResponse(Call<List<GetSubjectsAsignmentModal>> call, Response<List<GetSubjectsAsignmentModal>> response) {
                try {

                    prgTeacherAssignment.setVisibility(View.GONE);


                    List<GetSubjectsAsignmentModal> getSectionAsignmentModalList = response.body();
                    lIstItemAssignmentSubjects = new ArrayList<>();

                    for (int i = 0; i < getSectionAsignmentModalList.size(); i++) {
                        subjectId = getSectionAsignmentModalList.get(i).getClassSubjectId();
                        subjectName = getSectionAsignmentModalList.get(i).getClassSubjectName();
                        LIstItemAssignmentSubjects item = new LIstItemAssignmentSubjects(subjectId, subjectName);
                        lIstItemAssignmentSubjects.add(item);
                    }
                    ArrayAdapter<LIstItemAssignmentSubjects> assignmentSectionArrayAdapter = new ArrayAdapter<LIstItemAssignmentSubjects>(AssignmentTeacher.this,
                            android.R.layout.simple_spinner_item, lIstItemAssignmentSubjects);
                    assignmentSectionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnAssignmentSubject.setAdapter(assignmentSectionArrayAdapter);

                    spnAssignmentSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            try {
//                            prgTeacherAssignment.setVisibility(View.VISIBLE);

                                LIstItemAssignmentSubjects lIstItemAssignmentSubjects = (LIstItemAssignmentSubjects) spnAssignmentSubject.getSelectedItem();
                                subId = lIstItemAssignmentSubjects.getSubjectsId();
                                // Toast.makeText(AssignmentTeacher.this, "Sub ID: " + subId, Toast.LENGTH_SHORT).show();
                            } catch (Exception ex) {
                                Toast.makeText(AssignmentTeacher.this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    Toast.makeText(AssignmentTeacher.this, "error!!! \nSubject data null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSubjectsAsignmentModal>> call, Throwable t) {
                prgTeacherAssignment.setVisibility(View.GONE);

                HttpUrl test = call.request().url();
                Toast.makeText(AssignmentTeacher.this, "Error " + test, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(this, DashboardTeacher.class);
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
