package com.pareekshan.controllers;

import com.pareekshan.entity.quiz.Question;
import com.pareekshan.entity.quiz.Quiz;
import com.pareekshan.service.QuestionService;
import com.pareekshan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    /* add Question to the Database */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    /* update Question to the database */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Question updateQuestion(@RequestBody Question question){
        return this.questionService.updateQuestion(question);
    }

    /* get all the Question from the database */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

    /* get Question by QuestionId  */
    @RequestMapping(value = "/get/{questionId}", method = RequestMethod.GET)
    public Question getQuestionById(@PathVariable("questionId") Long questionId){
        return this.questionService.getQuestionById(questionId);
    }

    /* Delete the Question  */
    @RequestMapping(value = "/delete/{questionId}", method = RequestMethod.DELETE)
    public String deleteQuestion(@PathVariable("questionId") Long questionId) {
        this.questionService.deleteQuestion(questionId);
        return "Question Deleted Successfully";
    }

    /* get Question based on Quiz */
    @RequestMapping(value = "/get/quiz/{quizId}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionByQuiz(@PathVariable("quizid") Long quizId){
        Quiz quiz1 = this.quizService.getQuizById(quizId);
        Set<Question> questions = quiz1.getQuestion();
        List<Question> questionList = new ArrayList<>(questions);
        if(questionList.size() > Integer.parseInt(quiz1.getNumberOfQuestion())){
            questionList = questionList.subList(0, Integer.parseInt(quiz1.getNumberOfQuestion()+1));
        }
        Collections.shuffle(questionList);
        return ResponseEntity.ok(questionList);
    }
}
