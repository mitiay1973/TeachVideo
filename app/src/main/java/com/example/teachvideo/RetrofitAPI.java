package com.example.teachvideo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("Video")

    Call<DataModal> createPost(@Body DataModal dataModal);
}
