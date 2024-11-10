package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.Count;
import com.example.demo.model.questions.ArrayQuestionsTrueFalse;
import com.example.demo.model.questions.QuestionTrueFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArrayQuestionsTrueFalse questionList;

    @MockBean
    private Model model;

    private int score;
    private int questionIndex;

    @BeforeEach
    void setUp() {
        score = 0;
        questionIndex = 0;
    }

    //Home Page: Verifies that the home page (/) returns the correct view.
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    //Greeting Form: Verifies that the greeting form page (/greeting) is displayed correctly.
    @Test
    public void testGreetingForm() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"));
    }

   
    //Password Submission: Tests both valid and invalid password submissions.
    @Test
    public void testSubmitPassword_Valid() throws Exception {
        mockMvc.perform(post("/submit-password")
                .param("password", "Valid@1234"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/get_question"));
    }


    //Quiz Question: Ensures the correct question and score are displayed on the quiz page.
    @Test
    public void testSubmitPassword_Invalid() throws Exception {
        mockMvc.perform(post("/submit-password")
                .param("password", "short"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("error", "Password does not meet the required criteria."))
                .andExpect(view().name("home"));
    }


    //Quiz Submit: Simulates answering the quiz correctly and incorrectly.
    @Test
    public void testGetQuestion() throws Exception {
        QuestionTrueFalse mockQuestion = new QuestionTrueFalse("Is the sky blue?", true);
        when(questionList.nextQuestion(questionIndex)).thenReturn(mockQuestion);

        mockMvc.perform(get("/get_question"))
                .andExpect(status().isOk())
                .andExpect(view().name("question"))
                .andExpect(model().attribute("question", "Is the sky blue?"))
                .andExpect(model().attribute("score", score));
    }

    //Quiz Result: Verifies the result page shows the correct score.
    @Test
    public void testQuizSubmit_CorrectAnswer() throws Exception {
        QuestionTrueFalse mockQuestion = new QuestionTrueFalse("Is the sky blue?", true);
        when(questionList.nextQuestion(questionIndex)).thenReturn(mockQuestion);

        mockMvc.perform(post("/quiz")
                .param("userAnswer", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/get_question"));

        score++;
    }

    //Greeting Submit: Simulates submitting the greeting form.
    @Test
    public void testQuizSubmit_IncorrectAnswer() throws Exception {
        QuestionTrueFalse mockQuestion = new QuestionTrueFalse("Is the sky blue?", false);
        when(questionList.nextQuestion(questionIndex)).thenReturn(mockQuestion);

        mockMvc.perform(post("/quiz")
                .param("userAnswer", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/get_question"));

        score = 0; // Assuming incorrect answers don't increment the score
    }

    //confirms quiz-result page
    @Test
    public void testQuizResult() throws Exception {
        mockMvc.perform(get("/quiz-result"))
                .andExpect(status().isOk())
                .andExpect(view().name("quiz-result"))
                .andExpect(model().attribute("score", score));
    }
}
