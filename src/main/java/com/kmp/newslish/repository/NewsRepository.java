package com.kmp.newslish.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kmp.newslish.vo.NewsArticle;

public interface NewsRepository extends MongoRepository<NewsArticle, String> {
	List<NewsArticle> findByPublishedAtBetween(Date startDate, Date endDate);
	Page<NewsArticle> findByPublishedAtBetween(Date publishedAt, Date publ, Pageable pageable);
	NewsArticle findFirstBy();
	@Query("{}")
	List<NewsArticle> findRandomNews(Pageable pageable);
}
