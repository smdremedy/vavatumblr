package com.soldiersofmobile.tumblrviewer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.soldiersofmobile.tumblrviewer.api.TumblrApi;
import com.soldiersofmobile.tumblrviewer.model.Post;
import com.soldiersofmobile.tumblrviewer.model.TumblrResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PostsListFragment extends ListFragment {

    public interface PostListCallback {
        void loadUrl(String url);
    }

    public static final String NAME = "name";
    private ArrayAdapter<Post> postArrayAdapter;

    private PostListCallback callback;

    public static PostsListFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME, name);
        PostsListFragment fragment = new PostsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("", "onAttach/Activity");

        if(activity instanceof PostListCallback) {
            callback = (PostListCallback) activity;
        } else {
            throw new RuntimeException("Must implement callback!");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("", "onAttach/Context");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        postArrayAdapter = new PostAdapter(getContext(), android.R.layout.simple_list_item_1);

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint("http://api.tumblr.com");
        builder.setLogLevel(RestAdapter.LogLevel.FULL);
        final TumblrApi tumblrApi = builder.build().create(TumblrApi.class);

        String name = getArguments().getString(NAME);
        tumblrApi.getPosts(name, new Callback<TumblrResponse>() {
            @Override
            public void success(TumblrResponse tumblrResponse, Response response) {
                postArrayAdapter.addAll(tumblrResponse.getResponse().getPosts());
                setListAdapter(postArrayAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
                setListAdapter(postArrayAdapter);

            }
        });


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Post post = postArrayAdapter.getItem(position);

        if(callback != null) {
            callback.loadUrl(post.getLinkUrl());
        }

    }
}
