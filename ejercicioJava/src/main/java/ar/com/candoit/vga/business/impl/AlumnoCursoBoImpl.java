package ar.com.candoit.vga.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.candoit.vga.business.AlumnoCursoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.dao.AlumnoCursoDao;
import ar.com.candoit.vga.dao.AlumnoDao;

public class AlumnoCursoBoImpl implements AlumnoCursoBo {

    private AlumnoCursoDao alumnoCursoDao;
    private AlumnoDao alumnoDao;

    private static Logger logger = LoggerFactory.getLogger(AlumnoCursoBoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.business.AlumnoCursoBo#getAlumnosCursoByFilter(ar.
     * com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso)
     */
    @Override
    public SearchResult<AlumnoCurso> getAlumnosCursoByFilter(SearchFilterAlumnoCurso filter) throws BusinessException {

	try {
	    SearchResult<AlumnoCurso> alumunoCursos = alumnoCursoDao.getAlumnoCursoByFilter(filter);
	    return alumunoCursos;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.business.AlumnoCursoBo#getAlumnosInscriptos(ar.com
     * .candoit.vga.common.search.filter.SearchFilterAlumnoCurso)
     */
    @Override
    public SearchResult<Alumno> getAlumnosInscriptos(SearchFilterAlumnoCurso filter) throws BusinessException {
	try {
	    // Traigo los inscriptos
	    SearchResult<AlumnoCurso> alumnosInscriptos = getAlumnosCursoByFilter(filter);

	    SearchResult<Alumno> inscriptos = null;

	    // Los incluidos
	    List<AlumnoCurso> results = alumnosInscriptos.getResults();
	    if (results != null && results.size() > 0) {
		List<Alumno> included = new ArrayList<>();
		for (AlumnoCurso alumnoCurso : results) {
		    Alumno alumno = alumnoCurso.getAlumno();
		    included.add(alumno);
		}
		inscriptos = alumnoDao.searchAlumnosInAndFilter(included, filter);
	    } else {
		//No hay inscriptos retorno un resultado limpio
		inscriptos = new SearchResult<Alumno>();
	    }
	    return inscriptos;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    @Override
    public SearchResult<Alumno> getAlumnosNoInscriptos(SearchFilterAlumnoCurso filter) throws BusinessException {
	try {
	    //Traigo las incripciones
	    SearchResult<AlumnoCurso> alumnosInscriptos = getAlumnosCursoByFilter(filter);

	    SearchResult<Alumno> noInscriptos = null;

	    List<AlumnoCurso> results = alumnosInscriptos.getResults();
	    if (results != null && results.size() > 0) {
		List<Alumno> inscriptos = new ArrayList<>();
		for (AlumnoCurso alumnoCurso : results) {
		    Alumno alumno = alumnoCurso.getAlumno();
		    inscriptos.add(alumno);
		}
		noInscriptos = alumnoDao.searchAlumnosNotInAndFilter(inscriptos, filter);
	    } else {
		// No tiene inscriptos traigo todos!
		noInscriptos = alumnoDao.searchAlumnosByFilter(filter);
	    }
	    return noInscriptos;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    
    
    @Override
    public void inscribir(List<Long> alumnos, Long idCurso) throws BusinessException {
	for (Long idAlumno : alumnos) {
	    AlumnoCurso inscripcion = new AlumnoCurso();
	    inscripcion.setAlumno(new Alumno(idAlumno));
	    inscripcion.setCurso(new Curso(idCurso));
	    inscripcion.setFechaAlta(new Date());
	    alumnoCursoDao.guardar(inscripcion);
	}
    }

    @Override
    public void borrar(List<Long> alumnos, Long idCurso) throws BusinessException {
	for (Long idAlumno : alumnos) {
	    alumnoCursoDao.borrar(idAlumno,idCurso);
	}
    }

    /* IOC */
    public AlumnoCursoDao getAlumnoCursoDao() {
	return alumnoCursoDao;
    }

    public void setAlumnoCursoDao(AlumnoCursoDao alumnoCursoDao) {
	this.alumnoCursoDao = alumnoCursoDao;
    }

    public AlumnoDao getAlumnoDao() {
	return alumnoDao;
    }

    public void setAlumnoDao(AlumnoDao alumnoDao) {
	this.alumnoDao = alumnoDao;
    }

}
