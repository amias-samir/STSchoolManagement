package com.example.adsl4.stschoolmanagement.notices;

import android.content.Context;
import android.util.Log;

import com.example.adsl4.stschoolmanagement.network.NetworkApiClient;
import com.example.adsl4.stschoolmanagement.network.NetworkApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FetchNoticies {

    private String TAG = "FetchNoticies";
    private NoticesFetchCompleteListener listener;


    public void fetchNoticiesFromServer(Context context, int organizationId, int branchId, final NoticesFetchCompleteListener listener){
        this.listener = listener;

        final List<StudentNoticeModal> studentNoticeModals = new ArrayList<StudentNoticeModal>();

        NetworkApiInterface apiService = NetworkApiClient.getAPIClient().create(NetworkApiInterface.class);

        Log.d(TAG, "FetchFormViewsetList: ");

        apiService.getNotices(organizationId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<StudentNoticeModal>>(){

                    @Override
                    public void onNext(List<StudentNoticeModal> noticesListFromServer) {
                        studentNoticeModals.addAll(noticesListFromServer);
                        Log.d(TAG, "onNext: "+studentNoticeModals.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "FetchFormViewsetList: error "+e.getMessage());
                        Log.d(TAG, "FetchFormViewsetList: error "+e.getCause());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: "+studentNoticeModals.size());

                       listener.onNoticesFetchComplete( studentNoticeModals);

                    }
                });
    }

    public interface NoticesFetchCompleteListener {
        void onNoticesFetchComplete(List<StudentNoticeModal> studentNoticeModals);

    }
}
