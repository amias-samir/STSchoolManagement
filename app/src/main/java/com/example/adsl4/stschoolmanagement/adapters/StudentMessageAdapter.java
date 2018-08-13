package com.example.adsl4.stschoolmanagement.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.activities.StudentMessageDetail;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by adsl4 on 5/18/18.
 */

public class StudentMessageAdapter extends RecyclerView.Adapter<StudentMessageAdapter.MessageViewHolder> {
    Context context;
    private List<ListItemStudentMessage> items;
    String msgName,msgBody,msgDate,Student;


    public StudentMessageAdapter(Context context, List<ListItemStudentMessage> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sts_message_item,parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        final ListItemStudentMessage listItemStudentMessage =items.get(position);
        msgName=listItemStudentMessage.getMsgShortDes();
        msgBody=listItemStudentMessage.getMsgBody();

        try {

            String realdate= listItemStudentMessage.getMsgDate();
            Log.e("StudentMessageAdapter", "onBindViewHolder: "+realdate );
            String[] splitDate=realdate.split("T");
            String messageDate="Message Date: "+splitDate[0];
            holder.txtMessageDate.setText(messageDate);
        }catch (NullPointerException e){
            e.printStackTrace();
        }


        holder.txtMessageHead.setText(msgName);
        holder.txtMessageBody.setText(msgBody);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = context.getSharedPreferences(Student, MODE_PRIVATE).edit();
                editor.putString("msgUserId", listItemStudentMessage.getUsrId());
                editor.putString("msgFromId",listItemStudentMessage.getUsrFromId());
                editor.apply();
                Intent i=new Intent(context, StudentMessageDetail.class);
                i.putExtra("messageHead",listItemStudentMessage.getMsgShortDes());
                if(TextUtils.isEmpty(listItemStudentMessage.getMsgDate())) {
//                    String SplitDates[] = listItemStudentMessage.getMsgDate().split("T");
                    i.putExtra("messageDate", "Message Date: Date not found" );
                }else {
                    String SplitDates[] = listItemStudentMessage.getMsgDate().split("T");
                    i.putExtra("messageDate", "Message Date: " + SplitDates[0]);
                }

                i.putExtra("messageBody",listItemStudentMessage.getMsgBody());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        TextView txtMessageHead,txtMessageBody,txtMessageDate;
        public LinearLayout linearLayout;

        public MessageViewHolder(View itemView) {
            super(itemView);
            txtMessageHead=itemView.findViewById(R.id.txtMessageHead);
            txtMessageBody=itemView.findViewById(R.id.txtMessageBody);
            txtMessageDate=itemView.findViewById(R.id.txtMessageDate);
            linearLayout =itemView.findViewById(R.id.lnrStsMessage);


        }
    }

}
