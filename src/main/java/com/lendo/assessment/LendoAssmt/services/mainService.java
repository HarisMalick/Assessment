package com.lendo.assessment.LendoAssmt.services;

import com.lendo.assessment.LendoAssmt.model.CustomResponse;
import com.lendo.assessment.LendoAssmt.model.Post;
import com.lendo.assessment.LendoAssmt.model.User;
import com.lendo.assessment.LendoAssmt.repository.PostRepository;
import com.lendo.assessment.LendoAssmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mainService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    public CustomResponse addUser(User user)
    {
        CustomResponse response = new CustomResponse();
        try {

            User returnUser = userRepository.save(user);

            response.setData(returnUser);

            if (null != returnUser) {
                response.setStatus("OK");
                response.setMessage("User " + returnUser.getName() + " saved");
            } else {
                response.setStatus("FAILED");
                response.setMessage("User not saved");

            }
        }

        catch (Exception e)
        {
            response.setStatus("FAILED");
            response.setMessage(e.getMessage());
        }

        return response;
    }


    public CustomResponse addAllUser(List<User> Users)
    {
        CustomResponse response = new CustomResponse();
        try {

            Users.forEach(p->
            {
                userRepository.save(p);
            });

            response.setMessage("All users saved");
            response.setStatus("OK");
        }

        catch (Exception e)
        {
            response.setStatus("FAILED");
            response.setMessage(e.getMessage());
        }

        return response;
    }

    public CustomResponse getAllUser()
    {
        CustomResponse response = new CustomResponse();
        try {

          List<User> users = (List<User>) userRepository.findAll();

            response.setData(users);
            response.setMessage("All users saved");
            response.setStatus("OK");
        }

        catch (Exception e)
        {
            response.setStatus("FAILED");
            response.setMessage(e.getMessage());
        }

        return response;
    }


    public CustomResponse addPos(Post post)
    {
        CustomResponse response = new CustomResponse();
        try {

            Post returnPost = postRepository.save(post);

            response.setData(returnPost);

            if (null != returnPost) {
                response.setStatus("OK");
                response.setMessage("Post " + returnPost.getPostId() + " saved");
            } else {
                response.setStatus("FAILED");
                response.setMessage("Post not saved");

            }
        }

        catch (Exception e)
        {
            response.setStatus("FAILED");
            response.setMessage(e.getMessage());
        }

        return response;
    }


    public CustomResponse addAllPost(List<Post> posts)
    {
        CustomResponse response = new CustomResponse();
        try {

            posts.forEach(p->
            {
                postRepository.save(p);
            });

            response.setMessage("All posts saved");
            response.setStatus("OK");
        }

        catch (Exception e)
        {
            response.setStatus("FAILED");
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
