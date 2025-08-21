package com.kmp.newslish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmp.newslish.service.NewsService;
import com.kmp.newslish.vo.NewsArticle;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

	private final NewsService newsService;

	@GetMapping
	public NewsArticle getNewsByUrl(@RequestParam("url") String url) {
		System.out.println(url);
		return newsService.getNewsByUrl(url);
	}

}
