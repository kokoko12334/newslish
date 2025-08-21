package com.kmp.newslish.vo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.FetchProfile;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "contents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsArticle {
	@Id
	private String _id;

	@Field("voca")
	private List<Voca> voca;

	@Field("reading_time")
	private int readingTime;

	@Field("translations")
	private List<TransPair> translations;

	@Field("quiz")
	private Quiz quiz;

	@Field("level")
	private int level;

	@Field("publishedAt")
	private String publishedAt;

	@Field("short_content")
	private String shortContent;

	@Field("source")
	private String source;

	@Field("title")
	private String title;

	@Field("urlToImage")
	private String urlToImage;

	@Field("category")
	private String category;

}
