package com.example.adsl4.stschoolmanagement.assignedteacherassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AsgndAsgmntDtlsActivity extends AppCompatActivity {

    @BindView(R.id.txtHomeworkNo)
    TextView txtHomeworkNo;
    @BindView(R.id.txtHomeworkBody)
    TextView txtHomeworkBody;
    @BindView(R.id.txtHomeworkDate)
    TextView txtHomeworkDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asgnd_asgmnt_dtls);
        ButterKnife.bind(this);

        AssignedAssignmentDetail assignedAssignmentDetail = getIntent().getExtras().getParcelable("item");

        try {
            txtHomeworkNo.setText(assignedAssignmentDetail.getClassSubjectName());
            txtHomeworkBody.setText(Html.fromHtml(assignedAssignmentDetail.getAssignment()));

            String realdate= assignedAssignmentDetail.getCreatedDate();
            String[] splitDate=realdate.split("T");
            String assignmentDate="Assignment Date: "+splitDate[0];
            txtHomeworkDate.setText(assignmentDate);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
