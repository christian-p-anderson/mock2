package com.demo;

import com.demo.entities.CD;
import com.demo.services.CDService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MocksDemoApplication.class)
public class CDServiceUnitTest {
    @Autowired
    private CDService cdService;


    @Test
    public void whenTitleIsProvided_thenRetrievedTitleIsCorrect() {
        String mockTitle = "My New Album";
        String expectedTitle = "My New Album";
        Mockito.when(cdService.findCDByTitle(mockTitle)).thenReturn(new CD(mockTitle));

        String testName = cdService.findCDByTitle(mockTitle).getTitle();

        Assert.assertEquals(expectedTitle, testName);
    }


    @Test
    public void whenIdIsProvided_thenRetrievedTitleIsCorrect() {
        String mockTitle = "My New Album";
        Long id = new Long(2);
        Mockito.when(cdService.findCD(id)).thenReturn(new CD(mockTitle));

        String testName = cdService.findCD(id).getTitle();

        Assert.assertEquals(mockTitle, testName);
    }
}
