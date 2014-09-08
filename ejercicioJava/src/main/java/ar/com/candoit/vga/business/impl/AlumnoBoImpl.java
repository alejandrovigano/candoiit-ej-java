package ar.com.candoit.vga.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.candoit.vga.business.AlumnoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.dao.AlumnoCursoDao;
import ar.com.candoit.vga.dao.AlumnoDao;

public class AlumnoBoImpl implements AlumnoBo {

    private AlumnoDao alumnoDao;
    private AlumnoCursoDao alumnoCursoDao;

    private static Logger logger = LoggerFactory.getLogger(AlumnoBoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.business.AlumnoBo#getAlumnoById(java.lang.Long)
     */
    @Override
    public Alumno getAlumnoById(Long id) throws BusinessException {
	try {
	    Alumno alumno = alumnoDao.getAlumnoById(id);
	    return alumno;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener el alumno con ID=" + id + " : " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.business.AlumnoBo#searchAlumnosByFilter(ar.com.candoit
     * .vga.common.search.filter.SearchFilterAlumno)
     */
    @Override
    public SearchResult<Alumno> searchAlumnosByFilter(SearchFilterAlumno filter) throws BusinessException {
	try {
	    SearchResult<Alumno> result = alumnoDao.searchAlumnosByFilter(filter);
	    return result;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }
    
    

    @Override
    public void guardar(Alumno alumno) throws BusinessException {
	try {
	    alumno.setFechaAlta(new Date());
	    alumnoDao.guardar(alumno);
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    @SuppressWarnings("unchecked")
    private SearchResult<Alumno> convert(SearchResult<AlumnoCurso> alumunoCursos) {
	SearchResult<Alumno> alumnosResult = new SearchResult<>();

	List<AlumnoCurso> results = alumunoCursos.getResults();
	Long totalResults = alumunoCursos.getTotalResults();
	boolean truncated = alumunoCursos.isTruncated();

	List<Alumno> alumnos = ListUtils.EMPTY_LIST;

	if (results != null && results.size() > 0) {
	    alumnos = new ArrayList<>(results.size());
	    for (AlumnoCurso alumnoCurso : results) {
		Alumno alumno = alumnoCurso.getAlumno();
		alumnos.add(alumno);
	    }
	}

	alumnosResult.setResults(alumnos);
	alumnosResult.setTotalResults(totalResults);
	alumnosResult.setTruncated(truncated);
	return alumnosResult;
    }

    /* IOC */

    public AlumnoDao getAlumnoDao() {
	return alumnoDao;
    }

    public void setAlumnoDao(AlumnoDao alumnoDao) {
	this.alumnoDao = alumnoDao;
    }

    public AlumnoCursoDao getAlumnoCursoDao() {
	return alumnoCursoDao;
    }

    public void setAlumnoCursoDao(AlumnoCursoDao alumnoCursoDao) {
	this.alumnoCursoDao = alumnoCursoDao;
    }

}
