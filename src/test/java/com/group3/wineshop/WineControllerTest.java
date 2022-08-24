package com.group3.wineshop;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class WineControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void mostrarTodos() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/wine")
                    .contentType("application/json"))
                    .andExpect(status().isOk());
        }


        @Test
        void one() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/wine/1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id", Matchers.is(1)))
                    .andExpect(jsonPath("$.name", Matchers.is("Tinto")));
        }

    }

