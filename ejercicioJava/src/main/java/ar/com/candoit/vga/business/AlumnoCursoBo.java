package ar.com.candoit.vga.business;

import java.util.List;

import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;

public interface AlumnoCursoBo {

    /**
     * Obtiene alumnos inscriptos al curso
     * 
     * @param curso
     * @return alumnos
     */
    public SearchResult<AlumnoCurso> getAlumnosCursoByFilter(SearchFilterAlumnoCurso filter) throws BusinessException;

    /**
     * Obtiene los alumnos no inscriptos al curso
     * 
     * @param filter
     *            ()
     * @return
     * @throws BusinessException
     */
    public SearchResult<Alumno> getAlumnosNoInscriptos(SearchFilterAlumnoCurso filter) throws BusinessException;

    /**
     * Obtiene los alumnos inscriptos al curso
     * 
     * @param filter
     *            ()
     * @return
     * @throws BusinessException
     */
    public SearchResult<Alumno> getAlumnosInscriptos(SearchFilterAlumnoCurso filter) throws BusinessException;

    /**
     * Incribe los alumnos al curso
     * @param alumnos
     * @param idCurso
     */ 
    public void inscribir(List<Long> alumnos, Long idCurso) throws BusinessException;

    /**
     * borra los alumnos del curso
     * @param alumnos
     * @param idCurso
     */
    public void borrar(List<Long> alumnos, Long idCurso) throws BusinessException;

}
