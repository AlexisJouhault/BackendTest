package com.example.UrlShortener.repositories;

import com.example.UrlShortener.models.ShortenedUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "url", path = "url")
public interface UrlRepository extends CrudRepository<ShortenedUrl, String> {

    ShortenedUrl findByShortenedUrl(@Param("shortenedUrl") String shortenedUrl);

}
