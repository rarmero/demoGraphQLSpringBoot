package com.example.demoGraphQlSpringBoot.repository;

import com.example.demoGraphQlSpringBoot.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
