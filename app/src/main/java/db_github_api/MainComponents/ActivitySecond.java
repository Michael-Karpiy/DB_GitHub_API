package db_github_api.MainComponents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.Objects;

import db_github_api.API.ApiClient;
import db_github_api.API.JsonAPI;
import db_github_api.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySecond extends AppCompatActivity {

    EditText et_login, et_id,et_node_id,et_gravatar_id,et_url,et_html_url;
    ImageView iv_avatar_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_login = findViewById(R.id.et_login);
        et_id = findViewById(R.id.et_id);
        et_node_id = findViewById(R.id.et_node_id);
        et_gravatar_id = findViewById(R.id.et_gravatar_id);
        et_url = findViewById(R.id.et_url);
        et_html_url = findViewById(R.id.et_html_url);

        iv_avatar_url = findViewById(R.id.avatar_url);

        Intent intent = getIntent();
        String login = intent.getStringExtra("login");

        JsonAPI jsonAPI = ApiClient.getApiClient().create(JsonAPI.class);
        Call<Model> call = jsonAPI.getUsers(login);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {

                Glide.with(ActivitySecond.this).load(Objects.requireNonNull(response.body()).getAvatar_url())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(iv_avatar_url);

                et_login.setText(Objects.requireNonNull(response.body()).getLogin());
                et_id.setText(Objects.requireNonNull(response.body()).getId());
                et_node_id.setText(Objects.requireNonNull(response.body()).getNode_id());
                et_gravatar_id.setText(Objects.requireNonNull(response.body()).getGravatar_id());
                et_url.setText(Objects.requireNonNull(response.body()).getUrl());
                et_html_url.setText(Objects.requireNonNull(response.body()).getHtml_url());

            }

            @Override
            public void onFailure(@NonNull Call<Model> call, @NonNull Throwable t) {

            }
        });
    }
}