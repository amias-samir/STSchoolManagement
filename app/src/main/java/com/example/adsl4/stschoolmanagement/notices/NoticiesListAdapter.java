package com.example.adsl4.stschoolmanagement.notices;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.eventbus.NoticeItemSelectEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class NoticiesListAdapter extends BaseQuickAdapter<StudentNoticeModal, BaseViewHolder> {


    public NoticiesListAdapter(int layoutResId, @Nullable List<StudentNoticeModal> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, final StudentNoticeModal item) {
        helper.setText(R.id.txtNoticeHead,item.getDisplayName());
        helper.setText(R.id.txtNoticeDate,item.getCreatedDate().toString());
        helper.setText(R.id.txtNoticeShort,item.getShortDesc());
        helper.getView(R.id.lnrStsNotice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new NoticeItemSelectEvent.NoticeItemClick(item));
            }
        });


    }



}