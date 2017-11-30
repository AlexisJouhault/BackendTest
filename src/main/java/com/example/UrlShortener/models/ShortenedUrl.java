package com.example.UrlShortener.models;

import com.example.UrlShortener.exceptions.InvalidUrlException;
import com.example.UrlShortener.utils.UrlShortener;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortenedUrl {

    private String shortenedUrl;

    @Id
    private String baseUrl;

    public void setBaseUrl(String value) throws InvalidUrlException {
        baseUrl = value;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
