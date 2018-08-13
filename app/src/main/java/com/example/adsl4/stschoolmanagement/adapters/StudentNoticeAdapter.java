package com.example.adsl4.stschoolmanagement.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.StudentNoticeDetail;

import java.util.List;

/**
 * Created by adsl4 on 4/26/18.
 */

public class StudentNoticeAdapter extends RecyclerView.Adapter<StudentNoticeAdapter.NoticeViewHolder> {

    private Context  context;
    private List<ListItemStudentNotice> items;
    String date,head,detail;

    public StudentNoticeAdapter(Context context, List<ListItemStudentNotice> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sts_notice_item,parent,false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder holder, final int position) {
        final ListItemStudentNotice listItemStudentNotice =items.get(position);
        head= listItemStudentNotice.getHead();
        String realdate= listItemStudentNotice.getDate();
        String[] splitDate=realdate.split("T");
        date="Published Date: "+splitDate[0];
        detail= listItemStudentNotice.getDetail();
        holder.txtNoticeHead.setText(head);
        holder.txtNoticeDate.setText(date);
        holder.txtNoticeShort.setText(listItemStudentNotice.getShortDetail());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, StudentNoticeDetail.class);
                i.putExtra("detail",listItemStudentNotice.getDetail());
                i.putExtra("head",listItemStudentNotice.getHead());
                String realdate= listItemStudentNotice.getDate();
                String[] splitDate=realdate.split("T");
                date="Published Date: "+splitDate[0];
                i.putExtra("date",date);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder{
        TextView txtNoticeHead,txtNoticeDate,txtNoticeShort;
        public LinearLayout linearLayout;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            txtNoticeHead=itemView.findViewById(R.id.txtNoticeHead);
            txtNoticeDate=itemView.findViewById(R.id.txtNoticeDate);
            linearLayout =itemView.findViewById(R.id.lnrStsNotice);
            txtNoticeShort=itemView.findViewById(R.id.txtNoticeShort);

        }
    }

}

