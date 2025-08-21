package com.kmp.newslish.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kmp.newslish.vo.NewsArticle;

public interface NewsRepository extends MongoRepository<NewsArticle, String> {
	@Query(value = "{ 'publishedAt' : { $regex: ?0 } }")
	List<NewsArticle> findByPublishedAtStartingWith(String publishedAt);
}
