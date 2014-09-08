package ar.com.candoit.vga.common.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Info Curso
 * 
 * @author VGA
 *
 */
public class Curso {

    /** Id */
    private Long id;
    /** Denominacion */
    private String denominacion;
    /** Alumnos */
    private Set<AlumnoCurso> alumnos;
    /** Fecha alta en el sistema */
    private Date fechaAlta;

    
    public Curso() {
    }
    
    public Curso(Long id) {
	this.id = id;
    }
    
    /**
     * @return the fechaAlta
     */
    public Date getFechaAlta() {
	return fechaAlta;
    }

    /**
     * @param fechaAlta
     *            the fechaAlta to set
     */
    public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDenominacion() {
	return denominacion;
    }

    public void setDenominacion(String denominacion) {
	this.denominacion = denominacion;
    }

    public Set<AlumnoCurso> getAlumnos() {
	return alumnos;
    }

    public void setAlumnos(Set<AlumnoCurso> alumnos) {
	this.alumnos = alumnos;
    }

}
