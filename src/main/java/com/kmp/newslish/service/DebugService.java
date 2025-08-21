package com.kmp.newslish.service;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DebugService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void printOneContent() {
		Document doc = mongoTemplate.getCollection("contents")
			.find()
			.first();
		if (doc != null) {
			System.out.println(doc);
		} else {
			System.out.println("No document found in contents collection");
		}
	}

	public void checkQuizFields() {
		List<Document> allDocs = mongoTemplate.getCollection("contents")
			.find()
			.into(new ArrayList<>());

		List<String> problemIds = new ArrayList<>();

		for (Document doc : allDocs) {
			Document quiz = (Document) doc.get("quiz");
			if (quiz != null) {
				// 각 quiz 하위 필드가 배열인지 확인
				if (!isArray(quiz.get("true_false")) ||
					!isArray(quiz.get("multiple_choice")) ||
					!isArray(quiz.get("main_idea")) ||
					!isArray(quiz.get("inference"))) {
					problemIds.add(doc.getString("_id"));  // 문제 있는 문서 _id 수집
				}
			}
		}

		if (problemIds.isEmpty()) {
			System.out.println("모든 quiz 필드가 리스트로 되어 있습니다.");
		} else {
			System.out.println("List가 아닌 quiz 하위 필드가 있는 문서 _id:");
			problemIds.forEach(System.out::println);
		}
	}

	private boolean isArray(Object obj) {
		return obj instanceof List;
	}
}
