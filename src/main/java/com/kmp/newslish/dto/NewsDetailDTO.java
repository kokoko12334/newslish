package com.kmp.newslish.dto;

import java.util.List;

import com.kmp.newslish.vo.Quiz;
import com.kmp.newslish.vo.TransPair;
import com.kmp.newslish.vo.Voca;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewsDetailDTO {
	private String _id;
	private List<Voca> voca;
	private List<TransPair> translations;
	private Quiz quiz;
	private String publishedAt;
}
