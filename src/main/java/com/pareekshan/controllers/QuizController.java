package com.pareekshan.controllers;

import com.pareekshan.entity.quiz.Quiz;
import com.pareekshan.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /* add quiz to the Database */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    /* update quiz to the database */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return this.quizService.updateQuiz(quiz);
    }

    /* get all the quiz from the database */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    /* get quiz by quizId  */
    @RequestMapping(value = "/get/{quizId}", method = RequestMethod.GET)
    public Quiz getQuizById(@PathVariable("quizId") Long quizId){
        return this.quizService.getQuizById(quizId);
    }

    /* Delete the quiz  */
    @RequestMapping(value = "/delete/{quizId}", method = RequestMethod.DELETE)
    public String deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);
        return "Quiz Deleted Successfully";
    }
}
