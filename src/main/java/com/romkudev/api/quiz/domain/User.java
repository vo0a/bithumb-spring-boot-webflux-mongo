package com.romkudev.api.quiz.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Document(collection = "users")
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    private final long userid;
    private final String alias;
}