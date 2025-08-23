package com.kmp.newslish.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Quiz {
	private List<TrueFalseQuiz> trueFalse = new ArrayList<>();
	private List<MultipleChoiceQuiz> multipleChoice = new ArrayList<>();
	private List<MainIdeaQuiz> mainIdea = new ArrayList<>();
	private List<InferenceQuiz> inference = new ArrayList<>();

	@Data
	@NoArgsConstructor
	public static class TrueFalseQuiz {
		private String question;
		private String answer;
		private String explanation;

	}

	@Data
	@NoArgsConstructor
	public static class MultipleChoiceQuiz {
		private String question;
		private Map<String, String> options;
		private String answer;
		private String explanation;

	}

	@Data
	@NoArgsConstructor
	public static class MainIdeaQuiz {
		private String question;
		private Map<String, String> options;
		private String answer;
		private String explanation;

	}

	@Data
	@NoArgsConstructor
	public static class InferenceQuiz {
		private String question;
		private Map<String, String> options;
		private String answer;
		private String explanation;

	}
}