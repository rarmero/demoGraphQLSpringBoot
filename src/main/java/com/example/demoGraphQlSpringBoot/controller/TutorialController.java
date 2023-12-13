package com.example.demoGraphQlSpringBoot.controller;

import com.example.demoGraphQlSpringBoot.model.Tutorial;
import com.example.demoGraphQlSpringBoot.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class TutorialController {

    @Autowired
    private  TutorialRepository tutorialRepository;
    @QueryMapping
    public Optional<Tutorial> tutorialById(@Argument String id) {
        return tutorialRepository.findById(id);
    }
    @QueryMapping
    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }
    @QueryMapping
    public long countTutorials() {
        return tutorialRepository.count();
    }

    @MutationMapping
    public Tutorial addTutorial(@Argument String title, @Argument  String description, @Argument  String authorId) {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        tutorial.setAuthor_id(authorId);

      return tutorialRepository.save(tutorial);
    }

    @MutationMapping
    public Tutorial updateTutorial(@Argument String id,@Argument String title,@Argument String description) throws Exception {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();

            if (title != null)
                tutorial.setTitle(title);
            if (description != null)
                tutorial.setDescription(description);

            tutorialRepository.save(tutorial);
            return tutorial;
        }

        throw new Exception("Not found Tutorial to update!");
    }

    @MutationMapping
    public boolean deleteTutorial(@Argument String id) {
        tutorialRepository.deleteById(id);
        return true;
    }

}

