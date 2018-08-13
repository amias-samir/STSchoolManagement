package com.example.adsl4.stschoolmanagement.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by adsl4 on 4/26/18.
 */

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.AttendanceViewHolder> {

    private Context  context;
    private List<ListItemStudentAttendance> items;
   private String presentStatus,detail,Months,attainDaytest,Student;
   private int attainDay;

    public StudentAttendanceAdapter(Context context, List<ListItemStudentAttendance> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public AttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(com.example.adsl4.stschoolmanagement.R.layout.sts_attendance_item,parent,false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendanceViewHolder holder, final int position) {
        final ListItemStudentAttendance listItemStudentAttendance =items.get(position);
        SharedPreferences dataStatuss = context.getSharedPreferences(Student, Context.MODE_PRIVATE);
        int dataStatus = dataStatuss.getInt("dataStatus", 0);
        if (dataStatus==0){
            Toast.makeText(context, "Hello" + dataStatus, Toast.LENGTH_SHORT).show();
            holder.linearLayout.setVisibility(View.INVISIBLE);
            holder.crdStsAttendance.setVisibility(View.INVISIBLE);
        }
       else{

                holder.linearLayout.setVisibility(View.VISIBLE);
                holder.crdStsAttendance.setVisibility(View.VISIBLE);
                attainDay = listItemStudentAttendance.getAttenDay();
                presentStatus = listItemStudentAttendance.getPresentStatus();
                SharedPreferences organization = context.getSharedPreferences(Months, Context.MODE_PRIVATE);
                String thisMonth = organization.getString("thisMonth", null);
            for (int i=0;i<10;i++) {
                holder.txtStsAttendanceDay.setText(thisMonth + " " + String.valueOf(attainDay));
                if (presentStatus.equals("Present")) {
                    holder.chkStsPresent.setChecked(true);
                } else {
                    holder.chkStsAbsent.setChecked(true);
                }
            }

//        holder.txtAttenMonth.setText("Hello");
                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class AttendanceViewHolder extends RecyclerView.ViewHolder{
        TextView txtStsAttendanceDay,txtAttenMonth;
        CheckBox chkStsPresent,chkStsAbsent;
        CardView crdStsAttendance;
        public LinearLayout linearLayout;

        private AttendanceViewHolder(View itemView) {
            super(itemView);
            txtStsAttendanceDay=itemView.findViewById(com.example.adsl4.stschoolmanagement.R.id.txtStsAttendanceDay);
            chkStsPresent=itemView.findViewById(com.example.adsl4.stschoolmanagement.R.id.chkStsPresent);
            linearLayout =itemView.findViewById(com.example.adsl4.stschoolmanagement.R.id.lnrStsAttendances);
            chkStsAbsent=itemView.findViewById(com.example.adsl4.stschoolmanagement.R.id.chkStsAbsent);
            crdStsAttendance=itemView.findViewById(com.example.adsl4.stschoolmanagement.R.id.crdStsAttendance);
            //txtAttenMonth=itemView.findViewById(R.id.txtAttenMonth);


        }
    }

}

