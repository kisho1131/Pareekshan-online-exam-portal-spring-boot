package com.pareekshan.service.impl;

import com.pareekshan.entity.quiz.Question;
import com.pareekshan.entity.quiz.Quiz;
import com.pareekshan.repository.QuestionRepository;
import com.pareekshan.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question newQuestion = this.getQuestionById(question.getQuestionId());
        newQuestion.setAnswer(question.getAnswer());
        newQuestion.setContent(question.getContent());
        newQuestion.setImage(question.getImage());
        newQuestion.setOption1(question.getOption1());
        newQuestion.setOption2(question.getOption2());
        newQuestion.setOption3(question.getOption3());
        newQuestion.setOption4(question.getOption4());
        newQuestion.setQuiz(question.getQuiz());
        return this.questionRepository.save(newQuestion);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionByQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        this.questionRepository.deleteById(questionId);
    }
}
