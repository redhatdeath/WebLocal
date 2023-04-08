package ru.shanin.weblocal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.shanin.weblocal.api.APIServiceConstructor;
import ru.shanin.weblocal.api.local.APIConfigLocal;
import ru.shanin.weblocal.api.local.APIServiceLocal;
import ru.shanin.weblocal.api.local.data.DataGet;
import ru.shanin.weblocal.api.local.data.DataPost;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private SwipeRefreshLayout srl;
    private APIServiceLocal service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createService();
        initView();

    }

    private void initView() {
        tv = findViewById(R.id.tv);
        srl = findViewById(R.id.srl);
        //srl.setOnRefreshListener(this::loadGet);
        //srl.setOnRefreshListener(this::loadPostAll);
        srl.setOnRefreshListener(this::loadPostRequest);
        //loadGet();
        //loadPostAll();
        loadPostRequest();
    }

    private void createService() {
        service = APIServiceConstructor.CreateService(
                APIServiceLocal.class,
                APIConfigLocal.HOST_URL);
    }

    private void loadGet() {
        srl.setRefreshing(true);
        AsyncTask.execute(() -> {
            Call<DataGet> call_get = service.getGet();
            call_get.enqueue(new Callback<DataGet>() {
                @Override
                public void onResponse(@NonNull Call<DataGet> call, @NonNull Response<DataGet> response) {
                    if (response.body() != null) {
                        String text = (new Gson()).toJson(response.body());
                        tv.setText(text);
                        Log.d("ResponseData", text);
                    }
                    srl.setRefreshing(false);
                }

                @Override
                public void onFailure(@NonNull Call<DataGet> call, @NonNull Throwable t) {
                    tv.setText(t.toString());
                    Log.d("ResponseData", t.toString());
                    srl.setRefreshing(false);
                }
            });
        });
    }
    private void loadPostAll() {
        srl.setRefreshing(true);
        AsyncTask.execute(() -> {
            Call<ArrayList<DataPost>> call_get = service.getPostAll();
            call_get.enqueue(new Callback<ArrayList<DataPost>>() {
                @Override
                public void onResponse(
                        @NonNull Call<ArrayList<DataPost>> call,
                        @NonNull Response<ArrayList<DataPost>> response) {
                    if (response.body() != null) {
                        String text = (new Gson()).toJson(response.body());
                        tv.setText(text);
                        Log.d("ResponseData", text);
                    }
                    srl.setRefreshing(false);
                }

                @Override
                public void onFailure(
                        @NonNull Call<ArrayList<DataPost>> call,
                        @NonNull Throwable t) {
                    tv.setText(t.toString());
                    Log.d("ResponseData", t.toString());
                    srl.setRefreshing(false);
                }
            });
        });
    }
    private void loadPostRequest() {
        srl.setRefreshing(true);
        AsyncTask.execute(() -> {
            Call<ArrayList<DataPost>> call_get = service.getPostRequest(2,2);
            call_get.enqueue(new Callback<ArrayList<DataPost>>() {
                @Override
                public void onResponse(
                        @NonNull Call<ArrayList<DataPost>> call,
                        @NonNull Response<ArrayList<DataPost>> response) {
                    if (response.body() != null) {
                        String text = (new Gson()).toJson(response.body());
                        tv.setText(text);
                        Log.d("ResponseData", text);
                    }
                    srl.setRefreshing(false);
                }

                @Override
                public void onFailure(
                        @NonNull Call<ArrayList<DataPost>> call,
                        @NonNull Throwable t) {
                    tv.setText(t.toString());
                    Log.d("ResponseData", t.toString());
                    srl.setRefreshing(false);
                }
            });
        });
    }
}