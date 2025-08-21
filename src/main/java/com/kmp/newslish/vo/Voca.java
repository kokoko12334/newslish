package com.kmp.newslish.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voca {
	private String word;
	private int diff;
	private String meaning;

}