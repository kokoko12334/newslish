package com.kmp.newslish.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kmp.newslish.dto.NewsDetailDTO;
import com.kmp.newslish.dto.NewsListDTO;

@SpringBootTest
public class NewsServiceTest {

	@Autowired
	private NewsService newsService;

	@Test
	void testGetNewsByUrl() {
		//given
		String url = "https://www.cnbc.com/2025/08/21/chipotle-teams-up-with-zipline-to-test-drone-delivery.html";

		//when
		NewsDetailDTO newsByUrl = newsService.getNewsByUrl(url);

		//then
		assertEquals("Chipotle teams up with Zipline to test drone delivery - CNBC", newsByUrl.getTitle());
		assertEquals("business", newsByUrl.getCategory());
		assertEquals("CNBC", newsByUrl.getSource());
		assertEquals(5, newsByUrl.getReadingTime());
	}

	@Test
	void testGetAllNewsByDate() {

		Instant startOfDay = LocalDate.parse("2025-08-21").atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant endOfDay = LocalDate.parse("2025-08-22").atStartOfDay(ZoneOffset.UTC).toInstant();

		List<NewsListDTO> newsList = newsService.getAllNewsByDate(Date.from(startOfDay), Date.from(endOfDay));

		assertFalse(newsList.isEmpty());

	}

}
