package com.example.adsl4.stschoolmanagement.assignedteacherassignment;

import android.support.annotation.Nullable;
import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.adsl4.stschoolmanagement.R;

import java.util.List;

public class AssignedAssignmentListAdapter extends BaseQuickAdapter<AssignedAssignmentDetail, BaseViewHolder> {


    public AssignedAssignmentListAdapter(int layoutResId, @Nullable List<AssignedAssignmentDetail> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(final BaseViewHolder helper, final AssignedAssignmentDetail item) {
//        helper.setText(R.id.txtAssignmentNo, "QNo. "+String.valueOf(item.));

        try {
            helper.setText(R.id.txtAssignmentNo, item.getClassSubjectName());
            helper.setText(R.id.txtAssignmentBody,Html.fromHtml(item.getAssignment()));

            String realdate= item.getCreatedDate();
            String[] splitDate=realdate.split("T");
            String assignmentDate="Assignment Date: "+splitDate[0];
            helper.setText(R.id.txtAssignmentDate,assignmentDate);
        }catch (NullPointerException e){
            e.printStackTrace();
        }


//        String realdate= listItemStudentAssignment.getAssignmentDate();
//        String[] splitDate=realdate.split("T");
////        assignmentDate="Assignment Date: "+splitDate[0];
//        holder.txtAssignmentNo.setText("QNo. "+String.valueOf(assignmentId));
//        holder.txtAssignmentBody.setText(Html.fromHtml(assignmentName));
//        holder.txtAssignmentDate.setText(assignmentDate);
//        asigNo="QNo. "+String.valueOf(assignmentId);

    }


}