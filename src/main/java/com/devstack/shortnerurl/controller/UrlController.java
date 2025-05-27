package com.devstack.shortnerurl.controller;

import com.devstack.shortnerurl.model.ShortenUrlRequest;
import com.devstack.shortnerurl.model.ShorterUrlResponse;
import com.devstack.shortnerurl.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;
    @PostMapping("/shorten-url")
    public ResponseEntity<ShorterUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest body, HttpServletRequest request){
        ShorterUrlResponse response = urlService.createShortenUrl(body, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirectUrl(@PathVariable("id") String id, HttpServletRequest request){
        String url = urlService.getUrlToBeRedirected(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
