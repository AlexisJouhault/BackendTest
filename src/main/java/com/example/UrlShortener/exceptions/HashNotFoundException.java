package com.example.UrlShortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such hash")
public class HashNotFoundException extends RuntimeException {
}
