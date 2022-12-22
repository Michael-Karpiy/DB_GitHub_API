package db_github_api.MainComponents;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

import db_github_api.R;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    Context context;
    ArrayList<Model> model;

    public AdapterMain(Context context, ArrayList<Model> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int number) {
        holder.id.setText(model.get(number).getId());
        holder.login.setText(model.get(number).getLogin());

        Glide.with(context).load(model.get(number).getAvatar_url())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.avatar_url);

        holder.cardview.setOnClickListener(view -> {
            Intent intent = new Intent(context, ActivitySecond.class);
            intent.putExtra("login", model.get(number).getLogin());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView login, id;
        ImageView avatar_url;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            login = itemView.findViewById(R.id.login);
            id = itemView.findViewById(R.id.id);
            avatar_url = itemView.findViewById(R.id.avatar_url);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }
}

