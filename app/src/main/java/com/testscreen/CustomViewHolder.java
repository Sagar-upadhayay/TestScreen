package com.testscreen;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView textViewTile,textViewSource,Description,Publish;
    ImageView imageView;
    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTile = itemView.findViewById(R.id.titletxt);
        Description = itemView.findViewById(R.id.Description);
        textViewSource = itemView.findViewById(R.id.Source);
        cardView = itemView.findViewById(R.id.cardview);
        imageView = itemView.findViewById(R.id.imgHeadline);
        Publish = itemView.findViewById(R.id.PublishedAt);
    }
}
