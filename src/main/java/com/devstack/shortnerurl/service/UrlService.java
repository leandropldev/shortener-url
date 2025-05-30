package com.devstack.shortnerurl.service;

import com.devstack.shortnerurl.entity.UrlEntity;
import com.devstack.shortnerurl.exception.ResourceNotFoundException;
import com.devstack.shortnerurl.model.ShortenUrlRequest;
import com.devstack.shortnerurl.model.ShorterUrlResponse;
import com.devstack.shortnerurl.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    public ShorterUrlResponse createShortenUrl(ShortenUrlRequest body, HttpServletRequest request) {
        String id;
        do {
          id  =  RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));
        UrlEntity savedUrl = urlRepository.save(new UrlEntity(id, body.url(), LocalDateTime.now().plusDays(1)));
        return buildResponse(request, savedUrl, id);
    }

    public String getUrlToBeRedirected(String id) {
        UrlEntity urlEntity = urlRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("url not found: " + id));
        return urlEntity.getFullUrl();
    }

    private ShorterUrlResponse buildResponse(HttpServletRequest request, UrlEntity entity,String id){
        String expireAt = entity.getExpiresAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String redirectUrl = request.getRequestURL().toString().replace("shorten-url", id);
        return new ShorterUrlResponse(redirectUrl, expireAt);
    }
}
