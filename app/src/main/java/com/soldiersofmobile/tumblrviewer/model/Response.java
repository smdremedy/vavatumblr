
package com.soldiersofmobile.tumblrviewer.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("blog")
    @Expose
    private Blog blog;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<Post>();
    @SerializedName("total_posts")
    @Expose
    private Integer totalPosts;

    /**
     * 
     * @return
     *     The blog
     */
    public Blog getBlog() {
        return blog;
    }

    /**
     * 
     * @param blog
     *     The blog
     */
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The totalPosts
     */
    public Integer getTotalPosts() {
        return totalPosts;
    }

    /**
     * 
     * @param totalPosts
     *     The total_posts
     */
    public void setTotalPosts(Integer totalPosts) {
        this.totalPosts = totalPosts;
    }

}
