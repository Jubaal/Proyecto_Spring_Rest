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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void mostrarTodos() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/region")
                .contentType("application/json"))
                .andExpect(status().isOk()
                );
    }

    @Test
    void mostrarRegionId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/region/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("Toro"))
        );
    }

}
