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
@Document(collection ="tutorials")
        public class Tutorial {

        @Id
        private String id;
        private String title;
        private String description;
        private String author_id;

       public Tutorial(){}

        }
