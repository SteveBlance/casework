package com.codaconsultancy.dao;

import com.codaconsultancy.BlogEntry;
import com.codaconsultancy.Comment;
import com.codaconsultancy.dao.common.Dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CommentDao extends Dao<Comment> {

    List<Comment> findComments(BlogEntry blogEntry);

}
