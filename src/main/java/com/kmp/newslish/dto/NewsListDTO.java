package com.kmp.newslish.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewsListDTO {
	private String _id;
	private int readingTime;
	private int level;
	private String publishedAt;
	private String shortContent;
	private String source;
	private String title;
	private String urlToImage;
	private String category;
}
