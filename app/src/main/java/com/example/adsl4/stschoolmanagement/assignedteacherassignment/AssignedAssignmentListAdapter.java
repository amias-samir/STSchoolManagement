package com.example.adsl4.stschoolmanagement.assignedteacherassignment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.adsl4.stschoolmanagement.R;

import java.util.List;

public class AssignedAssignmentListAdapter extends BaseQuickAdapter<AssignedAssignmentDetail, BaseViewHolder> {

    Context context;

    public AssignedAssignmentListAdapter(Context context ,int layoutResId, @Nullable List<AssignedAssignmentDetail> data) {
        super(layoutResId, data);
        this.context = context;

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

        helper.getView(R.id.main_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(helper.getView(R.id.main_card).getContext(), AsgndAsgmntDtlsActivity.class);
                intent.putExtra("item ", item);
                helper.getView(R.id.main_card).getContext().startActivity(intent);
            }
        });

    }


}