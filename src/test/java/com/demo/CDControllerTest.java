package com.demo;

import com.demo.controllers.CDController;
import com.demo.entities.CD;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = CDController.class)
@ActiveProfiles("test")
public class CDControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CDController cdController;

    private List<CD> cdList;
    @Before
    public void setUp() {
        cdController = Mockito.mock(CDController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(cdController).build();
        this.cdList = new ArrayList<>();
        this.cdList.add(new CD("Official Soundtrack to a Work in Progress"));
        this.cdList.add(new CD("Aural Impetus"));
        this.cdList.add(new CD("No Time For Enemies"));
    }
    @Test
    public void shouldFindAllCdsTest() throws Exception {
        Mockito.when(cdController.findAllCds()).thenReturn(cdList);
        mockMvc.perform(get("/cd/all")).andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(cdList.size())));
    }



}
