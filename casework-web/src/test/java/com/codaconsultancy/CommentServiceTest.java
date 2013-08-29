package com.codaconsultancy;

import com.codaconsultancy.dao.CommentDao;
import com.codaconsultancy.dao.CommentDaoBean;
import com.codaconsultancy.injectionprovider.CurrentUserInjectionProvider;
import com.codaconsultancy.testdata.BlogEntryTestdataBuilder;
import de.akquinet.jbosscc.needle.annotation.InjectIntoMany;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.db.transaction.TransactionHelper;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.persistence.EntityManager;

public class CommentServiceTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Rule
    public NeedleRule needleRule = new NeedleRule(
            new CurrentUserInjectionProvider(), databaseRule);

    @ObjectUnderTest
    private CommentService commentService;

    @SuppressWarnings("unused")
    @InjectIntoMany
    @ObjectUnderTest(implementation = CommentDaoBean.class)
    private CommentDao commentDao;

    @SuppressWarnings("unused")
    @InjectIntoMany
    private BlogEntry blogEntry = new BlogEntryTestdataBuilder(
            databaseRule.getEntityManager()).buildAndSave();

    @Test
    public void testCreateAndPersist() throws Exception {
        TransactionHelper transactionHelper = databaseRule
                .getTransactionHelper();

        Long id = transactionHelper.executeInTransaction(new Runnable<Long>() {

            @Override
            public Long run(EntityManager entityManager) throws Exception {

                Comment instance = commentService.getInstance();
                entityManager.persist(instance.getAuthor());
                instance.setContent("comment");

                commentService.save();

                return instance.getId();
            }
        });

        Comment commentFromDb = databaseRule.getTransactionHelper().loadObject(
                Comment.class, id);

        Assert.assertNotNull(commentFromDb);

    }

}
