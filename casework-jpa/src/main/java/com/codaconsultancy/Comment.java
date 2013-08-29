package com.codaconsultancy;

import com.codaconsultancy.common.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Comment extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ManyToOne(optional = false)
    private User author;

    @NotNull
    @ManyToOne(optional = false)
    private BlogEntry blogEntry;

    @Lob
    @NotEmpty
    private String content;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

}
