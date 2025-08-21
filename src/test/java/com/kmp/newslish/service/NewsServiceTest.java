package com.kmp.newslish.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kmp.newslish.vo.NewsArticle;

@SpringBootTest
public class NewsServiceTest {

	@Autowired
	private NewsService newsService;


	@Test
	void testGetNewsUrl() {
		//given
		String url = "https://www.npr.org/2025/08/15/nx-s1-5500523/when-our-inflation-infeelings-dont-match-the-cpi";

		//when
		NewsArticle newsByUrl = newsService.getNewsByUrl(url);

		//then
		Assertions.assertEquals("When our inflation infeelings don’t match the CPI : Planet Money - NPR", newsByUrl.getTitle());
		Assertions.assertEquals("business", newsByUrl.getCategory());
		Assertions.assertEquals("NPR", newsByUrl.getSource());
	}



	@Test
	void testGetNewsByPublishedAt() {

		String publishedAt = "2025-08-15";

		List<NewsArticle> newsList = newsService.getNewsByPublishedAt(publishedAt);

		System.out.println(newsList.size());

		for (NewsArticle news: newsList) {
			System.out.println(news.getTitle());
		}

	}

}
