package com.pareekshan.entity.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    @Column(length = 1000)
    private String content;
    private String image;
    @Column(length = 1000)
    private String option1;
    @Column(length = 1000)
    private String option2;
    @Column(length = 1000)
    private String option3;
    @Column(length = 1000)
    private String option4;
    @Column(length = 1000)
    private String answer;


    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
}
