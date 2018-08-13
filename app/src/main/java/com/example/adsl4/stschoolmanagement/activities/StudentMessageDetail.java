package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.api.MessageToAdmin;
import com.example.adsl4.stschoolmanagement.modals.MessageToAdminModal;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentMessageDetail extends AppCompatActivity {
    TextView txtMessageDetailHead,txtMessageDetailBody,txtMessageDetailDate;
    EditText edtMessageBody;
    Button btnReplySend;
    String  Student,Organization;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_message_detail);

        txtMessageDetailHead=findViewById(R.id.txtMessageDetailHead);
        txtMessageDetailBody=findViewById(R.id.txtMessageDetailBody);
        txtMessageDetailDate=findViewById(R.id.txtMessageDetailDate);

        Intent intent=getIntent();
        txtMessageDetailHead.setText(intent.getStringExtra("messageHead"));
        txtMessageDetailBody.setText(intent.getStringExtra("messageBody"));
        txtMessageDetailDate.setText(intent.getStringExtra("messageDate"));

        edtMessageBody=findViewById(R.id.edtMessageBody);
        btnReplySend=findViewById(R.id.btnReplySend);
        btnReplySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                SharedPreferences sts = getSharedPreferences(Student, Context.MODE_PRIVATE);
                String usrId = sts.getString("msgUserId", null);
                String msgFromUsr=sts.getString("msgFromId",null);
                int batchId=sts.getInt("batchId",0);

                SharedPreferences org=getSharedPreferences(Organization, Context.MODE_PRIVATE);
                int branchId=org.getInt("branchId",0);
                int organizationId=org.getInt("orgId",0);

                MessageToAdminModal messageToAdminModal= new MessageToAdminModal(
                        0,msgFromUsr,"Reply Message",null,null,null,null,"Reply Message",edtMessageBody.getText().toString(),
                        usrId,null,0,currentTime.toString(),organizationId,branchId,null,null,null,msgFromUsr,
                        currentTime.toString(),null,null,null,null,null,null,null,null,null,null,null,batchId);
                replyToAdmin(messageToAdminModal);
            }
        });
    }
    public void replyToAdmin(MessageToAdminModal messageToAdminModal){
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mobile.sheshayapathshala.com.np/api/StudentDetails/")
                .build();
        final MessageToAdmin messageToAdmin = retrofit.create(MessageToAdmin.class);
        Call<MessageToAdminModal> messages=messageToAdmin.sendMessage(messageToAdminModal);
        messages.enqueue(new Callback<MessageToAdminModal>() {
            @Override
            public void onResponse(Call<MessageToAdminModal> call, Response<MessageToAdminModal> response) {
                String hello=new GsonBuilder().setPrettyPrinting().create().toJson(response);
                Log.w("gson => ",new GsonBuilder().setPrettyPrinting().create().toJson(response));
                for (int i=0;i<10;i++) {
                    Toast.makeText(StudentMessageDetail.this, "Yeah " + call.request().url(), Toast.LENGTH_LONG).show();
                }
                txtMessageDetailBody.setText(hello);
            }

            @Override
            public void onFailure(Call<MessageToAdminModal> call, Throwable t) {
                Toast.makeText(StudentMessageDetail.this, "Error: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
