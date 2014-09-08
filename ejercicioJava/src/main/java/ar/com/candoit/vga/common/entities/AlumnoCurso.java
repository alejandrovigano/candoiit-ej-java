package ar.com.candoit.vga.common.entities;

import java.util.Date;

/**
 * Info de incripcion de alumnos
 * 
 * @author VGA
 *
 */
public class AlumnoCurso {

    private Long id;
    /** Alumno incripto a curso */
    private Alumno alumno;
    /** Curso incripto */
    private Curso curso;
    /** Fecha de alta en curso */
    private Date fechaAlta;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Alumno getAlumno() {
	return alumno;
    }

    public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
    }

    public Curso getCurso() {
	return curso;
    }

    public void setCurso(Curso curso) {
	this.curso = curso;
    }

    public Date getFechaAlta() {
	return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
    }

}
