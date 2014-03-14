package com.codaconsultancy.casework.model.common;

import org.mockito.MockitoAnnotations;

public abstract class BaseUnitTest {

    protected BaseUnitTest() {
        MockitoAnnotations.initMocks(this);
    }
}
