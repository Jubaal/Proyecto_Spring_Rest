package com.group3.wineshop;


import com.group3.wineshop.Controllers.RegionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TypeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void typeRequestAll() throws Exception{
        mockMvc.perform(get("/api/type")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void typeRequestOne() throws Exception{
        mockMvc.perform(get("/api/type/2").with(httpBasic("gft","eduardo"))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.id", is(2)))
                        .andExpect(jsonPath("$.name", is("Tempranillo")));

    }

    @Test
    void typeRequestFail() throws Exception{
            mockMvc.perform(get("/api/type/0").with(httpBasic("gft","eduardo"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());



    }
}
