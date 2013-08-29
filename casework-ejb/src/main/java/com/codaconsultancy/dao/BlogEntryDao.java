package com.codaconsultancy.dao;

import com.codaconsultancy.BlogEntry;
import com.codaconsultancy.dao.common.Dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

    List<BlogEntry> find(int maxresults, int firstresult);

    Long count();

}
