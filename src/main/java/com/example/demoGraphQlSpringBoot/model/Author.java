package com.example.demoGraphQlSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    private String name;
    private Integer age;

    public Author() {
    }

}
