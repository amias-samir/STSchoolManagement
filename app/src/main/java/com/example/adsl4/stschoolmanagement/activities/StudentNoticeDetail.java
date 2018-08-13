package com.example.adsl4.stschoolmanagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;

public class StudentNoticeDetail extends AppCompatActivity {
    TextView txtNoticeDetailHead,txtNoticeDetailBody,txtNoticeDetailDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notice_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        txtNoticeDetailHead=findViewById(R.id.txtNoticeDetailHead);
        txtNoticeDetailBody=findViewById(R.id.txtNoticeDetailBody);
        txtNoticeDetailDate=findViewById(R.id.txtNoticeDetailDate);

        StudentNoticeModal studentNoticeModal = getIntent().getExtras().getParcelable(StudentNotices.KEY_NOTICE_OBJ);



        txtNoticeDetailHead.setText(studentNoticeModal.getDisplayName());
        txtNoticeDetailBody.setText(studentNoticeModal.getFullDescription());
        txtNoticeDetailDate.setText(studentNoticeModal.getCreatedDate().toString());

    }
}
