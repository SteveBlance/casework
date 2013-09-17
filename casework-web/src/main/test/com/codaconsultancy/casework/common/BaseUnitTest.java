package com.codaconsultancy.casework.common;

import org.mockito.MockitoAnnotations;

public abstract class BaseUnitTest {

    protected BaseUnitTest() {
        MockitoAnnotations.initMocks(this);
    }
}