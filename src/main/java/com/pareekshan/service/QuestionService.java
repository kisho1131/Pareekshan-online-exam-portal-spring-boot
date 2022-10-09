package com.pareekshan.service;


import com.pareekshan.entity.quiz.Question;
import com.pareekshan.entity.quiz.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestionById(Long questionId);

    public Set<Question> getQuestionByQuiz(Quiz quiz);

    public void deleteQuestion(Long questionId);
}
