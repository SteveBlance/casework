package com.codaconsultancy.dao;

import com.codaconsultancy.BlogEntry;
import com.codaconsultancy.BlogEntry_;
import com.codaconsultancy.dao.common.AbstractDaoBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BlogEntryDaoBean extends AbstractDaoBean<BlogEntry> implements
        BlogEntryDao {

    @Inject
    private Logger log;

    @Override
    public List<BlogEntry> find(int maxresults, int firstresult) {
        log.info("find blog entry, max results " + maxresults + " next result " + firstresult);

        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<BlogEntry> query = builder.createQuery(BlogEntry.class);

        Root<BlogEntry> from = query.from(BlogEntry.class);
        query.select(from).orderBy(builder.desc(from.get(BlogEntry_.created)));
        return getResultList(query, maxresults, firstresult);
    }

    @Override
    public Long count() {
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<BlogEntry> from = query.from(BlogEntry.class);

        query.select(builder.count(from));

        return this.<Long>getTypedSingleResult(query);

    }
}
