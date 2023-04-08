package ru.shanin.weblocal.api.local;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.shanin.weblocal.api.local.data.DataGet;
import ru.shanin.weblocal.api.local.data.DataPost;

public interface APIServiceLocal {
    @GET("/")
    Call<DataGet> getGet();

    @POST("/all")
    Call<ArrayList<DataPost>> getPostAll();

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded()
    @POST("/request")
    Call<ArrayList<DataPost>> getPostRequest(
            @Field("mark_min") int min,
            @Field("mark_max")int max
    );

}
