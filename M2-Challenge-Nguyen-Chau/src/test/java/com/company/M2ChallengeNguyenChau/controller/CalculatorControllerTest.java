package com.company.M2ChallengeNguyenChau.controller;

import com.company.M2ChallengeNguyenChau.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    MathSolution inputObject1;
    MathSolution outputObject1;
    MathSolution inputObject2;
    MathSolution outputObject2;

    @Before
    public void setUp(){
        inputObject1 = new MathSolution("8","4");
        outputObject1 = new MathSolution("8","4");
        inputObject2 = new MathSolution();
        outputObject2 = new MathSolution();
    }

    @Test
    public void shouldReturnCorrectAdditionOperationWithCreatedStatus() throws Exception {
        String inputJson = mapper.writeValueAsString(inputObject1);
        outputObject1.setOperation("add");
       outputObject1.setAnswer(12);
       String outputJson = mapper.writeValueAsString(outputObject1);
       mockMvc.perform(
               post("/add")
                       .content(inputJson)
                       .contentType(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnCorrectSubtractionOperationWithCreatedStatus() throws Exception {
        String inputJson = mapper.writeValueAsString(inputObject1);
        outputObject1.setOperation("subtract");
        outputObject1.setAnswer(4);
        String outputJson = mapper.writeValueAsString(outputObject1);
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnCorrectMultiplicationOperationWithCreatedStatus() throws Exception {
        String inputJson = mapper.writeValueAsString(inputObject1);
        outputObject1.setOperation("multiply");
        outputObject1.setAnswer(32);
        String outputJson = mapper.writeValueAsString(outputObject1);
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnCorrectDivisionOperationWithCreatedStatus() throws Exception {
        String inputJson = mapper.writeValueAsString(inputObject1);
        outputObject1.setOperation("divide");
        outputObject1.setAnswer(2);
        String outputJson = mapper.writeValueAsString(outputObject1);
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldThrow422ErrorWhenMissingOneOperand() throws Exception {
        inputObject2.setOperand1("5");
        String inputJson = mapper.writeValueAsString(inputObject2);
        mockMvc.perform(
                post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldThrow422ErrorWhenOperandContainsAlphabeticCharacter() throws Exception {
        inputObject2.setOperand1("5");
        inputObject2.setOperand2("string");
        String inputJson = mapper.writeValueAsString(inputObject2);
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldThrow422ErrorWhenOperand2IsZero() throws Exception {
        inputObject2.setOperand1("5");
        inputObject2.setOperand2("0");
        String inputJson = mapper.writeValueAsString(inputObject2);
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}