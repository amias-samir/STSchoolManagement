package com.example.adsl4.stschoolmanagement.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.StudentAssignmentDetail;

import java.util.List;

/**
 * Created by adsl4 on 5/18/18.
 */

public class StudentAssignmentAdapter extends RecyclerView.Adapter<StudentAssignmentAdapter.AssignmentViewHolder> {
    Context context;
    private List<ListItemStudentAssignment> items;
    private int assignmentId;
    private String assignmentName;
    private String assignmentDate,asigNo;


    public StudentAssignmentAdapter(Context context, List<ListItemStudentAssignment> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sts_assignment_item,parent,false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {
        final ListItemStudentAssignment listItemStudentAssignment =items.get(position);
        assignmentId=listItemStudentAssignment.getAssignmentId();
        assignmentName=listItemStudentAssignment.getAssignmentName();
        String realdate= listItemStudentAssignment.getAssignmentDate();
        String[] splitDate=realdate.split("T");
        assignmentDate="Assignment Date: "+splitDate[0];
        holder.txtAssignmentNo.setText("QNo. "+String.valueOf(assignmentId));
        holder.txtAssignmentBody.setText(Html.fromHtml(assignmentName));
        holder.txtAssignmentDate.setText(assignmentDate);
        asigNo="QNo. "+String.valueOf(assignmentId);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, StudentAssignmentDetail.class);
                i.putExtra("assignmentId","QNo. "+String.valueOf(listItemStudentAssignment.getAssignmentId()));
                String SplitDates[]= listItemStudentAssignment.getAssignmentDate().split("T");
                i.putExtra("assignmentName",Html.fromHtml(listItemStudentAssignment.getAssignmentName()).toString());
                i.putExtra("assignmentDate","Assignment Date: "+SplitDates[0]);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder{
        TextView txtAssignmentNo,txtAssignmentBody,txtAssignmentDate;
        public LinearLayout linearLayout;

        public AssignmentViewHolder(View itemView) {
            super(itemView);
            txtAssignmentNo=itemView.findViewById(R.id.txtAssignmentNo);
            txtAssignmentBody=itemView.findViewById(R.id.txtAssignmentBody);
            linearLayout =itemView.findViewById(R.id.lnrStsAssignment);
            txtAssignmentDate=itemView.findViewById(R.id.txtAssignmentDate);

        }
    }

}
