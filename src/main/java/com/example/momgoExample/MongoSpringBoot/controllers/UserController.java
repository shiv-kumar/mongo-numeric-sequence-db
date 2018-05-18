package com.example.momgoExample.MongoSpringBoot.controllers;

import com.example.momgoExample.MongoSpringBoot.SequenceService;
import com.example.momgoExample.MongoSpringBoot.model.User;
import com.example.momgoExample.MongoSpringBoot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private static String key = "idSeq";
    @Autowired
    UserRepository userRepository;

    @Autowired
    SequenceService sequenceService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user) {
        LOG.info("Saving user.");
        user.setId(sequenceService.getNextSequenceId(key));
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID: {}.", userId);
        User user = null;
        Optional<User> result = userRepository.findById(userId);
        if(result.isPresent()){
           user = result.get();
        }
        return user;
    }
}
