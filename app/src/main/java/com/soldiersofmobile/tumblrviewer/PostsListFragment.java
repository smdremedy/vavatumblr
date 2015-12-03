package com.soldiersofmobile.tumblrviewer;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class PostsListFragment extends ListFragment {

    public static final String NAME = "name";

    public static PostsListFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME, name);
        PostsListFragment fragment = new PostsListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
