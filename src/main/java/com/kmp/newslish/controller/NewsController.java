package com.kmp.newslish.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmp.newslish.dto.NewsDetailDTO;
import com.kmp.newslish.dto.NewsListDTO;
import com.kmp.newslish.dto.NewsPageDTO;
import com.kmp.newslish.service.NewsService;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

	private final NewsService newsService;

	@GetMapping("/by-url")
	public ResponseEntity<NewsDetailDTO> getNewsByUrl(@RequestParam("url") @NotBlank String url) {
		return ResponseEntity.ok(newsService.getNewsByUrl(url));
	}

	@GetMapping("/by-date")
	public ResponseEntity<List<NewsListDTO>> getNewsByDate(@RequestParam("startDate") @NotBlank String startDate,
		@RequestParam("endDate") @NotBlank String endDate) {
		return ResponseEntity.ok(newsService.getAllNewsByDate(startDate, endDate));
	}

	@GetMapping("/by-date/page")
	public ResponseEntity<NewsPageDTO> getNewsByDateWithPage(
		@RequestParam("startDate") @NotBlank String startDate, @RequestParam("endDate") @NotBlank String endDate,
		@RequestParam(value = "page", defaultValue = "0") @Min(0) int page,
		@RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(30) int size) {
		return ResponseEntity.ok(newsService.getNewsByDateWithPage(startDate, endDate, page, size));
	}

	@GetMapping("/recommend")
	public ResponseEntity<NewsListDTO> getRecommendedNews() {
		return ResponseEntity.ok(newsService.getRecommendedNews());
	}

}
