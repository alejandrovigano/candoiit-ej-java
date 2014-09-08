package ar.com.candoit.vga.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.candoit.vga.business.CursoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.common.search.filter.SearchFilterCurso;
import ar.com.candoit.vga.dao.AlumnoCursoDao;
import ar.com.candoit.vga.dao.CursoDao;

public class CursoBoImpl implements CursoBo {

    private CursoDao cursoDao;
    private AlumnoCursoDao alumnoCursoDao;

    private static Logger logger = LoggerFactory.getLogger(CursoBoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.candoit.vga.business.CursoBo#getCursoById(java.lang.Long)
     */
    @Override
    public Curso getCursoById(Long id) throws BusinessException {
	try {
	    Curso curso = cursoDao.getCursoById(id);
	    return curso;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener el curso con ID=" + id + " : " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.business.CursoBo#searchCursosByFilter(ar.com.candoit
     * .vga.common.search.filter.SearchFilterCurso)
     */
    @Override
    public SearchResult<Curso> searchCursosByFilter(SearchFilterCurso filter) throws BusinessException {
	try {
	    SearchResult<Curso> result = cursoDao.searchCursoByFilter(filter);
	    return result;
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los cursos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ar.com.candoit.vga.business.CursoBo#guardar(ar.com.candoit.vga.common
     * .entities.Curso)
     */
    @Override
    public void guardar(Curso curso) throws BusinessException {
	try {
	    curso.setFechaAlta(new Date());
	    cursoDao.guardar(curso);
	} catch (Exception e) {
	    logger.error("Hubo un error al obtener los alumnos: " + e.getMessage(), e);
	    throw new BusinessException(e);
	}
    }

    /* IOC */

    public AlumnoCursoDao getAlumnoCursoDao() {
	return alumnoCursoDao;
    }

    public CursoDao getCursoDao() {
	return cursoDao;
    }

    public void setCursoDao(CursoDao cursoDao) {
	this.cursoDao = cursoDao;
    }

    public void setAlumnoCursoDao(AlumnoCursoDao alumnoCursoDao) {
	this.alumnoCursoDao = alumnoCursoDao;
    }

}
