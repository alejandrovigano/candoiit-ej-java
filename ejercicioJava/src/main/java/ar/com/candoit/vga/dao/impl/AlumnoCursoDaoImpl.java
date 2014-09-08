package ar.com.candoit.vga.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.dao.AlumnoCursoDao;

public class AlumnoCursoDaoImpl extends AbstractBasicDao<AlumnoCurso, SearchFilterAlumnoCurso> implements
	AlumnoCursoDao {

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.dao.AlumnoCursoDao#getAlumnoCursoByFilter(ar.com.candoit
     * .vga.common.search.filter.SearchFilterAlumnoCurso)
     */
    @Override
    public SearchResult<AlumnoCurso> getAlumnoCursoByFilter(SearchFilterAlumnoCurso filter) {
	return searchByFilter(filter);
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
    protected void fillCriteria(DetachedCriteria criteria, SearchFilterAlumnoCurso filter) {
	Long idCurso = filter.getIdCurso();
	if (idCurso != null && !idCurso.equals(Long.valueOf(0L))) {
	    criteria.add(Restrictions.eq("curso.id", idCurso));
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.dao.AlumnoCursoDao#guardar(ar.com.candoit.vga.common
     * .entities.AlumnoCurso)
     */
    @Override
    public void guardar(AlumnoCurso inscripcion) {
	getHibernateTemplate().saveOrUpdate(inscripcion);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.AlumnoCursoDao#borrar(java.lang.Long,
     * java.lang.Long)
     */
    @Override
    public void borrar(Long idAlumno, Long idCurso) {
	DetachedCriteria criteria = DetachedCriteria.forClass(AlumnoCurso.class);
	criteria.add(Restrictions.eq("alumno.id", idAlumno )) ;
	criteria.add(Restrictions.eq("curso.id", idCurso )) ;
	List list = getHibernateTemplate().findByCriteria(criteria);
	getHibernateTemplate().deleteAll(list);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.impl.AbstractBasicDao#getEntityClass()
     */
    @Override
    protected Class<? extends AlumnoCurso> getEntityClass() {
	return AlumnoCurso.class;
    }

}
