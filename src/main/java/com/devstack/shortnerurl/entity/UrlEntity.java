package com.devstack.shortnerurl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    private String id;
    private String fullUrl;
    @Indexed(expireAfter = "1d")
    private LocalDateTime expiresAt;
}
