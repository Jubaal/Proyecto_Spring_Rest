package com.group3.wineshop;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group3.wineshop.Controllers.RegionController;
import com.group3.wineshop.entities.Region;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import static java.nio.file.Paths.get;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.nio.cs.Surrogate.is;

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

    @Test
    void modificarRegion() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/region")
                        .content(asJsonString(new Region(76,"Hospitalet", "Espana")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",Matchers.is(76)))
                .andExpect(jsonPath("$.name",Matchers.is("Hospitalet")))
                .andExpect(jsonPath("$.country",Matchers.is("America"))
                );
    }

    @Test
    void eliminarporId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/region/{id}",70))
                .andExpect(status().isOk()
        );
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
