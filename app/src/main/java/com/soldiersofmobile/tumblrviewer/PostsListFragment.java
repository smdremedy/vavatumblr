package com.soldiersofmobile.tumblrviewer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soldiersofmobile.tumblrviewer.api.TumblrApi;
import com.soldiersofmobile.tumblrviewer.model.Photo;
import com.soldiersofmobile.tumblrviewer.model.Post;
import com.soldiersofmobile.tumblrviewer.model.TumblrResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PostsListFragment extends ListFragment {

    public static final String NAME = "name";
    private ArrayAdapter<Post> postArrayAdapter;

    public static PostsListFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME, name);
        PostsListFragment fragment = new PostsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    static class PostAdapter extends ArrayAdapter<Post> {

        public PostAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null) {
                v = LayoutInflater.from(getContext()).inflate(R.layout.post_item, parent, false);
            }

            ViewHolder viewHolder = (ViewHolder) v.getTag();
            if(viewHolder == null) {
                viewHolder = new ViewHolder(v);
                v.setTag(viewHolder);
            }

            Post post = getItem(position);

            viewHolder.postTextView.setText(Html.fromHtml(post.getCaption()));
            List<Photo> photos = post.getPhotos();
            if(!photos.isEmpty()) {
                Glide.with(getContext())
                        .load(photos.get(0).getAltSizes().get(0).getUrl())
                        .into(viewHolder.postImageView);
            }

            return v;
        }

        /**
         * This class contains all butterknife-injected Views & Layouts from layout file 'post_item.xml'
         * for easy to all layout elements.
         *
         * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
         */
        static class ViewHolder {
            @Bind(R.id.postImageView)
            ImageView postImageView;
            @Bind(R.id.postTextView)
            TextView postTextView;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
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
}
