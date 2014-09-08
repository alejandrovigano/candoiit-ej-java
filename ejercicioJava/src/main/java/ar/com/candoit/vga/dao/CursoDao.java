package ar.com.candoit.vga.dao;

import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterCurso;

public interface CursoDao {

    /**
     * Obtiene curso por id unico
     * 
     * @param id
     * @return
     */
    public Curso getCursoById(Long id);

    /**
     * Obtiene cursos por filtro
     * 
     * @param filter
     * @return
     */
    public SearchResult<Curso> searchCursoByFilter(SearchFilterCurso filter);
    
    /**
     * Persiste el curso
     * @param alumno
     */
    public void guardar(Curso curso);
}
