package com.devstack.shortnerurl.repository;

import com.devstack.shortnerurl.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
