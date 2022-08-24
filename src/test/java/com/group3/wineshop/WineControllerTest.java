package com.group3.wineshop;

import com.group3.wineshop.Services.WineService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class WineControllerTest {

    @Mock
    WineService wineService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mostrarTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/wine")
                        .with(httpBasic("gft", "eduardo"))
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void mostrar1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/wine/1")
                        .with(httpBasic("gft", "eduardo"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("Tinto")));
    }
}

