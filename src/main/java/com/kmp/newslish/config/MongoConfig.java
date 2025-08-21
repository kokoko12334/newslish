package com.kmp.newslish.config;

import java.util.ArrayList;

import org.bson.json.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.kmp.newslish")
public class MongoConfig {

	@Bean
	@Primary
	public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory factory,
		MongoMappingContext context) {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
		MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);

		// _class 필드 제거 (타입 정보 저장하지 않음)
		mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

		// 커스텀 컨버터 추가
		mappingConverter.setCustomConversions(customConversions());

		return mappingConverter;
	}

	@Bean
	public MongoCustomConversions customConversions() {
		ArrayList<Object> converters = new ArrayList<>();
		return new MongoCustomConversions(converters);
	}
}