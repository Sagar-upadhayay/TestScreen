package com.testscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.testscreen.Model.HeadLine;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
     private Context context;
    private List<HeadLine> headline;

    public CustomAdapter(Context context, List<HeadLine> headline) {
        this.context = context;
        this.headline = headline;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsample, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


        holder.textViewTile.setText(headline.get(position).getTitle());
        holder.textViewSource.setText(headline.get(position).getSource().getName());
        holder.Description.setText(headline.get(position).getDescription());
        holder.Publish.setText(headline.get(position).getPublishedAt());
        if (headline.get(position).getUrlToImage() != null) {
            Picasso.get().load(headline.get(position).getUrlToImage()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return headline.size();
    }
}
