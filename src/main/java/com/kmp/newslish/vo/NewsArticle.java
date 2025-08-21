package com.kmp.newslish.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "contents")
@Data
public class NewsArticle {
	private String _id;
	private List<Voca> voca = new ArrayList<>();
	private int readingTime;
	private List<TransPair> translations;
	private Quiz quiz;
	private int level;
	private String publishedAt;
	private String shortContent;
	private String source;
	private String title;
	private String urlToImage;
	private String category;

}
