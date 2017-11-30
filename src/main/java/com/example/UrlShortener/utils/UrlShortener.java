package com.example.UrlShortener.utils;

import com.example.UrlShortener.exceptions.InvalidUrlException;
import com.example.UrlShortener.repositories.UrlRepository;

import java.util.Random;

public class UrlShortener {

    private static String ALLOWED_HASH_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqxyz1234567890";

    private final UrlRepository mUrlRepository;
    private final String mDomain = "https:/short.url/";
    private final int mMaxLength = 10;

    public UrlShortener(UrlRepository urlRepository) {
        mUrlRepository = urlRepository;
    }

    public String shortenUrl(String value) throws InvalidUrlException {
        if (isUrlValid(value)) {
            return mDomain + getUrlHash(value);
        } else {
            throw new InvalidUrlException();
        }
    }

    String getUrlHash(String url) {
        //todo make hash unique by url and not random
        StringBuilder hash = new StringBuilder();
        Random rnd = new Random();
        while (hash.length() < mMaxLength) {
            int index = rnd.nextInt(ALLOWED_HASH_CHARACTERS.length());
            hash.append(ALLOWED_HASH_CHARACTERS.charAt(index));
        }
        if (mUrlRepository.exists(hash.toString())) {
            return getUrlHash(url);
        }
        return hash.toString();
    }

    private boolean isUrlValid(String url) {
        //todo: add url verification
        return true;
    }
}
