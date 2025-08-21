package com.kmp.newslish.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kmp.newslish.repository.NewsRepository;
import com.kmp.newslish.vo.NewsArticle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsRepository newsRepository;

	public NewsArticle getNewsByUrl(String url) {
		return newsRepository.findById(url)
			.orElseThrow(() -> new NullPointerException("뉴스를 찾을 수 없습니다: " + url));
	}



	public List<NewsArticle> getNewsByPublishedAt(String publishedAt) {
		return newsRepository.findByPublishedAtStartingWith(publishedAt);
	}

}
