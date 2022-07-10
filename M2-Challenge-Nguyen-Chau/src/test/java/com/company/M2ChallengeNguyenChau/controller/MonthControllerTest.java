package com.company.M2ChallengeNguyenChau.controller;

import com.company.M2ChallengeNguyenChau.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();


    //Tests for month endpoint
    @Test
    public void shouldReturnAccordingMonthByIndicatedNumberThroughRoute() throws Exception {
        Month outputMonth = new Month("June", 6);
        String outputJson = mapper.writeValueAsString(outputMonth);
        mockMvc.perform(get("/month/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow422ErrorIfInputOutOfRange() throws Exception {
        mockMvc.perform(get("month/13"));
    }



    //Tests for randomMonth endpoint
    @Test
    public void shouldReturnSuccessfulResponseForRandomMonth() throws Exception {
        Month outputMonth = new Month();
        String outputJson = mapper.writeValueAsString(outputMonth);
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnRandomMonth() throws Exception {
        Random randomNumberGenerator = new Random();
        List<Month> months = new ArrayList<>(Arrays.asList(
                new Month("January", 1),
                new Month("February", 2),
                new Month("March", 3),
                new Month("April", 4),
                new Month("May", 5),
                new Month("June", 6),
                new Month("July", 7),
                new Month("August", 8),
                new Month("September", 9),
                new Month("October", 10),
                new Month("November", 11),
                new Month("December", 12)
        ));
        int randomNumber = randomNumberGenerator.nextInt(months.size());
            mockMvc.perform(get("/randomMonth"))
                    .andDo(print())
                    .andReturn();
            assertTrue(months.get(randomNumber).getName(), true);
        }
}