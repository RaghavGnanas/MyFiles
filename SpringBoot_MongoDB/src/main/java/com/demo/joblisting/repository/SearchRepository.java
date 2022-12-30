package com.demo.joblisting.repository;

import java.util.List;

import com.demo.joblisting.model.Post;

public interface SearchRepository {

	List<Post> searchText(String text);

}
