package com.webApp.dao;

import com.webApp.model.Blog;
import com.webApp.model.User;

import java.util.List;

public class BlogDaoImpl implements BlogDao {
    @Override
    public List<Blog> getAllBlogs() {
        return null;
    }

    @Override
    public List<Blog> getBlogsByUser(User user) {
        return null;
    }

    @Override
    public boolean createNewBlog(Blog blog) {
        return false;
    }
}
