package com.kmp.newslish.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
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

	public List<NewsArticle> getAllNews() {
		return newsRepository.findAll();
	}

	public List<NewsArticle> getAllNewsByDate(Date startDate, Date endDate) {
		return newsRepository.findByPublishedAtBetween(startDate, endDate);
	}

	public List<NewsArticle> getAllNewsByDate(String startDate, String endDate) {

		Instant startOfDay = LocalDate.parse(startDate).atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant endOfDay = LocalDate.parse(endDate).atStartOfDay(ZoneOffset.UTC).toInstant();

		return getAllNewsByDate(Date.from(startOfDay), Date.from(endOfDay));
	}





}
