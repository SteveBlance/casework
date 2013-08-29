package com.codaconsultancy;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
@Startup
public class ApplicationBootstrap {

    @Inject
    private Logger log;

    @EJB
    private UserTestdata userTestdata;

    @EJB
    private BlogEntryTestdata blogEntryTestdata;

    @EJB
    private CommentTestdata commentTestdata;

    @PostConstruct
    public void insertTestdata() {
        log.info("insert testdata");
        userTestdata.insert();
        blogEntryTestdata.insert();
        commentTestdata.insert();
    }

}
