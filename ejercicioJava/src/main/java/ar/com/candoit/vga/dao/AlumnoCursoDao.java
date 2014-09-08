package ar.com.candoit.vga.dao;

import ar.com.candoit.vga.common.entities.AlumnoCurso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;

/**
 * Dao para el acceso a la relacion alumno - curso
 * @author VGA
 *
 */
public interface AlumnoCursoDao {

    public SearchResult<AlumnoCurso> getAlumnoCursoByFilter(SearchFilterAlumnoCurso filter);

    public void guardar(AlumnoCurso inscripcion);

    public void borrar(Long idAlumno, Long idCurso);
    
}
