package com.example.adsl4.stschoolmanagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;

public class StudentAssignmentDetail extends AppCompatActivity {
TextView txtHomeworkNo,txtHomeworkBody,txtHomeworkDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        txtHomeworkNo=findViewById(R.id.txtHomeworkNo);
        txtHomeworkBody=findViewById(R.id.txtHomeworkBody);
        txtHomeworkDate=findViewById(R.id.txtHomeworkDate);

        Intent intent=getIntent();
        txtHomeworkNo.setText(intent.getStringExtra("assignmentId"));
        txtHomeworkBody.setText(intent.getStringExtra("assignmentName"));
        txtHomeworkDate.setText(intent.getStringExtra("assignmentDate"));

    }
}
