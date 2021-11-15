package me.springhateoasmemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void basic() throws Exception {
        mockMvc.perform(get("/personV1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstname").exists())
                .andExpect(jsonPath("lastname").exists())
                .andExpect(jsonPath("_links.self.href").exists())
        ;
    }

    @Test
    public void basic2() throws Exception {
        mockMvc.perform(get("/personV2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstname").exists())
                .andExpect(jsonPath("lastname").exists())
        ;
    }

    @Test
    public void basic3() throws Exception {
        mockMvc.perform(get("/personV3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.personList[0].firstname").exists())
                .andExpect(jsonPath("_embedded.personList[0].lastname").exists())
        ;
    }
}