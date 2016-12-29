package com.saran.test.mockitotest;

import com.saran.test.mockitotest.RetroFitTest.DataClass;
import com.saran.test.mockitotest.RetroFitTest.RetrofitClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by core I5 on 12/29/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDataClass {

    /*@Spy will allow us to call all the normal methods of the object while still tracking every interaction,
     just as you would with a mock.*/
    /*Use Spy instead of Mock for RetrofitClass because mock does not call the real implementation of mockRetro.getInstance()*/
    @Spy
    RetrofitClass mockRetro;

    /*InjectMocks creates instance of the class and injects the mocks that are created with @Mock or @Spy*/
    /*Creates instance of DataClass i.e. mockData and injects mockRetro inside it*/
    @InjectMocks
    DataClass mockData;

    // @Test defines the method to be tested
    @Test
    public void TestDataClass(){

        // Checks if mockData.getProblems() does not return null
        assertNotNull(mockData.getProblems());
        // Verifies if the setRetrofitClient() method of mockRetro is called
        verify(mockRetro).setRetrofitClient();

    }

}
