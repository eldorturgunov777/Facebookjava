package com.example.facebookjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookjava.R;
import com.example.facebookjava.model.Story;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook java
 * eldorturgunov777@gmail.com
 */
public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Story> items;
    int TYPE_ITEM_HEADER = 0;

    public StoryAdapter(Context context, ArrayList<Story> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_HEADER) {
            View header = LayoutInflater.from(context).inflate(R.layout.item_first_story, parent, false);
            return new FilterFirstViewHolder(header);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position)) return;
        Story data = items.get(position);
        if (holder instanceof StoryViewHolder) {
            ((StoryViewHolder) holder).iv_background.setImageResource(data.getProfile());
            ((StoryViewHolder) holder).iv_profile.setImageResource(data.getProfile());
            ((StoryViewHolder) holder).tv_fullname.setText(data.getFullname());
        }
    }



    public boolean isHeader(int position) {
        return position == 0;
    }

    public static class FilterFirstViewHolder extends RecyclerView.ViewHolder {

        public FilterFirstViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_background;
        ShapeableImageView iv_profile;
        TextView tv_fullname;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_background = itemView.findViewById(R.id.iv_background);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
