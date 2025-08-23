package com.kmp.newslish.config;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.kmp.newslish.dto.NewsDetailDTO;
import com.kmp.newslish.dto.NewsListDTO;
import com.kmp.newslish.vo.NewsArticle;

@Mapper(componentModel = "spring")
public interface MapperConfig {
	@Named("instantToDateString")
	static String instantToDateString(Instant instant) {
		if (instant == null)
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC"));
		return formatter.format(instant);
	}

	@Mapping(source = "publishedAt", target = "publishedAt", qualifiedByName = "instantToDateString")
	NewsDetailDTO toNewsDetailDTO(NewsArticle newsArticle);

	@Mapping(source = "publishedAt", target = "publishedAt", qualifiedByName = "instantToDateString")
	NewsListDTO toNewsListElement(NewsArticle newsArticle);

	List<NewsListDTO> toNewsListDTO(List<NewsArticle> newsArticles);
}
