package com.saran.test.mockitotest;

import com.saran.test.mockitotest.FirstTest.ClassToBeMocked;
import com.saran.test.mockitotest.FirstTest.MyClass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by core I5 on 12/29/2016.
 */
// MockitoJUnitRunner gives you automatic validation of framework usage, as well as an automatic initMocks().
@RunWith(MockitoJUnitRunner.class)
public class TestMyClass {

    // A mock object is a dummy implementation for an interface or a class in which you define the output of certain method calls.
    @Mock
    ClassToBeMocked ourMock;

    MyClass presenter;

    // Before define the method that runs before @Test method is called. Usually initailization takes place here.
    @Before
    public void setUp(){
        // Mock object ourMock is passed to presenter
        presenter = new MyClass(ourMock);
    }

    // @Test defines the method to be tested
    @Test
    public void myMockTest(){
        // Call method methodToBeTested of presenter
        presenter.methodToBeTested();

        // Verify if methodToBeMocked of ourMock was called
        verify(ourMock).methodToBeMocked();
    }

}
