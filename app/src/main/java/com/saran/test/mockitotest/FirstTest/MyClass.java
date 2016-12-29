package com.saran.test.mockitotest.FirstTest;

/**
 * Created by core I5 on 12/29/2016.
 */

public class MyClass {
    ClassToBeMocked dependency;

    // Notice that the dependency is now passed in.
    // This is commonly called Dependency Injection.
    public MyClass(ClassToBeMocked dependency){
        this.dependency = dependency;
    }

    public void methodToBeTested(){
        dependency.methodToBeMocked();
    }
}
