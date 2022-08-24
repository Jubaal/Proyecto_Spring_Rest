package com.group3.wineshop;


import com.group3.wineshop.Controllers.RegionController;
import com.group3.wineshop.entities.Region;
import com.group3.wineshop.entities.Type;
import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.group3.wineshop.RegionControllerTest.asJsonString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.RequestEntity.post;
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

    @Test
    void updateOne() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/type").with(httpBasic("gft","eduardo"))
                        .content(asJsonString(new Type(69,"Elmaschingon")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(69)))
                .andExpect(jsonPath("$.name",Matchers.is("Elmaschingon"))
                );
    }

    @Test
    void deleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/type/{id}",69).with(httpBasic("gft","eduardo")))
                .andExpect(status().isAccepted()
                );
    }

    @Test
    void typePostOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/type").with(httpBasic("gft","eduardo"))
                        .content(asJsonString(new Type(69, "Hospitalet")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()
                );

    }
}
