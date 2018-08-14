package com.example.adsl4.stschoolmanagement.assignedteacherassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.AssignmentStudent;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.network.NetworkApiClient;
import com.example.adsl4.stschoolmanagement.network.NetworkApiInterface;
import com.example.adsl4.stschoolmanagement.teacherattendance.TeacherAttendanceAdapter;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AssignedAssgnmntActivity extends AppCompatActivity {

    private static final String TAG ="AssignedAssgnmnt" ;
    @BindView(R.id.recStsAssignment)
    RecyclerView recStsAssignment;
    @BindView(R.id.prgStsAssignment)
    ProgressBar prgStsAssignment;
    @BindView(R.id.tv_no_data_found)
    TextView tvNoDataFound;

    int orgId, branchId, employeeId;
    String Student, Organization, assignmentName, assignmentDate;
    private List<AssignedAssignmentDetail> assignedAssignmentDetailList = new ArrayList<AssignedAssignmentDetail>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigned_assgnmnt);
        ButterKnife.bind(this);

        recStsAssignment.setHasFixedSize(true);
        recStsAssignment.setLayoutManager(new LinearLayoutManager(this));

        TeacherDetailsResponse teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(AssignedAssgnmntActivity.this);
        orgId = teacherDetailsResponse.getOrganizationId();
        branchId = teacherDetailsResponse.getBranchId();
        employeeId = teacherDetailsResponse.getEmployeeDetailId();


        setupListRecycler();

        fetchAssignedAssignmentFromServer();

    }
    private void setupListRecycler() {
        AssignedAssignmentListAdapter assignedAssignmentListAdapter = new AssignedAssignmentListAdapter(R.layout.sts_assignment_item, null);
        recStsAssignment.setLayoutManager(new LinearLayoutManager(this));
        recStsAssignment.setAdapter(assignedAssignmentListAdapter);
    }


    private void fetchAssignedAssignmentFromServer(){
        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);

        apiService.getAssignedAssignmentDetails(orgId, branchId, employeeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<AssignedAssignmentDetail>>() {
                    @Override
                    public void onNext(List<AssignedAssignmentDetail> assignedAssignmentDetails) {
                        Log.d(TAG, "onNext: size "+assignedAssignmentDetails.size());

                        assignedAssignmentDetailList.addAll(assignedAssignmentDetails);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, " error "+e.getMessage());
                        Log.d(TAG, " error "+e.getCause());
                    }

                    @Override
                    public void onComplete() {
                        if (assignedAssignmentDetailList.size() <= 0) {
                            prgStsAssignment.setVisibility(View.GONE);
                            tvNoDataFound.setVisibility(View.VISIBLE);
                            Toast.makeText(AssignedAssgnmntActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        try {
                            tvNoDataFound.setVisibility(View.GONE);
                            prgStsAssignment.setVisibility(View.GONE);
                            ((AssignedAssignmentListAdapter) recStsAssignment.getAdapter()).replaceData(assignedAssignmentDetailList);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
