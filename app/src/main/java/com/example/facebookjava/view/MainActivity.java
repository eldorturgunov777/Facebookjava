package com.example.facebookjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookjava.R;
import com.example.facebookjava.adapter.FeedAdapter;
import com.example.facebookjava.model.Feed;
import com.example.facebookjava.model.Post;
import com.example.facebookjava.model.Story;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Story> stories = new ArrayList<Story>();
    ArrayList<Feed> feeds = new ArrayList<Feed>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        refreshAdapter(getAllFeeds());
    }

    void refreshAdapter(ArrayList<Feed> feeds) {
        FeedAdapter feedAdapter = new FeedAdapter(this, feeds);
        recyclerView.setAdapter(feedAdapter);
    }

    ArrayList<Feed> getAllFeeds() {

        stories.add(new Story(R.drawable.im_user_1, "Barney Martyn"));
        stories.add(new Story(R.drawable.im_user_2, "Jayden Petaccio"));
        stories.add(new Story(R.drawable.im_user_3, "Linwood Ramin"));
        stories.add(new Story(R.drawable.im_user_1, "Nikko Verastequi"));
        stories.add(new Story(R.drawable.im_user_2, "Tevin Winett"));
        stories.add(new Story(R.drawable.im_user_3, "Aleeyah Buckless"));
        stories.add(new Story(R.drawable.im_user_1, "Giovanni Ottaway"));
        stories.add(new Story(R.drawable.im_user_2, "Jason Storton"));
        stories.add(new Story(R.drawable.im_user_3, "Sasha Wiegmann"));

        feeds.add(new Feed(true));
        //Story
        feeds.add(new Feed(false, stories));

        feeds.add(new Feed(false, new Post(R.drawable.im_user_3, "Barney", R.drawable.im_post_5)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_2, "Jayden", R.drawable.im_post_4)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_1, "Linwood", R.drawable.im_post_3)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_3, "Nikko", R.drawable.im_post_2)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_1, "Tevin", R.drawable.im_post_1)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_3, "Aleeyah", R.drawable.im_post_5)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_2, "Giovanni", R.drawable.im_post_4)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_1, "Jason", R.drawable.im_post_3)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_3, "Sasha", R.drawable.im_post_2)));
        feeds.add(new Feed(false, new Post(R.drawable.im_user_1, "Barney", R.drawable.im_post_1)));
        return feeds;
    }


}