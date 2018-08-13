package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.ListItemStudentAssignment;
import com.example.adsl4.stschoolmanagement.adapters.StudentAssignmentAdapter;
import com.example.adsl4.stschoolmanagement.api.StudentAssignmentApi;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.modals.StudentAssignmentModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AssignmentStudent extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ProgressBar prgStsAssignment;
    TextView tvNoDataFound;
    int orgId, branchId, classId, sectionId, batchId, assignmentNo;
    String Student, Organization, assignmentName, assignmentDate;
    private List<ListItemStudentAssignment> listItemStudentAssignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_student);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        recyclerView = findViewById(R.id.recStsAssignment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prgStsAssignment = findViewById(R.id.prgStsAssignment);
        tvNoDataFound = findViewById(R.id.tv_no_data_found);
        getAssignment();
    }

    private void getAssignment() {
        StudentDetail studentDetail = JsonAndGsonOperation.getStudentDetails(AssignmentStudent.this);
        batchId = studentDetail.getBatchId();
        classId = studentDetail.getClassId();
//        sectionId=Integer.parseInt(studentDetail.getSectionId().toString());
        orgId = studentDetail.getOrganizationId();
        branchId = studentDetail.getBranchId();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.assignment_base_url))
                .build();
        StudentAssignmentApi studentAssignmentApi = retrofit.create(StudentAssignmentApi.class);

        Call<List<StudentAssignmentModal>> assignments = studentAssignmentApi.getAssignments(orgId, branchId, batchId, classId);
        assignments.enqueue(new Callback<List<StudentAssignmentModal>>() {
            @Override
            public void onResponse(Call<List<StudentAssignmentModal>> call, Response<List<StudentAssignmentModal>> response) {
                List<StudentAssignmentModal> studentAssignmentModal = response.body();
                listItemStudentAssignments = new ArrayList<>();
                Log.d("AssignmentStudent", "onResponse: " + listItemStudentAssignments.size());


                if (listItemStudentAssignments.size() <= 0) {
                    prgStsAssignment.setVisibility(View.GONE);
                    tvNoDataFound.setVisibility(View.VISIBLE);
                    Toast.makeText(AssignmentStudent.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    tvNoDataFound.setVisibility(View.GONE);
                    for (int i = 0; i < studentAssignmentModal.size(); i++) {
                        assignmentNo = studentAssignmentModal.get(i).getAssignmentId();
                        assignmentDate = studentAssignmentModal.get(i).getCreatedDate();
                        assignmentName = studentAssignmentModal.get(i).getAssignmentName();
                        ListItemStudentAssignment item = new ListItemStudentAssignment(assignmentNo, assignmentName, assignmentDate);
                        listItemStudentAssignments.add(item);
                    }
                    adapter = new StudentAssignmentAdapter(getApplicationContext(), listItemStudentAssignments);
                    recyclerView.setAdapter(adapter);
                    prgStsAssignment.setVisibility(View.GONE);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<StudentAssignmentModal>> call, Throwable t) {

            }
        });

    }
}
