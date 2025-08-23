package com.kmp.newslish.config;

import com.kmp.newslish.dto.NewsDetailDTO;
import com.kmp.newslish.dto.NewsListDTO;
import com.kmp.newslish.vo.NewsArticle;
import com.kmp.newslish.vo.TransPair;
import com.kmp.newslish.vo.Voca;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-23T02:59:15+0900",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class MapperConfigImpl implements MapperConfig {

    @Override
    public NewsDetailDTO toNewsDetailDTO(NewsArticle newsArticle) {
        if ( newsArticle == null ) {
            return null;
        }

        NewsDetailDTO newsDetailDTO = new NewsDetailDTO();

        newsDetailDTO.setPublishedAt( MapperConfig.instantToDateString( newsArticle.getPublishedAt() ) );
        newsDetailDTO.set_id( newsArticle.get_id() );
        List<Voca> list = newsArticle.getVoca();
        if ( list != null ) {
            newsDetailDTO.setVoca( new ArrayList<Voca>( list ) );
        }
        List<TransPair> list1 = newsArticle.getTranslations();
        if ( list1 != null ) {
            newsDetailDTO.setTranslations( new ArrayList<TransPair>( list1 ) );
        }
        newsDetailDTO.setQuiz( newsArticle.getQuiz() );

        return newsDetailDTO;
    }

    @Override
    public NewsListDTO toNewsListElement(NewsArticle newsArticle) {
        if ( newsArticle == null ) {
            return null;
        }

        NewsListDTO newsListDTO = new NewsListDTO();

        newsListDTO.setPublishedAt( MapperConfig.instantToDateString( newsArticle.getPublishedAt() ) );
        newsListDTO.set_id( newsArticle.get_id() );
        newsListDTO.setReadingTime( newsArticle.getReadingTime() );
        newsListDTO.setLevel( newsArticle.getLevel() );
        newsListDTO.setShortContent( newsArticle.getShortContent() );
        newsListDTO.setSource( newsArticle.getSource() );
        newsListDTO.setTitle( newsArticle.getTitle() );
        newsListDTO.setUrlToImage( newsArticle.getUrlToImage() );
        newsListDTO.setCategory( newsArticle.getCategory() );

        return newsListDTO;
    }

    @Override
    public List<NewsListDTO> toNewsListDTO(List<NewsArticle> newsArticles) {
        if ( newsArticles == null ) {
            return null;
        }

        List<NewsListDTO> list = new ArrayList<NewsListDTO>( newsArticles.size() );
        for ( NewsArticle newsArticle : newsArticles ) {
            list.add( toNewsListElement( newsArticle ) );
        }

        return list;
    }
}
