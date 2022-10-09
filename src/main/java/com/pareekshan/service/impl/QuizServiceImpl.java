package com.pareekshan.service.impl;

import com.pareekshan.entity.quiz.Quiz;
import com.pareekshan.repository.QuizRepository;
import com.pareekshan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Quiz newQuiz = this.getQuizById(quiz.getQid());
        newQuiz.setTitle(quiz.getTitle());
        newQuiz.setCategory(quiz.getCategory());
        newQuiz.setDescription(quiz.getDescription());
        newQuiz.setQuestion(quiz.getQuestion());
        newQuiz.setMaxMarks(quiz.getMaxMarks());
        newQuiz.setNumberOfQuestion(quiz.getNumberOfQuestion());
        return this.quizRepository.save(newQuiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }
}
