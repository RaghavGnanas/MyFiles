package com.demo.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.joblisting.model.Post;

public interface Repository extends MongoRepository<Post, String> {

}
