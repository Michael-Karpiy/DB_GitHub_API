package db_github_api.MainComponents;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import db_github_api.API.ApiClient;
import db_github_api.API.JsonAPI;
import db_github_api.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMain extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        window.setNavigationBarColor(Color.TRANSPARENT);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        JsonAPI jsonAPI = ApiClient.getApiClient().create(JsonAPI.class);
        Call<ArrayList<Model>> call = jsonAPI.getUsers();
        call.enqueue(new Callback<ArrayList<Model>>() {
                    @Override
                    public void onResponse(@NonNull Call<ArrayList<Model>> call, @NonNull Response<ArrayList<Model>> response) {
                        ArrayList<Model> list = response.body();
                        createRecyclerView(list);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArrayList<Model>> call, @NonNull Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());
                    }
                });
    }

    private void createRecyclerView(ArrayList<Model> model) {
        AdapterMain adapterMain = new AdapterMain(ActivityMain.this, model);
        recyclerView.setAdapter(adapterMain);
    }
}