package ar.com.candoit.vga.business;

import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;

public interface AlumnoBo {

    /**
     * Obtiene alumno por id unico
     * 
     * @param id
     * @return
     */
    public Alumno getAlumnoById(Long id) throws BusinessException;

    /**
     * Obtiene alumnos por filtro
     * 
     * @param filter
     * @return alumnos (lista vacia si no se encuentran)
     */
    public SearchResult<Alumno> searchAlumnosByFilter(SearchFilterAlumno filter) throws BusinessException;
    /**
     * Guarda el alumno
     * 
     * @param alumno
     */
    public void guardar(Alumno alumno) throws BusinessException;
}
