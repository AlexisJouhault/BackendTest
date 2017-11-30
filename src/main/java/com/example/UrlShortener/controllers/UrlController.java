package com.example.UrlShortener.controllers;

import com.example.UrlShortener.exceptions.HashNotFoundException;
import com.example.UrlShortener.models.ShortenedUrl;
import com.example.UrlShortener.repositories.UrlRepository;
import com.example.UrlShortener.utils.UrlShortener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    private static final Logger log = LoggerFactory.getLogger(UrlController.class);

    @Autowired
    private UrlRepository urlRepository;

    @RequestMapping(value = "/url", method = RequestMethod.PUT)
    public String transformUrl(@Param("value") String value) {
        UrlShortener urlShortener = new UrlShortener(urlRepository);
        ShortenedUrl shortenedUrl = urlRepository.findOne(value);

        if (shortenedUrl == null) {
            shortenedUrl = new ShortenedUrl();
            shortenedUrl.setBaseUrl(value);
            shortenedUrl.setShortenedUrl(urlShortener.shortenUrl(value));
            log.debug("Adding shortenedUrl");
            urlRepository.save(shortenedUrl);
        }
        return shortenedUrl.getShortenedUrl();
    }

    @RequestMapping(value = "/url", method = RequestMethod.GET)
    public String getUrlFromHash(@Param("hash") String hash) {
        ShortenedUrl shortenedUrl = urlRepository.findByShortenedUrl(hash);
        if (shortenedUrl == null) {
            throw new HashNotFoundException();
        }
        return shortenedUrl.getBaseUrl();
    }
}
