package com.example.facebookjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookjava.R;
import com.example.facebookjava.model.Feed;
import com.example.facebookjava.model.Story;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook java
 * eldorturgunov777@gmail.com
 */
public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int TYPE_ITEM_HEAD = 0;
    int TYPE_ITEM_STORY = 1;
    int TYPE_ITEM_POST = 2;
    int TYPE_ITEM_HEADER = 3;

    Context context;
    ArrayList<Feed> items;

    public FeedAdapter(Context context, ArrayList<Feed> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Feed feed = items.get(position);
        if (isHead(position))
            return TYPE_ITEM_HEADER;
        if (feed.getHeader())
            return TYPE_ITEM_HEAD;
        else if (feed.getStories().size() > 0)
            return TYPE_ITEM_STORY;
        return TYPE_ITEM_POST;
    }

    public boolean isHead(int position) {
        return position == 2;
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_feed_head, parent, false);
            return new HeadViewHolder(view);
        } else if (viewType == TYPE_ITEM_STORY) {
            View view =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_story, parent, false);
            return new StoryViewHolder(view);
        }
        if (viewType == TYPE_ITEM_HEADER) {
            View header =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_avatar, parent, false);
            return new FeedAvatarViewHolder(header);
        }
        View view =
                LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (isHead(position)) return;
        Feed feed = items.get(position);
        if (holder instanceof HeadViewHolder) {
        }
        if (holder instanceof PostViewHolder) {
            ((PostViewHolder) holder).iv_profile.setImageResource(feed.getPost().getProfile());
            ((PostViewHolder) holder).iv_photo.setImageResource(feed.getPost().getPhoto());
            ((PostViewHolder) holder).tv_fullname.setText(feed.getPost().getFullname());
        }
        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            refreshAdapter(feed.getStories(), recyclerView);
        }
    }

    void refreshAdapter(ArrayList<Story> stories, RecyclerView recyclerView) {
        StoryAdapter storyAdapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(storyAdapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        ImageView iv_photo;
        TextView tv_fullname;

        public PostViewHolder(View view) {
            super(view);
            iv_profile = view.findViewById(R.id.iv_profile);
            iv_photo = view.findViewById(R.id.iv_photo);
            tv_fullname = view.findViewById(R.id.tv_fullname);
        }
    }

    private static class StoryViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public StoryViewHolder(View view) {
            super(view);
            recyclerView = view.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(manager);
        }
    }

    private static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View view) {
            super(view);
        }
    }

    private static class FeedAvatarViewHolder extends RecyclerView.ViewHolder {
        public FeedAvatarViewHolder(View view) {
            super(view);
        }
    }
}
