package ar.com.candoit.vga.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterCurso;
import ar.com.candoit.vga.dao.CursoDao;

public class CursoDaoImpl extends AbstractBasicDao<Curso, SearchFilterCurso> implements CursoDao {

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.CursoDao#getCursoById(java.lang.Long)
     */
    @Override
    public Curso getCursoById(Long id) {
	return getById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.dao.CursoDao#searchCursoByFilter(ar.com.candoit.vga
     * .common.search.filter.SearchFilterCurso)
     */
    @Override
    public SearchResult<Curso> searchCursoByFilter(SearchFilterCurso filter) {
	return super.searchByFilter(filter);
    }
    
    

    /* (non-Javadoc)
     * @see ar.com.candoit.vga.dao.CursoDao#guardar(ar.com.candoit.vga.common.entities.Curso)
     */
    @Override
    public void guardar(Curso curso) {
	getHibernateTemplate().saveOrUpdate(curso);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.dao.impl.AbstractBasicDao#fillCriteria(org.hibernate
     * .criterion.DetachedCriteria,
     * ar.com.candoit.vga.common.search.SearchFilter)
     */
    @Override
    protected void fillCriteria(DetachedCriteria criteria, SearchFilterCurso filter) {
	Long id = filter.getId();

	String denominacion = filter.getDenominacion();

	if (StringUtils.isNotBlank(denominacion)) {
	    criteria.add(Restrictions.ilike("denominacion", denominacion));
	}
	if (id != null && !id.equals(Long.valueOf(0L))) {
	    criteria.add(Restrictions.eq("id", id));
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.impl.AbstractBasicDao#getEntityClass()
     */
    @Override
    protected Class<Curso> getEntityClass() {
	return Curso.class;
    }

}
