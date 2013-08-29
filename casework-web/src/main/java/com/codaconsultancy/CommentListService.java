package com.codaconsultancy;

import com.codaconsultancy.dao.CommentDao;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named
@ConversationScoped
public class CommentListService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    private CommentDao commentDao;

    @Inject
    private BlogEntryService blogEntryService;

    public List<Comment> getResultList() {
        log.info("get result list");
        return commentDao.findComments(blogEntryService.getInstance());
    }

}
