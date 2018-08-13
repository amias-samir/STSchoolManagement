package com.example.adsl4.stschoolmanagement.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.ListItemStudentAttendance;
import com.example.adsl4.stschoolmanagement.adapters.StudentAttendanceAdapter;
import com.example.adsl4.stschoolmanagement.api.MonthDetailApi;
import com.example.adsl4.stschoolmanagement.api.StudentAttendanceApi;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.modals.MonthDetailModal;
import com.example.adsl4.stschoolmanagement.modals.StudentAttendanceModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    int monthNumber,attenDay, monthNum;
    Spinner spnStsAttendance;
    String Organization, Student,presentStatus,Months;
    private List<ListItemStudentAttendance> listItemStudentAttendances;
    ProgressBar prgStsAttendance;
    TextView txtCurrentMonth,txtErrAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        recyclerView=findViewById(R.id.recStsAttendance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        spnStsAttendance=findViewById(R.id.spnAttendanceMonth);
        prgStsAttendance=findViewById(R.id.prgStsAttendance);
        txtCurrentMonth=findViewById(R.id.txtCurrentMonth);
        txtErrAttendance=findViewById(R.id.txtErrAttendance);
        txtErrAttendance.setVisibility(View.INVISIBLE);

        getMonths();
        //getAttendanceDetail();
        spnStsAttendance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spnStsAttendance.getSelectedItemPosition()==0){

                }
                else {
                    txtCurrentMonth.setText("Attendance Detail for the month of " + spnStsAttendance.getSelectedItem());
                    monthNum = spnStsAttendance.getSelectedItemPosition();
//                    Toast.makeText(StudentAttendance.this, "Hello " + monthNum, Toast.LENGTH_SHORT).show();
                    getAttendance();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getAttendance() {
        prgStsAttendance.setVisibility(View.VISIBLE);
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.attain_detail_url))
                .build();
        final StudentAttendanceApi studentAttendanceApi=retrofit.create(StudentAttendanceApi.class);

        StudentDetail studentDetail = JsonAndGsonOperation.getStudentDetails(StudentAttendance.this);
        int orgId = studentDetail.getOrganizationId();
        int brnId=studentDetail.getBranchId();
        int batchId=studentDetail.getBranchId();
        int classId=studentDetail.getClassId();
        int stsId= studentDetail.getStudentId();

        Call<List<StudentAttendanceModal>> attendances=studentAttendanceApi.getAttendances(orgId,brnId,batchId,classId,stsId,monthNum);
        attendances.enqueue(new Callback<List<StudentAttendanceModal>>() {
            @Override
            public void onResponse(Call<List<StudentAttendanceModal>> call, Response<List<StudentAttendanceModal>> response) {
                List<StudentAttendanceModal> studentAttendanceModals = response.body();
//                String errorMessage=studentAttendanceModals.get(0).getErrorMessage();
                if( studentAttendanceModals.get(0).getStudentId()!=0) {
                    txtErrAttendance.setVisibility(View.INVISIBLE);
                    SharedPreferences.Editor dataStatusa = getSharedPreferences(Student, MODE_PRIVATE).edit();
                    dataStatusa.putInt("dataStatus", 1);
                    dataStatusa.apply();
                }

                else {
                    prgStsAttendance.setVisibility(View.GONE);
                    SharedPreferences.Editor dataStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
                    dataStatus.putInt("dataStatus", 0);
                    dataStatus.apply();
                }
                    listItemStudentAttendances = new ArrayList<>();
                    try {
                        for (int i = 0; i < studentAttendanceModals.size(); i++) {
                            try {
                                attenDay = studentAttendanceModals.get(i).getAttendanceId();
                            } catch (Exception e) {
                                attenDay = 0;
                            }
                            presentStatus = studentAttendanceModals.get(i).getStudentStatus();
                            ListItemStudentAttendance item = new ListItemStudentAttendance(attenDay, presentStatus);
                            listItemStudentAttendances.add(item);
                        }
                        adapter = new StudentAttendanceAdapter(getApplicationContext(), listItemStudentAttendances);
                        recyclerView.setAdapter(adapter);
                        prgStsAttendance.setVisibility(View.GONE);

                    } catch (Exception e) {

                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        prgStsAttendance.setVisibility(View.GONE);
                        e.printStackTrace();
                    }
                }

            @Override
            public void onFailure(Call<List<StudentAttendanceModal>> call, Throwable t) {
                prgStsAttendance.setVisibility(View.GONE);
                txtErrAttendance.setVisibility(View.VISIBLE);
                SharedPreferences.Editor dataStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
                dataStatus.putInt("dataStatus", 0);
                dataStatus.apply();

                listItemStudentAttendances = new ArrayList<>();
                adapter = new StudentAttendanceAdapter(getApplicationContext(), listItemStudentAttendances);
                recyclerView.setAdapter(adapter);


                //Toast.makeText(StudentAttendance.this, "Error GetAttendance "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void getAttendanceDetail() {
//        prgStsAttendance.setVisibility(View.VISIBLE);
//        final Retrofit retrofit=new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(getString(R.string.attain_detail_url))
//                .build();
//        final StudentAttendanceApi studentAttendanceApi=retrofit.create(StudentAttendanceApi.class);
//        SharedPreferences organization = this.getSharedPreferences(Organization, Context.MODE_PRIVATE);
//        int orgId = organization.getInt("orgId", 0);
//        int brnId=organization.getInt("branchId",0);
//        SharedPreferences student = this.getSharedPreferences(Student, Context.MODE_PRIVATE);
//        int batchId=student.getInt("batchId",0);
//        int classId=student.getInt("classId",0);
//        int stsId=student.getInt("stsId",0);
//        SharedPreferences months = this.getSharedPreferences(Student, Context.MODE_PRIVATE);
//         monthNum=months.getInt("currentMonth",0);
//
//
//        Call<List<StudentAttendanceModal>> attendances=studentAttendanceApi.getAttendances(orgId,brnId,batchId,classId,stsId,monthNum);
//        attendances.enqueue(new Callback<List<StudentAttendanceModal>>() {
//            @Override
//            public void onResponse(Call<List<StudentAttendanceModal>> call, Response<List<StudentAttendanceModal>> response) {
//                List<StudentAttendanceModal> studentAttendanceModals = response.body();
//                String errorMessage=studentAttendanceModals.get(0).getErrorMessage();
//                if( studentAttendanceModals.get(0).getErrorNumber()==null){
//                    SharedPreferences.Editor dataStatusa = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                    dataStatusa.putInt("dataStatus", 1);
//                    dataStatusa.apply();
//                    listItemStudentAttendances = new ArrayList<>();
//
//                    try {
//                        for (int i = 0; i < studentAttendanceModals.size(); i++) {
//                            try {
//                                attenDay = studentAttendanceModals.get(i).getAttendanceId();
//                            } catch (Exception e) {
//                                attenDay = 0;
//                            }
//
//                            presentStatus = studentAttendanceModals.get(i).getStudentStatus();
//                            ListItemStudentAttendance item = new ListItemStudentAttendance(attenDay, presentStatus);
//                            listItemStudentAttendances.add(item);
//                        }
//                        adapter = new StudentAttendanceAdapter(getApplicationContext(), listItemStudentAttendances);
//                        recyclerView.setAdapter(adapter);
//                        prgStsAttendance.setVisibility(View.GONE);
//
//                    } catch (Exception e) {
//
//                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                        prgStsAttendance.setVisibility(View.GONE);
//                        e.printStackTrace();
//                    }
//
//
//                }
//                else {
//                    SharedPreferences.Editor dataStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                    dataStatus.putInt("dataStatus", 0);
//                    dataStatus.apply();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<StudentAttendanceModal>> call, Throwable t) {
//                Toast.makeText(StudentAttendance.this, "Error GetAttendance "+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void getMonths(){
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.get_month_url))
                .build();
        final MonthDetailApi monthDetailApi=retrofit.create(MonthDetailApi.class);
        Call<List<MonthDetailModal>> months=monthDetailApi.getMonths();
        months.enqueue(new Callback<List<MonthDetailModal>>() {
            @Override
            public void onResponse(Call<List<MonthDetailModal>> call, Response<List<MonthDetailModal>> response) {
                List<MonthDetailModal> monthDetailModals=response.body();
                monthNumber = monthDetailModals.get(monthDetailModals.size()-1).getMonthNumber();
                spnStsAttendance.setSelection(monthNumber);

                txtCurrentMonth.setText("Attendance Detail for the month of "+monthDetailModals.get(monthDetailModals.size()-1).getMonthName());


                SharedPreferences sp = getSharedPreferences("month", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("currentMonth", monthNumber);
                editor.apply();

                SharedPreferences.Editor thisMonth = getSharedPreferences(Months, MODE_PRIVATE).edit();
                thisMonth.putString("thisMonth", monthDetailModals.get(monthDetailModals.size()-1).getMonthName());
                thisMonth.apply();
                //Toast.makeText(StudentAttendance.this, monthDetailModals.get(monthDetailModals.size()-1).getMonthNumber(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<MonthDetailModal>> call, Throwable t) {
                Toast.makeText(StudentAttendance.this, "Error GetMonth: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
