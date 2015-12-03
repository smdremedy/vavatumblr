package com.soldiersofmobile.tumblrviewer.api;

import com.soldiersofmobile.tumblrviewer.model.TumblrResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Sylwester on 2015-12-03.
 */
public interface TumblrApi {

    @GET("/v2/blog/{name}.tumblr.com" +
            "/posts?api_key=fD0HOvNDa2z10uyozPZNnjeb4fEFGVGm58zttH6cXSe4K0qC64" +
            "&limit=20&offset=0")
    void getPosts(@Path("name") String name, Callback<TumblrResponse> callback);

}
