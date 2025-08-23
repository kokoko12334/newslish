package com.kmp.newslish.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsPageDTO {
	private List<NewsListDTO> newsList;
	private int totalPages;
	private long totalElements;
	private int currentPage;
}
