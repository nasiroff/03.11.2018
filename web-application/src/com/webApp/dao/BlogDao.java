package com.webApp.dao;

import com.webApp.model.Blog;
import com.webApp.model.User;

import java.util.List;

public interface BlogDao {
    List<Blog> getAllBlogs();
    List<Blog> getBlogsByUser(User user);
    boolean createNewBlog(Blog blog);

}
