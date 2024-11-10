package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;
import com.example.demo.model.Count; 
import com.example.demo.model.Greeting; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Home page (Greeting)
    @GetMapping("/") 
	public String home() { 
		return "home";  // for home.html 
	} 

    // Greeting page (GET request)
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        Count count = new Count();
        Count.count = Count.count + 1;
        model.addAttribute("greeting", new Greeting());
        model.addAttribute("count", count);
        return "greeting"; // For greeting.html
    }

    // Greeting form submission (POST request)
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, @ModelAttribute Count count, Model model) {
        model.addAttribute("greeting", greeting);
        model.addAttribute("count", count);
        return "result"; // For result.html
    }

    // Verify password page (POST request)
    @PostMapping("/verify")
    public String verifyPassword(@RequestParam String password, Model model) {
        if (isValidPassword(password)) {
            return "redirect:https://organic-waddle-pjgv96qpxwrgc7v6r-8080.app.github.dev/quiz"; // Redirect to quiz page if password is valid
        } else {
            model.addAttribute("error", "Invalid password. Try again.");
            return "login"; // Stay on login page if password is invalid
        }
    }

    // Quiz page (GET request)
    @GetMapping("/quiz")
    public String quizPage() {
        return "quiz"; // For quiz.html
    }

    // Simple password strength validation method
    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        return password.matches(passwordPattern); // Returns true if password matches the pattern
    }
}
