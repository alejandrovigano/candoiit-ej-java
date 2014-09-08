package ar.com.candoit.vga.business;

import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.common.search.filter.SearchFilterCurso;

public interface CursoBo {

    /**
     * Obtiene curso por id unico
     * 
     * @param id
     * @return
     */
    public Curso getCursoById(Long id) throws BusinessException;

    /**
     * Obtiene cursos por filtro
     * 
     * @param filter
     * @return cursos (lista vacia si no se encuentran)
     */
    public SearchResult<Curso> searchCursosByFilter(SearchFilterCurso filter) throws BusinessException;
    
    /**
     * Guarda el alumno
     * 
     * @param alumno
     */
    public void guardar(Curso alumno) throws BusinessException;
}
