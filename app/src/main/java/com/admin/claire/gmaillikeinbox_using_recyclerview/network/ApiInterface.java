package com.admin.claire.gmaillikeinbox_using_recyclerview.network;

import com.admin.claire.gmaillikeinbox_using_recyclerview.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by claire on 2017/9/19.
 * 這個類包含了請求的接口，這裡我們只有一個inbox.json接口
 */

public interface ApiInterface {
    @GET("inbox.json")
    Call<List<Message>> getInbox();
}
