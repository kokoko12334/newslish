package com.kmp.newslish.vo;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

// import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "contents")
@Data
@NoArgsConstructor
public class NewsArticle {
	// @Id
	@MongoId
	private String _id;

	@Field("voca")
	private List<Voca> voca;

	@Field("readingTime")
	private int readingTime;

	@Field("translations")
	private List<TransPair> translations;

	@Field("quiz")
	private Quiz quiz;

	@Field("level")
	private int level;

	@Field("publishedAt")
	private Instant publishedAt;

	@Field("shortContent")
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
