package com.demo.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.joblisting.model.Post;
import com.demo.joblisting.repository.Repository;
import com.demo.joblisting.repository.SearchRepository;

@RestController
public class PostController {

	@Autowired
	Repository repo;

	@Autowired
	SearchRepository srepo;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return repo.findAll();

	}

	@PostMapping("/addPosts")
	public Post addPosts(@RequestBody Post post) {
		repo.insert(post);
		return post;

	}

	@GetMapping("posts/{text}")
	public List<Post> search(@PathVariable String text) {
		List<Post> post = srepo.searchText(text);
		return post;

	}

}
