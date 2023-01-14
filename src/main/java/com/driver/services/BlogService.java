package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        return blogRepository1.findAll();
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        long milliSecond = System.currentTimeMillis();

        blog.setPubDate(new Date(milliSecond));

        //updating the blog details

        //Updating the userInformation and changing its blogs
        User user = userRepository1.findById(userId).get();
        blog.setUser(user);
        List<Blog> blogList = user.getBlog();
        blogList.add(blog);
        user.setBlog(blogList);

        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
        Blog blog = blogRepository1.findById(blogId).get(); //by me
        return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Image imageObj = new Image(); //creating image
        imageObj.setDescription(description);
        imageObj.setDimensions(dimensions);
        Blog blog = findBlogById(blogId);
        imageObj.setBlog(blog);
        List<Image> listOfImages = blog.getImageList();
        listOfImages.add(imageObj);
        blog.setImageList(listOfImages);
        blogRepository1.save(blog);

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
