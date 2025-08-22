package com.kmp.newslish.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kmp.newslish.vo.NewsArticle;

public interface NewsRepository extends MongoRepository<NewsArticle, String> {
	List<NewsArticle> findByPublishedAtBetween(Date publishedAt, Date publishedAt2);
}
