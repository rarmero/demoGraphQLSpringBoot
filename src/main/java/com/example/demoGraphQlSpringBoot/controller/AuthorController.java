package com.example.demoGraphQlSpringBoot.controller;

import com.example.demoGraphQlSpringBoot.model.Author;
import com.example.demoGraphQlSpringBoot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @QueryMapping
    public Optional<Author> authorById(@Argument String id) {
        return authorRepository.findById(id);
    }

    @QueryMapping
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public long countAuthors() {
        return authorRepository.count();
    }

    @MutationMapping
    public Author addAuthor(@Argument String name, @Argument int age){
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        return authorRepository.save(author);
    }


}
