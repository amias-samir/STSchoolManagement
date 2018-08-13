package com.example.adsl4.stschoolmanagement.teacherattendance;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.eventbus.AttendanceStudentSelectEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class TeacherAttendanceAdapter extends BaseQuickAdapter<StudentAttendance, BaseViewHolder> {


    public TeacherAttendanceAdapter(int layoutResId, @Nullable List<StudentAttendance> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(final BaseViewHolder helper, final StudentAttendance item) {
        helper.setText(R.id.txtStudentName, item.getStudentName());
//        helper.setText(R.id.txtNoticeDate,item.getCreatedDate().toString());
//        helper.setText(R.id.txtNoticeShort,item.getShortDesc());
        final CheckBox cbAttendancePresent = helper.getView(R.id.chkAttendancePresent);
        final CheckBox cbAttendanceAbsent = helper.getView(R.id.chkAttendanceAbsent);

        cbAttendancePresent.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            cbAttendanceAbsent.setChecked(false);
                            String status = "Present";
                            AttendanceDetails attendanceDetails = new AttendanceDetails(item, helper.getAdapterPosition(), status);
                            EventBus.getDefault().post(new AttendanceStudentSelectEvent.StudentAttendanceItemClick(attendanceDetails));
                        }

                    }
                }
        );

        cbAttendanceAbsent.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            cbAttendancePresent.setChecked(false);
                            String status = "Absent";
                            AttendanceDetails attendanceDetails = new AttendanceDetails(item, helper.getAdapterPosition(), status);
                            EventBus.getDefault().post(new AttendanceStudentSelectEvent.StudentAttendanceItemClick(attendanceDetails));

                        }

                    }
                }
        );

    }


}