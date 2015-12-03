package com.soldiersofmobile.tumblrviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PostDetailsActivity extends AppCompatActivity {

    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        if(savedInstanceState == null) {
            String url = getIntent().getStringExtra(URL);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.detailsContainer, PostDetailsFragment.newInstance(url))
                    .commit();
        }
    }
}
