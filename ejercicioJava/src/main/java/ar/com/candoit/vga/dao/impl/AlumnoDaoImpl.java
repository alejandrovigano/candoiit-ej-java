package ar.com.candoit.vga.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.dao.AlumnoDao;

public class AlumnoDaoImpl extends AbstractBasicDao<Alumno, SearchFilterAlumno> implements AlumnoDao {

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.AlumnoDao#getAlumnoById(java.lang.Long)
     */
    @Override
    public Alumno getAlumnoById(Long id) {
	return getById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.dao.AlumnoDao#searchAlumnosByFilter(ar.com.candoit
     * .vga.common.search.filter.SearchFilterAlumno)
     */
    @Override
    public SearchResult<Alumno> searchAlumnosByFilter(SearchFilterAlumno filter) {
	return super.searchByFilter(filter);
    }

    @Override
    public void guardar(Alumno alumno) {
	getHibernateTemplate().saveOrUpdate(alumno);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.AlumnoDao#searchAlumnosNotIn(java.util.List)
     */
    @Override
    @SuppressWarnings("unchecked")
    public SearchResult<Alumno> searchAlumnosNotInAndFilter(List<Alumno> excluded,SearchFilterAlumno filter) {

	List<Long> ids = new ArrayList<>();

	for (Alumno alumno : excluded) {
	    ids.add(alumno.getId());
	}

	DetachedCriteria criteriaCount = DetachedCriteria.forClass(getEntityClass());
	criteriaCount.add(Restrictions.not(Restrictions.in("id", ids)));
	fillCriteria(criteriaCount, filter);
	Long totalResults = count(criteriaCount);

	List<Alumno> results = ListUtils.EMPTY_LIST;
	boolean truncated = false;
	if (totalResults > 0) {
	    DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
	    criteria.add(Restrictions.not(Restrictions.in("id", ids)));
	    fillCriteria(criteria, filter);
	    results = (List<Alumno>) getHibernateTemplate().findByCriteria(criteria);
	    if (totalResults > results.size()) {
		truncated = true;
	    }
	}
	SearchResult<Alumno> sr = new SearchResult<Alumno>();
	sr.setResults(results);
	sr.setTotalResults(totalResults);
	sr.setTruncated(truncated);

	return sr;
    }

    
    
    /* (non-Javadoc)
     * @see ar.com.candoit.vga.dao.AlumnoDao#searchAlumnosInAndFilter(java.util.List, ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso)
     */
    @Override
    @SuppressWarnings("unchecked")

    public SearchResult<Alumno> searchAlumnosInAndFilter(List<Alumno> included, SearchFilterAlumnoCurso filter) {

	List<Long> ids = new ArrayList<>();

	for (Alumno alumno : included) {
	    ids.add(alumno.getId());
	}

	DetachedCriteria criteriaCount = DetachedCriteria.forClass(getEntityClass());
	criteriaCount.add(Restrictions.in("id", ids));
	fillCriteria(criteriaCount, filter);
	Long totalResults = count(criteriaCount);

	List<Alumno> results = ListUtils.EMPTY_LIST;
	boolean truncated = false;
	if (totalResults > 0) {
	    DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
	    criteria.add(Restrictions.in("id", ids));
	    fillCriteria(criteria, filter);
	    results = (List<Alumno>) getHibernateTemplate().findByCriteria(criteria);
	    if (totalResults > results.size()) {
		truncated = true;
	    }
	}
	SearchResult<Alumno> sr = new SearchResult<Alumno>();
	sr.setResults(results);
	sr.setTotalResults(totalResults);
	sr.setTruncated(truncated);

	return sr;
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
    protected void fillCriteria(DetachedCriteria criteria, SearchFilterAlumno filter) {
	Long id = filter.getId();
	String nombre = filter.getNombre();
	String apellido = filter.getApellido();
	Long dni = filter.getDni();
	Date nacDesde = filter.getFechaNacimientoDesde();
	Date nacHasta = filter.getFechaNacimientoHasta();

	if (id != null && !id.equals(Long.valueOf(0L))) {
	    criteria.add(Restrictions.eq("id", id));
	}
	if (StringUtils.isNotBlank(nombre)) {
	    criteria.add(Restrictions.ilike("nombre", "%" + nombre + "%"));
	}
	if (StringUtils.isNotBlank(apellido)) {
	    criteria.add(Restrictions.ilike("apellido", "%" + apellido + "%"));
	}
	if (dni != null && !dni.equals(Long.valueOf(0L))) {
	    criteria.add(Restrictions.eq("dni", dni));
	}
	if (nacDesde != null) {
	    criteria.add(Restrictions.le("fechaNacimiento", nacDesde));
	}
	if (nacHasta != null) {
	    criteria.add(Restrictions.ge("fechaNacimiento", nacHasta));
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.dao.impl.AbstractBasicDao#getEntityClass()
     */
    @Override
    protected Class<Alumno> getEntityClass() {
	return Alumno.class;
    }

}
