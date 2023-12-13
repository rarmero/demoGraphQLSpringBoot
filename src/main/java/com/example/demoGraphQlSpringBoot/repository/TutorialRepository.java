package com.example.demoGraphQlSpringBoot.repository;

import com.example.demoGraphQlSpringBoot.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

 public interface TutorialRepository extends MongoRepository<Tutorial, String> {

}
