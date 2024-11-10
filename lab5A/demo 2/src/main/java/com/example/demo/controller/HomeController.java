package com.example.demo.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Greeting;
import com.example.demo.model.MyString;
import com.example.demo.model.GetQuestion;
import com.example.demo.model.Count;
import com.example.demo.model.questions.ArrayQuestionsTrueFalse;
import com.example.demo.model.questions.QuestionTrueFalse;

@Controller 
public class HomeController { 

    // Initialize quiz data and score tracking
    private static int score = 0;
    private static int questionIndex = 0;
    private static ArrayQuestionsTrueFalse questionList = new ArrayQuestionsTrueFalse();

    @GetMapping("/") 
    public String home() { 
        return "home";  // for home.html 
    }

    // Existing greeting form
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        Count count = new Count();
        Count.count = Count.count + 1;
        model.addAttribute("greeting", new Greeting());
        model.addAttribute("count", count);
        return "greeting";
    }

    // Quiz question form
    @GetMapping("/get_question")
    public String questionForm(Model model) {
        // Get current question
        QuestionTrueFalse currentQuestion = questionList.nextQuestion(questionIndex);
        
        // Send current question and score to the view
        model.addAttribute("question", currentQuestion.getQuestion());
        model.addAttribute("score", score);
        return "question";  // question.html
    }

    @PostMapping("/quiz")
    public String quizSubmit(@RequestParam("userAnswer") Boolean userAnswer, Model model) {
        // Get the current question
        QuestionTrueFalse currentQuestion = questionList.nextQuestion(questionIndex);
        
        // Check if the answer is correct
        if (currentQuestion.getAnswer().equals(userAnswer)) {
            score++;  // Increment score if correct
        }
        
        // Move to the next question
        questionIndex++;
        
        // Check if the quiz is complete
        if (questionIndex >= questionList.getTotalQuestions()) {
            // Quiz is finished, show results
            return "redirect:/https://organic-waddle-pjgv96qpxwrgc7v6r-8080.app.github.dev/get_question";
        }

        // Show next question
        return "redirect:/https://organic-waddle-pjgv96qpxwrgc7v6r-8080.app.github.dev/get_question";
    }

    @GetMapping("/quiz-result")
    public String quizResult(Model model) {
        model.addAttribute("score", score);
        return "quiz-result";  // quiz-result.html (you need to create this page)
    }

    // Password validation and greeting submit logic remains the same
    @PostMapping("/submit-password")
    public String submitPassword(@RequestParam("password") String password, Model model) {
        if (isValidPassword(password)) {
            return "redirect:https://organic-waddle-pjgv96qpxwrgc7v6r-8080.app.github.dev/get_question";
        } else {
            model.addAttribute("error", "Password does not meet the required criteria.");
            return "home";
        }
    }
    
    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[a-z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) return false;
        return true;
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, @ModelAttribute Count count, Model model) {
        model.addAttribute("greeting", greeting);
        model.addAttribute("count", count);
        return "result";
    }
}
