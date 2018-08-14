package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.ListItemStudentNotice;
import com.example.adsl4.stschoolmanagement.adapters.StudentNoticeAdapter;
import com.example.adsl4.stschoolmanagement.api.StudentNoticeApi;
import com.example.adsl4.stschoolmanagement.eventbus.NoticeItemSelectEvent;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.notices.FetchNoticies;
import com.example.adsl4.stschoolmanagement.notices.NoticiesListAdapter;
import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentNotices extends AppCompatActivity implements FetchNoticies.NoticesFetchCompleteListener{
    RecyclerView recyclerView;
    public static final String KEY_NOTICE_OBJ = "notices";
    private RecyclerView.Adapter adapter;
    String Organization,noticeHead,noticeDate,noticeDetail,shortDetail;
    private List<ListItemStudentNotice> listItemStudentNotices;
    ProgressBar prgStsDetal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notices);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        recyclerView=findViewById(R.id.recStsNotice);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prgStsDetal=findViewById(R.id.prgStsDetal);
//        getNotices();


        setupListRecycler();
        fetchNoticiesFromServer();


    }

    private void setupListRecycler() {
        NoticiesListAdapter noticiesListAdapter = new NoticiesListAdapter(R.layout.sts_notice_item, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noticiesListAdapter);
    }

    private void fetchNoticiesFromServer(){
        int orgId = 0;
        int branchId = 0;
        SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(StudentNotices.this);

        int userType = sharedPreferenceUtils.getIntValue(SharedPreferenceUtils.KEY_USER_ID, -1);
        Log.d("StudentNotices", "fetchNoticiesFromServer: "+userType);
        if(userType != 0 && userType != 1){
            Toast.makeText(this, "Error fetching data \n retry login", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userType == 0) {
            StudentDetail studentDetail = JsonAndGsonOperation.getStudentDetails(StudentNotices.this);
            orgId = studentDetail.getOrganizationId();
            branchId = studentDetail.getBranchId();
        }
        if(userType == 1) {
            TeacherDetailsResponse teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(StudentNotices.this);
            orgId = teacherDetailsResponse.getOrganizationId();
            branchId = teacherDetailsResponse.getBranchId();
        }

        Log.d("FetchNoticies", "fetchNoticiesFromServer: orgId : "+ orgId + ", BranchId : "+branchId);

        FetchNoticies fetchNoticies = new FetchNoticies();
        fetchNoticies.fetchNoticiesFromServer(StudentNotices.this, orgId, branchId, this);
    }


    @Override
    public void onNoticesFetchComplete(List<StudentNoticeModal> studentNoticeModals) {
//        sts_notice_item adapter_layout
        prgStsDetal.setVisibility(View.GONE);
        ((NoticiesListAdapter) recyclerView.getAdapter()).replaceData(studentNoticeModals);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    public void onRVNoticetemClick(NoticeItemSelectEvent.NoticeItemClick itemClick) {
        Intent intent = new Intent(StudentNotices.this, StudentNoticeDetail.class);
        intent.putExtra(KEY_NOTICE_OBJ, itemClick.getNoticeData());
        startActivity(intent);
        Toast.makeText(this, ""+itemClick.getNoticeData().getFullDescription(), Toast.LENGTH_SHORT).show();
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
