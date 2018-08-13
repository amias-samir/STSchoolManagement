package com.example.adsl4.stschoolmanagement.api;

import com.example.adsl4.stschoolmanagement.modals.MessageToAdminModal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MessageToAdmin {
    @POST("ReplyToAdmin")
    Call<MessageToAdminModal> sendMessage(@Body MessageToAdminModal messageToAdminModal);
}
