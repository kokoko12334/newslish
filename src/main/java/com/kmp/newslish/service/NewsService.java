package com.kmp.newslish.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kmp.newslish.config.MapperConfig;
import com.kmp.newslish.dto.NewsDetailDTO;
import com.kmp.newslish.dto.NewsListDTO;
import com.kmp.newslish.dto.NewsPageDTO;
import com.kmp.newslish.repository.NewsRepository;
import com.kmp.newslish.vo.NewsArticle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsRepository newsRepository;
	private final MapperConfig mapper;

	public NewsDetailDTO getNewsByUrl(String url) {

		NewsArticle newsArticle = newsRepository.findById(url)
			.orElseThrow(() -> new NullPointerException("뉴스를 찾을 수 없습니다: " + url));

		return mapper.toNewsDetailDTO(newsArticle);
	}

	public List<NewsListDTO> getAllNewsByDate(Date startDate, Date endDate) {
		return mapper.toNewsListDTO(newsRepository.findByPublishedAtBetween(startDate, endDate));
	}

	public List<NewsListDTO> getAllNewsByDate(String startDate, String endDate) {

		Instant startOfDay = LocalDate.parse(startDate).atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant endOfDay = LocalDate.parse(endDate).atStartOfDay(ZoneOffset.UTC).toInstant();

		return getAllNewsByDate(Date.from(startOfDay), Date.from(endOfDay));
	}

	public NewsPageDTO getNewsByDateWithPage(Date startDate, Date endDate, int page, int size) {
		Page<NewsArticle> results = newsRepository.findByPublishedAtBetween(startDate, endDate,
			PageRequest.of(page, size));

		return NewsPageDTO.builder()
			.newsList(mapper.toNewsListDTO(results.getContent()))
			.currentPage(results.getNumber())
			.totalPages(results.getTotalPages())
			.totalElements(results.getTotalElements())
			.build();
	}

	public NewsPageDTO getNewsByDateWithPage(String startDate, String endDate, int page, int size) {

		Instant startOfDay = LocalDate.parse(startDate).atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant endOfDay = LocalDate.parse(endDate).atStartOfDay(ZoneOffset.UTC).toInstant();

		return getNewsByDateWithPage(Date.from(startOfDay), Date.from(endOfDay), page, size);
	}

	public NewsListDTO getRecommendedNews() {
		List<NewsArticle> randomNews = newsRepository.findRandomNews(PageRequest.of(0, 10));
		return mapper.toNewsListElement(randomNews.get(0));
	}

}
