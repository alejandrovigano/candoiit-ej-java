package ar.com.candoit.vga.dao.impl;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.candoit.vga.common.search.SearchFilter;
import ar.com.candoit.vga.common.search.SearchResult;

/**
 * 
 * @author VGA
 *
 * @param <E>
 *            Entity
 * @param <F>
 *            Filter
 */
public abstract class AbstractBasicDao<E, F extends SearchFilter> extends HibernateDaoSupport {

    protected E getById(Long id) {
	return getHibernateTemplate().get(getEntityClass(), id);
    }

    @SuppressWarnings("unchecked")
    protected SearchResult<E> searchByFilter(F filter) {
	HibernateTemplate template = getHibernateTemplate();

	boolean truncated = false;
	List<E> results = ListUtils.EMPTY_LIST;

	DetachedCriteria criteriaCount = DetachedCriteria.forClass(getEntityClass());
	fillCriteria(criteriaCount, filter);

	Long totalResult = count(criteriaCount);
	
	if (totalResult > 0) {
	    DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
	    fillCriteria(criteria, filter);
	    results = (List<E>) template.findByCriteria(criteria);
	    if (totalResult > results.size()) {
		truncated = true;
	    }
	}

	SearchResult<E> sr = new SearchResult<E>();
	sr.setTotalResults(totalResult);
	sr.setTruncated(truncated);
	sr.setResults(results);

	return sr;
    }

    @SuppressWarnings("unchecked")
    protected Long count(DetachedCriteria criteriaCount) {
	fillCriteriaProjections(criteriaCount);
	List<Long> countlist = getHibernateTemplate().findByCriteria(criteriaCount);
	Long totalResult = countlist.get(0);
	return totalResult;
    }

    protected void fillCriteriaProjections(DetachedCriteria criteria) {
	criteria.setProjection(Projections.count("id"));
    }

    protected abstract void fillCriteria(DetachedCriteria criteria, F filter);

    protected abstract Class<? extends E> getEntityClass();
}
