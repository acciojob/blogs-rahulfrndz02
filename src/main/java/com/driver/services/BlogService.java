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
        List<Blog> blogList = blogRepository1.findAll(); //by me
        return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blogOjb = new Blog();
        blogOjb.setTitle(title);
        blogOjb.setContent(content);
        List<Blog> listOfBlogs = new ArrayList<>();


        //updating the blog details
        User user = userRepository1.findById(userId).get();
         listOfBlogs = user.getBlog();
         listOfBlogs.add(blogOjb);
         user.setBlog(listOfBlogs);
         blogOjb.setUser(user);

        //Updating the userInformation and changing its blogs
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
        Blog blog = blogRepository1.findById(blogId).get(); //by me
        return blog;

    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Image imageObj = new Image();
        imageObj.setDescription(description);
        imageObj.setDimensions(dimensions);
        Blog blog = blogRepository1.findById(blogId).get();
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
