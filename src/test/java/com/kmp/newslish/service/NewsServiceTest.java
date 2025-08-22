package com.kmp.newslish.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
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

	@Autowired
	private DebugService debugService;


	@Test
	void testGetNewsUrl() {
		//given
		String url = "https://apnews.com/article/microsoft-azure-gaza-israel-protests-49a0dd5905a1cf16eb3e19a98ca17d50";

		//when
		NewsArticle newsByUrl = newsService.getNewsByUrl(url);

		//then
		assertEquals("Microsoft employee protests lead to 18 arrests as company reviews its work with Israel's military - AP News", newsByUrl.getTitle());
		assertEquals("business", newsByUrl.getCategory());
		assertEquals("Associated Press", newsByUrl.getSource());
	}

	@Test
	void testGetAllNewsByDate() {

		Instant startOfDay = LocalDate.parse("2025-08-20").atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant endOfDay = LocalDate.parse("2025-08-21").atStartOfDay(ZoneOffset.UTC).toInstant();

		List<NewsArticle> newsList = newsService.getAllNewsByDate(Date.from(startOfDay), Date.from(endOfDay));

		assertFalse(newsList.isEmpty());

	}

}
