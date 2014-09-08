package ar.com.candoit.vga.dao;

import java.util.List;

import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;

public interface AlumnoDao {

    /**
     * Obtiene alumno por id unico
     * 
     * @param id
     * @return
     */
    public Alumno getAlumnoById(Long id);

    /**
     * Obtiene alumnos por filtro
     * 
     * @param filter
     * @return alumnos (lista vacia si no se encuentran)
     */
    public SearchResult<Alumno> searchAlumnosByFilter(SearchFilterAlumno filter);

    /**
     * Persiste el alumno
     * 
     * @param alumno
     */
    public void guardar(Alumno alumno);

    /**
     * Obtiene los alumnos que no se encuentren en esta lista y coincidan con el filtro
     * 
     * @param inscriptos
     * @return
     */
    public SearchResult<Alumno> searchAlumnosNotInAndFilter(List<Alumno> excluded,SearchFilterAlumno filter);

    /**
     * Obtiene los alumnos que se encuentren en esta lista y coincidan con el filtro
     * 
     * @param inscriptos
     * @return
     */
    public SearchResult<Alumno> searchAlumnosInAndFilter(List<Alumno> included, SearchFilterAlumnoCurso filter);
}
