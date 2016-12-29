package com.saran.test.mockitotest;

import com.saran.test.mockitotest.StubbingTest.DummyClass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by core I5 on 12/29/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDummyClass {

    DummyClass mockDummy;
    DummyClass spyDummy;

    // It is used to capture the argument of specific types used in functions. In this case it is of string type.
    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Before
    public void setUp(){
        // Mock object of DummyClass is created
        mockDummy = mock(DummyClass.class);

        // Spy object of DummyClass is created
        spyDummy = spy(DummyClass.class);
    }

    // @Test defines the method to be tested
    @Test
    public void testGetName(){

        /* Stubbing method getName(). After stubbing, getName() will return Android whenever it is called.
         Stubbing can be done on both mock and spy objects*/
        when(mockDummy.getName()).thenReturn("Android");

        // Checks if mockDummy.getName() has returned Android.
        assertEquals(mockDummy.getName(),"Android");

        // Using reset, mock object forgets all the interactions and stubbing
        reset(mockDummy);

        //Now mockDummy.getName() will return null after mockDummy is reset
        assertNull(mockDummy.getName());
    }

    @Test
    public void testSetName(){

        // setName method is called with argument "Test". Spy object calls real method until it is stubbed.
        spyDummy.setName("Test");

        // Used to capture the argument passed in spyDummy.setName()
        verify(spyDummy).setName(argumentCaptor.capture());

        // Is true because real method of spyDummy.setName("Test") is called
        assertEquals(spyDummy.getName(),argumentCaptor.getValue());

        // Is correct because we are passing data on a mock object but its true method setName() is not called
        mockDummy.setName("Test");

        /* Is true because setName() method is called but remember the argument is "Test".
        If any other argument than "Test" is used will fail the test*/
        verify(mockDummy).setName("Test");

        // mockDummy.getName() will return null in case of string because real method is not called by mock object
        assertEquals(mockDummy.getName(),null);
        // This method also can be used to check null
        assertNull(mockDummy.getName());

        /* Used to verify if mockDummy.getName() was called atleast once in this function.
           You can keep track how many times the method was called.*/
        verify(mockDummy,atLeastOnce()).getName();
    }

}
