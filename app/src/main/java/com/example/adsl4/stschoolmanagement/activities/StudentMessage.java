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
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.adapters.ListItemStudentMessage;
import com.example.adsl4.stschoolmanagement.adapters.StudentMessageAdapter;
import com.example.adsl4.stschoolmanagement.api.StudentMessageApi;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.modals.StudentMessageModal;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentMessage extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    String Organization,Student,messageHead,messageDate,messageDetail,usrId,usrFromId;
    private List<ListItemStudentMessage> listItemStudentMessages;
    ProgressBar prgStsMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        recyclerView=findViewById(R.id.recStsMessage);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prgStsMessage=findViewById(R.id.prgStsMessage);
        getMessage();
    }


    private void getMessage() {
        final Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.sts_msg_url))
                .build();
        final StudentMessageApi studentMessageApi=retrofit.create(StudentMessageApi.class);

        StudentDetail studentDetail = JsonAndGsonOperation.getStudentDetails(StudentMessage.this);
        Log.d("LoginResponse", "getMessage: "+studentDetail.getUserId() +" ,  "+ studentDetail.getOrganizationId()+" ,  " + studentDetail.getBatchId());

//        Call<List<StudentMessageModal>> notices=studentMessageApi.getMessage(userId, orgId, branchId);
        Call<List<StudentMessageModal>> notices=studentMessageApi.getMessage(studentDetail.getUserId(),
                studentDetail.getOrganizationId(),
                studentDetail.getBranchId());
        notices.enqueue(new Callback<List<StudentMessageModal>>() {
            @Override
            public void onResponse(Call<List<StudentMessageModal>> call, Response<List<StudentMessageModal>> response) {
                List<StudentMessageModal> studentMessageDetails=response.body();
                listItemStudentMessages = new ArrayList<>();
                Log.d("StudentMessage", "onResponse: "+response.body().size() );

                try {
                    for (int i = 0; i < studentMessageDetails.size(); i++) {
                        try {
                            messageHead = studentMessageDetails.get(i).getDisplayName();
                        }
                        catch (Exception e){
                            messageHead="Nothing to show";
                        }
                        usrId=studentMessageDetails.get(i).getUserId();
                        usrFromId=studentMessageDetails.get(i).getMessageFrom();
                        messageDate = studentMessageDetails.get(i).getCreatedDate();
                        messageDetail=studentMessageDetails.get(i).getMessageDescription();
                        ListItemStudentMessage item = new ListItemStudentMessage(messageHead, messageDetail, messageDate,usrId,usrFromId);
                        listItemStudentMessages.add(item);
                    }
                    adapter = new StudentMessageAdapter(getApplicationContext(), listItemStudentMessages);
                    recyclerView.setAdapter(adapter);
                    prgStsMessage.setVisibility(View.GONE);

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    prgStsMessage.setVisibility(View.GONE);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<StudentMessageModal>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
